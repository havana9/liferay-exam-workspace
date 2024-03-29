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

package com.liferay.exam.usercrud.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserCrudLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserCrudLocalService
 * @generated
 */
@ProviderType
public class UserCrudLocalServiceWrapper implements UserCrudLocalService,
	ServiceWrapper<UserCrudLocalService> {
	public UserCrudLocalServiceWrapper(
		UserCrudLocalService userCrudLocalService) {
		_userCrudLocalService = userCrudLocalService;
	}

	@Override
	public com.liferay.exam.usercrud.model.UserCrud addUser(long userId,
		String firstName, String lastName, String birthDate, String email,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userCrudLocalService.addUser(userId, firstName, lastName,
			birthDate, email, serviceContext);
	}

	/**
	* Adds the user crud to the database. Also notifies the appropriate model listeners.
	*
	* @param userCrud the user crud
	* @return the user crud that was added
	*/
	@Override
	public com.liferay.exam.usercrud.model.UserCrud addUserCrud(
		com.liferay.exam.usercrud.model.UserCrud userCrud) {
		return _userCrudLocalService.addUserCrud(userCrud);
	}

	/**
	* Creates a new user crud with the primary key. Does not add the user crud to the database.
	*
	* @param userCrudId the primary key for the new user crud
	* @return the new user crud
	*/
	@Override
	public com.liferay.exam.usercrud.model.UserCrud createUserCrud(
		long userCrudId) {
		return _userCrudLocalService.createUserCrud(userCrudId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userCrudLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the user crud with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userCrudId the primary key of the user crud
	* @return the user crud that was removed
	* @throws PortalException if a user crud with the primary key could not be found
	*/
	@Override
	public com.liferay.exam.usercrud.model.UserCrud deleteUserCrud(
		long userCrudId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userCrudLocalService.deleteUserCrud(userCrudId);
	}

	/**
	* Deletes the user crud from the database. Also notifies the appropriate model listeners.
	*
	* @param userCrud the user crud
	* @return the user crud that was removed
	*/
	@Override
	public com.liferay.exam.usercrud.model.UserCrud deleteUserCrud(
		com.liferay.exam.usercrud.model.UserCrud userCrud) {
		return _userCrudLocalService.deleteUserCrud(userCrud);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userCrudLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _userCrudLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.exam.usercrud.model.impl.UserCrudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _userCrudLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.exam.usercrud.model.impl.UserCrudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _userCrudLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _userCrudLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _userCrudLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.exam.usercrud.model.UserCrud fetchUserCrud(
		long userCrudId) {
		return _userCrudLocalService.fetchUserCrud(userCrudId);
	}

	/**
	* Returns the user crud matching the UUID and group.
	*
	* @param uuid the user crud's UUID
	* @param groupId the primary key of the group
	* @return the matching user crud, or <code>null</code> if a matching user crud could not be found
	*/
	@Override
	public com.liferay.exam.usercrud.model.UserCrud fetchUserCrudByUuidAndGroupId(
		String uuid, long groupId) {
		return _userCrudLocalService.fetchUserCrudByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _userCrudLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _userCrudLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _userCrudLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userCrudLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the user crud with the primary key.
	*
	* @param userCrudId the primary key of the user crud
	* @return the user crud
	* @throws PortalException if a user crud with the primary key could not be found
	*/
	@Override
	public com.liferay.exam.usercrud.model.UserCrud getUserCrud(long userCrudId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userCrudLocalService.getUserCrud(userCrudId);
	}

	/**
	* Returns the user crud matching the UUID and group.
	*
	* @param uuid the user crud's UUID
	* @param groupId the primary key of the group
	* @return the matching user crud
	* @throws PortalException if a matching user crud could not be found
	*/
	@Override
	public com.liferay.exam.usercrud.model.UserCrud getUserCrudByUuidAndGroupId(
		String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userCrudLocalService.getUserCrudByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the user cruds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.exam.usercrud.model.impl.UserCrudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user cruds
	* @param end the upper bound of the range of user cruds (not inclusive)
	* @return the range of user cruds
	*/
	@Override
	public java.util.List<com.liferay.exam.usercrud.model.UserCrud> getUserCruds(
		int start, int end) {
		return _userCrudLocalService.getUserCruds(start, end);
	}

	/**
	* Returns all the user cruds matching the UUID and company.
	*
	* @param uuid the UUID of the user cruds
	* @param companyId the primary key of the company
	* @return the matching user cruds, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.exam.usercrud.model.UserCrud> getUserCrudsByUuidAndCompanyId(
		String uuid, long companyId) {
		return _userCrudLocalService.getUserCrudsByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns a range of user cruds matching the UUID and company.
	*
	* @param uuid the UUID of the user cruds
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of user cruds
	* @param end the upper bound of the range of user cruds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching user cruds, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.exam.usercrud.model.UserCrud> getUserCrudsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.exam.usercrud.model.UserCrud> orderByComparator) {
		return _userCrudLocalService.getUserCrudsByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns the number of user cruds.
	*
	* @return the number of user cruds
	*/
	@Override
	public int getUserCrudsCount() {
		return _userCrudLocalService.getUserCrudsCount();
	}

	/**
	* Updates the user crud in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userCrud the user crud
	* @return the user crud that was updated
	*/
	@Override
	public com.liferay.exam.usercrud.model.UserCrud updateUserCrud(
		com.liferay.exam.usercrud.model.UserCrud userCrud) {
		return _userCrudLocalService.updateUserCrud(userCrud);
	}

	@Override
	public UserCrudLocalService getWrappedService() {
		return _userCrudLocalService;
	}

	@Override
	public void setWrappedService(UserCrudLocalService userCrudLocalService) {
		_userCrudLocalService = userCrudLocalService;
	}

	private UserCrudLocalService _userCrudLocalService;
}