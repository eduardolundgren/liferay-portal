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

package com.liferay.shopping.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.liferay.shopping.model.ShoppingCart;
import com.liferay.shopping.service.ShoppingCartLocalService;
import com.liferay.shopping.service.persistence.ShoppingCartPersistence;
import com.liferay.shopping.service.persistence.ShoppingCouponFinder;
import com.liferay.shopping.service.persistence.ShoppingCouponPersistence;
import com.liferay.shopping.service.persistence.ShoppingItemFinder;
import com.liferay.shopping.service.persistence.ShoppingItemPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the shopping cart local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.shopping.service.impl.ShoppingCartLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.shopping.service.impl.ShoppingCartLocalServiceImpl
 * @see com.liferay.shopping.service.ShoppingCartLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class ShoppingCartLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements ShoppingCartLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.shopping.service.ShoppingCartLocalServiceUtil} to access the shopping cart local service.
	 */

	/**
	 * Adds the shopping cart to the database. Also notifies the appropriate model listeners.
	 *
	 * @param shoppingCart the shopping cart
	 * @return the shopping cart that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ShoppingCart addShoppingCart(ShoppingCart shoppingCart) {
		shoppingCart.setNew(true);

		return shoppingCartPersistence.update(shoppingCart);
	}

	/**
	 * Creates a new shopping cart with the primary key. Does not add the shopping cart to the database.
	 *
	 * @param cartId the primary key for the new shopping cart
	 * @return the new shopping cart
	 */
	@Override
	public ShoppingCart createShoppingCart(long cartId) {
		return shoppingCartPersistence.create(cartId);
	}

	/**
	 * Deletes the shopping cart with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cartId the primary key of the shopping cart
	 * @return the shopping cart that was removed
	 * @throws PortalException if a shopping cart with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ShoppingCart deleteShoppingCart(long cartId)
		throws PortalException {
		return shoppingCartPersistence.remove(cartId);
	}

	/**
	 * Deletes the shopping cart from the database. Also notifies the appropriate model listeners.
	 *
	 * @param shoppingCart the shopping cart
	 * @return the shopping cart that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ShoppingCart deleteShoppingCart(ShoppingCart shoppingCart) {
		return shoppingCartPersistence.remove(shoppingCart);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(ShoppingCart.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return shoppingCartPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.shopping.model.impl.ShoppingCartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return shoppingCartPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.shopping.model.impl.ShoppingCartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return shoppingCartPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return shoppingCartPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return shoppingCartPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public ShoppingCart fetchShoppingCart(long cartId) {
		return shoppingCartPersistence.fetchByPrimaryKey(cartId);
	}

	/**
	 * Returns the shopping cart with the primary key.
	 *
	 * @param cartId the primary key of the shopping cart
	 * @return the shopping cart
	 * @throws PortalException if a shopping cart with the primary key could not be found
	 */
	@Override
	public ShoppingCart getShoppingCart(long cartId) throws PortalException {
		return shoppingCartPersistence.findByPrimaryKey(cartId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(shoppingCartLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ShoppingCart.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("cartId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(shoppingCartLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(ShoppingCart.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("cartId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(shoppingCartLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ShoppingCart.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("cartId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return shoppingCartLocalService.deleteShoppingCart((ShoppingCart)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return shoppingCartPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the shopping carts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.shopping.model.impl.ShoppingCartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of shopping carts
	 * @param end the upper bound of the range of shopping carts (not inclusive)
	 * @return the range of shopping carts
	 */
	@Override
	public List<ShoppingCart> getShoppingCarts(int start, int end) {
		return shoppingCartPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of shopping carts.
	 *
	 * @return the number of shopping carts
	 */
	@Override
	public int getShoppingCartsCount() {
		return shoppingCartPersistence.countAll();
	}

	/**
	 * Updates the shopping cart in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param shoppingCart the shopping cart
	 * @return the shopping cart that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ShoppingCart updateShoppingCart(ShoppingCart shoppingCart) {
		return shoppingCartPersistence.update(shoppingCart);
	}

	/**
	 * Returns the shopping cart local service.
	 *
	 * @return the shopping cart local service
	 */
	public ShoppingCartLocalService getShoppingCartLocalService() {
		return shoppingCartLocalService;
	}

	/**
	 * Sets the shopping cart local service.
	 *
	 * @param shoppingCartLocalService the shopping cart local service
	 */
	public void setShoppingCartLocalService(
		ShoppingCartLocalService shoppingCartLocalService) {
		this.shoppingCartLocalService = shoppingCartLocalService;
	}

	/**
	 * Returns the shopping cart persistence.
	 *
	 * @return the shopping cart persistence
	 */
	public ShoppingCartPersistence getShoppingCartPersistence() {
		return shoppingCartPersistence;
	}

	/**
	 * Sets the shopping cart persistence.
	 *
	 * @param shoppingCartPersistence the shopping cart persistence
	 */
	public void setShoppingCartPersistence(
		ShoppingCartPersistence shoppingCartPersistence) {
		this.shoppingCartPersistence = shoppingCartPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
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
	 * Returns the shopping coupon local service.
	 *
	 * @return the shopping coupon local service
	 */
	public com.liferay.shopping.service.ShoppingCouponLocalService getShoppingCouponLocalService() {
		return shoppingCouponLocalService;
	}

	/**
	 * Sets the shopping coupon local service.
	 *
	 * @param shoppingCouponLocalService the shopping coupon local service
	 */
	public void setShoppingCouponLocalService(
		com.liferay.shopping.service.ShoppingCouponLocalService shoppingCouponLocalService) {
		this.shoppingCouponLocalService = shoppingCouponLocalService;
	}

	/**
	 * Returns the shopping coupon persistence.
	 *
	 * @return the shopping coupon persistence
	 */
	public ShoppingCouponPersistence getShoppingCouponPersistence() {
		return shoppingCouponPersistence;
	}

	/**
	 * Sets the shopping coupon persistence.
	 *
	 * @param shoppingCouponPersistence the shopping coupon persistence
	 */
	public void setShoppingCouponPersistence(
		ShoppingCouponPersistence shoppingCouponPersistence) {
		this.shoppingCouponPersistence = shoppingCouponPersistence;
	}

	/**
	 * Returns the shopping coupon finder.
	 *
	 * @return the shopping coupon finder
	 */
	public ShoppingCouponFinder getShoppingCouponFinder() {
		return shoppingCouponFinder;
	}

	/**
	 * Sets the shopping coupon finder.
	 *
	 * @param shoppingCouponFinder the shopping coupon finder
	 */
	public void setShoppingCouponFinder(
		ShoppingCouponFinder shoppingCouponFinder) {
		this.shoppingCouponFinder = shoppingCouponFinder;
	}

	/**
	 * Returns the shopping item local service.
	 *
	 * @return the shopping item local service
	 */
	public com.liferay.shopping.service.ShoppingItemLocalService getShoppingItemLocalService() {
		return shoppingItemLocalService;
	}

	/**
	 * Sets the shopping item local service.
	 *
	 * @param shoppingItemLocalService the shopping item local service
	 */
	public void setShoppingItemLocalService(
		com.liferay.shopping.service.ShoppingItemLocalService shoppingItemLocalService) {
		this.shoppingItemLocalService = shoppingItemLocalService;
	}

	/**
	 * Returns the shopping item persistence.
	 *
	 * @return the shopping item persistence
	 */
	public ShoppingItemPersistence getShoppingItemPersistence() {
		return shoppingItemPersistence;
	}

	/**
	 * Sets the shopping item persistence.
	 *
	 * @param shoppingItemPersistence the shopping item persistence
	 */
	public void setShoppingItemPersistence(
		ShoppingItemPersistence shoppingItemPersistence) {
		this.shoppingItemPersistence = shoppingItemPersistence;
	}

	/**
	 * Returns the shopping item finder.
	 *
	 * @return the shopping item finder
	 */
	public ShoppingItemFinder getShoppingItemFinder() {
		return shoppingItemFinder;
	}

	/**
	 * Sets the shopping item finder.
	 *
	 * @param shoppingItemFinder the shopping item finder
	 */
	public void setShoppingItemFinder(ShoppingItemFinder shoppingItemFinder) {
		this.shoppingItemFinder = shoppingItemFinder;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("com.liferay.shopping.model.ShoppingCart",
			shoppingCartLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.liferay.shopping.model.ShoppingCart");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ShoppingCartLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ShoppingCart.class;
	}

	protected String getModelClassName() {
		return ShoppingCart.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = shoppingCartPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = ShoppingCartLocalService.class)
	protected ShoppingCartLocalService shoppingCartLocalService;
	@BeanReference(type = ShoppingCartPersistence.class)
	protected ShoppingCartPersistence shoppingCartPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = com.liferay.shopping.service.ShoppingCouponLocalService.class)
	protected com.liferay.shopping.service.ShoppingCouponLocalService shoppingCouponLocalService;
	@BeanReference(type = ShoppingCouponPersistence.class)
	protected ShoppingCouponPersistence shoppingCouponPersistence;
	@BeanReference(type = ShoppingCouponFinder.class)
	protected ShoppingCouponFinder shoppingCouponFinder;
	@BeanReference(type = com.liferay.shopping.service.ShoppingItemLocalService.class)
	protected com.liferay.shopping.service.ShoppingItemLocalService shoppingItemLocalService;
	@BeanReference(type = ShoppingItemPersistence.class)
	protected ShoppingItemPersistence shoppingItemPersistence;
	@BeanReference(type = ShoppingItemFinder.class)
	protected ShoppingItemFinder shoppingItemFinder;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}