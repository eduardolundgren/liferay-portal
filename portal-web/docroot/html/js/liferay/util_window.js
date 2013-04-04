AUI.add(
	'liferay-util-window',
	function(A) {
		var Lang = A.Lang;
		var Util = Liferay.Util;
		var Window = Util.Window;

		A.mix(
			Window,
			{
				DEFAULTS: {
					centered: true,
					modal: true,
					visible: true,
					zIndex: 1000
				},

				IFRAME_SUFFIX: '_iframe_',

				TITLE_TEMPLATE: '<h3/>',

				_winResizeHandler: null,

				getById: function(id) {
					var instance = this;

					return instance._map[id];
				},

				_bindDOMWinResizeIfNeeded: function() {
					var instance = this;

					if (!instance._winResizeHandler) {
						instance._winResizeHandler = A.getWin().after('windowresize', instance._syncWindowsUI, instance);
					}
				},

				_bindWindowHooks: function(modal, config) {
					var instance = this;

					var id = modal.get('id');

					var openingWindow = config.openingWindow;

					var refreshWindow = config.refreshWindow;

					modal._opener = openingWindow;
					modal._refreshWindow = refreshWindow;

					modal.after(
						'destroy',
						function(event) {
							instance._unregister(modal);

							modal = null;
						}
					);

					Liferay.after(
						'hashChange',
						function(event) {
							modal.iframe.set('uri', event.uri);
						}
					);

					Liferay.after(
						'popupReady',
						function(event) {
							var iframeId = id + instance.IFRAME_SUFFIX;

							if (event.windowName === iframeId) {
								event.dialog = modal;
								event.details[0].dialog = modal;

								if (event.doc) {
									Util.afterIframeLoaded(event);

									var modalUtil = event.win.Liferay.Util;

									modalUtil.Window._opener = openingWindow;

									modalUtil.Window._name = id;
								}

								modal.iframe.node.focus();
							}
						}
					);
				},

				_ensureDefaultId: function(config) {
					var instance = this;

					if (!Lang.isValue(config.id)) {
						config.id = A.guid();
					}

					config.iframeId = config.id + instance.IFRAME_SUFFIX;
				},

				_fetchOrCreateWindow: function(config) {
					var instance = this;

					var id = config.id;

					var dialogIframeConfig = instance._getDialogIframeConfig(config);

					var modal = instance.getById(id);

					if (!modal) {
						var titleNode = A.Node.create(instance.TITLE_TEMPLATE);

						modal = new A.Modal(
							{
								headerContent: titleNode,
								id: id
							}
						);

						if (dialogIframeConfig) {
							modal.plug(A.Plugin.DialogIframe, dialogIframeConfig);
						}

						modal.titleNode = titleNode;

						instance._bindWindowHooks(modal, config);

						instance._register(modal);
					}
					else {
						if (dialogIframeConfig) {
							modal.iframe.set('uri', dialogIframeConfig.uri);
						}
					}

					var modalConfig = instance._getWindowConfig(config);

					modal.setAttrs(modalConfig);

					modal.titleNode.html(config.title);

					return modal;
				},

				_getWindowConfig: function(config) {
					var instance = this;

					var modalConfig = A.merge(config.dialog, instance.DEFAULTS);

					modalConfig.id = config.id;

					delete modalConfig.headerContent;

					return modalConfig;
				},

				_getDialogIframeConfig: function(config) {
					var instance = this;

					var dialogIframeConfig;

					var iframeId = config.iframeId;

					var uri = config.uri;

					if (uri) {
						if (config.cache === false) {
							uri = Liferay.Util.addParams(A.guid() + '=' + Lang.now(), uri);
						}

						dialogIframeConfig = A.merge(
							config.dialogIframe,
							{
								bindLoadHandler: function() {
									var instance = this;

									var popupReady = false;

									Liferay.on(
										'popupReady',
										function(event) {
											instance.fire('load', event);

											popupReady = true;
										}
									);

									instance.node.on(
										'load',
										function(event) {
											if (!popupReady) {
												Liferay.fire(
													'popupReady',
													{
														windowName: iframeId
													}
												);
											}

											popupReady = false;
										}
									);
								},

								iframeId: iframeId,
								uri: uri
							}
						);
					}

					return dialogIframeConfig;
				},

				_getWinDefaultHeight: function() {
					var instance = this;

					return A.DOM.winHeight() * 0.95;
				},

				_getWinDefaultWidth: function() {
					var instance = this;

					return A.DOM.winWidth() * 0.95;
				},

				_openWindow: function(config) {
					var instance = this;

					instance._ensureDefaultId(config);

					var modal = instance._fetchOrCreateWindow(config);

					instance._setWindowDefaultSizeIfNeeded(modal);

					modal.render();

					instance._bindDOMWinResizeIfNeeded();

					return modal;
				},

				_register: function(modal) {
					var instance = this;

					var id = modal.get('id');

					instance._map[id] = modal;
					instance._map[id + instance.IFRAME_SUFFIX] = modal;
				},

				_setWindowDefaultSizeIfNeeded: function(modal) {
					var instance = this;

					var width = modal.get('width');
					var height = modal.get('height');

					if (width !== 'auto' || width !== '') {
						modal.set('width', instance._getWinDefaultWidth());
					}

					if (height !== 'auto' || height !== '') {
						modal.set('height', instance._getWinDefaultHeight());
					}
				},

				_syncWindowsUI: function() {
					var instance = this;

					var modals = instance._map;

					A.each(
						modals,
						function (modal) {
							if (modal.get('visible')) {
								instance._setWindowDefaultSizeIfNeeded(modal);

								modal.align();
							}
						}
					);
				},

				_unregister: function(modal) {
					var instance = this;

					var id = modal.get('id');

					delete instance._map[id];
					delete instance._map[id + instance.IFRAME_SUFFIX];
				}
			}
		);
	},
	'',
	{
		requires: ['aui-modal', 'aui-dialog-iframe-deprecated', 'event-resize']
	}
);