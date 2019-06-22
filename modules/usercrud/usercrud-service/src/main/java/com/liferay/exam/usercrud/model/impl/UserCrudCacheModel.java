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

package com.liferay.exam.usercrud.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.exam.usercrud.model.UserCrud;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserCrud in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see UserCrud
 * @generated
 */
@ProviderType
public class UserCrudCacheModel implements CacheModel<UserCrud>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserCrudCacheModel)) {
			return false;
		}

		UserCrudCacheModel userCrudCacheModel = (UserCrudCacheModel)obj;

		if (userCrudId == userCrudCacheModel.userCrudId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userCrudId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", userCrudId=");
		sb.append(userCrudId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", email=");
		sb.append(email);
		sb.append(", birthDate=");
		sb.append(birthDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserCrud toEntityModel() {
		UserCrudImpl userCrudImpl = new UserCrudImpl();

		if (uuid == null) {
			userCrudImpl.setUuid("");
		}
		else {
			userCrudImpl.setUuid(uuid);
		}

		userCrudImpl.setUserCrudId(userCrudId);
		userCrudImpl.setGroupId(groupId);
		userCrudImpl.setCompanyId(companyId);
		userCrudImpl.setUserId(userId);

		if (userName == null) {
			userCrudImpl.setUserName("");
		}
		else {
			userCrudImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			userCrudImpl.setCreateDate(null);
		}
		else {
			userCrudImpl.setCreateDate(new Date(createDate));
		}

		if (firstName == null) {
			userCrudImpl.setFirstName("");
		}
		else {
			userCrudImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			userCrudImpl.setLastName("");
		}
		else {
			userCrudImpl.setLastName(lastName);
		}

		if (email == null) {
			userCrudImpl.setEmail("");
		}
		else {
			userCrudImpl.setEmail(email);
		}

		if (birthDate == Long.MIN_VALUE) {
			userCrudImpl.setBirthDate(null);
		}
		else {
			userCrudImpl.setBirthDate(new Date(birthDate));
		}

		userCrudImpl.resetOriginalValues();

		return userCrudImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		userCrudId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		email = objectInput.readUTF();
		birthDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(userCrudId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		objectOutput.writeLong(birthDate);
	}

	public String uuid;
	public long userCrudId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public String firstName;
	public String lastName;
	public String email;
	public long birthDate;
}