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

package com.liferay.portlet.documentlibrary.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.WorkflowedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the DLFileVersion service. Represents a row in the &quot;DLFileVersion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portlet.documentlibrary.model.impl.DLFileVersionModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portlet.documentlibrary.model.impl.DLFileVersionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DLFileVersion
 * @see com.liferay.portlet.documentlibrary.model.impl.DLFileVersionImpl
 * @see com.liferay.portlet.documentlibrary.model.impl.DLFileVersionModelImpl
 * @generated
 */
public interface DLFileVersionModel extends BaseModel<DLFileVersion>,
	WorkflowedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a document library file version model instance should use the {@link DLFileVersion} interface instead.
	 */

	/**
	 * Returns the primary key of this document library file version.
	 *
	 * @return the primary key of this document library file version
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this document library file version.
	 *
	 * @param primaryKey the primary key of this document library file version
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the file version ID of this document library file version.
	 *
	 * @return the file version ID of this document library file version
	 */
	public long getFileVersionId();

	/**
	 * Sets the file version ID of this document library file version.
	 *
	 * @param fileVersionId the file version ID of this document library file version
	 */
	public void setFileVersionId(long fileVersionId);

	/**
	 * Returns the group ID of this document library file version.
	 *
	 * @return the group ID of this document library file version
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this document library file version.
	 *
	 * @param groupId the group ID of this document library file version
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this document library file version.
	 *
	 * @return the company ID of this document library file version
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this document library file version.
	 *
	 * @param companyId the company ID of this document library file version
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this document library file version.
	 *
	 * @return the user ID of this document library file version
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this document library file version.
	 *
	 * @param userId the user ID of this document library file version
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this document library file version.
	 *
	 * @return the user uuid of this document library file version
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this document library file version.
	 *
	 * @param userUuid the user uuid of this document library file version
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this document library file version.
	 *
	 * @return the user name of this document library file version
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this document library file version.
	 *
	 * @param userName the user name of this document library file version
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this document library file version.
	 *
	 * @return the create date of this document library file version
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this document library file version.
	 *
	 * @param createDate the create date of this document library file version
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the repository ID of this document library file version.
	 *
	 * @return the repository ID of this document library file version
	 */
	public long getRepositoryId();

	/**
	 * Sets the repository ID of this document library file version.
	 *
	 * @param repositoryId the repository ID of this document library file version
	 */
	public void setRepositoryId(long repositoryId);

	/**
	 * Returns the file entry ID of this document library file version.
	 *
	 * @return the file entry ID of this document library file version
	 */
	public long getFileEntryId();

	/**
	 * Sets the file entry ID of this document library file version.
	 *
	 * @param fileEntryId the file entry ID of this document library file version
	 */
	public void setFileEntryId(long fileEntryId);

	/**
	 * Returns the extension of this document library file version.
	 *
	 * @return the extension of this document library file version
	 */
	@AutoEscape
	public String getExtension();

	/**
	 * Sets the extension of this document library file version.
	 *
	 * @param extension the extension of this document library file version
	 */
	public void setExtension(String extension);

	/**
	 * Returns the mime type of this document library file version.
	 *
	 * @return the mime type of this document library file version
	 */
	@AutoEscape
	public String getMimeType();

	/**
	 * Sets the mime type of this document library file version.
	 *
	 * @param mimeType the mime type of this document library file version
	 */
	public void setMimeType(String mimeType);

	/**
	 * Returns the title of this document library file version.
	 *
	 * @return the title of this document library file version
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this document library file version.
	 *
	 * @param title the title of this document library file version
	 */
	public void setTitle(String title);

	/**
	 * Returns the description of this document library file version.
	 *
	 * @return the description of this document library file version
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this document library file version.
	 *
	 * @param description the description of this document library file version
	 */
	public void setDescription(String description);

	/**
	 * Returns the change log of this document library file version.
	 *
	 * @return the change log of this document library file version
	 */
	@AutoEscape
	public String getChangeLog();

	/**
	 * Sets the change log of this document library file version.
	 *
	 * @param changeLog the change log of this document library file version
	 */
	public void setChangeLog(String changeLog);

	/**
	 * Returns the extra settings of this document library file version.
	 *
	 * @return the extra settings of this document library file version
	 */
	@AutoEscape
	public String getExtraSettings();

	/**
	 * Sets the extra settings of this document library file version.
	 *
	 * @param extraSettings the extra settings of this document library file version
	 */
	public void setExtraSettings(String extraSettings);

	/**
	 * Returns the file entry type ID of this document library file version.
	 *
	 * @return the file entry type ID of this document library file version
	 */
	public long getFileEntryTypeId();

	/**
	 * Sets the file entry type ID of this document library file version.
	 *
	 * @param fileEntryTypeId the file entry type ID of this document library file version
	 */
	public void setFileEntryTypeId(long fileEntryTypeId);

	/**
	 * Returns the version of this document library file version.
	 *
	 * @return the version of this document library file version
	 */
	@AutoEscape
	public String getVersion();

	/**
	 * Sets the version of this document library file version.
	 *
	 * @param version the version of this document library file version
	 */
	public void setVersion(String version);

	/**
	 * Returns the size of this document library file version.
	 *
	 * @return the size of this document library file version
	 */
	public long getSize();

	/**
	 * Sets the size of this document library file version.
	 *
	 * @param size the size of this document library file version
	 */
	public void setSize(long size);

	/**
	 * Returns the small image ID of this document library file version.
	 *
	 * @return the small image ID of this document library file version
	 */
	public long getSmallImageId();

	/**
	 * Sets the small image ID of this document library file version.
	 *
	 * @param smallImageId the small image ID of this document library file version
	 */
	public void setSmallImageId(long smallImageId);

	/**
	 * Returns the large image ID of this document library file version.
	 *
	 * @return the large image ID of this document library file version
	 */
	public long getLargeImageId();

	/**
	 * Sets the large image ID of this document library file version.
	 *
	 * @param largeImageId the large image ID of this document library file version
	 */
	public void setLargeImageId(long largeImageId);

	/**
	 * Returns the custom1 image ID of this document library file version.
	 *
	 * @return the custom1 image ID of this document library file version
	 */
	public long getCustom1ImageId();

	/**
	 * Sets the custom1 image ID of this document library file version.
	 *
	 * @param custom1ImageId the custom1 image ID of this document library file version
	 */
	public void setCustom1ImageId(long custom1ImageId);

	/**
	 * Returns the custom2 image ID of this document library file version.
	 *
	 * @return the custom2 image ID of this document library file version
	 */
	public long getCustom2ImageId();

	/**
	 * Sets the custom2 image ID of this document library file version.
	 *
	 * @param custom2ImageId the custom2 image ID of this document library file version
	 */
	public void setCustom2ImageId(long custom2ImageId);

	/**
	 * Returns the status of this document library file version.
	 *
	 * @return the status of this document library file version
	 */
	public int getStatus();

	/**
	 * Sets the status of this document library file version.
	 *
	 * @param status the status of this document library file version
	 */
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this document library file version.
	 *
	 * @return the status by user ID of this document library file version
	 */
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this document library file version.
	 *
	 * @param statusByUserId the status by user ID of this document library file version
	 */
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this document library file version.
	 *
	 * @return the status by user uuid of this document library file version
	 * @throws SystemException if a system exception occurred
	 */
	public String getStatusByUserUuid() throws SystemException;

	/**
	 * Sets the status by user uuid of this document library file version.
	 *
	 * @param statusByUserUuid the status by user uuid of this document library file version
	 */
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this document library file version.
	 *
	 * @return the status by user name of this document library file version
	 */
	@AutoEscape
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this document library file version.
	 *
	 * @param statusByUserName the status by user name of this document library file version
	 */
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this document library file version.
	 *
	 * @return the status date of this document library file version
	 */
	public Date getStatusDate();

	/**
	 * Sets the status date of this document library file version.
	 *
	 * @param statusDate the status date of this document library file version
	 */
	public void setStatusDate(Date statusDate);

	/**
	 * @deprecated Renamed to {@link #isApproved()}
	 */
	public boolean getApproved();

	/**
	 * Returns <code>true</code> if this document library file version is approved.
	 *
	 * @return <code>true</code> if this document library file version is approved; <code>false</code> otherwise
	 */
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this document library file version is a draft.
	 *
	 * @return <code>true</code> if this document library file version is a draft; <code>false</code> otherwise
	 */
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this document library file version is expired.
	 *
	 * @return <code>true</code> if this document library file version is expired; <code>false</code> otherwise
	 */
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this document library file version is pending.
	 *
	 * @return <code>true</code> if this document library file version is pending; <code>false</code> otherwise
	 */
	public boolean isPending();

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(DLFileVersion dlFileVersion);

	public int hashCode();

	public CacheModel<DLFileVersion> toCacheModel();

	public DLFileVersion toEscapedModel();

	public String toString();

	public String toXmlString();
}