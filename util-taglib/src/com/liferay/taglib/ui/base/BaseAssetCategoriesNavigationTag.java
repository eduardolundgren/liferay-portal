/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.liferay.taglib.ui.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

/**
 * @author Eduardo Lundgren
 * @author Bruno Basto
 * @author Nathan Cavanaugh
 * @author Julio Camarero
 * @generated
 */
public class BaseAssetCategoriesNavigationTag extends com.liferay.taglib.util.IncludeTag {

	@Override
	public int doStartTag() throws JspException {
		setAttributeNamespace(_ATTRIBUTE_NAMESPACE);

		return super.doStartTag();
	}

	public boolean getHidePortletWhenEmpty() {
		return _hidePortletWhenEmpty;
	}

	public long[] getVocabularyIds() {
		return _vocabularyIds;
	}

	public void setHidePortletWhenEmpty(boolean hidePortletWhenEmpty) {
		_hidePortletWhenEmpty = hidePortletWhenEmpty;

		setScopedAttribute("hidePortletWhenEmpty", hidePortletWhenEmpty);
	}

	public void setVocabularyIds(long[] vocabularyIds) {
		_vocabularyIds = vocabularyIds;

		setScopedAttribute("vocabularyIds", vocabularyIds);
	}

	@Override
	protected void cleanUp() {
		_hidePortletWhenEmpty = false;
		_vocabularyIds = null;
	}

	@Override
	protected String getPage() {
		return _PAGE;
	}

	@Override
	protected void setAttributes(HttpServletRequest request) {
		setNamespacedAttribute(request, "hidePortletWhenEmpty", _hidePortletWhenEmpty);
		setNamespacedAttribute(request, "vocabularyIds", _vocabularyIds);
	}

	protected static final String _ATTRIBUTE_NAMESPACE = "ui:asset-categories-navigation:";

	private static final String _PAGE =
		"/html/taglib/ui/asset_categories_navigation/page.jsp";

	private boolean _hidePortletWhenEmpty = false;
	private long[] _vocabularyIds = null;

}