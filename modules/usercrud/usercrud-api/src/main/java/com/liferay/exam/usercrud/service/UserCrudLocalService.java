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

import com.liferay.exam.usercrud.model.UserCrud;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for UserCrud. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserCrudLocalServiceUtil
 * @see com.liferay.exam.usercrud.service.base.UserCrudLocalServiceBaseImpl
 * @see com.liferay.exam.usercrud.service.impl.UserCrudLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface UserCrudLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserCrudLocalServiceUtil} to access the user crud local service. Add custom service methods to {@link com.liferay.exam.usercrud.service.impl.UserCrudLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public UserCrud addUser(long userId, String firstName, String lastName,
		String birthDate, String email, ServiceContext serviceContext)
		throws PortalException;

	/**
	* Adds the user crud to the database. Also notifies the appropriate model listeners.
	*
	* @param userCrud the user crud
	* @return the user crud that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public UserCrud addUserCrud(UserCrud userCrud);

	/**
	* Creates a new user crud with the primary key. Does not add the user crud to the database.
	*
	* @param userCrudId the primary key for the new user crud
	* @return the new user crud
	*/
	@Transactional(enabled = false)
	public UserCrud createUserCrud(long userCrudId);

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	* Deletes the user crud with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userCrudId the primary key of the user crud
	* @return the user crud that was removed
	* @throws PortalException if a user crud with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public UserCrud deleteUserCrud(long userCrudId) throws PortalException;

	/**
	* Deletes the user crud from the database. Also notifies the appropriate model listeners.
	*
	* @param userCrud the user crud
	* @return the user crud that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public UserCrud deleteUserCrud(UserCrud userCrud);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UserCrud fetchUserCrud(long userCrudId);

	/**
	* Returns the user crud matching the UUID and group.
	*
	* @param uuid the user crud's UUID
	* @param groupId the primary key of the group
	* @return the matching user crud, or <code>null</code> if a matching user crud could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UserCrud fetchUserCrudByUuidAndGroupId(String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Returns the user crud with the primary key.
	*
	* @param userCrudId the primary key of the user crud
	* @return the user crud
	* @throws PortalException if a user crud with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UserCrud getUserCrud(long userCrudId) throws PortalException;

	/**
	* Returns the user crud matching the UUID and group.
	*
	* @param uuid the user crud's UUID
	* @param groupId the primary key of the group
	* @return the matching user crud
	* @throws PortalException if a matching user crud could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UserCrud getUserCrudByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserCrud> getUserCruds(int start, int end);

	/**
	* Returns all the user cruds matching the UUID and company.
	*
	* @param uuid the UUID of the user cruds
	* @param companyId the primary key of the company
	* @return the matching user cruds, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserCrud> getUserCrudsByUuidAndCompanyId(String uuid,
		long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserCrud> getUserCrudsByUuidAndCompanyId(String uuid,
		long companyId, int start, int end,
		OrderByComparator<UserCrud> orderByComparator);

	/**
	* Returns the number of user cruds.
	*
	* @return the number of user cruds
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getUserCrudsCount();

	/**
	* Updates the user crud in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userCrud the user crud
	* @return the user crud that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public UserCrud updateUserCrud(UserCrud userCrud);
}