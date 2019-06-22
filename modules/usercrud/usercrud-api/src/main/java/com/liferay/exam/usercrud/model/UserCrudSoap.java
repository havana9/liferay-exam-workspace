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

package com.liferay.exam.usercrud.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.exam.usercrud.service.http.UserCrudServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.exam.usercrud.service.http.UserCrudServiceSoap
 * @generated
 */
@ProviderType
public class UserCrudSoap implements Serializable {
	public static UserCrudSoap toSoapModel(UserCrud model) {
		UserCrudSoap soapModel = new UserCrudSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setUserCrudId(model.getUserCrudId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setEmail(model.getEmail());
		soapModel.setBirthDate(model.getBirthDate());

		return soapModel;
	}

	public static UserCrudSoap[] toSoapModels(UserCrud[] models) {
		UserCrudSoap[] soapModels = new UserCrudSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserCrudSoap[][] toSoapModels(UserCrud[][] models) {
		UserCrudSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserCrudSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserCrudSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserCrudSoap[] toSoapModels(List<UserCrud> models) {
		List<UserCrudSoap> soapModels = new ArrayList<UserCrudSoap>(models.size());

		for (UserCrud model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserCrudSoap[soapModels.size()]);
	}

	public UserCrudSoap() {
	}

	public long getPrimaryKey() {
		return _userCrudId;
	}

	public void setPrimaryKey(long pk) {
		setUserCrudId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getUserCrudId() {
		return _userCrudId;
	}

	public void setUserCrudId(long userCrudId) {
		_userCrudId = userCrudId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public Date getBirthDate() {
		return _birthDate;
	}

	public void setBirthDate(Date birthDate) {
		_birthDate = birthDate;
	}

	private String _uuid;
	private long _userCrudId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private String _firstName;
	private String _lastName;
	private String _email;
	private Date _birthDate;
}