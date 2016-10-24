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

package com.liferay.sync.engine.document.library.util.comparator;

import com.liferay.sync.engine.model.SyncFile;

import java.util.Comparator;

/**
 * @author Shinn Lok
 */
public class SyncFileFilePathNameComparator implements Comparator<SyncFile> {

	@Override
	public int compare(SyncFile syncFile1, SyncFile syncFile2) {
		String filePathName1 = syncFile1.getFilePathName();
		String filePathName2 = syncFile2.getFilePathName();

		return filePathName1.compareToIgnoreCase(filePathName2);
	}

}