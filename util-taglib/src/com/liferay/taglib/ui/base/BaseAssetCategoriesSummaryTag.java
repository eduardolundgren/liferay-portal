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
public class BaseAssetCategoriesSummaryTag extends com.liferay.taglib.util.IncludeTag {

	@Override
	public int doStartTag() throws JspException {
		setAttributeNamespace(_ATTRIBUTE_NAMESPACE);

		return super.doStartTag();
	}

	public java.lang.String getClassName() {
		return _className;
	}

	public long getClassPK() {
		return _classPK;
	}

	public java.lang.String getMessage() {
		return _message;
	}

	public javax.portlet.PortletURL getPortletURL() {
		return _portletURL;
	}

	public void setClassName(java.lang.String className) {
		_className = className;

		setScopedAttribute("className", className);
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;

		setScopedAttribute("classPK", classPK);
	}

	public void setMessage(java.lang.String message) {
		_message = message;

		setScopedAttribute("message", message);
	}

	public void setPortletURL(javax.portlet.PortletURL portletURL) {
		_portletURL = portletURL;

		setScopedAttribute("portletURL", portletURL);
	}

	@Override
	protected void cleanUp() {
		_className = null;
		_classPK = 0;
		_message = null;
		_portletURL = null;
	}

	@Override
	protected String getPage() {
		return _PAGE;
	}

	@Override
	protected void setAttributes(HttpServletRequest request) {
		setNamespacedAttribute(request, "className", _className);
		setNamespacedAttribute(request, "classPK", _classPK);
		setNamespacedAttribute(request, "message", _message);
		setNamespacedAttribute(request, "portletURL", _portletURL);
	}

	protected static final String _ATTRIBUTE_NAMESPACE = "ui:asset-categories-summary:";

	private static final String _PAGE =
		"/html/taglib/ui/asset_categories_summary/page.jsp";

	private java.lang.String _className = null;
	private long _classPK = 0;
	private java.lang.String _message = null;
	private javax.portlet.PortletURL _portletURL = null;

}