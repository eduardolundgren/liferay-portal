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

package com.liferay.portalweb.portal.dbupgrade.sampledata6120.announcements.announcementsentry;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddPortletAnnouncementsEntryTest extends BaseTestCase {
	public void testAddPortletAnnouncementsEntry() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open(
			"/web/announcements-entry-community/announcements-entry-page");
		selenium.clickAt("link=Announcements Entry Page",
			RuntimeVariables.replace("Announcements Entry Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
		assertEquals(RuntimeVariables.replace("Add"),
			selenium.getText("//li[@id='_145_addContent']/a/span"));
		selenium.mouseOver("//li[@id='_145_addContent']/a/span");
		selenium.waitForVisible("//a[@id='_145_addApplication']");
		assertTrue(selenium.isPartialText("//a[@id='_145_addApplication']",
				"More"));
		selenium.clickAt("//a[@id='_145_addApplication']",
			RuntimeVariables.replace("More"));
		selenium.waitForVisible("//input[@id='layout_configuration_content']");
		selenium.typeKeys("//input[@id='layout_configuration_content']",
			RuntimeVariables.replace("a"));
		selenium.waitForVisible("//div[@title='Announcements']/p/a");
		selenium.clickAt("//div[@title='Announcements']/p/a",
			RuntimeVariables.replace("Add"));
		selenium.waitForVisible("//section");
		assertTrue(selenium.isVisible("//section"));
	}
}