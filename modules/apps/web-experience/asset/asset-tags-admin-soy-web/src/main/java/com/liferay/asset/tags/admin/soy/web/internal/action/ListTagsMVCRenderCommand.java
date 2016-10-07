/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.asset.tags.admin.soy.web.internal.action;

import com.liferay.asset.tags.admin.soy.web.internal.constants.AssetTagsAdminPortletKeys;
import com.liferay.asset.tags.admin.soy.web.internal.display.context.AssetTagsDisplayContext;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Chema Balsas
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + AssetTagsAdminPortletKeys.ASSET_TAGS_ADMIN_SOY, "mvc.command.name=/"
	},
	service = MVCRenderCommand.class
)
public class ListTagsMVCRenderCommand implements MVCRenderCommand {

	public static final String PATH = "AssetTagsAdminSoyListTags";

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		Template template = (Template)renderRequest.getAttribute(
			WebKeys.TEMPLATE);

		//template.put("addPokemonURL", getAddPokemonURL(renderResponse));

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		template.put("pathThemeImages", themeDisplay.getPathThemeImages());

		User user = themeDisplay.getUser();

		List<Map<String, Object>> addMenuItems = new ArrayList<>();

		Map<String, Object> menuItem = new HashMap<>();

		menuItem.put("id", "cacafuti.id");
		menuItem.put("title", "cacafuti.title");
		menuItem.put("url", "cacafuti.url");

		addMenuItems.add(menuItem);

		Map<String, Object> addMenu = new HashMap<>();
		addMenu.put("items", addMenuItems);

		template.put("addMenu", addMenu);

		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);

		AssetTagsDisplayContext assetTagsDisplayContext = new AssetTagsDisplayContext(renderRequest, renderResponse, httpServletRequest);

		template.put("displayStyle", assetTagsDisplayContext.getDisplayStyle());
		template.put("tags", assetTagsDisplayContext.getTagsSearchContainer().getResults());

		Map<String, Object> button1 = new HashMap<>();
		button1.put("active", "true");
		button1.put("href", "#1");
		button1.put("icon", "cards2");
		button1.put("label", "Action 1");

		Map<String, Object> button2 = new HashMap<>();
		button2.put("href", "#2");
		button2.put("icon", "list");
		button2.put("label", "Action 2");

		Map<String, Object> button3 = new HashMap<>();
		button3.put("cssClasses", "my-custom-class");
		button3.put("href", "#3");
		button3.put("icon", "table2");
		button3.put("label", "Action 3");

		List<Map<String, Object>> managementBarButtons = new ArrayList<>();
		managementBarButtons.add(button1);
		managementBarButtons.add(button2);
		managementBarButtons.add(button3);

		Map<String, Object> filter1 = new HashMap<>();
		filter1.put("label", "All");
		filter1.put("type", "dropdown");

		Map<String, Object> filter2 = new HashMap<>();
		filter2.put("label", "Order by: Name");
		filter2.put("type", "dropdown");

		Map<String, Object> filter3 = new HashMap<>();
		filter3.put("active", true);
		filter3.put("href", "#filter3");
		filter3.put("icon", "caret-top");
		filter3.put("type", "button");

		Map<String, Object> filter4 = new HashMap<>();
		filter4.put("href", "#filter4");
		filter4.put("icon", "caret-bottom");
		filter4.put("type", "button");

		List<Map<String, Object>> managementBarFilters = new ArrayList<>();
		managementBarFilters.add(filter1);
		managementBarFilters.add(filter2);
		managementBarFilters.add(filter3);
		managementBarFilters.add(filter4);

		Map<String, Object> managementBar = new HashMap<>();

		managementBar.put("buttons", managementBarButtons);
		managementBar.put("filters", managementBarFilters);
		managementBar.put("showCheckbox", true);

		template.put("managementBar", managementBar);

		List<Map<String, Object>> breadcrumbs = new ArrayList<>();

		Map<String, Object> breadcrumb1 = new HashMap<>();
		breadcrumb1.put("href", "#0");
		breadcrumb1.put("label", "Home");

		Map<String, Object> breadcrumb2 = new HashMap<>();
		breadcrumb2.put("href", "#1");
		breadcrumb2.put("label", "Level 1");

		Map<String, Object> breadcrumb3 = new HashMap<>();
		breadcrumb3.put("label", "Level 2");
		breadcrumb3.put("active", true);

		breadcrumbs.add(breadcrumb1);
		breadcrumbs.add(breadcrumb2);
		breadcrumbs.add(breadcrumb3);

		template.put("breadcrumbs", breadcrumbs);

		//List<Pokemon> pokemons = _pokemonLocalService.getPokemons(user.getGroupId());

		//template.put("pokemons", toSoyData(pokemons, renderResponse));

		//template.put("originalPokemonList", toSoyData(pokemons, renderResponse));

		return PATH;
	}
}