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

package com.liferay.portalweb.socialofficehome.events.event.vieweventmultipleed;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialofficehome.events.event.viewevented.AddPageCalendarSOTest;
import com.liferay.portalweb.socialofficehome.events.event.viewevented.AddPortletCalendarSOTest;
import com.liferay.portalweb.socialofficehome.events.event.viewevented.TearDownEventSOTest;
import com.liferay.portalweb.socialofficehome.events.event.viewevented.TearDownPageCalendarSOTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewEventMultipleEDTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageCalendarSOTest.class);
		testSuite.addTestSuite(AddPortletCalendarSOTest.class);
		testSuite.addTestSuite(AddEvent1SOTest.class);
		testSuite.addTestSuite(AddEvent2SOTest.class);
		testSuite.addTestSuite(AddEvent3SOTest.class);
		testSuite.addTestSuite(ViewEventMultipleEDTest.class);
		testSuite.addTestSuite(TearDownEventSOTest.class);
		testSuite.addTestSuite(TearDownPageCalendarSOTest.class);

		return testSuite;
	}
}