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
--%>

<%@ include file="/html/taglib/aui/live_search/init.jsp" %>

<aui:component
	excludeAttributes="javaScriptAttributes,useJavaScript,useMarkup,var"
	module="aui-live-search"
	name="LiveSearch"
	options="<%= _options %>"
	scriptPosition='<%= GetterUtil.getString(_options.get("scriptPosition")) %>'
	tagPageContext="<%= pageContext %>"
	useJavaScript='<%= GetterUtil.getBoolean(_options.get("useJavaScript"), true) %>'
	var='<%= GetterUtil.getString(_options.get("var")) %>'
/>