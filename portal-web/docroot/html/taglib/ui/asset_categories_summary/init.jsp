<%--
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

@generated
--%>

<%@ include file="/html/taglib/taglib-init.jsp" %>

<%
Map<String, Object> dynamicAttributes = (Map<String, Object>)request.getAttribute("ui:asset-categories-summary:dynamicAttributes");
Map<String, Object> scopedAttributes = (Map<String, Object>)request.getAttribute("ui:asset-categories-summary:scopedAttributes");
CustomAttributes customAttributes = (CustomAttributes)request.getAttribute("ui:asset-categories-summary:customAttributes");

Map<String, Object> _options = new HashMap<String, Object>();

if ((scopedAttributes != null) && !scopedAttributes.isEmpty()) {
	_options.putAll(scopedAttributes);
}

if ((dynamicAttributes != null) && !dynamicAttributes.isEmpty()) {
	_options.putAll(dynamicAttributes);
}

java.lang.String className = GetterUtil.getString((java.lang.String)request.getAttribute("ui:asset-categories-summary:className"));
long classPK = GetterUtil.getLong(String.valueOf(request.getAttribute("ui:asset-categories-summary:classPK")));
java.lang.String message = GetterUtil.getString((java.lang.String)request.getAttribute("ui:asset-categories-summary:message"));
javax.portlet.PortletURL portletURL = (javax.portlet.PortletURL)request.getAttribute("ui:asset-categories-summary:portletURL");

_updateOptions(_options, "className", className);
_updateOptions(_options, "classPK", classPK);
_updateOptions(_options, "message", message);
_updateOptions(_options, "portletURL", portletURL);
%>

<%@ include file="/html/taglib/ui/asset_categories_summary/init-ext.jspf" %>

<%!
private static final String _NAMESPACE = "ui:asset-categories-summary:";
%>