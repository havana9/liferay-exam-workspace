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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link UserCrud}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserCrud
 * @generated
 */
@ProviderType
public class UserCrudWrapper implements UserCrud, ModelWrapper<UserCrud> {
	public UserCrudWrapper(UserCrud userCrud) {
		_userCrud = userCrud;
	}

	@Override
	public Class<?> getModelClass() {
		return UserCrud.class;
	}

	@Override
	public String getModelClassName() {
		return UserCrud.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("userCrudId", getUserCrudId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("email", getEmail());
		attributes.put("birthDate", getBirthDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long userCrudId = (Long)attributes.get("userCrudId");

		if (userCrudId != null) {
			setUserCrudId(userCrudId);
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

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Date birthDate = (Date)attributes.get("birthDate");

		if (birthDate != null) {
			setBirthDate(birthDate);
		}
	}

	@Override
	public Object clone() {
		return new UserCrudWrapper((UserCrud)_userCrud.clone());
	}

	@Override
	public int compareTo(UserCrud userCrud) {
		return _userCrud.compareTo(userCrud);
	}

	/**
	* Returns the birth date of this user crud.
	*
	* @return the birth date of this user crud
	*/
	@Override
	public Date getBirthDate() {
		return _userCrud.getBirthDate();
	}

	/**
	* Returns the company ID of this user crud.
	*
	* @return the company ID of this user crud
	*/
	@Override
	public long getCompanyId() {
		return _userCrud.getCompanyId();
	}

	/**
	* Returns the create date of this user crud.
	*
	* @return the create date of this user crud
	*/
	@Override
	public Date getCreateDate() {
		return _userCrud.getCreateDate();
	}

	/**
	* Returns the email of this user crud.
	*
	* @return the email of this user crud
	*/
	@Override
	public String getEmail() {
		return _userCrud.getEmail();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _userCrud.getExpandoBridge();
	}

	/**
	* Returns the first name of this user crud.
	*
	* @return the first name of this user crud
	*/
	@Override
	public String getFirstName() {
		return _userCrud.getFirstName();
	}

	/**
	* Returns the group ID of this user crud.
	*
	* @return the group ID of this user crud
	*/
	@Override
	public long getGroupId() {
		return _userCrud.getGroupId();
	}

	/**
	* Returns the last name of this user crud.
	*
	* @return the last name of this user crud
	*/
	@Override
	public String getLastName() {
		return _userCrud.getLastName();
	}

	/**
	* Returns the primary key of this user crud.
	*
	* @return the primary key of this user crud
	*/
	@Override
	public long getPrimaryKey() {
		return _userCrud.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userCrud.getPrimaryKeyObj();
	}

	/**
	* Returns the user crud ID of this user crud.
	*
	* @return the user crud ID of this user crud
	*/
	@Override
	public long getUserCrudId() {
		return _userCrud.getUserCrudId();
	}

	/**
	* Returns the user ID of this user crud.
	*
	* @return the user ID of this user crud
	*/
	@Override
	public long getUserId() {
		return _userCrud.getUserId();
	}

	/**
	* Returns the user name of this user crud.
	*
	* @return the user name of this user crud
	*/
	@Override
	public String getUserName() {
		return _userCrud.getUserName();
	}

	/**
	* Returns the user uuid of this user crud.
	*
	* @return the user uuid of this user crud
	*/
	@Override
	public String getUserUuid() {
		return _userCrud.getUserUuid();
	}

	/**
	* Returns the uuid of this user crud.
	*
	* @return the uuid of this user crud
	*/
	@Override
	public String getUuid() {
		return _userCrud.getUuid();
	}

	@Override
	public int hashCode() {
		return _userCrud.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _userCrud.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _userCrud.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _userCrud.isNew();
	}

	@Override
	public void persist() {
		_userCrud.persist();
	}

	/**
	* Sets the birth date of this user crud.
	*
	* @param birthDate the birth date of this user crud
	*/
	@Override
	public void setBirthDate(Date birthDate) {
		_userCrud.setBirthDate(birthDate);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userCrud.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this user crud.
	*
	* @param companyId the company ID of this user crud
	*/
	@Override
	public void setCompanyId(long companyId) {
		_userCrud.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this user crud.
	*
	* @param createDate the create date of this user crud
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_userCrud.setCreateDate(createDate);
	}

	/**
	* Sets the email of this user crud.
	*
	* @param email the email of this user crud
	*/
	@Override
	public void setEmail(String email) {
		_userCrud.setEmail(email);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_userCrud.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_userCrud.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_userCrud.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the first name of this user crud.
	*
	* @param firstName the first name of this user crud
	*/
	@Override
	public void setFirstName(String firstName) {
		_userCrud.setFirstName(firstName);
	}

	/**
	* Sets the group ID of this user crud.
	*
	* @param groupId the group ID of this user crud
	*/
	@Override
	public void setGroupId(long groupId) {
		_userCrud.setGroupId(groupId);
	}

	/**
	* Sets the last name of this user crud.
	*
	* @param lastName the last name of this user crud
	*/
	@Override
	public void setLastName(String lastName) {
		_userCrud.setLastName(lastName);
	}

	@Override
	public void setNew(boolean n) {
		_userCrud.setNew(n);
	}

	/**
	* Sets the primary key of this user crud.
	*
	* @param primaryKey the primary key of this user crud
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_userCrud.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_userCrud.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user crud ID of this user crud.
	*
	* @param userCrudId the user crud ID of this user crud
	*/
	@Override
	public void setUserCrudId(long userCrudId) {
		_userCrud.setUserCrudId(userCrudId);
	}

	/**
	* Sets the user ID of this user crud.
	*
	* @param userId the user ID of this user crud
	*/
	@Override
	public void setUserId(long userId) {
		_userCrud.setUserId(userId);
	}

	/**
	* Sets the user name of this user crud.
	*
	* @param userName the user name of this user crud
	*/
	@Override
	public void setUserName(String userName) {
		_userCrud.setUserName(userName);
	}

	/**
	* Sets the user uuid of this user crud.
	*
	* @param userUuid the user uuid of this user crud
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_userCrud.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this user crud.
	*
	* @param uuid the uuid of this user crud
	*/
	@Override
	public void setUuid(String uuid) {
		_userCrud.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<UserCrud> toCacheModel() {
		return _userCrud.toCacheModel();
	}

	@Override
	public UserCrud toEscapedModel() {
		return new UserCrudWrapper(_userCrud.toEscapedModel());
	}

	@Override
	public String toString() {
		return _userCrud.toString();
	}

	@Override
	public UserCrud toUnescapedModel() {
		return new UserCrudWrapper(_userCrud.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _userCrud.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserCrudWrapper)) {
			return false;
		}

		UserCrudWrapper userCrudWrapper = (UserCrudWrapper)obj;

		if (Objects.equals(_userCrud, userCrudWrapper._userCrud)) {
			return true;
		}

		return false;
	}

	@Override
	public UserCrud getWrappedModel() {
		return _userCrud;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _userCrud.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _userCrud.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_userCrud.resetOriginalValues();
	}

	private final UserCrud _userCrud;
}