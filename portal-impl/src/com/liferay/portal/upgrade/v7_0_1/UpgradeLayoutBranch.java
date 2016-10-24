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

package com.liferay.portal.upgrade.v7_0_1;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.upgrade.v7_0_1.util.LayoutBranchTable;

/**
 * @author Miguel Pastor
 */
public class UpgradeLayoutBranch extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		alter(
			LayoutBranchTable.class,
			new AlterColumnName("LayoutBranchId", "layoutBranchId LONG"));
	}

}