/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.liferay.portalweb.portlet.documentlibrary.document.unlockfolderdocument;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AssertUnlockFolderDocumentTest extends BaseTestCase {
	public void testAssertUnlockFolderDocument() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("link=Documents and Media Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Documents and Media Test Page",
			RuntimeVariables.replace("Documents and Media Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("DML Folder Name"),
			selenium.getText("//span[@class='document-title']"));
		selenium.clickAt("//span[@class='document-title']",
			RuntimeVariables.replace("DML Folder Name"));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (RuntimeVariables.replace("DML Folder Name")
										.equals(selenium.getText(
								"//li[@class='folder selected']/a"))) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("DML Folder Name"),
			selenium.getText("//li[@class='folder selected']/a"));
		assertFalse(selenium.isElementPresent("//img[@class='locked-icon']"));
		assertEquals(RuntimeVariables.replace("DML Folder Document Title"),
			selenium.getText("//span[@class='document-title']"));
		selenium.clickAt("//span[@class='document-title']",
			RuntimeVariables.replace("DML Folder Document Title"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertFalse(selenium.isTextPresent(
				"You now have a lock on this document. No one else can edit this document until you unlock it. This lock will automatically expire in 0 week."));
		assertEquals(RuntimeVariables.replace("Edit"),
			selenium.getText("//button[1]"));
		selenium.clickAt("//button[1]", RuntimeVariables.replace("Edit"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertFalse(selenium.isTextPresent(
				"You now have a lock on this document. No one else can edit this document until you unlock it. This lock will automatically expire in 0 week."));
	}
}