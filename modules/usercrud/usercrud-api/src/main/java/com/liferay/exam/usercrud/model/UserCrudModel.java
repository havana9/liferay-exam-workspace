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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the UserCrud service. Represents a row in the &quot;LFREXAM_UserCrud&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.exam.usercrud.model.impl.UserCrudModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.exam.usercrud.model.impl.UserCrudImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserCrud
 * @see com.liferay.exam.usercrud.model.impl.UserCrudImpl
 * @see com.liferay.exam.usercrud.model.impl.UserCrudModelImpl
 * @generated
 */
@ProviderType
public interface UserCrudModel extends BaseModel<UserCrud>, ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a user crud model instance should use the {@link UserCrud} interface instead.
	 */

	/**
	 * Returns the primary key of this user crud.
	 *
	 * @return the primary key of this user crud
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this user crud.
	 *
	 * @param primaryKey the primary key of this user crud
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this user crud.
	 *
	 * @return the uuid of this user crud
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this user crud.
	 *
	 * @param uuid the uuid of this user crud
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the user crud ID of this user crud.
	 *
	 * @return the user crud ID of this user crud
	 */
	public long getUserCrudId();

	/**
	 * Sets the user crud ID of this user crud.
	 *
	 * @param userCrudId the user crud ID of this user crud
	 */
	public void setUserCrudId(long userCrudId);

	/**
	 * Returns the group ID of this user crud.
	 *
	 * @return the group ID of this user crud
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this user crud.
	 *
	 * @param groupId the group ID of this user crud
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this user crud.
	 *
	 * @return the company ID of this user crud
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this user crud.
	 *
	 * @param companyId the company ID of this user crud
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this user crud.
	 *
	 * @return the user ID of this user crud
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this user crud.
	 *
	 * @param userId the user ID of this user crud
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this user crud.
	 *
	 * @return the user uuid of this user crud
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this user crud.
	 *
	 * @param userUuid the user uuid of this user crud
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this user crud.
	 *
	 * @return the user name of this user crud
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this user crud.
	 *
	 * @param userName the user name of this user crud
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this user crud.
	 *
	 * @return the create date of this user crud
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this user crud.
	 *
	 * @param createDate the create date of this user crud
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the first name of this user crud.
	 *
	 * @return the first name of this user crud
	 */
	@AutoEscape
	public String getFirstName();

	/**
	 * Sets the first name of this user crud.
	 *
	 * @param firstName the first name of this user crud
	 */
	public void setFirstName(String firstName);

	/**
	 * Returns the last name of this user crud.
	 *
	 * @return the last name of this user crud
	 */
	@AutoEscape
	public String getLastName();

	/**
	 * Sets the last name of this user crud.
	 *
	 * @param lastName the last name of this user crud
	 */
	public void setLastName(String lastName);

	/**
	 * Returns the email of this user crud.
	 *
	 * @return the email of this user crud
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this user crud.
	 *
	 * @param email the email of this user crud
	 */
	public void setEmail(String email);

	/**
	 * Returns the birth date of this user crud.
	 *
	 * @return the birth date of this user crud
	 */
	public Date getBirthDate();

	/**
	 * Sets the birth date of this user crud.
	 *
	 * @param birthDate the birth date of this user crud
	 */
	public void setBirthDate(Date birthDate);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(UserCrud userCrud);

	@Override
	public int hashCode();

	@Override
	public CacheModel<UserCrud> toCacheModel();

	@Override
	public UserCrud toEscapedModel();

	@Override
	public UserCrud toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}