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

package com.liferay.portal.service;

import aQute.bnd.annotation.ProviderType;

/**
 * Provides a wrapper for {@link AccountService}.
 *
 * @author Brian Wing Shun Chan
 * @see AccountService
 * @generated
 */
@ProviderType
public class AccountServiceWrapper implements AccountService,
	ServiceWrapper<AccountService> {
	public AccountServiceWrapper(AccountService accountService) {
		_accountService = accountService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _accountService.getOSGiServiceIdentifier();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	@Deprecated
	public AccountService getWrappedAccountService() {
		return _accountService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	@Deprecated
	public void setWrappedAccountService(AccountService accountService) {
		_accountService = accountService;
	}

	@Override
	public AccountService getWrappedService() {
		return _accountService;
	}

	@Override
	public void setWrappedService(AccountService accountService) {
		_accountService = accountService;
	}

	private AccountService _accountService;
}