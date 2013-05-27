<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

<%@ include file="/html/taglib/aui/nav_item/init.jsp" %>

<li class="<%= cssClass %><%= selected ? " active" : StringPool.BLANK %>" id="<%= id %>" <%= AUIUtil.buildData(data) %> <%= InlineUtil.buildDynamicAttributes(dynamicAttributes) %>>
	<c:if test="<%= Validator.isNotNull(label) %>">
		<c:if test="<%= Validator.isNotNull(href) %>">
			<a class="<%= anchorCssClass %>" <%= AUIUtil.buildData(anchorData) %> href="<%= href %>" id="<%= anchorId %>" title="<liferay-ui:message key="<%= title %>" />">
		</c:if>
				<c:if test="<%= Validator.isNotNull(iconClass) %>">
					<i class="<%= iconClass %>"></i>
				</c:if>

				<liferay-ui:message key="<%= label %>" />

				<c:if test="<%= dropdown %>">
					<b class="caret"></b>
				</c:if>
		<c:if test="<%= Validator.isNotNull(href) %>">
			</a>
		</c:if>
	</c:if>

	<c:if test="<%= dropdown %>">
		<aui:script use="aui-base,event-outside">
			A.one('#<%= id %>').on(
				'click',
				function(event) {
					var STR_OPEN = 'open';

					var currentTarget = event.currentTarget;

					if (currentTarget.hasClass(STR_OPEN)) {
						currentTarget.removeClass(STR_OPEN);
					} else {
						currentTarget.addClass(STR_OPEN);

						currentTarget.once(
							'clickoutside',
							function(event) {
								currentTarget.removeClass(STR_OPEN);
							}
						);
					}
				}
			);
		</aui:script>

		<c:if test="<%= wrapDropDownMenu %>">
			<ul class="dropdown-menu">
		</c:if>
	</c:if>