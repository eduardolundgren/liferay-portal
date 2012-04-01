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

package com.liferay.portlet.dynamicdatalists.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.dynamicdatalists.model.DDLRecord;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSet;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordVersion;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordLocalServiceUtil;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;
import com.liferay.portlet.dynamicdatamapping.storage.StorageEngineUtil;
import com.liferay.portlet.dynamicdatamapping.util.DDMIndexerUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import javax.portlet.PortletURL;

/**
 * @author Marcellus Tavares
 */
public class DDLIndexer extends BaseIndexer {

	public static final String[] CLASS_NAMES = {DDLRecord.class.getName()};

	public static final String PORTLET_ID = PortletKeys.DYNAMIC_DATA_LISTS;

	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	public String getPortletId() {
		return PORTLET_ID;
	}

	@Override
	public boolean isFilterSearch() {
		return _FILTER_SEARCH;
	}

	@Override
	public boolean isPermissionAware() {
		return _PERMISSION_AWARE;
	}

	@Override
	public void postProcessContextQuery(
			BooleanQuery contextQuery, SearchContext searchContext)
		throws Exception {

		int status = GetterUtil.getInteger(
			searchContext.getAttribute(Field.STATUS),
			WorkflowConstants.STATUS_APPROVED);

		if (status != WorkflowConstants.STATUS_ANY) {
			contextQuery.addRequiredTerm(Field.STATUS, status);
		}

		long recordSetId = GetterUtil.getLong(
			searchContext.getAttribute("recordSetId"));

		if (recordSetId > 0) {
			contextQuery.addRequiredTerm("recordSetId", recordSetId);
		}
	}

	@Override
	public void postProcessSearchQuery(
			BooleanQuery searchQuery, SearchContext searchContext)
		throws Exception {

		Set<DDMStructure> ddmStructuresSet = new TreeSet<DDMStructure>();

		long recordSetId = GetterUtil.getLong(
			searchContext.getAttribute("recordSetId"));

		if (recordSetId > 0) {
			DDLRecordSet recordSet = DDLRecordSetLocalServiceUtil.getRecordSet(
				recordSetId);

			ddmStructuresSet.add(recordSet.getDDMStructure());
		}
		else {
			long[] groupIds = searchContext.getGroupIds();

			if ((groupIds != null) && (groupIds.length > 0)) {
				List<DDMStructure> ddmStructures =
					DDMStructureLocalServiceUtil.getStructures(groupIds);

				ddmStructuresSet.addAll(ddmStructures);
			}
		}

		BooleanQuery ddmStructureQuery = BooleanQueryFactoryUtil.create(
			searchContext);

		for (DDMStructure ddmStructure : ddmStructuresSet) {
			addSearchDDMStruture(searchQuery, searchContext, ddmStructure);
		}

		if (ddmStructureQuery.hasClauses()) {
			searchQuery.add(ddmStructureQuery, BooleanClauseOccur.MUST);
		}

		addSearchTerm(searchQuery, searchContext, Field.USER_NAME, false);
	}

	protected void addDDMAttributes(
			Document document, DDLRecordVersion recordVersion)
		throws PortalException, SystemException {

		DDLRecordSet recordSet = recordVersion.getRecordSet();

		DDMStructure ddmStructure = recordSet.getDDMStructure();

		Fields fields = StorageEngineUtil.getFields(
			recordVersion.getDDMStorageId());

		DDMIndexerUtil.addAttributes(document, ddmStructure, fields);
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		DDLRecord record = (DDLRecord)obj;

		deleteDocument(record.getCompanyId(), record.getRecordId());
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		DDLRecord record = (DDLRecord)obj;

		if (_log.isDebugEnabled()) {
			_log.debug("Indexing document " + record);
		}

		Document document = getBaseModelDocument(PORTLET_ID, record);

		DDLRecordVersion recordVersion = record.getRecordVersion();

		document.addKeyword(Field.STATUS, recordVersion.getStatus());
		document.addKeyword(Field.VERSION, recordVersion.getVersion());
		document.addKeyword("recordSetId", recordVersion.getRecordSetId());

		addDDMAttributes(document, recordVersion);

		if (_log.isDebugEnabled()) {
			_log.debug("Document " + record + " indexed successfully");
		}

		return document;
	}

	@Override
	protected Summary doGetSummary(
		Document document, Locale locale, String snippet,
		PortletURL portletURL) {

		long recordSetId = GetterUtil.getLong(document.get("recordSetId"));

		String title = getTitle(recordSetId, locale);

		String content = snippet;

		if (Validator.isNull(snippet)) {
			content = StringUtil.shorten(document.get(Field.CONTENT), 200);
		}

		String recordId = document.get(Field.ENTRY_CLASS_PK);

		portletURL.setParameter(
			"struts_action", "/dynamic_data_lists/view_record");
		portletURL.setParameter("recordId", recordId);

		return new Summary(title, content, portletURL);
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		DDLRecord record = (DDLRecord)obj;

		Document document = getDocument(record);

		if (document != null) {
			SearchEngineUtil.updateDocument(
				getSearchEngineId(), record.getCompanyId(), document);
		}
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		DDLRecord record = DDLRecordLocalServiceUtil.getRecord(classPK);

		doReindex(record);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);

		reindexRecords(companyId);
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {
		return PORTLET_ID;
	}

	protected String getTitle(long recordSetId, Locale locale) {
		try {
			DDLRecordSet recordSet = DDLRecordSetLocalServiceUtil.getRecordSet(
				recordSetId);

			String name = recordSet.getName(locale);

			return LanguageUtil.format(locale, "new-record-for-list-x", name);
		}
		catch (Exception e) {
			_log.error(e);
		}

		return StringPool.BLANK;
	}

	protected void reindexRecords(long companyId) throws Exception {
		int recordsCount = DDLRecordLocalServiceUtil.getCompanyRecordsCount(
			companyId);

		int recordPages = recordsCount / Indexer.DEFAULT_INTERVAL;

		for (int i = 0; i <= recordPages; i++) {
			int start = (i * Indexer.DEFAULT_INTERVAL);
			int end = start + Indexer.DEFAULT_INTERVAL;

			reindexRecords(companyId, start, end);
		}
	}

	protected void reindexRecords(long companyId, int start, int end)
		throws Exception {

		Collection<Document> documents = new ArrayList<Document>();

		List<DDLRecord> records = DDLRecordLocalServiceUtil.getCompanyRecords(
			companyId, start, end, null);

		for (DDLRecord record : records) {
			Document document = getDocument(record);

			if (document != null) {
				documents.add(document);
			}
		}

		SearchEngineUtil.updateDocuments(
			getSearchEngineId(), companyId, documents);
	}

	private static final boolean _FILTER_SEARCH = true;

	private static final boolean _PERMISSION_AWARE = false;

	private static Log _log = LogFactoryUtil.getLog(DDLIndexer.class);

}