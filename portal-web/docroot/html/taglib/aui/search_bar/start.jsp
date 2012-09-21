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

<%@ include file="init.jsp" %>

start tag <hr />

<%
BodyContent _bodyContent = (BodyContent)request.getAttribute("aui:search-bar:bodyContent");

// String bodyContentString = StringPool.BLANK;
String bodyContentString = "StringPool.BLANK"; //DEBUG

if (_bodyContent != null) {
	bodyContentString = _bodyContent.getString();
}

out.println("start tag bodyContentString:" + bodyContentString + ":<hr />");
%>

<liferay-util:buffer var="searchBar">
	<span class="aui-search-bar">
		<aui:input id="<%= id %>" inlineField="<%= inlineField %>" label="<%= label %>" name="<%= name %>" size="<%= size %>" title="<%= title %>" type="text" value="<%= inputValue %>" />

		<c:choose>
			<c:when test="<%= Validator.isNotNull(onClick) %>">
				<aui:button onClick="<%= onClick %>" type="button" value="<%= buttonValue %>" />
			</c:when>
			<c:otherwise>
				<aui:button type="submit" value="<%= buttonValue %>" />
			</c:otherwise>
		</c:choose>
	</span>
</liferay-util:buffer>

<div <%= Validator.isNotNull(cssClass) ? "class=\"" + cssClass + "\"" : StringPool.BLANK %>>
	<c:choose>
		<c:when test="<%= buildForm %>">
			<aui:form action="<%= formAction %>" method="<%= formMethod %>" name="<%= formName %>">
				<liferay-portlet:renderURLParams varImpl="<%= formAction %>" />
				<aui:input name="redirect" type="hidden" value="<%= formRedirectURL %>" />

				<c:if test="<%= heading.length() > 0 %>">
					<liferay-ui:header backURL="<%= formRedirectURL %>" title="<%= heading %>" />
				</c:if>

				<%= searchBar %>
			</aui:form>

			<c:if test="<%= useAutoFocus && portletDisplay.isStateMax() %>">
				<aui:script>
					Liferay.Util.focusFormField(document.<%= namespace + formName %>.<%= namespace + name %>);
				</aui:script>
			</c:if>
		</c:when>
		<c:otherwise>
			<%= searchBar %>
		</c:otherwise>
	</c:choose>
</div>