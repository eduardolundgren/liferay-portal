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

package com.liferay.portlet.announcements.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.service.persistence.CompanyPersistence;
import com.liferay.portal.service.persistence.GroupFinder;
import com.liferay.portal.service.persistence.GroupPersistence;
import com.liferay.portal.service.persistence.OrganizationFinder;
import com.liferay.portal.service.persistence.OrganizationPersistence;
import com.liferay.portal.service.persistence.RoleFinder;
import com.liferay.portal.service.persistence.RolePersistence;
import com.liferay.portal.service.persistence.UserFinder;
import com.liferay.portal.service.persistence.UserGroupFinder;
import com.liferay.portal.service.persistence.UserGroupPersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.portlet.announcements.model.AnnouncementsEntry;
import com.liferay.portlet.announcements.service.AnnouncementsEntryLocalService;
import com.liferay.portlet.announcements.service.persistence.AnnouncementsDeliveryPersistence;
import com.liferay.portlet.announcements.service.persistence.AnnouncementsEntryFinder;
import com.liferay.portlet.announcements.service.persistence.AnnouncementsEntryPersistence;
import com.liferay.portlet.announcements.service.persistence.AnnouncementsFlagPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the announcements entry local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.portlet.announcements.service.impl.AnnouncementsEntryLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.portlet.announcements.service.impl.AnnouncementsEntryLocalServiceImpl
 * @see com.liferay.portlet.announcements.service.AnnouncementsEntryLocalServiceUtil
 * @generated
 */
