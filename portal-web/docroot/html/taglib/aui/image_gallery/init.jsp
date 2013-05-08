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
Map<String, Object> dynamicAttributes = (Map<String, Object>)request.getAttribute("aui:image-gallery:dynamicAttributes");
Map<String, Object> scopedAttributes = (Map<String, Object>)request.getAttribute("aui:image-gallery:scopedAttributes");
CustomAttributes customAttributes = (CustomAttributes)request.getAttribute("aui:image-gallery:customAttributes");

Map<String, Object> _options = new HashMap<String, Object>();

if ((scopedAttributes != null) && !scopedAttributes.isEmpty()) {
	_options.putAll(scopedAttributes);
}

if ((dynamicAttributes != null) && !dynamicAttributes.isEmpty()) {
	_options.putAll(dynamicAttributes);
}

%>

<%@ include file="/html/taglib/aui/init-alloy.jspf" %>

<%
java.util.HashMap align = _toHashMap(GetterUtil.getObject((java.lang.Object)request.getAttribute("aui:image-gallery:align")));
java.util.ArrayList alignOn = _toArrayList(GetterUtil.getObject((java.lang.Object)request.getAttribute("aui:image-gallery:alignOn")));
boolean anim = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:image-gallery:anim")), true);
java.lang.Object arrowLeftEl = (java.lang.Object)request.getAttribute("aui:image-gallery:arrowLeftEl");
java.lang.Object arrowRightEl = (java.lang.Object)request.getAttribute("aui:image-gallery:arrowRightEl");
boolean autoPlay = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:image-gallery:autoPlay")), false);
java.lang.Object imagegalleryBodyContent = (java.lang.Object)request.getAttribute("aui:image-gallery:imagegalleryBodyContent");
java.lang.String caption = GetterUtil.getString((java.lang.String)request.getAttribute("aui:image-gallery:caption"));
java.lang.Object captionEl = (java.lang.Object)request.getAttribute("aui:image-gallery:captionEl");
boolean captionFromTitle = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:image-gallery:captionFromTitle")), true);
boolean centered = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:image-gallery:centered")), true);
java.lang.Object closeEl = (java.lang.Object)request.getAttribute("aui:image-gallery:closeEl");
java.lang.Object constrain = (java.lang.Object)request.getAttribute("aui:image-gallery:constrain");
java.lang.String cssClass = GetterUtil.getString((java.lang.String)request.getAttribute("aui:image-gallery:cssClass"));
java.lang.Number currentIndex = GetterUtil.getNumber(String.valueOf(request.getAttribute("aui:image-gallery:currentIndex")), 0);
java.lang.Number delay = GetterUtil.getNumber(String.valueOf(request.getAttribute("aui:image-gallery:delay")), 7000);
boolean destroyed = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:image-gallery:destroyed")), false);
boolean disabled = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:image-gallery:disabled")), false);
java.lang.Object fillHeight = (java.lang.Object)request.getAttribute("aui:image-gallery:fillHeight");
boolean focused = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:image-gallery:focused")), false);
java.lang.Object footerContent = (java.lang.Object)request.getAttribute("aui:image-gallery:footerContent");
java.lang.Object headerContent = (java.lang.Object)request.getAttribute("aui:image-gallery:headerContent");
java.lang.Object height = (java.lang.Object)request.getAttribute("aui:image-gallery:height");
java.lang.String hideClass = GetterUtil.getString((java.lang.String)request.getAttribute("aui:image-gallery:hideClass"), "aui-helper-hidden");
java.lang.String imagegalleryId = GetterUtil.getString((java.lang.String)request.getAttribute("aui:image-gallery:imagegalleryId"));
java.lang.Object image = (java.lang.Object)request.getAttribute("aui:image-gallery:image");
java.util.HashMap imageAnim = _toHashMap(GetterUtil.getObject((java.lang.Object)request.getAttribute("aui:image-gallery:imageAnim")));
java.lang.Object infoEl = (java.lang.Object)request.getAttribute("aui:image-gallery:infoEl");
java.lang.String infoTemplate = GetterUtil.getString((java.lang.String)request.getAttribute("aui:image-gallery:infoTemplate"), "Image {current} of {total}");
boolean initialized = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:image-gallery:initialized")), false);
java.lang.Object links = (java.lang.Object)request.getAttribute("aui:image-gallery:links");
java.lang.Object loader = (java.lang.Object)request.getAttribute("aui:image-gallery:loader");
boolean loading = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:image-gallery:loading")), false);
java.lang.Object loadingEl = (java.lang.Object)request.getAttribute("aui:image-gallery:loadingEl");
java.lang.Number maxHeight = GetterUtil.getNumber(String.valueOf(request.getAttribute("aui:image-gallery:maxHeight")), 2147483647);
java.lang.Number maxWidth = GetterUtil.getNumber(String.valueOf(request.getAttribute("aui:image-gallery:maxWidth")), 2147483647);
java.lang.Object modal = (java.lang.Object)request.getAttribute("aui:image-gallery:modal");
java.util.HashMap paginator = _toHashMap(GetterUtil.getObject((java.lang.Object)request.getAttribute("aui:image-gallery:paginator")));
java.lang.Object paginatorEl = (java.lang.Object)request.getAttribute("aui:image-gallery:paginatorEl");
java.lang.Object paginatorInstance = (java.lang.Object)request.getAttribute("aui:image-gallery:paginatorInstance");
boolean paused = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:image-gallery:paused")), false);
java.lang.String pausedLabel = GetterUtil.getString((java.lang.String)request.getAttribute("aui:image-gallery:pausedLabel"));
boolean playing = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:image-gallery:playing")), false);
java.lang.String playingLabel = GetterUtil.getString((java.lang.String)request.getAttribute("aui:image-gallery:playingLabel"), "(Playing)");
boolean preloadAllImages = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:image-gallery:preloadAllImages")), false);
boolean preventOverlap = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:image-gallery:preventOverlap")), false);
java.lang.Object render = (java.lang.Object)request.getAttribute("aui:image-gallery:render");
boolean rendered = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:image-gallery:rendered")), false);
boolean repeat = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:image-gallery:repeat")), true);
boolean shim = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:image-gallery:shim")), false);
boolean showArrows = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:image-gallery:showArrows")), true);
boolean showClose = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:image-gallery:showClose")), true);
boolean showPlayer = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:image-gallery:showPlayer")), true);
java.util.HashMap strings = _toHashMap(GetterUtil.getObject((java.lang.Object)request.getAttribute("aui:image-gallery:strings")));
java.lang.Number tabIndex = GetterUtil.getNumber(String.valueOf(request.getAttribute("aui:image-gallery:tabIndex")), 0);
java.lang.Object toolbar = (java.lang.Object)request.getAttribute("aui:image-gallery:toolbar");
boolean totalLinks = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:image-gallery:totalLinks")), true);
boolean useARIA = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:image-gallery:useARIA")), true);
boolean useOriginalImage = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:image-gallery:useOriginalImage")), false);
boolean visible = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:image-gallery:visible")), true);
java.lang.Object width = (java.lang.Object)request.getAttribute("aui:image-gallery:width");
java.lang.Number x = GetterUtil.getNumber(String.valueOf(request.getAttribute("aui:image-gallery:x")), 0);
java.util.ArrayList xy = _toArrayList(GetterUtil.getObject((java.lang.Object)request.getAttribute("aui:image-gallery:xy"), "[0,0]"));
java.lang.Number y = GetterUtil.getNumber(String.valueOf(request.getAttribute("aui:image-gallery:y")), 0);
java.lang.Number zIndex = GetterUtil.getNumber(String.valueOf(request.getAttribute("aui:image-gallery:zIndex")), 0);
java.lang.Object afterAlignChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterAlignChange");
java.lang.Object afterAlignOnChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterAlignOnChange");
java.lang.Object afterAnim = (java.lang.Object)request.getAttribute("aui:image-gallery:afterAnim");
java.lang.Object afterAnimChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterAnimChange");
java.lang.Object afterArrowLeftElChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterArrowLeftElChange");
java.lang.Object afterArrowRightElChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterArrowRightElChange");
java.lang.Object afterAutoPlayChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterAutoPlayChange");
java.lang.Object afterBodyContentChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterBodyContentChange");
java.lang.Object afterBoundingBoxChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterBoundingBoxChange");
java.lang.Object afterCaptionChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterCaptionChange");
java.lang.Object afterCaptionElChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterCaptionElChange");
java.lang.Object afterCaptionFromTitleChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterCaptionFromTitleChange");
java.lang.Object afterCenteredChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterCenteredChange");
java.lang.Object afterCloseElChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterCloseElChange");
java.lang.Object afterConstrainChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterConstrainChange");
java.lang.Object afterContentBoxChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterContentBoxChange");
java.lang.Object afterCssClassChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterCssClassChange");
java.lang.Object afterCurrentIndexChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterCurrentIndexChange");
java.lang.Object afterDelayChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterDelayChange");
java.lang.Object afterDestroy = (java.lang.Object)request.getAttribute("aui:image-gallery:afterDestroy");
java.lang.Object afterDestroyedChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterDestroyedChange");
java.lang.Object afterDisabledChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterDisabledChange");
java.lang.Object afterFillHeightChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterFillHeightChange");
java.lang.Object afterFocusedChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterFocusedChange");
java.lang.Object afterFooterContentChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterFooterContentChange");
java.lang.Object afterHeaderContentChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterHeaderContentChange");
java.lang.Object afterHeightChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterHeightChange");
java.lang.Object afterHideClassChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterHideClassChange");
java.lang.Object afterIdChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterIdChange");
java.lang.Object afterImageAnimChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterImageAnimChange");
java.lang.Object afterImageChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterImageChange");
java.lang.Object afterInfoElChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterInfoElChange");
java.lang.Object afterInfoTemplateChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterInfoTemplateChange");
java.lang.Object afterInit = (java.lang.Object)request.getAttribute("aui:image-gallery:afterInit");
java.lang.Object afterInitializedChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterInitializedChange");
java.lang.Object afterLinksChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterLinksChange");
java.lang.Object afterLoad = (java.lang.Object)request.getAttribute("aui:image-gallery:afterLoad");
java.lang.Object afterLoaderChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterLoaderChange");
java.lang.Object afterLoadingChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterLoadingChange");
java.lang.Object afterLoadingElChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterLoadingElChange");
java.lang.Object afterMaxHeightChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterMaxHeightChange");
java.lang.Object afterMaxWidthChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterMaxWidthChange");
java.lang.Object afterModalChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterModalChange");
java.lang.Object afterPaginatorChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterPaginatorChange");
java.lang.Object afterPaginatorElChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterPaginatorElChange");
java.lang.Object afterPaginatorInstanceChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterPaginatorInstanceChange");
java.lang.Object afterPausedChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterPausedChange");
java.lang.Object afterPausedLabelChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterPausedLabelChange");
java.lang.Object afterPlayingChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterPlayingChange");
java.lang.Object afterPlayingLabelChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterPlayingLabelChange");
java.lang.Object afterPreloadAllImagesChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterPreloadAllImagesChange");
java.lang.Object afterPreventOverlapChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterPreventOverlapChange");
java.lang.Object afterRenderChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterRenderChange");
java.lang.Object afterRenderedChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterRenderedChange");
java.lang.Object afterRepeatChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterRepeatChange");
java.lang.Object afterRequest = (java.lang.Object)request.getAttribute("aui:image-gallery:afterRequest");
java.lang.Object afterShimChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterShimChange");
java.lang.Object afterShowArrowsChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterShowArrowsChange");
java.lang.Object afterShowCloseChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterShowCloseChange");
java.lang.Object afterShowPlayerChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterShowPlayerChange");
java.lang.Object afterSrcNodeChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterSrcNodeChange");
java.lang.Object afterStringsChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterStringsChange");
java.lang.Object afterTabIndexChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterTabIndexChange");
java.lang.Object afterToolbarChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterToolbarChange");
java.lang.Object afterTotalLinksChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterTotalLinksChange");
java.lang.Object afterUseARIAChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterUseARIAChange");
java.lang.Object afterUseOriginalImageChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterUseOriginalImageChange");
java.lang.Object afterVisibleChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterVisibleChange");
java.lang.Object afterContentUpdate = (java.lang.Object)request.getAttribute("aui:image-gallery:afterContentUpdate");
java.lang.Object afterRender = (java.lang.Object)request.getAttribute("aui:image-gallery:afterRender");
java.lang.Object afterWidthChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterWidthChange");
java.lang.Object afterXChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterXChange");
java.lang.Object afterXyChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterXyChange");
java.lang.Object afterYChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterYChange");
java.lang.Object afterZIndexChange = (java.lang.Object)request.getAttribute("aui:image-gallery:afterZIndexChange");
java.lang.Object onAlignChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onAlignChange");
java.lang.Object onAlignOnChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onAlignOnChange");
java.lang.Object onAnim = (java.lang.Object)request.getAttribute("aui:image-gallery:onAnim");
java.lang.Object onAnimChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onAnimChange");
java.lang.Object onArrowLeftElChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onArrowLeftElChange");
java.lang.Object onArrowRightElChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onArrowRightElChange");
java.lang.Object onAutoPlayChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onAutoPlayChange");
java.lang.Object onBodyContentChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onBodyContentChange");
java.lang.Object onBoundingBoxChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onBoundingBoxChange");
java.lang.Object onCaptionChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onCaptionChange");
java.lang.Object onCaptionElChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onCaptionElChange");
java.lang.Object onCaptionFromTitleChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onCaptionFromTitleChange");
java.lang.Object onCenteredChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onCenteredChange");
java.lang.Object onCloseElChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onCloseElChange");
java.lang.Object onConstrainChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onConstrainChange");
java.lang.Object onContentBoxChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onContentBoxChange");
java.lang.Object onCssClassChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onCssClassChange");
java.lang.Object onCurrentIndexChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onCurrentIndexChange");
java.lang.Object onDelayChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onDelayChange");
java.lang.Object onDestroy = (java.lang.Object)request.getAttribute("aui:image-gallery:onDestroy");
java.lang.Object onDestroyedChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onDestroyedChange");
java.lang.Object onDisabledChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onDisabledChange");
java.lang.Object onFillHeightChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onFillHeightChange");
java.lang.Object onFocusedChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onFocusedChange");
java.lang.Object onFooterContentChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onFooterContentChange");
java.lang.Object onHeaderContentChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onHeaderContentChange");
java.lang.Object onHeightChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onHeightChange");
java.lang.Object onHideClassChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onHideClassChange");
java.lang.Object onIdChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onIdChange");
java.lang.Object onImageAnimChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onImageAnimChange");
java.lang.Object onImageChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onImageChange");
java.lang.Object onInfoElChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onInfoElChange");
java.lang.Object onInfoTemplateChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onInfoTemplateChange");
java.lang.Object onInit = (java.lang.Object)request.getAttribute("aui:image-gallery:onInit");
java.lang.Object onInitializedChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onInitializedChange");
java.lang.Object onLinksChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onLinksChange");
java.lang.Object onLoad = (java.lang.Object)request.getAttribute("aui:image-gallery:onLoad");
java.lang.Object onLoaderChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onLoaderChange");
java.lang.Object onLoadingChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onLoadingChange");
java.lang.Object onLoadingElChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onLoadingElChange");
java.lang.Object onMaxHeightChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onMaxHeightChange");
java.lang.Object onMaxWidthChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onMaxWidthChange");
java.lang.Object onModalChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onModalChange");
java.lang.Object onPaginatorChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onPaginatorChange");
java.lang.Object onPaginatorElChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onPaginatorElChange");
java.lang.Object onPaginatorInstanceChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onPaginatorInstanceChange");
java.lang.Object onPausedChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onPausedChange");
java.lang.Object onPausedLabelChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onPausedLabelChange");
java.lang.Object onPlayingChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onPlayingChange");
java.lang.Object onPlayingLabelChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onPlayingLabelChange");
java.lang.Object onPreloadAllImagesChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onPreloadAllImagesChange");
java.lang.Object onPreventOverlapChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onPreventOverlapChange");
java.lang.Object onRenderChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onRenderChange");
java.lang.Object onRenderedChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onRenderedChange");
java.lang.Object onRepeatChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onRepeatChange");
java.lang.Object onRequest = (java.lang.Object)request.getAttribute("aui:image-gallery:onRequest");
java.lang.Object onShimChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onShimChange");
java.lang.Object onShowArrowsChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onShowArrowsChange");
java.lang.Object onShowCloseChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onShowCloseChange");
java.lang.Object onShowPlayerChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onShowPlayerChange");
java.lang.Object onSrcNodeChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onSrcNodeChange");
java.lang.Object onStringsChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onStringsChange");
java.lang.Object onTabIndexChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onTabIndexChange");
java.lang.Object onToolbarChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onToolbarChange");
java.lang.Object onTotalLinksChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onTotalLinksChange");
java.lang.Object onUseARIAChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onUseARIAChange");
java.lang.Object onUseOriginalImageChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onUseOriginalImageChange");
java.lang.Object onVisibleChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onVisibleChange");
java.lang.Object onContentUpdate = (java.lang.Object)request.getAttribute("aui:image-gallery:onContentUpdate");
java.lang.Object onRender = (java.lang.Object)request.getAttribute("aui:image-gallery:onRender");
java.lang.Object onWidthChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onWidthChange");
java.lang.Object onXChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onXChange");
java.lang.Object onXyChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onXyChange");
java.lang.Object onYChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onYChange");
java.lang.Object onZIndexChange = (java.lang.Object)request.getAttribute("aui:image-gallery:onZIndexChange");

