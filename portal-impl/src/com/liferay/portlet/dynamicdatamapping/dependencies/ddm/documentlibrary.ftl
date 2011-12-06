<#include "../init.ftl">

<#assign groupLocalService = serviceLocator.findService("com.liferay.portal.service.GroupLocalService")>

<#assign controlPanelGroup = groupLocalService.getGroup(themeDisplay.getCompanyId(), "Control Panel")>

<#assign layoutLocalService = serviceLocator.findService("com.liferay.portal.service.LayoutLocalService")>

<#assign controlPanelPlid = layoutLocalService.getDefaultPlid(controlPanelGroup.getGroupId(), true)>

<#assign fileEntryTitle = "">
<#assign fileEntryURL = "">

<#if (fields??) && (fieldValue != "")>
	<#assign fileJSONObject = getFileJSONObject(fieldRawValue)>

	<#assign fileEntry = getFileEntry(fileJSONObject)>

	<#if (fileEntry != "")>
		<#assign fileEntryTitle = fileEntry.getTitle()>
		<#assign fileEntryURL = getFileEntryURL(fileEntry)>
	</#if>
</#if>

<@aui["field-wrapper"]>
	<@aui.input inlineField=true label=label name="${namespacedFieldName}Title" readonly="readonly" type="text" url=fileEntryURL value=fileEntryTitle>
		<#if required>
			<@aui.validator name="required" />
		</#if>
	</@aui.input>

	<@aui["button-row"]>
		<@aui.button id=namespacedFieldName value="select" />

		<@aui.button onClick="window['${portletNamespace}${namespacedFieldName}downloadFileEntry']();" value="download" />

		<@aui.button onClick="window['${portletNamespace}${namespacedFieldName}clearFileEntry']();" value="clear" />
	</@>

	<@aui.input name=namespacedFieldName type="hidden" value=fieldRawValue />
</@>

<@aui.script>
	Liferay.provide(
		window,
		'${portletNamespace}${namespacedFieldName}clearFileEntry',
		function() {
			window['${portletNamespace}${namespacedFieldName}setFileEntry']('', '', '', '');
		},
		[]
	);

	Liferay.provide(
		window,
		'${portletNamespace}${namespacedFieldName}downloadFileEntry',
		function() {
			var A = AUI();

			var titleNode = A.one('#${portletNamespace}${namespacedFieldName}Title');

			if (titleNode) {
				var url = titleNode.getAttribute('url');

				if (url) {
					location.href = url;
				}
			}
		},
		['aui-base']
	);

	Liferay.provide(
		window,
		'${portalUtil.getPortletNamespace("15")}selectDocumentLibrary',
		function(url, uuid, title, version) {
			window['${portletNamespace}${namespacedFieldName}setFileEntry'](url, uuid, title, version);
		},
		[]
	);

	Liferay.provide(
		window,
		'${portletNamespace}${namespacedFieldName}setFileEntry',
		function(url, uuid, title, version) {
			var A = AUI();

			var inputNode = A.one('#${portletNamespace}${namespacedFieldName}');

			if (inputNode) {
				inputNode.val(
					A.JSON.stringify(
						{
							groupId: ${scopeGroupId?c},
							uuid: uuid,
							version: version
						}
					)
				);
			}

			var titleNode = A.one('#${portletNamespace}${namespacedFieldName}Title');

			if (titleNode) {
				titleNode.setAttribute('url', url);
				titleNode.val(title);
			}
		},
		['json']
	);
</@>

<@aui.script use="liferay-portlet-url">
	var namespacedField = A.one('#${namespacedFieldName}');

	if (namespacedField) {
		namespacedField.on(
			'click',
			function(event) {
				var portletURL = Liferay.PortletURL.createRenderURL();

				portletURL.setParameter('groupId', ${scopeGroupId?c});
				portletURL.setParameter('struts_action', '/journal/select_document_library');

				portletURL.setPlid(${controlPanelPlid?c});

				portletURL.setPortletId('15');

				portletURL.setWindowState('pop_up');

				Liferay.Util.openWindow(
					{
						uri: portletURL.toString()
					}
				);
			}
		);
	}
</@>