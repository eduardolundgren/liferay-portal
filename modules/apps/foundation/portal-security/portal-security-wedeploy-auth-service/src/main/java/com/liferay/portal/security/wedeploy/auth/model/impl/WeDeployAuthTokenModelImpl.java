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

package com.liferay.portal.security.wedeploy.auth.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthToken;
import com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthTokenModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the WeDeployAuthToken service. Represents a row in the &quot;WeDeployAuth_WeDeployAuthToken&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link WeDeployAuthTokenModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link WeDeployAuthTokenImpl}.
 * </p>
 *
 * @author Supritha Sundaram
 * @see WeDeployAuthTokenImpl
 * @see WeDeployAuthToken
 * @see WeDeployAuthTokenModel
 * @generated
 */
@ProviderType
public class WeDeployAuthTokenModelImpl extends BaseModelImpl<WeDeployAuthToken>
	implements WeDeployAuthTokenModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a we deploy auth token model instance should use the {@link WeDeployAuthToken} interface instead.
	 */
	public static final String TABLE_NAME = "WeDeployAuth_WeDeployAuthToken";
	public static final Object[][] TABLE_COLUMNS = {
			{ "weDeployAuthTokenId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "clientId", Types.VARCHAR },
			{ "token", Types.VARCHAR },
			{ "type_", Types.INTEGER }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("weDeployAuthTokenId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("clientId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("token", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("type_", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE = "create table WeDeployAuth_WeDeployAuthToken (weDeployAuthTokenId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,clientId VARCHAR(75) null,token VARCHAR(75) null,type_ INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table WeDeployAuth_WeDeployAuthToken";
	public static final String ORDER_BY_JPQL = " ORDER BY weDeployAuthToken.weDeployAuthTokenId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY WeDeployAuth_WeDeployAuthToken.weDeployAuthTokenId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.security.wedeploy.auth.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthToken"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.security.wedeploy.auth.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthToken"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.security.wedeploy.auth.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthToken"),
			true);
	public static final long CLIENTID_COLUMN_BITMASK = 1L;
	public static final long TOKEN_COLUMN_BITMASK = 2L;
	public static final long TYPE_COLUMN_BITMASK = 4L;
	public static final long WEDEPLOYAUTHTOKENID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.security.wedeploy.auth.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthToken"));

	public WeDeployAuthTokenModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _weDeployAuthTokenId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setWeDeployAuthTokenId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _weDeployAuthTokenId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return WeDeployAuthToken.class;
	}

	@Override
	public String getModelClassName() {
		return WeDeployAuthToken.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("weDeployAuthTokenId", getWeDeployAuthTokenId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("clientId", getClientId());
		attributes.put("token", getToken());
		attributes.put("type", getType());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long weDeployAuthTokenId = (Long)attributes.get("weDeployAuthTokenId");

		if (weDeployAuthTokenId != null) {
			setWeDeployAuthTokenId(weDeployAuthTokenId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String clientId = (String)attributes.get("clientId");

		if (clientId != null) {
			setClientId(clientId);
		}

		String token = (String)attributes.get("token");

		if (token != null) {
			setToken(token);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}
	}

	@Override
	public long getWeDeployAuthTokenId() {
		return _weDeployAuthTokenId;
	}

	@Override
	public void setWeDeployAuthTokenId(long weDeployAuthTokenId) {
		_weDeployAuthTokenId = weDeployAuthTokenId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getClientId() {
		if (_clientId == null) {
			return StringPool.BLANK;
		}
		else {
			return _clientId;
		}
	}

	@Override
	public void setClientId(String clientId) {
		_columnBitmask |= CLIENTID_COLUMN_BITMASK;

		if (_originalClientId == null) {
			_originalClientId = _clientId;
		}

		_clientId = clientId;
	}

	public String getOriginalClientId() {
		return GetterUtil.getString(_originalClientId);
	}

	@Override
	public String getToken() {
		if (_token == null) {
			return StringPool.BLANK;
		}
		else {
			return _token;
		}
	}

	@Override
	public void setToken(String token) {
		_columnBitmask |= TOKEN_COLUMN_BITMASK;

		if (_originalToken == null) {
			_originalToken = _token;
		}

		_token = token;
	}

	public String getOriginalToken() {
		return GetterUtil.getString(_originalToken);
	}

	@Override
	public int getType() {
		return _type;
	}

	@Override
	public void setType(int type) {
		_columnBitmask |= TYPE_COLUMN_BITMASK;

		if (!_setOriginalType) {
			_setOriginalType = true;

			_originalType = _type;
		}

		_type = type;
	}

	public int getOriginalType() {
		return _originalType;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			WeDeployAuthToken.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public WeDeployAuthToken toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (WeDeployAuthToken)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		WeDeployAuthTokenImpl weDeployAuthTokenImpl = new WeDeployAuthTokenImpl();

		weDeployAuthTokenImpl.setWeDeployAuthTokenId(getWeDeployAuthTokenId());
		weDeployAuthTokenImpl.setCompanyId(getCompanyId());
		weDeployAuthTokenImpl.setUserId(getUserId());
		weDeployAuthTokenImpl.setUserName(getUserName());
		weDeployAuthTokenImpl.setCreateDate(getCreateDate());
		weDeployAuthTokenImpl.setModifiedDate(getModifiedDate());
		weDeployAuthTokenImpl.setClientId(getClientId());
		weDeployAuthTokenImpl.setToken(getToken());
		weDeployAuthTokenImpl.setType(getType());

		weDeployAuthTokenImpl.resetOriginalValues();

		return weDeployAuthTokenImpl;
	}

	@Override
	public int compareTo(WeDeployAuthToken weDeployAuthToken) {
		long primaryKey = weDeployAuthToken.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WeDeployAuthToken)) {
			return false;
		}

		WeDeployAuthToken weDeployAuthToken = (WeDeployAuthToken)obj;

		long primaryKey = weDeployAuthToken.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		WeDeployAuthTokenModelImpl weDeployAuthTokenModelImpl = this;

		weDeployAuthTokenModelImpl._setModifiedDate = false;

		weDeployAuthTokenModelImpl._originalClientId = weDeployAuthTokenModelImpl._clientId;

		weDeployAuthTokenModelImpl._originalToken = weDeployAuthTokenModelImpl._token;

		weDeployAuthTokenModelImpl._originalType = weDeployAuthTokenModelImpl._type;

		weDeployAuthTokenModelImpl._setOriginalType = false;

		weDeployAuthTokenModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<WeDeployAuthToken> toCacheModel() {
		WeDeployAuthTokenCacheModel weDeployAuthTokenCacheModel = new WeDeployAuthTokenCacheModel();

		weDeployAuthTokenCacheModel.weDeployAuthTokenId = getWeDeployAuthTokenId();

		weDeployAuthTokenCacheModel.companyId = getCompanyId();

		weDeployAuthTokenCacheModel.userId = getUserId();

		weDeployAuthTokenCacheModel.userName = getUserName();

		String userName = weDeployAuthTokenCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			weDeployAuthTokenCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			weDeployAuthTokenCacheModel.createDate = createDate.getTime();
		}
		else {
			weDeployAuthTokenCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			weDeployAuthTokenCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			weDeployAuthTokenCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		weDeployAuthTokenCacheModel.clientId = getClientId();

		String clientId = weDeployAuthTokenCacheModel.clientId;

		if ((clientId != null) && (clientId.length() == 0)) {
			weDeployAuthTokenCacheModel.clientId = null;
		}

		weDeployAuthTokenCacheModel.token = getToken();

		String token = weDeployAuthTokenCacheModel.token;

		if ((token != null) && (token.length() == 0)) {
			weDeployAuthTokenCacheModel.token = null;
		}

		weDeployAuthTokenCacheModel.type = getType();

		return weDeployAuthTokenCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{weDeployAuthTokenId=");
		sb.append(getWeDeployAuthTokenId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", clientId=");
		sb.append(getClientId());
		sb.append(", token=");
		sb.append(getToken());
		sb.append(", type=");
		sb.append(getType());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthToken");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>weDeployAuthTokenId</column-name><column-value><![CDATA[");
		sb.append(getWeDeployAuthTokenId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>clientId</column-name><column-value><![CDATA[");
		sb.append(getClientId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>token</column-name><column-value><![CDATA[");
		sb.append(getToken());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = WeDeployAuthToken.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			WeDeployAuthToken.class
		};
	private long _weDeployAuthTokenId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _clientId;
	private String _originalClientId;
	private String _token;
	private String _originalToken;
	private int _type;
	private int _originalType;
	private boolean _setOriginalType;
	private long _columnBitmask;
	private WeDeployAuthToken _escapedModel;
}