_updateOptions(_options, "align", align);
_updateOptions(_options, "alignOn", alignOn);
_updateOptions(_options, "anim", anim);
_updateOptions(_options, "arrowLeftEl", arrowLeftEl);
_updateOptions(_options, "arrowRightEl", arrowRightEl);
_updateOptions(_options, "autoPlay", autoPlay);
_updateOptions(_options, "imagegalleryBodyContent", imagegalleryBodyContent);
_updateOptions(_options, "boundingBox", boundingBox);
_updateOptions(_options, "caption", caption);
_updateOptions(_options, "captionEl", captionEl);
_updateOptions(_options, "captionFromTitle", captionFromTitle);
_updateOptions(_options, "centered", centered);
_updateOptions(_options, "closeEl", closeEl);
_updateOptions(_options, "constrain", constrain);
_updateOptions(_options, "contentBox", contentBox);
_updateOptions(_options, "cssClass", cssClass);
_updateOptions(_options, "currentIndex", currentIndex);
_updateOptions(_options, "delay", delay);
_updateOptions(_options, "destroyed", destroyed);
_updateOptions(_options, "disabled", disabled);
_updateOptions(_options, "fillHeight", fillHeight);
_updateOptions(_options, "focused", focused);
_updateOptions(_options, "footerContent", footerContent);
_updateOptions(_options, "headerContent", headerContent);
_updateOptions(_options, "height", height);
_updateOptions(_options, "hideClass", hideClass);
_updateOptions(_options, "imagegalleryId", imagegalleryId);
_updateOptions(_options, "image", image);
_updateOptions(_options, "imageAnim", imageAnim);
_updateOptions(_options, "infoEl", infoEl);
_updateOptions(_options, "infoTemplate", infoTemplate);
_updateOptions(_options, "initialized", initialized);
_updateOptions(_options, "links", links);
_updateOptions(_options, "loader", loader);
_updateOptions(_options, "loading", loading);
_updateOptions(_options, "loadingEl", loadingEl);
_updateOptions(_options, "maxHeight", maxHeight);
_updateOptions(_options, "maxWidth", maxWidth);
_updateOptions(_options, "modal", modal);
_updateOptions(_options, "paginator", paginator);
_updateOptions(_options, "paginatorEl", paginatorEl);
_updateOptions(_options, "paginatorInstance", paginatorInstance);
_updateOptions(_options, "paused", paused);
_updateOptions(_options, "pausedLabel", pausedLabel);
_updateOptions(_options, "playing", playing);
_updateOptions(_options, "playingLabel", playingLabel);
_updateOptions(_options, "preloadAllImages", preloadAllImages);
_updateOptions(_options, "preventOverlap", preventOverlap);
_updateOptions(_options, "render", render);
_updateOptions(_options, "rendered", rendered);
_updateOptions(_options, "repeat", repeat);
_updateOptions(_options, "shim", shim);
_updateOptions(_options, "showArrows", showArrows);
_updateOptions(_options, "showClose", showClose);
_updateOptions(_options, "showPlayer", showPlayer);
_updateOptions(_options, "srcNode", srcNode);
_updateOptions(_options, "strings", strings);
_updateOptions(_options, "tabIndex", tabIndex);
_updateOptions(_options, "toolbar", toolbar);
_updateOptions(_options, "totalLinks", totalLinks);
_updateOptions(_options, "useARIA", useARIA);
_updateOptions(_options, "useOriginalImage", useOriginalImage);
_updateOptions(_options, "visible", visible);
_updateOptions(_options, "width", width);
_updateOptions(_options, "x", x);
_updateOptions(_options, "xy", xy);
_updateOptions(_options, "y", y);
_updateOptions(_options, "zIndex", zIndex);
_updateOptions(_options, "afterAlignChange", afterAlignChange);
_updateOptions(_options, "afterAlignOnChange", afterAlignOnChange);
_updateOptions(_options, "afterAnim", afterAnim);
_updateOptions(_options, "afterAnimChange", afterAnimChange);
_updateOptions(_options, "afterArrowLeftElChange", afterArrowLeftElChange);
_updateOptions(_options, "afterArrowRightElChange", afterArrowRightElChange);
_updateOptions(_options, "afterAutoPlayChange", afterAutoPlayChange);
_updateOptions(_options, "afterBodyContentChange", afterBodyContentChange);
_updateOptions(_options, "afterBoundingBoxChange", afterBoundingBoxChange);
_updateOptions(_options, "afterCaptionChange", afterCaptionChange);
_updateOptions(_options, "afterCaptionElChange", afterCaptionElChange);
_updateOptions(_options, "afterCaptionFromTitleChange", afterCaptionFromTitleChange);
_updateOptions(_options, "afterCenteredChange", afterCenteredChange);
_updateOptions(_options, "afterCloseElChange", afterCloseElChange);
_updateOptions(_options, "afterConstrainChange", afterConstrainChange);
_updateOptions(_options, "afterContentBoxChange", afterContentBoxChange);
_updateOptions(_options, "afterCssClassChange", afterCssClassChange);
_updateOptions(_options, "afterCurrentIndexChange", afterCurrentIndexChange);
_updateOptions(_options, "afterDelayChange", afterDelayChange);
_updateOptions(_options, "afterDestroy", afterDestroy);
_updateOptions(_options, "afterDestroyedChange", afterDestroyedChange);
_updateOptions(_options, "afterDisabledChange", afterDisabledChange);
_updateOptions(_options, "afterFillHeightChange", afterFillHeightChange);
_updateOptions(_options, "afterFocusedChange", afterFocusedChange);
_updateOptions(_options, "afterFooterContentChange", afterFooterContentChange);
_updateOptions(_options, "afterHeaderContentChange", afterHeaderContentChange);
_updateOptions(_options, "afterHeightChange", afterHeightChange);
_updateOptions(_options, "afterHideClassChange", afterHideClassChange);
_updateOptions(_options, "afterIdChange", afterIdChange);
_updateOptions(_options, "afterImageAnimChange", afterImageAnimChange);
_updateOptions(_options, "afterImageChange", afterImageChange);
_updateOptions(_options, "afterInfoElChange", afterInfoElChange);
_updateOptions(_options, "afterInfoTemplateChange", afterInfoTemplateChange);
_updateOptions(_options, "afterInit", afterInit);
_updateOptions(_options, "afterInitializedChange", afterInitializedChange);
_updateOptions(_options, "afterLinksChange", afterLinksChange);
_updateOptions(_options, "afterLoad", afterLoad);
_updateOptions(_options, "afterLoaderChange", afterLoaderChange);
_updateOptions(_options, "afterLoadingChange", afterLoadingChange);
_updateOptions(_options, "afterLoadingElChange", afterLoadingElChange);
_updateOptions(_options, "afterMaxHeightChange", afterMaxHeightChange);
_updateOptions(_options, "afterMaxWidthChange", afterMaxWidthChange);
_updateOptions(_options, "afterModalChange", afterModalChange);
_updateOptions(_options, "afterPaginatorChange", afterPaginatorChange);
_updateOptions(_options, "afterPaginatorElChange", afterPaginatorElChange);
_updateOptions(_options, "afterPaginatorInstanceChange", afterPaginatorInstanceChange);
_updateOptions(_options, "afterPausedChange", afterPausedChange);
_updateOptions(_options, "afterPausedLabelChange", afterPausedLabelChange);
_updateOptions(_options, "afterPlayingChange", afterPlayingChange);
_updateOptions(_options, "afterPlayingLabelChange", afterPlayingLabelChange);
_updateOptions(_options, "afterPreloadAllImagesChange", afterPreloadAllImagesChange);
_updateOptions(_options, "afterPreventOverlapChange", afterPreventOverlapChange);
_updateOptions(_options, "afterRenderChange", afterRenderChange);
_updateOptions(_options, "afterRenderedChange", afterRenderedChange);
_updateOptions(_options, "afterRepeatChange", afterRepeatChange);
_updateOptions(_options, "afterRequest", afterRequest);
_updateOptions(_options, "afterShimChange", afterShimChange);
_updateOptions(_options, "afterShowArrowsChange", afterShowArrowsChange);
_updateOptions(_options, "afterShowCloseChange", afterShowCloseChange);
_updateOptions(_options, "afterShowPlayerChange", afterShowPlayerChange);
_updateOptions(_options, "afterSrcNodeChange", afterSrcNodeChange);
_updateOptions(_options, "afterStringsChange", afterStringsChange);
_updateOptions(_options, "afterTabIndexChange", afterTabIndexChange);
_updateOptions(_options, "afterToolbarChange", afterToolbarChange);
_updateOptions(_options, "afterTotalLinksChange", afterTotalLinksChange);
_updateOptions(_options, "afterUseARIAChange", afterUseARIAChange);
_updateOptions(_options, "afterUseOriginalImageChange", afterUseOriginalImageChange);
_updateOptions(_options, "afterVisibleChange", afterVisibleChange);
_updateOptions(_options, "afterContentUpdate", afterContentUpdate);
_updateOptions(_options, "afterRender", afterRender);
_updateOptions(_options, "afterWidthChange", afterWidthChange);
_updateOptions(_options, "afterXChange", afterXChange);
_updateOptions(_options, "afterXyChange", afterXyChange);
_updateOptions(_options, "afterYChange", afterYChange);
_updateOptions(_options, "afterZIndexChange", afterZIndexChange);
_updateOptions(_options, "onAlignChange", onAlignChange);
_updateOptions(_options, "onAlignOnChange", onAlignOnChange);
_updateOptions(_options, "onAnim", onAnim);
_updateOptions(_options, "onAnimChange", onAnimChange);
_updateOptions(_options, "onArrowLeftElChange", onArrowLeftElChange);
_updateOptions(_options, "onArrowRightElChange", onArrowRightElChange);
_updateOptions(_options, "onAutoPlayChange", onAutoPlayChange);
_updateOptions(_options, "onBodyContentChange", onBodyContentChange);
_updateOptions(_options, "onBoundingBoxChange", onBoundingBoxChange);
_updateOptions(_options, "onCaptionChange", onCaptionChange);
_updateOptions(_options, "onCaptionElChange", onCaptionElChange);
_updateOptions(_options, "onCaptionFromTitleChange", onCaptionFromTitleChange);
_updateOptions(_options, "onCenteredChange", onCenteredChange);
_updateOptions(_options, "onCloseElChange", onCloseElChange);
_updateOptions(_options, "onConstrainChange", onConstrainChange);
_updateOptions(_options, "onContentBoxChange", onContentBoxChange);
_updateOptions(_options, "onCssClassChange", onCssClassChange);
_updateOptions(_options, "onCurrentIndexChange", onCurrentIndexChange);
_updateOptions(_options, "onDelayChange", onDelayChange);
_updateOptions(_options, "onDestroy", onDestroy);
_updateOptions(_options, "onDestroyedChange", onDestroyedChange);
_updateOptions(_options, "onDisabledChange", onDisabledChange);
_updateOptions(_options, "onFillHeightChange", onFillHeightChange);
_updateOptions(_options, "onFocusedChange", onFocusedChange);
_updateOptions(_options, "onFooterContentChange", onFooterContentChange);
_updateOptions(_options, "onHeaderContentChange", onHeaderContentChange);
_updateOptions(_options, "onHeightChange", onHeightChange);
_updateOptions(_options, "onHideClassChange", onHideClassChange);
_updateOptions(_options, "onIdChange", onIdChange);
_updateOptions(_options, "onImageAnimChange", onImageAnimChange);
_updateOptions(_options, "onImageChange", onImageChange);
_updateOptions(_options, "onInfoElChange", onInfoElChange);
_updateOptions(_options, "onInfoTemplateChange", onInfoTemplateChange);
_updateOptions(_options, "onInit", onInit);
_updateOptions(_options, "onInitializedChange", onInitializedChange);
_updateOptions(_options, "onLinksChange", onLinksChange);
_updateOptions(_options, "onLoad", onLoad);
_updateOptions(_options, "onLoaderChange", onLoaderChange);
_updateOptions(_options, "onLoadingChange", onLoadingChange);
_updateOptions(_options, "onLoadingElChange", onLoadingElChange);
_updateOptions(_options, "onMaxHeightChange", onMaxHeightChange);
_updateOptions(_options, "onMaxWidthChange", onMaxWidthChange);
_updateOptions(_options, "onModalChange", onModalChange);
_updateOptions(_options, "onPaginatorChange", onPaginatorChange);
_updateOptions(_options, "onPaginatorElChange", onPaginatorElChange);
_updateOptions(_options, "onPaginatorInstanceChange", onPaginatorInstanceChange);
_updateOptions(_options, "onPausedChange", onPausedChange);
_updateOptions(_options, "onPausedLabelChange", onPausedLabelChange);
_updateOptions(_options, "onPlayingChange", onPlayingChange);
_updateOptions(_options, "onPlayingLabelChange", onPlayingLabelChange);
_updateOptions(_options, "onPreloadAllImagesChange", onPreloadAllImagesChange);
_updateOptions(_options, "onPreventOverlapChange", onPreventOverlapChange);
_updateOptions(_options, "onRenderChange", onRenderChange);
_updateOptions(_options, "onRenderedChange", onRenderedChange);
_updateOptions(_options, "onRepeatChange", onRepeatChange);
_updateOptions(_options, "onRequest", onRequest);
_updateOptions(_options, "onShimChange", onShimChange);
_updateOptions(_options, "onShowArrowsChange", onShowArrowsChange);
_updateOptions(_options, "onShowCloseChange", onShowCloseChange);
_updateOptions(_options, "onShowPlayerChange", onShowPlayerChange);
_updateOptions(_options, "onSrcNodeChange", onSrcNodeChange);
_updateOptions(_options, "onStringsChange", onStringsChange);
_updateOptions(_options, "onTabIndexChange", onTabIndexChange);
_updateOptions(_options, "onToolbarChange", onToolbarChange);
_updateOptions(_options, "onTotalLinksChange", onTotalLinksChange);
_updateOptions(_options, "onUseARIAChange", onUseARIAChange);
_updateOptions(_options, "onUseOriginalImageChange", onUseOriginalImageChange);
_updateOptions(_options, "onVisibleChange", onVisibleChange);
_updateOptions(_options, "onContentUpdate", onContentUpdate);
_updateOptions(_options, "onRender", onRender);
_updateOptions(_options, "onWidthChange", onWidthChange);
_updateOptions(_options, "onXChange", onXChange);
_updateOptions(_options, "onXyChange", onXyChange);
_updateOptions(_options, "onYChange", onYChange);
_updateOptions(_options, "onZIndexChange", onZIndexChange);
%>

<%@ include file="/html/taglib/aui/image_gallery/init-ext.jspf" %>

<%!
private static final String _NAMESPACE = "aui:image-gallery:";
%>