public abstract class AnnouncementsEntryLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements AnnouncementsEntryLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.portlet.announcements.service.AnnouncementsEntryLocalServiceUtil} to access the announcements entry local service.
	 */

	/**
	 * Adds the announcements entry to the database. Also notifies the appropriate model listeners.
	 *
	 * @param announcementsEntry the announcements entry
	 * @return the announcements entry that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AnnouncementsEntry addAnnouncementsEntry(
		AnnouncementsEntry announcementsEntry) throws SystemException {
		announcementsEntry.setNew(true);

		return announcementsEntryPersistence.update(announcementsEntry);
	}

	/**
	 * Creates a new announcements entry with the primary key. Does not add the announcements entry to the database.
	 *
	 * @param entryId the primary key for the new announcements entry
	 * @return the new announcements entry
	 */
	@Override
	public AnnouncementsEntry createAnnouncementsEntry(long entryId) {
		return announcementsEntryPersistence.create(entryId);
	}

	/**
	 * Deletes the announcements entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entryId the primary key of the announcements entry
	 * @return the announcements entry that was removed
	 * @throws PortalException if a announcements entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AnnouncementsEntry deleteAnnouncementsEntry(long entryId)
		throws PortalException, SystemException {
		return announcementsEntryPersistence.remove(entryId);
	}

	/**
	 * Deletes the announcements entry from the database. Also notifies the appropriate model listeners.
	 *
	 * @param announcementsEntry the announcements entry
	 * @return the announcements entry that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AnnouncementsEntry deleteAnnouncementsEntry(
		AnnouncementsEntry announcementsEntry) throws SystemException {
		return announcementsEntryPersistence.remove(announcementsEntry);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(AnnouncementsEntry.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return announcementsEntryPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.portlet.announcements.model.impl.AnnouncementsEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return announcementsEntryPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.portlet.announcements.model.impl.AnnouncementsEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return announcementsEntryPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return announcementsEntryPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return announcementsEntryPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public AnnouncementsEntry fetchAnnouncementsEntry(long entryId)
		throws SystemException {
		return announcementsEntryPersistence.fetchByPrimaryKey(entryId);
	}

	/**
	 * Returns the announcements entry with the primary key.
	 *
	 * @param entryId the primary key of the announcements entry
	 * @return the announcements entry
	 * @throws PortalException if a announcements entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnnouncementsEntry getAnnouncementsEntry(long entryId)
		throws PortalException, SystemException {
		return announcementsEntryPersistence.findByPrimaryKey(entryId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return announcementsEntryPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the announcements entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.portlet.announcements.model.impl.AnnouncementsEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of announcements entries
	 * @param end the upper bound of the range of announcements entries (not inclusive)
	 * @return the range of announcements entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AnnouncementsEntry> getAnnouncementsEntries(int start, int end)
		throws SystemException {
		return announcementsEntryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of announcements entries.
	 *
	 * @return the number of announcements entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getAnnouncementsEntriesCount() throws SystemException {
		return announcementsEntryPersistence.countAll();
	}

	/**
	 * Updates the announcements entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param announcementsEntry the announcements entry
	 * @return the announcements entry that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AnnouncementsEntry updateAnnouncementsEntry(
		AnnouncementsEntry announcementsEntry) throws SystemException {
		return announcementsEntryPersistence.update(announcementsEntry);
	}

	/**
	 * Returns the announcements delivery local service.
	 *
	 * @return the announcements delivery local service
	 */
	public com.liferay.portlet.announcements.service.AnnouncementsDeliveryLocalService getAnnouncementsDeliveryLocalService() {
		return announcementsDeliveryLocalService;
	}

	/**
	 * Sets the announcements delivery local service.
	 *
	 * @param announcementsDeliveryLocalService the announcements delivery local service
	 */
	public void setAnnouncementsDeliveryLocalService(
		com.liferay.portlet.announcements.service.AnnouncementsDeliveryLocalService announcementsDeliveryLocalService) {
		this.announcementsDeliveryLocalService = announcementsDeliveryLocalService;
	}

	/**
	 * Returns the announcements delivery remote service.
	 *
	 * @return the announcements delivery remote service
	 */
	public com.liferay.portlet.announcements.service.AnnouncementsDeliveryService getAnnouncementsDeliveryService() {
		return announcementsDeliveryService;
	}

	/**
	 * Sets the announcements delivery remote service.
	 *
	 * @param announcementsDeliveryService the announcements delivery remote service
	 */
	public void setAnnouncementsDeliveryService(
		com.liferay.portlet.announcements.service.AnnouncementsDeliveryService announcementsDeliveryService) {
		this.announcementsDeliveryService = announcementsDeliveryService;
	}

	/**
	 * Returns the announcements delivery persistence.
	 *
	 * @return the announcements delivery persistence
	 */
	public AnnouncementsDeliveryPersistence getAnnouncementsDeliveryPersistence() {
		return announcementsDeliveryPersistence;
	}

	/**
	 * Sets the announcements delivery persistence.
	 *
	 * @param announcementsDeliveryPersistence the announcements delivery persistence
	 */
	public void setAnnouncementsDeliveryPersistence(
		AnnouncementsDeliveryPersistence announcementsDeliveryPersistence) {
		this.announcementsDeliveryPersistence = announcementsDeliveryPersistence;
	}

	/**
	 * Returns the announcements entry local service.
	 *
	 * @return the announcements entry local service
	 */
	public com.liferay.portlet.announcements.service.AnnouncementsEntryLocalService getAnnouncementsEntryLocalService() {
		return announcementsEntryLocalService;
	}

	/**
	 * Sets the announcements entry local service.
	 *
	 * @param announcementsEntryLocalService the announcements entry local service
	 */
	public void setAnnouncementsEntryLocalService(
		com.liferay.portlet.announcements.service.AnnouncementsEntryLocalService announcementsEntryLocalService) {
		this.announcementsEntryLocalService = announcementsEntryLocalService;
	}

	/**
	 * Returns the announcements entry remote service.
	 *
	 * @return the announcements entry remote service
	 */
	public com.liferay.portlet.announcements.service.AnnouncementsEntryService getAnnouncementsEntryService() {
		return announcementsEntryService;
	}

	/**
	 * Sets the announcements entry remote service.
	 *
	 * @param announcementsEntryService the announcements entry remote service
	 */
	public void setAnnouncementsEntryService(
		com.liferay.portlet.announcements.service.AnnouncementsEntryService announcementsEntryService) {
		this.announcementsEntryService = announcementsEntryService;
	}

	/**
	 * Returns the announcements entry persistence.
	 *
	 * @return the announcements entry persistence
	 */
	public AnnouncementsEntryPersistence getAnnouncementsEntryPersistence() {
		return announcementsEntryPersistence;
	}

	/**
	 * Sets the announcements entry persistence.
	 *
	 * @param announcementsEntryPersistence the announcements entry persistence
	 */
	public void setAnnouncementsEntryPersistence(
		AnnouncementsEntryPersistence announcementsEntryPersistence) {
		this.announcementsEntryPersistence = announcementsEntryPersistence;
	}

	/**
	 * Returns the announcements entry finder.
	 *
	 * @return the announcements entry finder
	 */
	public AnnouncementsEntryFinder getAnnouncementsEntryFinder() {
		return announcementsEntryFinder;
	}

	/**
	 * Sets the announcements entry finder.
	 *
	 * @param announcementsEntryFinder the announcements entry finder
	 */
	public void setAnnouncementsEntryFinder(
		AnnouncementsEntryFinder announcementsEntryFinder) {
		this.announcementsEntryFinder = announcementsEntryFinder;
	}

	/**
	 * Returns the announcements flag local service.
	 *
	 * @return the announcements flag local service
	 */
	public com.liferay.portlet.announcements.service.AnnouncementsFlagLocalService getAnnouncementsFlagLocalService() {
		return announcementsFlagLocalService;
	}

	/**
	 * Sets the announcements flag local service.
	 *
	 * @param announcementsFlagLocalService the announcements flag local service
	 */
	public void setAnnouncementsFlagLocalService(
		com.liferay.portlet.announcements.service.AnnouncementsFlagLocalService announcementsFlagLocalService) {
		this.announcementsFlagLocalService = announcementsFlagLocalService;
	}

	/**
	 * Returns the announcements flag remote service.
	 *
	 * @return the announcements flag remote service
	 */
	public com.liferay.portlet.announcements.service.AnnouncementsFlagService getAnnouncementsFlagService() {
		return announcementsFlagService;
	}

	/**
	 * Sets the announcements flag remote service.
	 *
	 * @param announcementsFlagService the announcements flag remote service
	 */
	public void setAnnouncementsFlagService(
		com.liferay.portlet.announcements.service.AnnouncementsFlagService announcementsFlagService) {
		this.announcementsFlagService = announcementsFlagService;
	}

	/**
	 * Returns the announcements flag persistence.
	 *
	 * @return the announcements flag persistence
	 */
	public AnnouncementsFlagPersistence getAnnouncementsFlagPersistence() {
		return announcementsFlagPersistence;
	}

	/**
	 * Sets the announcements flag persistence.
	 *
	 * @param announcementsFlagPersistence the announcements flag persistence
	 */
	public void setAnnouncementsFlagPersistence(
		AnnouncementsFlagPersistence announcementsFlagPersistence) {
		this.announcementsFlagPersistence = announcementsFlagPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the mail remote service.
	 *
	 * @return the mail remote service
	 */
	public com.liferay.mail.service.MailService getMailService() {
		return mailService;
	}

	/**
	 * Sets the mail remote service.
	 *
	 * @param mailService the mail remote service
	 */
	public void setMailService(com.liferay.mail.service.MailService mailService) {
		this.mailService = mailService;
	}

	/**
	 * Returns the company local service.
	 *
	 * @return the company local service
	 */
	public com.liferay.portal.service.CompanyLocalService getCompanyLocalService() {
		return companyLocalService;
	}

	/**
	 * Sets the company local service.
	 *
	 * @param companyLocalService the company local service
	 */
	public void setCompanyLocalService(
		com.liferay.portal.service.CompanyLocalService companyLocalService) {
		this.companyLocalService = companyLocalService;
	}

	/**
	 * Returns the company remote service.
	 *
	 * @return the company remote service
	 */
	public com.liferay.portal.service.CompanyService getCompanyService() {
		return companyService;
	}

	/**
	 * Sets the company remote service.
	 *
	 * @param companyService the company remote service
	 */
	public void setCompanyService(
		com.liferay.portal.service.CompanyService companyService) {
		this.companyService = companyService;
	}

	/**
	 * Returns the company persistence.
	 *
	 * @return the company persistence
	 */
	public CompanyPersistence getCompanyPersistence() {
		return companyPersistence;
	}

	/**
	 * Sets the company persistence.
	 *
	 * @param companyPersistence the company persistence
	 */
	public void setCompanyPersistence(CompanyPersistence companyPersistence) {
		this.companyPersistence = companyPersistence;
	}

	/**
	 * Returns the group local service.
	 *
	 * @return the group local service
	 */
	public com.liferay.portal.service.GroupLocalService getGroupLocalService() {
		return groupLocalService;
	}

	/**
	 * Sets the group local service.
	 *
	 * @param groupLocalService the group local service
	 */
	public void setGroupLocalService(
		com.liferay.portal.service.GroupLocalService groupLocalService) {
		this.groupLocalService = groupLocalService;
	}

	/**
	 * Returns the group remote service.
	 *
	 * @return the group remote service
	 */
	public com.liferay.portal.service.GroupService getGroupService() {
		return groupService;
	}

	/**
	 * Sets the group remote service.
	 *
	 * @param groupService the group remote service
	 */
	public void setGroupService(
		com.liferay.portal.service.GroupService groupService) {
		this.groupService = groupService;
	}

	/**
	 * Returns the group persistence.
	 *
	 * @return the group persistence
	 */
	public GroupPersistence getGroupPersistence() {
		return groupPersistence;
	}

	/**
	 * Sets the group persistence.
	 *
	 * @param groupPersistence the group persistence
	 */
	public void setGroupPersistence(GroupPersistence groupPersistence) {
		this.groupPersistence = groupPersistence;
	}

	/**
	 * Returns the group finder.
	 *
	 * @return the group finder
	 */
	public GroupFinder getGroupFinder() {
		return groupFinder;
	}

	/**
	 * Sets the group finder.
	 *
	 * @param groupFinder the group finder
	 */
	public void setGroupFinder(GroupFinder groupFinder) {
		this.groupFinder = groupFinder;
	}

	/**
	 * Returns the organization local service.
	 *
	 * @return the organization local service
	 */
	public com.liferay.portal.service.OrganizationLocalService getOrganizationLocalService() {
		return organizationLocalService;
	}

	/**
	 * Sets the organization local service.
	 *
	 * @param organizationLocalService the organization local service
	 */
	public void setOrganizationLocalService(
		com.liferay.portal.service.OrganizationLocalService organizationLocalService) {
		this.organizationLocalService = organizationLocalService;
	}

	/**
	 * Returns the organization remote service.
	 *
	 * @return the organization remote service
	 */
	public com.liferay.portal.service.OrganizationService getOrganizationService() {
		return organizationService;
	}

	/**
	 * Sets the organization remote service.
	 *
	 * @param organizationService the organization remote service
	 */
	public void setOrganizationService(
		com.liferay.portal.service.OrganizationService organizationService) {
		this.organizationService = organizationService;
	}

	/**
	 * Returns the organization persistence.
	 *
	 * @return the organization persistence
	 */
	public OrganizationPersistence getOrganizationPersistence() {
		return organizationPersistence;
	}

	/**
	 * Sets the organization persistence.
	 *
	 * @param organizationPersistence the organization persistence
	 */
	public void setOrganizationPersistence(
		OrganizationPersistence organizationPersistence) {
		this.organizationPersistence = organizationPersistence;
	}

	/**
	 * Returns the organization finder.
	 *
	 * @return the organization finder
	 */
	public OrganizationFinder getOrganizationFinder() {
		return organizationFinder;
	}

	/**
	 * Sets the organization finder.
	 *
	 * @param organizationFinder the organization finder
	 */
	public void setOrganizationFinder(OrganizationFinder organizationFinder) {
		this.organizationFinder = organizationFinder;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the role local service.
	 *
	 * @return the role local service
	 */
	public com.liferay.portal.service.RoleLocalService getRoleLocalService() {
		return roleLocalService;
	}

	/**
	 * Sets the role local service.
	 *
	 * @param roleLocalService the role local service
	 */
	public void setRoleLocalService(
		com.liferay.portal.service.RoleLocalService roleLocalService) {
		this.roleLocalService = roleLocalService;
	}

	/**
	 * Returns the role remote service.
	 *
	 * @return the role remote service
	 */
	public com.liferay.portal.service.RoleService getRoleService() {
		return roleService;
	}

	/**
	 * Sets the role remote service.
	 *
	 * @param roleService the role remote service
	 */
	public void setRoleService(
		com.liferay.portal.service.RoleService roleService) {
		this.roleService = roleService;
	}

	/**
	 * Returns the role persistence.
	 *
	 * @return the role persistence
	 */
	public RolePersistence getRolePersistence() {
		return rolePersistence;
	}

	/**
	 * Sets the role persistence.
	 *
	 * @param rolePersistence the role persistence
	 */
	public void setRolePersistence(RolePersistence rolePersistence) {
		this.rolePersistence = rolePersistence;
	}

	/**
	 * Returns the role finder.
	 *
	 * @return the role finder
	 */
	public RoleFinder getRoleFinder() {
		return roleFinder;
	}

	/**
	 * Sets the role finder.
	 *
	 * @param roleFinder the role finder
	 */
	public void setRoleFinder(RoleFinder roleFinder) {
		this.roleFinder = roleFinder;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Returns the user finder.
	 *
	 * @return the user finder
	 */
	public UserFinder getUserFinder() {
		return userFinder;
	}

	/**
	 * Sets the user finder.
	 *
	 * @param userFinder the user finder
	 */
	public void setUserFinder(UserFinder userFinder) {
		this.userFinder = userFinder;
	}

	/**
	 * Returns the user group local service.
	 *
	 * @return the user group local service
	 */
	public com.liferay.portal.service.UserGroupLocalService getUserGroupLocalService() {
		return userGroupLocalService;
	}

	/**
	 * Sets the user group local service.
	 *
	 * @param userGroupLocalService the user group local service
	 */
	public void setUserGroupLocalService(
		com.liferay.portal.service.UserGroupLocalService userGroupLocalService) {
		this.userGroupLocalService = userGroupLocalService;
	}

	/**
	 * Returns the user group remote service.
	 *
	 * @return the user group remote service
	 */
	public com.liferay.portal.service.UserGroupService getUserGroupService() {
		return userGroupService;
	}

	/**
	 * Sets the user group remote service.
	 *
	 * @param userGroupService the user group remote service
	 */
	public void setUserGroupService(
		com.liferay.portal.service.UserGroupService userGroupService) {
		this.userGroupService = userGroupService;
	}

	/**
	 * Returns the user group persistence.
	 *
	 * @return the user group persistence
	 */
	public UserGroupPersistence getUserGroupPersistence() {
		return userGroupPersistence;
	}

	/**
	 * Sets the user group persistence.
	 *
	 * @param userGroupPersistence the user group persistence
	 */
	public void setUserGroupPersistence(
		UserGroupPersistence userGroupPersistence) {
		this.userGroupPersistence = userGroupPersistence;
	}

	/**
	 * Returns the user group finder.
	 *
	 * @return the user group finder
	 */
	public UserGroupFinder getUserGroupFinder() {
		return userGroupFinder;
	}

	/**
	 * Sets the user group finder.
	 *
	 * @param userGroupFinder the user group finder
	 */
	public void setUserGroupFinder(UserGroupFinder userGroupFinder) {
		this.userGroupFinder = userGroupFinder;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("com.liferay.portlet.announcements.model.AnnouncementsEntry",
			announcementsEntryLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.liferay.portlet.announcements.model.AnnouncementsEntry");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	protected Class<?> getModelClass() {
		return AnnouncementsEntry.class;
	}

	protected String getModelClassName() {
		return AnnouncementsEntry.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = announcementsEntryPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.portlet.announcements.service.AnnouncementsDeliveryLocalService.class)
	protected com.liferay.portlet.announcements.service.AnnouncementsDeliveryLocalService announcementsDeliveryLocalService;
	@BeanReference(type = com.liferay.portlet.announcements.service.AnnouncementsDeliveryService.class)
	protected com.liferay.portlet.announcements.service.AnnouncementsDeliveryService announcementsDeliveryService;
	@BeanReference(type = AnnouncementsDeliveryPersistence.class)
	protected AnnouncementsDeliveryPersistence announcementsDeliveryPersistence;
	@BeanReference(type = com.liferay.portlet.announcements.service.AnnouncementsEntryLocalService.class)
	protected com.liferay.portlet.announcements.service.AnnouncementsEntryLocalService announcementsEntryLocalService;
	@BeanReference(type = com.liferay.portlet.announcements.service.AnnouncementsEntryService.class)
	protected com.liferay.portlet.announcements.service.AnnouncementsEntryService announcementsEntryService;
	@BeanReference(type = AnnouncementsEntryPersistence.class)
	protected AnnouncementsEntryPersistence announcementsEntryPersistence;
	@BeanReference(type = AnnouncementsEntryFinder.class)
	protected AnnouncementsEntryFinder announcementsEntryFinder;
	@BeanReference(type = com.liferay.portlet.announcements.service.AnnouncementsFlagLocalService.class)
	protected com.liferay.portlet.announcements.service.AnnouncementsFlagLocalService announcementsFlagLocalService;
	@BeanReference(type = com.liferay.portlet.announcements.service.AnnouncementsFlagService.class)
	protected com.liferay.portlet.announcements.service.AnnouncementsFlagService announcementsFlagService;
	@BeanReference(type = AnnouncementsFlagPersistence.class)
	protected AnnouncementsFlagPersistence announcementsFlagPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.mail.service.MailService.class)
	protected com.liferay.mail.service.MailService mailService;
	@BeanReference(type = com.liferay.portal.service.CompanyLocalService.class)
	protected com.liferay.portal.service.CompanyLocalService companyLocalService;
	@BeanReference(type = com.liferay.portal.service.CompanyService.class)
	protected com.liferay.portal.service.CompanyService companyService;
	@BeanReference(type = CompanyPersistence.class)
	protected CompanyPersistence companyPersistence;
	@BeanReference(type = com.liferay.portal.service.GroupLocalService.class)
	protected com.liferay.portal.service.GroupLocalService groupLocalService;
	@BeanReference(type = com.liferay.portal.service.GroupService.class)
	protected com.liferay.portal.service.GroupService groupService;
	@BeanReference(type = GroupPersistence.class)
	protected GroupPersistence groupPersistence;
	@BeanReference(type = GroupFinder.class)
	protected GroupFinder groupFinder;
	@BeanReference(type = com.liferay.portal.service.OrganizationLocalService.class)
	protected com.liferay.portal.service.OrganizationLocalService organizationLocalService;
	@BeanReference(type = com.liferay.portal.service.OrganizationService.class)
	protected com.liferay.portal.service.OrganizationService organizationService;
	@BeanReference(type = OrganizationPersistence.class)
	protected OrganizationPersistence organizationPersistence;
	@BeanReference(type = OrganizationFinder.class)
	protected OrganizationFinder organizationFinder;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.RoleLocalService.class)
	protected com.liferay.portal.service.RoleLocalService roleLocalService;
	@BeanReference(type = com.liferay.portal.service.RoleService.class)
	protected com.liferay.portal.service.RoleService roleService;
	@BeanReference(type = RolePersistence.class)
	protected RolePersistence rolePersistence;
	@BeanReference(type = RoleFinder.class)
	protected RoleFinder roleFinder;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = UserFinder.class)
	protected UserFinder userFinder;
	@BeanReference(type = com.liferay.portal.service.UserGroupLocalService.class)
	protected com.liferay.portal.service.UserGroupLocalService userGroupLocalService;
	@BeanReference(type = com.liferay.portal.service.UserGroupService.class)
	protected com.liferay.portal.service.UserGroupService userGroupService;
	@BeanReference(type = UserGroupPersistence.class)
	protected UserGroupPersistence userGroupPersistence;
	@BeanReference(type = UserGroupFinder.class)
	protected UserGroupFinder userGroupFinder;
	@BeanReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
	private String _beanIdentifier;
}