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

<%@ include file="/html/portlet/search/facets/init.jsp" %>

<%
if (termCollectors.isEmpty()) {
	return;
}

String displayStyle = dataJSONObject.getString("displayStyle", "cloud");
int frequencyThreshold = dataJSONObject.getInt("frequencyThreshold");
int maxTerms = dataJSONObject.getInt("maxTerms", 10);
boolean showAssetCount = dataJSONObject.getBoolean("showAssetCount", true);
%>

<div class="asset-tags <%= cssClass %>" data-facetFieldName="<%= facet.getFieldName() %>" id="<%= randomNamespace %>facet">
	<aui:input name="<%= facet.getFieldName() %>" type="hidden" value="<%= fieldParam %>" />

	<ul class="unstyled <%= (showAssetCount && displayStyle.equals("cloud")) ? "tag-cloud" : "tag-list" %>">
		<li class="facet-value default <%= Validator.isNull(fieldParam) ? "current-term" : StringPool.BLANK %>">
			<a data-value="" href="javascript:;"><img alt="" src="<%= themeDisplay.getPathThemeImages() %>/common/<%= facetConfiguration.getLabel() %>.png" /><liferay-ui:message key="any" /> <liferay-ui:message key="<%= facetConfiguration.getLabel() %>" /></a>
		</li>

		<%
		int maxCount = 1;
		int minCount = 1;

		if (showAssetCount && displayStyle.equals("cloud")) {

			// The cloud style may not list tags in the order of frequency,
			// so keep looking through the results until we reach the maximum
			// number of terms or we run out of terms.

			for (int i = 0, j = 0; i < termCollectors.size(); i++, j++) {
				if (j >= maxTerms) {
					break;
				}

				TermCollector termCollector = termCollectors.get(i);

				int frequency = termCollector.getFrequency();

				if (frequencyThreshold > frequency) {
					j--;

					continue;
				}

				maxCount = Math.max(maxCount, frequency);
				minCount = Math.min(minCount, frequency);
			}
		}

		double multiplier = 1;

		if (maxCount != minCount) {
			multiplier = (double)5 / (maxCount - minCount);
		}

		for (int i = 0, j = 0; i < termCollectors.size(); i++, j++) {
			if (j >= maxTerms) {
				break;
			}

			TermCollector termCollector = termCollectors.get(i);
		%>

				<c:if test="<%= fieldParam.equals(termCollector.getTerm()) %>">
					<aui:script use="liferay-token-list">
						Liferay.Search.tokenList.add(
							{
								clearFields: '<%= renderResponse.getNamespace() + facet.getFieldName() %>',
								text: '<%= HtmlUtil.escapeJS(termCollector.getTerm()) %>'
							}
						);
					</aui:script>
				</c:if>

		<%
			int popularity = (int)(1 + ((maxCount - (maxCount - (termCollector.getFrequency() - minCount))) * multiplier));

			if (frequencyThreshold > termCollector.getFrequency()) {
				j--;

				continue;
			}
		%>

			<li class="facet-value tag-popularity-<%= popularity %> <%= fieldParam.equals(termCollector.getTerm()) ? "current-term" : StringPool.BLANK %>">
				<a data-value="<%= HtmlUtil.escapeAttribute(termCollector.getTerm()) %>" href="javascript:;"><%= HtmlUtil.escape(termCollector.getTerm()) %></a>

				<c:if test="<%= showAssetCount %>">
					<span class="frequency">(<%= termCollector.getFrequency() %>)</span>
				</c:if>
			</li>

		<%
		}
		%>

	</ul>
</div>