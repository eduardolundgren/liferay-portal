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
--%>

<%@ include file="/html/portlet/mobile_device_rules_admin/action/init.jsp" %>

<%
String layoutTemplateId = StringPool.BLANK;

if (!isAdd) {
	layoutTemplateId = actionTypeSettings.getProperty("layoutTemplateId");

	if (Validator.isNull(layoutTemplateId)) {
		layoutTemplateId = StringPool.BLANK;
	}
}

List layoutTemplates = LayoutTemplateLocalServiceUtil.getLayoutTemplates();
%>

<liferay-ui:error-marker key="errorSection" value="layout" />

<h5><%= LanguageUtil.get(pageContext, "layout-template") %></h5>

<%@ include file="/html/portlet/layouts_admin/layout_field.jspf" %>