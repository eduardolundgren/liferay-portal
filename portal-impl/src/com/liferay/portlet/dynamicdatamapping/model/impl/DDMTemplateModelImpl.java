/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.liferay.portlet.dynamicdatamapping.model.impl;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.dynamicdatamapping.model.DDMTemplate;
import com.liferay.portlet.dynamicdatamapping.model.DDMTemplateModel;
import com.liferay.portlet.dynamicdatamapping.model.DDMTemplateSoap;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The base model implementation for the DDMTemplate service. Represents a row in the &quot;DDMTemplate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portlet.dynamicdatamapping.model.DDMTemplateModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DDMTemplateImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DDMTemplateImpl
 * @see com.liferay.portlet.dynamicdatamapping.model.DDMTemplate
 * @see com.liferay.portlet.dynamicdatamapping.model.DDMTemplateModel
 * @generated
 */
@JSON(strict = true)
public class DDMTemplateModelImpl extends BaseModelImpl<DDMTemplate>
	implements DDMTemplateModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a d d m template model instance should use the {@link com.liferay.portlet.dynamicdatamapping.model.DDMTemplate} interface instead.
	 */
	public static final String TABLE_NAME = "DDMTemplate";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "templateId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "classNameId", Types.BIGINT },
			{ "classPK", Types.BIGINT },
			{ "templateKey", Types.VARCHAR },
			{ "name", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "type_", Types.VARCHAR },
			{ "mode_", Types.VARCHAR },
			{ "language", Types.VARCHAR },
			{ "script", Types.CLOB },
			{ "cacheable", Types.BOOLEAN },
			{ "smallImage", Types.BOOLEAN },
			{ "smallImageId", Types.BIGINT },
			{ "smallImageURL", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table DDMTemplate (uuid_ VARCHAR(75) null,templateId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,classNameId LONG,classPK LONG,templateKey VARCHAR(75) null,name STRING null,description STRING null,type_ VARCHAR(75) null,mode_ VARCHAR(75) null,language VARCHAR(75) null,script TEXT null,cacheable BOOLEAN,smallImage BOOLEAN,smallImageId LONG,smallImageURL VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table DDMTemplate";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portlet.dynamicdatamapping.model.DDMTemplate"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portlet.dynamicdatamapping.model.DDMTemplate"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.portlet.dynamicdatamapping.model.DDMTemplate"),
			true);
	public static long CLASSNAMEID_COLUMN_BITMASK = 1L;
	public static long CLASSPK_COLUMN_BITMASK = 2L;
	public static long COMPANYID_COLUMN_BITMASK = 4L;
	public static long GROUPID_COLUMN_BITMASK = 8L;
	public static long LANGUAGE_COLUMN_BITMASK = 16L;
	public static long MODE_COLUMN_BITMASK = 32L;
	public static long TEMPLATEKEY_COLUMN_BITMASK = 64L;
	public static long TYPE_COLUMN_BITMASK = 128L;
	public static long UUID_COLUMN_BITMASK = 256L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static DDMTemplate toModel(DDMTemplateSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		DDMTemplate model = new DDMTemplateImpl();

		model.setUuid(soapModel.getUuid());
		model.setTemplateId(soapModel.getTemplateId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setClassNameId(soapModel.getClassNameId());
		model.setClassPK(soapModel.getClassPK());
		model.setTemplateKey(soapModel.getTemplateKey());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setType(soapModel.getType());
		model.setMode(soapModel.getMode());
		model.setLanguage(soapModel.getLanguage());
		model.setScript(soapModel.getScript());
		model.setCacheable(soapModel.getCacheable());
		model.setSmallImage(soapModel.getSmallImage());
		model.setSmallImageId(soapModel.getSmallImageId());
		model.setSmallImageURL(soapModel.getSmallImageURL());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<DDMTemplate> toModels(DDMTemplateSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<DDMTemplate> models = new ArrayList<DDMTemplate>(soapModels.length);

		for (DDMTemplateSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portlet.dynamicdatamapping.model.DDMTemplate"));

	public DDMTemplateModelImpl() {
	}

	public long getPrimaryKey() {
		return _templateId;
	}

	public void setPrimaryKey(long primaryKey) {
		setTemplateId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_templateId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return DDMTemplate.class;
	}

	public String getModelClassName() {
		return DDMTemplate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("templateId", getTemplateId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
		attributes.put("templateKey", getTemplateKey());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("type", getType());
		attributes.put("mode", getMode());
		attributes.put("language", getLanguage());
		attributes.put("script", getScript());
		attributes.put("cacheable", getCacheable());
		attributes.put("smallImage", getSmallImage());
		attributes.put("smallImageId", getSmallImageId());
		attributes.put("smallImageURL", getSmallImageURL());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long templateId = (Long)attributes.get("templateId");

		if (templateId != null) {
			setTemplateId(templateId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		String templateKey = (String)attributes.get("templateKey");

		if (templateKey != null) {
			setTemplateKey(templateKey);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String mode = (String)attributes.get("mode");

		if (mode != null) {
			setMode(mode);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}

		String script = (String)attributes.get("script");

		if (script != null) {
			setScript(script);
		}

		Boolean cacheable = (Boolean)attributes.get("cacheable");

		if (cacheable != null) {
			setCacheable(cacheable);
		}

		Boolean smallImage = (Boolean)attributes.get("smallImage");

		if (smallImage != null) {
			setSmallImage(smallImage);
		}

		Long smallImageId = (Long)attributes.get("smallImageId");

		if (smallImageId != null) {
			setSmallImageId(smallImageId);
		}

		String smallImageURL = (String)attributes.get("smallImageURL");

		if (smallImageURL != null) {
			setSmallImageURL(smallImageURL);
		}
	}

	@JSON
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

	@JSON
	public long getTemplateId() {
		return _templateId;
	}

	public void setTemplateId(long templateId) {
		_templateId = templateId;
	}

	@JSON
	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getClassName() {
		if (getClassNameId() <= 0) {
			return StringPool.BLANK;
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	public void setClassName(String className) {
		long classNameId = 0;

		if (Validator.isNotNull(className)) {
			classNameId = PortalUtil.getClassNameId(className);
		}

		setClassNameId(classNameId);
	}

	@JSON
	public long getClassNameId() {
		return _classNameId;
	}

	public void setClassNameId(long classNameId) {
		_columnBitmask |= CLASSNAMEID_COLUMN_BITMASK;

		if (!_setOriginalClassNameId) {
			_setOriginalClassNameId = true;

			_originalClassNameId = _classNameId;
		}

		_classNameId = classNameId;
	}

	public long getOriginalClassNameId() {
		return _originalClassNameId;
	}

	@JSON
	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_columnBitmask |= CLASSPK_COLUMN_BITMASK;

		if (!_setOriginalClassPK) {
			_setOriginalClassPK = true;

			_originalClassPK = _classPK;
		}

		_classPK = classPK;
	}

	public long getOriginalClassPK() {
		return _originalClassPK;
	}

	@JSON
	public String getTemplateKey() {
		if (_templateKey == null) {
			return StringPool.BLANK;
		}
		else {
			return _templateKey;
		}
	}

	public void setTemplateKey(String templateKey) {
		_columnBitmask |= TEMPLATEKEY_COLUMN_BITMASK;

		if (_originalTemplateKey == null) {
			_originalTemplateKey = _templateKey;
		}

		_templateKey = templateKey;
	}

	public String getOriginalTemplateKey() {
		return GetterUtil.getString(_originalTemplateKey);
	}

	@JSON
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	public String getName(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId);
	}

	public String getName(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId, useDefault);
	}

	public String getName(String languageId) {
		return LocalizationUtil.getLocalization(getName(), languageId);
	}

	public String getName(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getName(), languageId,
			useDefault);
	}

	public String getNameCurrentLanguageId() {
		return _nameCurrentLanguageId;
	}

	@JSON
	public String getNameCurrentValue() {
		Locale locale = getLocale(_nameCurrentLanguageId);

		return getName(locale);
	}

	public Map<Locale, String> getNameMap() {
		return LocalizationUtil.getLocalizationMap(getName());
	}

	public void setName(String name) {
		_name = name;
	}

	public void setName(String name, Locale locale) {
		setName(name, locale, LocaleUtil.getDefault());
	}

	public void setName(String name, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(name)) {
			setName(LocalizationUtil.updateLocalization(getName(), "Name",
					name, languageId, defaultLanguageId));
		}
		else {
			setName(LocalizationUtil.removeLocalization(getName(), "Name",
					languageId));
		}
	}

	public void setNameCurrentLanguageId(String languageId) {
		_nameCurrentLanguageId = languageId;
	}

	public void setNameMap(Map<Locale, String> nameMap) {
		setNameMap(nameMap, LocaleUtil.getDefault());
	}

	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale) {
		if (nameMap == null) {
			return;
		}

		setName(LocalizationUtil.updateLocalization(nameMap, getName(), "Name",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@JSON
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	public String getDescription(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId);
	}

	public String getDescription(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId, useDefault);
	}

	public String getDescription(String languageId) {
		return LocalizationUtil.getLocalization(getDescription(), languageId);
	}

	public String getDescription(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getDescription(), languageId,
			useDefault);
	}

	public String getDescriptionCurrentLanguageId() {
		return _descriptionCurrentLanguageId;
	}

	@JSON
	public String getDescriptionCurrentValue() {
		Locale locale = getLocale(_descriptionCurrentLanguageId);

		return getDescription(locale);
	}

	public Map<Locale, String> getDescriptionMap() {
		return LocalizationUtil.getLocalizationMap(getDescription());
	}

	public void setDescription(String description) {
		_description = description;
	}

	public void setDescription(String description, Locale locale) {
		setDescription(description, locale, LocaleUtil.getDefault());
	}

	public void setDescription(String description, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(description)) {
			setDescription(LocalizationUtil.updateLocalization(
					getDescription(), "Description", description, languageId,
					defaultLanguageId));
		}
		else {
			setDescription(LocalizationUtil.removeLocalization(
					getDescription(), "Description", languageId));
		}
	}

	public void setDescriptionCurrentLanguageId(String languageId) {
		_descriptionCurrentLanguageId = languageId;
	}

	public void setDescriptionMap(Map<Locale, String> descriptionMap) {
		setDescriptionMap(descriptionMap, LocaleUtil.getDefault());
	}

	public void setDescriptionMap(Map<Locale, String> descriptionMap,
		Locale defaultLocale) {
		if (descriptionMap == null) {
			return;
		}

		setDescription(LocalizationUtil.updateLocalization(descriptionMap,
				getDescription(), "Description",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@JSON
	public String getType() {
		if (_type == null) {
			return StringPool.BLANK;
		}
		else {
			return _type;
		}
	}

	public void setType(String type) {
		_columnBitmask |= TYPE_COLUMN_BITMASK;

		if (_originalType == null) {
			_originalType = _type;
		}

		_type = type;
	}

	public String getOriginalType() {
		return GetterUtil.getString(_originalType);
	}

	@JSON
	public String getMode() {
		if (_mode == null) {
			return StringPool.BLANK;
		}
		else {
			return _mode;
		}
	}

	public void setMode(String mode) {
		_columnBitmask |= MODE_COLUMN_BITMASK;

		if (_originalMode == null) {
			_originalMode = _mode;
		}

		_mode = mode;
	}

	public String getOriginalMode() {
		return GetterUtil.getString(_originalMode);
	}

	@JSON
	public String getLanguage() {
		if (_language == null) {
			return StringPool.BLANK;
		}
		else {
			return _language;
		}
	}

	public void setLanguage(String language) {
		_columnBitmask |= LANGUAGE_COLUMN_BITMASK;

		if (_originalLanguage == null) {
			_originalLanguage = _language;
		}

		_language = language;
	}

	public String getOriginalLanguage() {
		return GetterUtil.getString(_originalLanguage);
	}

	@JSON
	public String getScript() {
		if (_script == null) {
			return StringPool.BLANK;
		}
		else {
			return _script;
		}
	}

	public void setScript(String script) {
		_script = script;
	}

	@JSON
	public boolean getCacheable() {
		return _cacheable;
	}

	public boolean isCacheable() {
		return _cacheable;
	}

	public void setCacheable(boolean cacheable) {
		_cacheable = cacheable;
	}

	@JSON
	public boolean getSmallImage() {
		return _smallImage;
	}

	public boolean isSmallImage() {
		return _smallImage;
	}

	public void setSmallImage(boolean smallImage) {
		_smallImage = smallImage;
	}

	@JSON
	public long getSmallImageId() {
		return _smallImageId;
	}

	public void setSmallImageId(long smallImageId) {
		_smallImageId = smallImageId;
	}

	@JSON
	public String getSmallImageURL() {
		if (_smallImageURL == null) {
			return StringPool.BLANK;
		}
		else {
			return _smallImageURL;
		}
	}

	public void setSmallImageURL(String smallImageURL) {
		_smallImageURL = smallImageURL;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			DDMTemplate.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {
		setName(getName(defaultImportLocale), defaultImportLocale,
			defaultImportLocale);
		setDescription(getDescription(defaultImportLocale),
			defaultImportLocale, defaultImportLocale);
	}

	@Override
	public DDMTemplate toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (DDMTemplate)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		DDMTemplateImpl ddmTemplateImpl = new DDMTemplateImpl();

		ddmTemplateImpl.setUuid(getUuid());
		ddmTemplateImpl.setTemplateId(getTemplateId());
		ddmTemplateImpl.setGroupId(getGroupId());
		ddmTemplateImpl.setCompanyId(getCompanyId());
		ddmTemplateImpl.setUserId(getUserId());
		ddmTemplateImpl.setUserName(getUserName());
		ddmTemplateImpl.setCreateDate(getCreateDate());
		ddmTemplateImpl.setModifiedDate(getModifiedDate());
		ddmTemplateImpl.setClassNameId(getClassNameId());
		ddmTemplateImpl.setClassPK(getClassPK());
		ddmTemplateImpl.setTemplateKey(getTemplateKey());
		ddmTemplateImpl.setName(getName());
		ddmTemplateImpl.setDescription(getDescription());
		ddmTemplateImpl.setType(getType());
		ddmTemplateImpl.setMode(getMode());
		ddmTemplateImpl.setLanguage(getLanguage());
		ddmTemplateImpl.setScript(getScript());
		ddmTemplateImpl.setCacheable(getCacheable());
		ddmTemplateImpl.setSmallImage(getSmallImage());
		ddmTemplateImpl.setSmallImageId(getSmallImageId());
		ddmTemplateImpl.setSmallImageURL(getSmallImageURL());

		ddmTemplateImpl.resetOriginalValues();

		return ddmTemplateImpl;
	}

	public int compareTo(DDMTemplate ddmTemplate) {
		long primaryKey = ddmTemplate.getPrimaryKey();

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

		DDMTemplate ddmTemplate = null;

		try {
			ddmTemplate = (DDMTemplate)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = ddmTemplate.getPrimaryKey();

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
		DDMTemplateModelImpl ddmTemplateModelImpl = this;

		ddmTemplateModelImpl._originalUuid = ddmTemplateModelImpl._uuid;

		ddmTemplateModelImpl._originalGroupId = ddmTemplateModelImpl._groupId;

		ddmTemplateModelImpl._setOriginalGroupId = false;

		ddmTemplateModelImpl._originalCompanyId = ddmTemplateModelImpl._companyId;

		ddmTemplateModelImpl._setOriginalCompanyId = false;

		ddmTemplateModelImpl._originalClassNameId = ddmTemplateModelImpl._classNameId;

		ddmTemplateModelImpl._setOriginalClassNameId = false;

		ddmTemplateModelImpl._originalClassPK = ddmTemplateModelImpl._classPK;

		ddmTemplateModelImpl._setOriginalClassPK = false;

		ddmTemplateModelImpl._originalTemplateKey = ddmTemplateModelImpl._templateKey;

		ddmTemplateModelImpl._originalType = ddmTemplateModelImpl._type;

		ddmTemplateModelImpl._originalMode = ddmTemplateModelImpl._mode;

		ddmTemplateModelImpl._originalLanguage = ddmTemplateModelImpl._language;

		ddmTemplateModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DDMTemplate> toCacheModel() {
		DDMTemplateCacheModel ddmTemplateCacheModel = new DDMTemplateCacheModel();

		ddmTemplateCacheModel.uuid = getUuid();

		String uuid = ddmTemplateCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			ddmTemplateCacheModel.uuid = null;
		}

		ddmTemplateCacheModel.templateId = getTemplateId();

		ddmTemplateCacheModel.groupId = getGroupId();

		ddmTemplateCacheModel.companyId = getCompanyId();

		ddmTemplateCacheModel.userId = getUserId();

		ddmTemplateCacheModel.userName = getUserName();

		String userName = ddmTemplateCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			ddmTemplateCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			ddmTemplateCacheModel.createDate = createDate.getTime();
		}
		else {
			ddmTemplateCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			ddmTemplateCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			ddmTemplateCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		ddmTemplateCacheModel.classNameId = getClassNameId();

		ddmTemplateCacheModel.classPK = getClassPK();

		ddmTemplateCacheModel.templateKey = getTemplateKey();

		String templateKey = ddmTemplateCacheModel.templateKey;

		if ((templateKey != null) && (templateKey.length() == 0)) {
			ddmTemplateCacheModel.templateKey = null;
		}

		ddmTemplateCacheModel.name = getName();

		String name = ddmTemplateCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			ddmTemplateCacheModel.name = null;
		}

		ddmTemplateCacheModel.description = getDescription();

		String description = ddmTemplateCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			ddmTemplateCacheModel.description = null;
		}

		ddmTemplateCacheModel.type = getType();

		String type = ddmTemplateCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			ddmTemplateCacheModel.type = null;
		}

		ddmTemplateCacheModel.mode = getMode();

		String mode = ddmTemplateCacheModel.mode;

		if ((mode != null) && (mode.length() == 0)) {
			ddmTemplateCacheModel.mode = null;
		}

		ddmTemplateCacheModel.language = getLanguage();

		String language = ddmTemplateCacheModel.language;

		if ((language != null) && (language.length() == 0)) {
			ddmTemplateCacheModel.language = null;
		}

		ddmTemplateCacheModel.script = getScript();

		String script = ddmTemplateCacheModel.script;

		if ((script != null) && (script.length() == 0)) {
			ddmTemplateCacheModel.script = null;
		}

		ddmTemplateCacheModel.cacheable = getCacheable();

		ddmTemplateCacheModel.smallImage = getSmallImage();

		ddmTemplateCacheModel.smallImageId = getSmallImageId();

		ddmTemplateCacheModel.smallImageURL = getSmallImageURL();

		String smallImageURL = ddmTemplateCacheModel.smallImageURL;

		if ((smallImageURL != null) && (smallImageURL.length() == 0)) {
			ddmTemplateCacheModel.smallImageURL = null;
		}

		return ddmTemplateCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", templateId=");
		sb.append(getTemplateId());
		sb.append(", groupId=");
		sb.append(getGroupId());
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
		sb.append(", classNameId=");
		sb.append(getClassNameId());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append(", templateKey=");
		sb.append(getTemplateKey());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", mode=");
		sb.append(getMode());
		sb.append(", language=");
		sb.append(getLanguage());
		sb.append(", script=");
		sb.append(getScript());
		sb.append(", cacheable=");
		sb.append(getCacheable());
		sb.append(", smallImage=");
		sb.append(getSmallImage());
		sb.append(", smallImageId=");
		sb.append(getSmallImageId());
		sb.append(", smallImageURL=");
		sb.append(getSmallImageURL());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(67);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portlet.dynamicdatamapping.model.DDMTemplate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>templateId</column-name><column-value><![CDATA[");
		sb.append(getTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
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
			"<column><column-name>classNameId</column-name><column-value><![CDATA[");
		sb.append(getClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>templateKey</column-name><column-value><![CDATA[");
		sb.append(getTemplateKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mode</column-name><column-value><![CDATA[");
		sb.append(getMode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>language</column-name><column-value><![CDATA[");
		sb.append(getLanguage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>script</column-name><column-value><![CDATA[");
		sb.append(getScript());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cacheable</column-name><column-value><![CDATA[");
		sb.append(getCacheable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>smallImage</column-name><column-value><![CDATA[");
		sb.append(getSmallImage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>smallImageId</column-name><column-value><![CDATA[");
		sb.append(getSmallImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>smallImageURL</column-name><column-value><![CDATA[");
		sb.append(getSmallImageURL());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = DDMTemplate.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			DDMTemplate.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _templateId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _classNameId;
	private long _originalClassNameId;
	private boolean _setOriginalClassNameId;
	private long _classPK;
	private long _originalClassPK;
	private boolean _setOriginalClassPK;
	private String _templateKey;
	private String _originalTemplateKey;
	private String _name;
	private String _nameCurrentLanguageId;
	private String _description;
	private String _descriptionCurrentLanguageId;
	private String _type;
	private String _originalType;
	private String _mode;
	private String _originalMode;
	private String _language;
	private String _originalLanguage;
	private String _script;
	private boolean _cacheable;
	private boolean _smallImage;
	private long _smallImageId;
	private String _smallImageURL;
	private long _columnBitmask;
	private DDMTemplate _escapedModelProxy;
}