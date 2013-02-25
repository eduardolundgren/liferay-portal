/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.lar;

import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.lar.PortletDataHandlerKeys;
import com.liferay.portal.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.portal.kernel.lar.StagedModelPathUtil;
import com.liferay.portal.kernel.lar.UserIdStrategy;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.kernel.xml.XPath;
import com.liferay.portal.kernel.zip.ZipReader;
import com.liferay.portal.kernel.zip.ZipReaderFactoryUtil;
import com.liferay.portal.kernel.zip.ZipWriter;
import com.liferay.portal.kernel.zip.ZipWriterFactoryUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.StagedModel;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.util.GroupTestUtil;
import com.liferay.portal.util.TestPropsValues;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.powermock.api.mockito.PowerMockito;

/**
 * @author Daniel Kocsis
 * @author Mate Thurzo
 */
public abstract class BaseStagedModelDataHandlerTestCase extends PowerMockito {

	@Before
	public void setUp() throws Exception {
		FinderCacheUtil.clearCache();

		_liveGroup = GroupTestUtil.addGroup();
		_stagingGroup = GroupTestUtil.addGroup();
	}

	@After
	public void tearDown() throws Exception {
		GroupLocalServiceUtil.deleteGroup(_liveGroup);
		GroupLocalServiceUtil.deleteGroup(_stagingGroup);
	}

	@Test
	@Transactional
	public void testStagedModelDataHandler() throws Exception {

		// Export

		ZipWriter zipWriter = ZipWriterFactoryUtil.getZipWriter();

		PortletDataContext portletDataContext = new PortletDataContextImpl(
			_stagingGroup.getCompanyId(), _stagingGroup.getGroupId(),
			getParameterMap(), new HashSet<String>(), getStartDate(),
			getEndDate(), zipWriter);

		Map<String, List<StagedModel>> stagedModels = addStagedModels(
			_stagingGroup);

		StagedModel stagedModel = addStagedModel(_stagingGroup, stagedModels);

		Element[] stagedModelsElements = getStagedModelsElements(stagedModels);

		StagedModelDataHandlerUtil.exportStagedModel(
			portletDataContext, stagedModelsElements, stagedModel);

		validateExport(stagedModel, stagedModels, stagedModelsElements);

		// Import

		UserIdStrategy userIdStrategy = new CurrentUserIdStrategy(
			TestPropsValues.getUser());

		ZipReader zipReader = ZipReaderFactoryUtil.getZipReader(
			zipWriter.getFile());

		portletDataContext = new PortletDataContextImpl(
			_liveGroup.getCompanyId(), _liveGroup.getGroupId(),
			getParameterMap(), new HashSet<String>(), userIdStrategy,
			zipReader);

		portletDataContext.setSourceGroupId(_stagingGroup.getGroupId());

		Element importedStagedModelElement = getImportedStagedModelElement(
			stagedModel, stagedModelsElements);

		Assert.assertNotNull(importedStagedModelElement);

		StagedModelDataHandlerUtil.importStagedModel(
			portletDataContext, importedStagedModelElement);

		validateImport(stagedModel, stagedModels, _liveGroup);
	}

	protected abstract StagedModel addStagedModel(
			Group group, Map<String, List<StagedModel>> dependentStagedModels)
		throws Exception;

	protected Map<String, List<StagedModel>> addStagedModels(Group group)
		throws Exception {

		return new HashMap<String, List<StagedModel>>();
	}

	protected abstract String getElementName();

	protected Date getEndDate() {
		return new Date();
	}

	protected Element getImportedStagedModelElement(
		StagedModel stagedModel, Element[] stagedModelsElements) {

		Element rootElement = SAXReaderUtil.createElement("root");

		for (Element stagedModelElement : stagedModelsElements) {
			rootElement.add(stagedModelElement);
		}

		StringBundler sb = new StringBundler(6);

		sb.append(getStagedModelClassName());
		sb.append(StringPool.FORWARD_SLASH);
		sb.append(getElementName());
		sb.append("[@path='");
		sb.append(StagedModelPathUtil.getPath(stagedModel));
		sb.append("']");

		XPath xPath = SAXReaderUtil.createXPath(sb.toString());

		return (Element)xPath.selectSingleNode(rootElement);
	}

