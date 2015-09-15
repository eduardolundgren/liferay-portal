/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p/>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p/>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package com.liferay.portal.template;

import com.liferay.portal.kernel.template.TemplateResource;

import java.util.List;
import java.util.Map;

/**
 * @author Miroslav Ligas
 */
public abstract class AbstractMultiResourceTemplate extends AbstractTemplate{
	public AbstractMultiResourceTemplate(
		List<TemplateResource> templateResources,
		TemplateResource errorTemplateResource, Map<String, Object> context,
		TemplateContextHelper templateContextHelper, String templateManagerName,
		long interval) {

		super(errorTemplateResource, context,
			templateContextHelper, templateManagerName);

		if (templateResources == null || templateResources.isEmpty()) {
			throw new IllegalArgumentException("Template resource is null");
		}
	}
}
