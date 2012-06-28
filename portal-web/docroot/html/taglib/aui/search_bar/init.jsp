<%--
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

@generated
--%>

<%@ include file="/html/taglib/taglib-init.jsp" %>

<%
Map<String, Object> dynamicAttributes = (Map<String, Object>)request.getAttribute("aui:search-bar:dynamicAttributes");
Map<String, Object> scopedAttributes = (Map<String, Object>)request.getAttribute("aui:search-bar:scopedAttributes");

Map<String, Object> _options = new HashMap<String, Object>();

if ((scopedAttributes != null) && !scopedAttributes.isEmpty()) {
	_options.putAll(scopedAttributes);
}

if ((dynamicAttributes != null) && !dynamicAttributes.isEmpty()) {
	_options.putAll(dynamicAttributes);
}

java.lang.String onClick = GetterUtil.getString((java.lang.String)request.getAttribute("aui:search-bar:onClick"));
java.lang.String buttonValue = GetterUtil.getString((java.lang.String)request.getAttribute("aui:search-bar:buttonValue"), "search");
java.lang.String cssClass = GetterUtil.getString((java.lang.String)request.getAttribute("aui:search-bar:cssClass"));
java.lang.String formAction = GetterUtil.getString((java.lang.String)request.getAttribute("aui:search-bar:formAction"));
java.lang.String formMethod = GetterUtil.getString((java.lang.String)request.getAttribute("aui:search-bar:formMethod"), "get");
java.lang.String formRedirectURL = GetterUtil.getString((java.lang.String)request.getAttribute("aui:search-bar:formRedirectURL"));
java.lang.String heading = GetterUtil.getString((java.lang.String)request.getAttribute("aui:search-bar:heading"), "search");
java.lang.String id = GetterUtil.getString((java.lang.String)request.getAttribute("aui:search-bar:id"));
boolean inlineField = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:search-bar:inlineField")), true);
java.lang.Object inputValue = (java.lang.Object)request.getAttribute("aui:search-bar:inputValue");
java.lang.String label = GetterUtil.getString((java.lang.String)request.getAttribute("aui:search-bar:label"));
java.lang.String name = GetterUtil.getString((java.lang.String)request.getAttribute("aui:search-bar:name"), "keywords");
java.lang.String size = GetterUtil.getString((java.lang.String)request.getAttribute("aui:search-bar:size"), "30");
java.lang.String title = GetterUtil.getString((java.lang.String)request.getAttribute("aui:search-bar:title"), "search");
boolean useAutoFocus = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:search-bar:useAutoFocus")), false);
boolean useNamespace = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:search-bar:useNamespace")), true);

_updateOptions(_options, "onClick", onClick);
_updateOptions(_options, "buttonValue", buttonValue);
_updateOptions(_options, "cssClass", cssClass);
_updateOptions(_options, "formAction", formAction);
_updateOptions(_options, "formMethod", formMethod);
_updateOptions(_options, "formRedirectURL", formRedirectURL);
_updateOptions(_options, "heading", heading);
_updateOptions(_options, "id", id);
_updateOptions(_options, "inlineField", inlineField);
_updateOptions(_options, "inputValue", inputValue);
_updateOptions(_options, "label", label);
_updateOptions(_options, "name", name);
_updateOptions(_options, "size", size);
_updateOptions(_options, "title", title);
_updateOptions(_options, "useAutoFocus", useAutoFocus);
_updateOptions(_options, "useNamespace", useNamespace);
%>

<%@ include file="/html/taglib/aui/search_bar/init-ext.jspf" %>

<%!
private static final String _NAMESPACE = "aui:search-bar:";
%>