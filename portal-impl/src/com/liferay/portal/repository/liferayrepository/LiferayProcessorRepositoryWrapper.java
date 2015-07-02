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

package com.liferay.portal.repository.liferayrepository;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.Repository;
import com.liferay.portal.kernel.repository.capabilities.ProcessorCapability;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.repository.util.RepositoryWrapper;
import com.liferay.portal.service.ServiceContext;

import java.io.File;
import java.io.InputStream;

/**
 * @author Adolfo Pérez
 */
public class LiferayProcessorRepositoryWrapper extends RepositoryWrapper {

	public LiferayProcessorRepositoryWrapper(
		Repository repository, ProcessorCapability processorCapability) {

		super(repository);

		_processorCapability = processorCapability;
	}

	@Override
	public FileEntry addFileEntry(
			long userId, long folderId, String sourceFileName, String mimeType,
			String title, String description, String changeLog, File file,
			ServiceContext serviceContext)
		throws PortalException {

		FileEntry fileEntry = super.addFileEntry(
			userId, folderId, sourceFileName, mimeType, title, description,
			changeLog, file, serviceContext);

		_processorCapability.generateNew(fileEntry);

		return fileEntry;
	}

	@Override
	public FileEntry addFileEntry(
			long userId, long folderId, String sourceFileName, String mimeType,
			String title, String description, String changeLog, InputStream is,
			long size, ServiceContext serviceContext)
		throws PortalException {

		FileEntry fileEntry = super.addFileEntry(
			userId, folderId, sourceFileName, mimeType, title, description,
			changeLog, is, size, serviceContext);

		_processorCapability.generateNew(fileEntry);

		return fileEntry;
	}

	@Override
	public FileVersion cancelCheckOut(long fileEntryId) throws PortalException {
		FileEntry fileEntry = getFileEntry(fileEntryId);

		_processorCapability.cleanUp(fileEntry.getLatestFileVersion());

		FileVersion fileVersion = super.cancelCheckOut(fileEntryId);

		_processorCapability.generateNew(fileEntry);

		return fileVersion;
	}

	@Override
	public void checkInFileEntry(
			long userId, long fileEntryId, boolean major, String changeLog,
			ServiceContext serviceContext)
		throws PortalException {

		FileEntry fileEntry = getFileEntry(fileEntryId);

		_processorCapability.cleanUp(fileEntry.getLatestFileVersion());

		super.checkInFileEntry(
			userId, fileEntryId, major, changeLog, serviceContext);

		_processorCapability.copyPrevious(fileEntry.getFileVersion());
	}

	@Override
	public void checkInFileEntry(
			long userId, long fileEntryId, String lockUuid,
			ServiceContext serviceContext)
		throws PortalException {

		FileEntry fileEntry = getFileEntry(fileEntryId);

		_processorCapability.cleanUp(fileEntry.getLatestFileVersion());

		super.checkInFileEntry(userId, fileEntryId, lockUuid, serviceContext);

		_processorCapability.copyPrevious(fileEntry.getFileVersion());
	}

	@Override
	public FileEntry checkOutFileEntry(
			long fileEntryId, ServiceContext serviceContext)
		throws PortalException {

		FileEntry oldFileEntry = getFileEntry(fileEntryId);

		FileVersion oldFileVersion = oldFileEntry.getFileVersion();

		FileEntry fileEntry = super.checkOutFileEntry(
			fileEntryId, serviceContext);

		_processorCapability.copyPrevious(oldFileVersion);

		return fileEntry;
	}

	@Override
	public FileEntry checkOutFileEntry(
			long fileEntryId, String owner, long expirationTime,
			ServiceContext serviceContext)
		throws PortalException {

		FileEntry oldFileEntry = getFileEntry(fileEntryId);

		FileVersion oldFileVersion = oldFileEntry.getFileVersion();

		FileEntry fileEntry = super.checkOutFileEntry(
			fileEntryId, owner, expirationTime, serviceContext);

		_processorCapability.copyPrevious(oldFileVersion);

		return fileEntry;
	}

	@Override
	public void deleteFileVersion(long fileEntryId, String version)
		throws PortalException {

		FileEntry fileEntry = getFileEntry(fileEntryId);

		FileVersion fileVersion = fileEntry.getFileVersion(version);

		super.deleteFileVersion(fileEntryId, version);

		_processorCapability.cleanUp(fileVersion);
	}

	@Override
	public void revertFileEntry(
			long userId, long fileEntryId, String version,
			ServiceContext serviceContext)
		throws PortalException {

		super.revertFileEntry(userId, fileEntryId, version, serviceContext);

		FileEntry fileEntry = getFileEntry(fileEntryId);

		_processorCapability.copyPrevious(fileEntry.getFileVersion(version));
	}

	@Override
	public FileEntry updateFileEntry(
			long userId, long fileEntryId, String sourceFileName,
			String mimeType, String title, String description, String changeLog,
			boolean majorVersion, File file, ServiceContext serviceContext)
		throws PortalException {

		FileEntry fileEntry = super.updateFileEntry(
			userId, fileEntryId, sourceFileName, mimeType, title, description,
			changeLog, majorVersion, file, serviceContext);

		_processorCapability.cleanUp(fileEntry.getLatestFileVersion());
		_processorCapability.generateNew(fileEntry);

		return fileEntry;
	}

	@Override
	public FileEntry updateFileEntry(
			long userId, long fileEntryId, String sourceFileName,
			String mimeType, String title, String description, String changeLog,
			boolean majorVersion, InputStream is, long size,
			ServiceContext serviceContext)
		throws PortalException {

		FileEntry oldFileEntry = null;
		FileVersion oldFileVersion = null;

		if (is == null) {
			oldFileEntry = getFileEntry(fileEntryId);
			oldFileVersion = oldFileEntry.getLatestFileVersion(true);
		}

		FileEntry fileEntry = super.updateFileEntry(
			userId, fileEntryId, sourceFileName, mimeType, title, description,
			changeLog, majorVersion, is, size, serviceContext);

		if (is == null) {
			_processorCapability.copyPrevious(oldFileVersion);
		}
		else {
			_processorCapability.cleanUp(fileEntry.getLatestFileVersion());
			_processorCapability.generateNew(fileEntry);
		}

		return fileEntry;
	}

	private final ProcessorCapability _processorCapability;

}