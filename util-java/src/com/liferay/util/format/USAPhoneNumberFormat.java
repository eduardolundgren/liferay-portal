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

package com.liferay.util.format;

import com.liferay.portal.kernel.format.PhoneNumberFormat;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author     Brian Wing Shun Chan
 * @author     Manuel de la Peña
 * @deprecated As of 6.2.0, replaced by {@link com.liferay.portal.format.USAPhoneNumberFormatImpl}
 */
public class USAPhoneNumberFormat implements PhoneNumberFormat {

	public String format(String phoneNumber) {
		if (Validator.isNull(phoneNumber)) {
			return StringPool.BLANK;
		}

		if (phoneNumber.length() > 10) {
			StringBundler sb = new StringBundler(8);

			sb.append(StringPool.OPEN_PARENTHESIS);
			sb.append(phoneNumber.substring(0, 3));
			sb.append(") ");
			sb.append(phoneNumber.substring(3, 6));
			sb.append(StringPool.DASH);
			sb.append(phoneNumber.substring(6, 10));
			sb.append(" x");
			sb.append(phoneNumber.substring(10));

			return sb.toString();
		}
		else if (phoneNumber.length() == 10) {
			StringBundler sb = new StringBundler(6);

			sb.append(StringPool.OPEN_PARENTHESIS);
			sb.append(phoneNumber.substring(0, 3));
			sb.append(") ");
			sb.append(phoneNumber.substring(3, 6));
			sb.append(StringPool.DASH);
			sb.append(phoneNumber.substring(6));

			return sb.toString();
		}
		else if (phoneNumber.length() == 7) {
			return phoneNumber.substring(0, 3).concat(StringPool.DASH).concat(
				phoneNumber.substring(3));
		}

		return phoneNumber;
	}

	public String strip(String phoneNumber) {
		return StringUtil.extractDigits(phoneNumber);
	}

	public boolean validate(String phoneNumber) {
		if (Validator.isNull(phoneNumber)) {
			return false;
		}

		return phoneNumber.matches(
			PropsUtil.get(PropsKeys.PHONE_NUMBER_FORMAT_USA_REGEXP));
	}

}