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

<%@ include file="/html/portlet/workflow_definitions/init.jsp" %>

<%
String toolbarItem = ParamUtil.getString(request, "toolbarItem", "view-all");
%>

<div class="lfr-portlet-toolbar">
	<portlet:renderURL var="viewDefinitionsURL">
		<portlet:param name="struts_action" value="/workflow_definitions/view" />
		<portlet:param name="tabs1" value="workflow-definitions" />
	</portlet:renderURL>

	<span class="lfr-toolbar-button view-button <%= toolbarItem.equals("view-all") ? "current" : StringPool.BLANK %>">
		<a href="<%= viewDefinitionsURL %>"><liferay-ui:message key="view-all" /></a>
	</span>

	<portlet:renderURL var="addWorkflowDefinitionURL">
		<portlet:param name="struts_action" value="/workflow_definitions/edit_workflow_definition" />
		<portlet:param name="tabs1" value="workflow-definitions" />
		<portlet:param name="redirect" value="<%= viewDefinitionsURL %>" />
		<portlet:param name="backURL" value="<%= viewDefinitionsURL %>" />
	</portlet:renderURL>

	<c:if test='<%= DeployManagerUtil.isDeployed("kaleo-designer-portlet") %>'>
		<%
		String kaleoDesignerURL = "javascript:Liferay.Util.getOpener()." + renderResponse.getNamespace() + "openKaleoDesigner('', '0', '', Liferay.Util.getWindowName());";
		%>
		<span class="lfr-toolbar-button add-button">
			<a href="<%= kaleoDesignerURL %>"><liferay-ui:message key="add-definition" /></a>
		</span>
	</c:if>

	<span class="lfr-toolbar-button upload-button <%= toolbarItem.equals("add") ? "current" : StringPool.BLANK %>">
		<a href="<%= addWorkflowDefinitionURL %>"><liferay-ui:message key="file-upload" /></a>
	</span>
</div>

<c:if test='<%= DeployManagerUtil.isDeployed("kaleo-designer-portlet") %>'>
	<aui:script>
		Liferay.provide(
			window,
			'<portlet:namespace />openKaleoDesigner',
			function(workflowDefinitionName, workflowDefinitionVersion, saveCallback, openerWindowName) {
				var A = AUI();
				console.log('openerWindowName: ', openerWindowName);
				Liferay.Util.openKaleoDesignerPortlet(
					{
						availablePropertyModels: 'Liferay.KaleoDesigner.AVAILABLE_PROPERTY_MODELS.KALEO_FORMS_EDIT',
						name: workflowDefinitionName,
						openerWindowName: openerWindowName,
						portletResourceNamespace: '<%= renderResponse.getNamespace() %>',
						saveCallback: saveCallback,
						version: workflowDefinitionVersion,
						versionLabel: '<liferay-ui:message key="version" />',
						dialog: {
							id: '<portlet:namespace />kaleoDesignerDialog',
							modal: true,
							width: A.one(Liferay.Util.getOpener()).get('region').width * 0.85,
							on: {
								close: function(event) { 
									event.preventDefault();
									console.log('opa');
									Liferay.fire(
										'closeWindow',
										{
											id: '<portlet:namespace />kaleoDesignerDialog'
										}
									);
								} 
							}
						}
					}
				);
			},
			['aui-base']
		);
	</aui:script>
</c:if>

<aui:script>
	Liferay.provide(
		Liferay.Util,
		'openKaleoDesignerPortlet',
		function(config) {
			var A = AUI();

			var kaleoURL = Liferay.PortletURL.createRenderURL();

			kaleoURL.setParameter('availableFields', config.availableFields);
			kaleoURL.setParameter('availablePropertyModels', config.availablePropertyModels);
			kaleoURL.setParameter('ddmStructureId', config.ddmStructureId);
			kaleoURL.setParameter('draftVersion', config.draftVersion);
			kaleoURL.setParameter('kaleoProcessId', config.kaleoProcessId);
			kaleoURL.setParameter('name', config.name);
			kaleoURL.setParameter('openerWindowName', config.openerWindowName);
			kaleoURL.setParameter('portletResourceNamespace', config.portletResourceNamespace);
			kaleoURL.setParameter('propertiesSaveCallback', config.propertiesSaveCallback);
			kaleoURL.setParameter('saveCallback', config.saveCallback);
			kaleoURL.setParameter('uiScope', config.uiScope);
			kaleoURL.setParameter('version', config.version);

			kaleoURL.setPortletId('2_WAR_kaleodesignerportlet');
			kaleoURL.setWindowState('pop_up');

			config.uri = kaleoURL.toString();

			var dialogConfig = config.dialog;

			if (!dialogConfig) {
				var region = A.one(Liferay.Util.getOpener()).get('region');

				dialogConfig = {
					modal: true,
					title: config.name,
					width: region.width * 0.85
				};

				config.dialog = dialogConfig;
			}

			if (!('align' in dialogConfig)) {
				dialogConfig.align = Liferay.Util.Window.ALIGN_CENTER;
			}

			var dialogIframeConfig = config.dialogIframe;

			if (!dialogIframeConfig) {
				dialogIframeConfig = {
					closeOnEscape: false
				};

				config.dialogIframe = dialogIframeConfig;
			}

			Liferay.Util.openWindow(config);
		},
		['liferay-portlet-url']
	);
</aui:script>