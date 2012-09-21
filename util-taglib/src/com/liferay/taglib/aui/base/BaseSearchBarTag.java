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

package com.liferay.taglib.aui.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

/**
 * @author Eduardo Lundgren
 * @author Bruno Basto
 * @author Nathan Cavanaugh
 * @author Julio Camarero
 * @author Byran Zaugg
 * @generated
 */
public class BaseSearchBarTag extends com.liferay.taglib.util.IncludeTag {

	@Override
	public int doStartTag() throws JspException {
		setAttributeNamespace(_ATTRIBUTE_NAMESPACE);

		return super.doStartTag();
	}

	public java.lang.String getOnClick() {
		return _onClick;
	}

	public java.lang.String getButtonValue() {
		return _buttonValue;
	}

	public java.lang.String getCssClass() {
		return _cssClass;
	}

	public java.lang.String getFormAction() {
		return _formAction;
	}

	public java.lang.String getFormMethod() {
		return _formMethod;
	}

	public java.lang.String getFormRedirectURL() {
		return _formRedirectURL;
	}

	public java.lang.String getHeading() {
		return _heading;
	}

	public java.lang.String getId() {
		return _id;
	}

	public boolean getInlineField() {
		return _inlineField;
	}

	public java.lang.Object getInputValue() {
		return _inputValue;
	}

	public java.lang.String getLabel() {
		return _label;
	}

	public java.lang.String getName() {
		return _name;
	}

	public java.lang.String getSize() {
		return _size;
	}

	public java.lang.String getTitle() {
		return _title;
	}

	public boolean getUseAutoFocus() {
		return _useAutoFocus;
	}

	public boolean getUseNamespace() {
		return _useNamespace;
	}

	public void setOnClick(java.lang.String onClick) {
		_onClick = onClick;

		setScopedAttribute("onClick", onClick);
	}

	public void setButtonValue(java.lang.String buttonValue) {
		_buttonValue = buttonValue;

		setScopedAttribute("buttonValue", buttonValue);
	}

	public void setCssClass(java.lang.String cssClass) {
		_cssClass = cssClass;

		setScopedAttribute("cssClass", cssClass);
	}

	public void setFormAction(java.lang.String formAction) {
		_formAction = formAction;

		setScopedAttribute("formAction", formAction);
	}

	public void setFormMethod(java.lang.String formMethod) {
		_formMethod = formMethod;

		setScopedAttribute("formMethod", formMethod);
	}

	public void setFormRedirectURL(java.lang.String formRedirectURL) {
		_formRedirectURL = formRedirectURL;

		setScopedAttribute("formRedirectURL", formRedirectURL);
	}

	public void setHeading(java.lang.String heading) {
		_heading = heading;

		setScopedAttribute("heading", heading);
	}

	public void setId(java.lang.String id) {
		_id = id;

		setScopedAttribute("id", id);
	}

	public void setInlineField(boolean inlineField) {
		_inlineField = inlineField;

		setScopedAttribute("inlineField", inlineField);
	}

	public void setInputValue(java.lang.Object inputValue) {
		_inputValue = inputValue;

		setScopedAttribute("inputValue", inputValue);
	}

	public void setLabel(java.lang.String label) {
		_label = label;

		setScopedAttribute("label", label);
	}

	public void setName(java.lang.String name) {
		_name = name;

		setScopedAttribute("name", name);
	}

	public void setSize(java.lang.String size) {
		_size = size;

		setScopedAttribute("size", size);
	}

	public void setTitle(java.lang.String title) {
		_title = title;

		setScopedAttribute("title", title);
	}

	public void setUseAutoFocus(boolean useAutoFocus) {
		_useAutoFocus = useAutoFocus;

		setScopedAttribute("useAutoFocus", useAutoFocus);
	}

	public void setUseNamespace(boolean useNamespace) {
		_useNamespace = useNamespace;

		setScopedAttribute("useNamespace", useNamespace);
	}

	@Override
	protected void cleanUp() {
		_onClick = null;
		_buttonValue = "search";
		_cssClass = null;
		_formAction = null;
		_formMethod = "get";
		_formRedirectURL = null;
		_heading = "search";
		_id = null;
		_inlineField = true;
		_inputValue = null;
		_label = null;
		_name = "keywords";
		_size = "30";
		_title = "search";
		_useAutoFocus = false;
		_useNamespace = true;
	}

	@Override
	protected String getEndPage() {
		return _END_PAGE;
	}

	@Override
	protected String getStartPage() {
		return _START_PAGE;
	}

	@Override
	protected void setAttributes(HttpServletRequest request) {
		setNamespacedAttribute(request, "onClick", _onClick);
		setNamespacedAttribute(request, "buttonValue", _buttonValue);
		setNamespacedAttribute(request, "cssClass", _cssClass);
		setNamespacedAttribute(request, "formAction", _formAction);
		setNamespacedAttribute(request, "formMethod", _formMethod);
		setNamespacedAttribute(request, "formRedirectURL", _formRedirectURL);
		setNamespacedAttribute(request, "heading", _heading);
		setNamespacedAttribute(request, "id", _id);
		setNamespacedAttribute(request, "inlineField", _inlineField);
		setNamespacedAttribute(request, "inputValue", _inputValue);
		setNamespacedAttribute(request, "label", _label);
		setNamespacedAttribute(request, "name", _name);
		setNamespacedAttribute(request, "size", _size);
		setNamespacedAttribute(request, "title", _title);
		setNamespacedAttribute(request, "useAutoFocus", _useAutoFocus);
		setNamespacedAttribute(request, "useNamespace", _useNamespace);
	}

	protected static final String _ATTRIBUTE_NAMESPACE = "aui:search-bar:";

	private static final String _END_PAGE =
		"/html/taglib/aui/search_bar/end.jsp";

	private static final String _START_PAGE =
		"/html/taglib/aui/search_bar/start.jsp";

	private java.lang.String _onClick = null;
	private java.lang.String _buttonValue = "search";
	private java.lang.String _cssClass = null;
	private java.lang.String _formAction = null;
	private java.lang.String _formMethod = "get";
	private java.lang.String _formRedirectURL = null;
	private java.lang.String _heading = "search";
	private java.lang.String _id = null;
	private boolean _inlineField = true;
	private java.lang.Object _inputValue = null;
	private java.lang.String _label = null;
	private java.lang.String _name = "keywords";
	private java.lang.String _size = "30";
	private java.lang.String _title = "search";
	private boolean _useAutoFocus = false;
	private boolean _useNamespace = true;

}