	protected Map<String, String[]> getParameterMap() {
		Map<String, String[]> parameterMap =
			new LinkedHashMap<String, String[]>();

		parameterMap.put(
			PortletDataHandlerKeys.DATA_STRATEGY,
			new String[] {
				PortletDataHandlerKeys.DATA_STRATEGY_MIRROR_OVERWRITE});
		parameterMap.put(
			PortletDataHandlerKeys.IGNORE_LAST_PUBLISH_DATE,
			new String[] {Boolean.TRUE.toString()});
		parameterMap.put(
			PortletDataHandlerKeys.PORTLET_DATA,
			new String[] {Boolean.TRUE.toString()});
		parameterMap.put(
			PortletDataHandlerKeys.PORTLET_DATA_ALL,
			new String[] {Boolean.TRUE.toString()});

		return parameterMap;
	}

	protected abstract StagedModel getStagedModel(String uuid, Group group);

	protected abstract String getStagedModelClassName();

	protected Element[] getStagedModelsElements(
		Map<String, List<StagedModel>> stagedModelsMap) {

		List<Element> stagedModelsElements = new ArrayList<Element>();

		for (String className : stagedModelsMap.keySet()) {
			Element stagedModelsElement = SAXReaderUtil.createElement(
				className);

			stagedModelsElements.add(stagedModelsElement);
		}

		if (!stagedModelsMap.containsKey(getStagedModelClassName())) {
			Element stagedModelsElement = SAXReaderUtil.createElement(
				getStagedModelClassName());

			stagedModelsElements.add(stagedModelsElement);
		}

		return stagedModelsElements.toArray(
			new Element[stagedModelsElements.size()]);
	}

	protected Date getStartDate() {
		return new Date(System.currentTimeMillis() - Time.HOUR);
	}

	protected void validateExport(
			StagedModel stagedModel,
			Map<String, List<StagedModel>> stagedModelsMap,
			Element[] stagedModelsElements)
		throws Exception {

		for (Element stagedModelsElement : stagedModelsElements) {
			String className = stagedModelsElement.getName();

			List<StagedModel> stagedModels = stagedModelsMap.get(className);

			if (stagedModels == null) {
				stagedModels = new ArrayList<StagedModel>();
			}
			else {
				stagedModels = ListUtil.copy(stagedModels);
			}

			if (className.equals(getStagedModelClassName())) {
				stagedModels.add(stagedModel);
			}

			List<Element> elements = stagedModelsElement.elements();

			Assert.assertEquals(stagedModels.size(), elements.size());

			for (Element element : elements) {
				String path = element.attributeValue("path");

				Assert.assertNotNull(path);

				Iterator<StagedModel> iterator = stagedModels.iterator();

				while (iterator.hasNext()) {
					StagedModel curStagedModel = iterator.next();

					String curPath = StagedModelPathUtil.getPath(
						curStagedModel);

					if (path.equals(curPath)) {
						iterator.remove();
					}
				}
			}

			Assert.assertTrue(
				"There is more than one element exported with the same path",
				stagedModels.isEmpty());
		}
	}

	protected void validateImport(
			Map<String, List<StagedModel>> stagedModelsMap, Group group)
		throws Exception {
	}

	protected void validateImport(
			StagedModel stagedModel,
			Map<String, List<StagedModel>> stagedModelsMap, Group group)
		throws Exception {

		StagedModel importedStagedModel = getStagedModel(
			stagedModel.getUuid(), group);

		Assert.assertNotNull(importedStagedModel);

		validateImport(stagedModelsMap, group);
	}

	private Group _liveGroup;
	private Group _stagingGroup;

}