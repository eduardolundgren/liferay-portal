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

package com.liferay.taglib.aui;

import com.liferay.portal.kernel.servlet.TrackedServletRequest;
import com.liferay.taglib.aui.base.BaseSearchBarTag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
//import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.PageContext;

/**
 * @author Eduardo Lundgren
 * @author Bruno Basto
 * @author Nathan Cavanaugh
 * @author Julio Camarero
 * @author Byran Zaugg
 */
public class SearchBarTag extends BaseSearchBarTag {

	@Override
	public int doAfterBody() throws JspException {
		try {
			return super.doAfterBody(); // SKIP_BODY
			// return SKIP_BODY;
		}
		catch (Exception e) {
			throw new JspException(e);
		}
	}
	
	@Override
	public void doInitBody() throws JspException {
		try {
			super.doInitBody(); //DEBUG
		}
		catch (Exception e) {
			throw new JspException(e);
		}
	}

	@Override
	public int doEndTag() throws JspException { // #3 (Tag)
		try {
//			return super.doEndTag(); // EVAL_PAGE
			
			BodyContent bodyContent = pageContext.pushBody();
			
			String bodyString = bodyContent.getString(); //DEBUG

			super.setBodyContent(bodyContent);
			
			// An attempt to rewrite NamespacedAttribute bodyContent
			HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();

			if (isCleanUpSetAttributes()) {
				_trackedRequest = new TrackedServletRequest(request);

				request = _trackedRequest;
			}

			setNamespacedAttribute(request, "bodyContent", getBodyContent());
			//-------------------------

			pageContext.popBody(); // May belong in doEndTag()
			
			super.doEndTag();
			
			return EVAL_PAGE;
		}
		catch (Exception e) {
			throw new JspException(e);
		}
	}

	@Override
	public int doStartTag() throws JspException { //#2 (Tag)
		try {
			return super.doStartTag(); // EVAL_BODY_INCLUDE
/*
			setAttributeNamespace(_ATTRIBUTE_NAMESPACE);

			BodyContent bodyContent = pageContext.pushBody();
			
			String bodyString = bodyContent.getString(); //DEBUG

			super.setBodyContent(bodyContent);

//			pageContext.popBody(); // May belong in doEndTag()

			super.doStartTag();

			//return SKIP_BODY;
			return EVAL_BODY_INCLUDE;
			//return BodyTag.EVAL_BODY_BUFFERED;
*/		
		}
		catch (Exception e) {
			throw new JspException(e);
		}
	}
	
	@Override
	public void setBodyContent(BodyContent bodyContent) {
		super.setBodyContent(bodyContent); //DEBUG
	}

	@Override
	public void setPageContext(PageContext pageContext) { //#1 (Tag)
		super.setPageContext(pageContext); //DEBUG
	}
	
	private TrackedServletRequest _trackedRequest;
}