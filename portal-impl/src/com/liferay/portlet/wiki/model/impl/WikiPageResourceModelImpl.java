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

package com.liferay.portlet.wiki.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;
import com.liferay.portlet.wiki.model.WikiPageResource;
import com.liferay.portlet.wiki.model.WikiPageResourceModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the WikiPageResource service. Represents a row in the &quot;WikiPageResource&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portlet.wiki.model.WikiPageResourceModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link WikiPageResourceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WikiPageResourceImpl
 * @see com.liferay.portlet.wiki.model.WikiPageResource
 * @see com.liferay.portlet.wiki.model.WikiPageResourceModel
 * @generated
 */
public class WikiPageResourceModelImpl extends BaseModelImpl<WikiPageResource>
	implements WikiPageResourceModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a wiki page resource model instance should use the {@link com.liferay.portlet.wiki.model.WikiPageResource} interface instead.
	 */
	public static final String TABLE_NAME = "WikiPageResource";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "resourcePrimKey", Types.BIGINT },
			{ "nodeId", Types.BIGINT },
			{ "title", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table WikiPageResource (uuid_ VARCHAR(75) null,resourcePrimKey LONG not null primary key,nodeId LONG,title VARCHAR(255) null)";
	public static final String TABLE_SQL_DROP = "drop table WikiPageResource";
	public static final String ORDER_BY_JPQL = " ORDER BY wikiPageResource.resourcePrimKey ASC";
	public static final String ORDER_BY_SQL = " ORDER BY WikiPageResource.resourcePrimKey ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portlet.wiki.model.WikiPageResource"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portlet.wiki.model.WikiPageResource"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.portlet.wiki.model.WikiPageResource"),
			true);
	public static long NODEID_COLUMN_BITMASK = 1L;
	public static long TITLE_COLUMN_BITMASK = 2L;
	public static long UUID_COLUMN_BITMASK = 4L;
	public static long RESOURCEPRIMKEY_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portlet.wiki.model.WikiPageResource"));

	public WikiPageResourceModelImpl() {
	}

	public long getPrimaryKey() {
		return _resourcePrimKey;
	}

	public void setPrimaryKey(long primaryKey) {
		setResourcePrimKey(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _resourcePrimKey;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return WikiPageResource.class;
	}

	public String getModelClassName() {
		return WikiPageResource.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("resourcePrimKey", getResourcePrimKey());
		attributes.put("nodeId", getNodeId());
		attributes.put("title", getTitle());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long resourcePrimKey = (Long)attributes.get("resourcePrimKey");

		if (resourcePrimKey != null) {
			setResourcePrimKey(resourcePrimKey);
		}

		Long nodeId = (Long)attributes.get("nodeId");

		if (nodeId != null) {
			setNodeId(nodeId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}
	}

	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	public long getResourcePrimKey() {
		return _resourcePrimKey;
	}

	public void setResourcePrimKey(long resourcePrimKey) {
		_resourcePrimKey = resourcePrimKey;
	}

	public long getNodeId() {
		return _nodeId;
	}

	public void setNodeId(long nodeId) {
		_columnBitmask |= NODEID_COLUMN_BITMASK;

		if (!_setOriginalNodeId) {
			_setOriginalNodeId = true;

			_originalNodeId = _nodeId;
		}

		_nodeId = nodeId;
	}

	public long getOriginalNodeId() {
		return _originalNodeId;
	}

	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	public void setTitle(String title) {
		_columnBitmask |= TITLE_COLUMN_BITMASK;

		if (_originalTitle == null) {
			_originalTitle = _title;
		}

		_title = title;
	}

	public String getOriginalTitle() {
		return GetterUtil.getString(_originalTitle);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			WikiPageResource.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public WikiPageResource toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (WikiPageResource)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		WikiPageResourceImpl wikiPageResourceImpl = new WikiPageResourceImpl();

		wikiPageResourceImpl.setUuid(getUuid());
		wikiPageResourceImpl.setResourcePrimKey(getResourcePrimKey());
		wikiPageResourceImpl.setNodeId(getNodeId());
		wikiPageResourceImpl.setTitle(getTitle());

		wikiPageResourceImpl.resetOriginalValues();

		return wikiPageResourceImpl;
	}

	public int compareTo(WikiPageResource wikiPageResource) {
		long primaryKey = wikiPageResource.getPrimaryKey();

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
		if (obj == null) {
			return false;
		}

		WikiPageResource wikiPageResource = null;

		try {
			wikiPageResource = (WikiPageResource)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = wikiPageResource.getPrimaryKey();

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
	public void resetOriginalValues() {
		WikiPageResourceModelImpl wikiPageResourceModelImpl = this;

		wikiPageResourceModelImpl._originalUuid = wikiPageResourceModelImpl._uuid;

		wikiPageResourceModelImpl._originalNodeId = wikiPageResourceModelImpl._nodeId;

		wikiPageResourceModelImpl._setOriginalNodeId = false;

		wikiPageResourceModelImpl._originalTitle = wikiPageResourceModelImpl._title;

		wikiPageResourceModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<WikiPageResource> toCacheModel() {
		WikiPageResourceCacheModel wikiPageResourceCacheModel = new WikiPageResourceCacheModel();

		wikiPageResourceCacheModel.uuid = getUuid();

		String uuid = wikiPageResourceCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			wikiPageResourceCacheModel.uuid = null;
		}

		wikiPageResourceCacheModel.resourcePrimKey = getResourcePrimKey();

		wikiPageResourceCacheModel.nodeId = getNodeId();

		wikiPageResourceCacheModel.title = getTitle();

		String title = wikiPageResourceCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			wikiPageResourceCacheModel.title = null;
		}

		return wikiPageResourceCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", resourcePrimKey=");
		sb.append(getResourcePrimKey());
		sb.append(", nodeId=");
		sb.append(getNodeId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portlet.wiki.model.WikiPageResource");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resourcePrimKey</column-name><column-value><![CDATA[");
		sb.append(getResourcePrimKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nodeId</column-name><column-value><![CDATA[");
		sb.append(getNodeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = WikiPageResource.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			WikiPageResource.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _resourcePrimKey;
	private long _nodeId;
	private long _originalNodeId;
	private boolean _setOriginalNodeId;
	private String _title;
	private String _originalTitle;
	private long _columnBitmask;
	private WikiPageResource _escapedModel;
}