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

package com.liferay.exam.usercrud.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.exam.usercrud.model.UserCrud;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the user crud service. This utility wraps {@link com.liferay.exam.usercrud.service.persistence.impl.UserCrudPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserCrudPersistence
 * @see com.liferay.exam.usercrud.service.persistence.impl.UserCrudPersistenceImpl
 * @generated
 */
@ProviderType
public class UserCrudUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(UserCrud userCrud) {
		getPersistence().clearCache(userCrud);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserCrud> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserCrud> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserCrud> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserCrud> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserCrud update(UserCrud userCrud) {
		return getPersistence().update(userCrud);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserCrud update(UserCrud userCrud,
		ServiceContext serviceContext) {
		return getPersistence().update(userCrud, serviceContext);
	}

	/**
	* Returns all the user cruds where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching user cruds
	*/
	public static List<UserCrud> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the user cruds where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserCrudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of user cruds
	* @param end the upper bound of the range of user cruds (not inclusive)
	* @return the range of matching user cruds
	*/
	public static List<UserCrud> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the user cruds where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserCrudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of user cruds
	* @param end the upper bound of the range of user cruds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user cruds
	*/
	public static List<UserCrud> findByUuid(String uuid, int start, int end,
		OrderByComparator<UserCrud> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the user cruds where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserCrudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of user cruds
	* @param end the upper bound of the range of user cruds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching user cruds
	*/
	public static List<UserCrud> findByUuid(String uuid, int start, int end,
		OrderByComparator<UserCrud> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first user crud in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user crud
	* @throws NoSuchUserCrudException if a matching user crud could not be found
	*/
	public static UserCrud findByUuid_First(String uuid,
		OrderByComparator<UserCrud> orderByComparator)
		throws com.liferay.exam.usercrud.exception.NoSuchUserCrudException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first user crud in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user crud, or <code>null</code> if a matching user crud could not be found
	*/
	public static UserCrud fetchByUuid_First(String uuid,
		OrderByComparator<UserCrud> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last user crud in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user crud
	* @throws NoSuchUserCrudException if a matching user crud could not be found
	*/
	public static UserCrud findByUuid_Last(String uuid,
		OrderByComparator<UserCrud> orderByComparator)
		throws com.liferay.exam.usercrud.exception.NoSuchUserCrudException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last user crud in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user crud, or <code>null</code> if a matching user crud could not be found
	*/
	public static UserCrud fetchByUuid_Last(String uuid,
		OrderByComparator<UserCrud> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the user cruds before and after the current user crud in the ordered set where uuid = &#63;.
	*
	* @param userCrudId the primary key of the current user crud
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user crud
	* @throws NoSuchUserCrudException if a user crud with the primary key could not be found
	*/
	public static UserCrud[] findByUuid_PrevAndNext(long userCrudId,
		String uuid, OrderByComparator<UserCrud> orderByComparator)
		throws com.liferay.exam.usercrud.exception.NoSuchUserCrudException {
		return getPersistence()
				   .findByUuid_PrevAndNext(userCrudId, uuid, orderByComparator);
	}

	/**
	* Removes all the user cruds where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of user cruds where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching user cruds
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the user crud where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchUserCrudException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching user crud
	* @throws NoSuchUserCrudException if a matching user crud could not be found
	*/
	public static UserCrud findByUUID_G(String uuid, long groupId)
		throws com.liferay.exam.usercrud.exception.NoSuchUserCrudException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the user crud where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching user crud, or <code>null</code> if a matching user crud could not be found
	*/
	public static UserCrud fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the user crud where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching user crud, or <code>null</code> if a matching user crud could not be found
	*/
	public static UserCrud fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the user crud where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the user crud that was removed
	*/
	public static UserCrud removeByUUID_G(String uuid, long groupId)
		throws com.liferay.exam.usercrud.exception.NoSuchUserCrudException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of user cruds where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching user cruds
	*/
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the user cruds where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching user cruds
	*/
	public static List<UserCrud> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the user cruds where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserCrudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of user cruds
	* @param end the upper bound of the range of user cruds (not inclusive)
	* @return the range of matching user cruds
	*/
	public static List<UserCrud> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the user cruds where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserCrudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of user cruds
	* @param end the upper bound of the range of user cruds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user cruds
	*/
	public static List<UserCrud> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<UserCrud> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the user cruds where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserCrudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of user cruds
	* @param end the upper bound of the range of user cruds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching user cruds
	*/
	public static List<UserCrud> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<UserCrud> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first user crud in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user crud
	* @throws NoSuchUserCrudException if a matching user crud could not be found
	*/
	public static UserCrud findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<UserCrud> orderByComparator)
		throws com.liferay.exam.usercrud.exception.NoSuchUserCrudException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first user crud in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user crud, or <code>null</code> if a matching user crud could not be found
	*/
	public static UserCrud fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<UserCrud> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last user crud in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user crud
	* @throws NoSuchUserCrudException if a matching user crud could not be found
	*/
	public static UserCrud findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<UserCrud> orderByComparator)
		throws com.liferay.exam.usercrud.exception.NoSuchUserCrudException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last user crud in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user crud, or <code>null</code> if a matching user crud could not be found
	*/
	public static UserCrud fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<UserCrud> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the user cruds before and after the current user crud in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param userCrudId the primary key of the current user crud
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user crud
	* @throws NoSuchUserCrudException if a user crud with the primary key could not be found
	*/
	public static UserCrud[] findByUuid_C_PrevAndNext(long userCrudId,
		String uuid, long companyId,
		OrderByComparator<UserCrud> orderByComparator)
		throws com.liferay.exam.usercrud.exception.NoSuchUserCrudException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(userCrudId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the user cruds where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of user cruds where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching user cruds
	*/
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the user cruds where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching user cruds
	*/
	public static List<UserCrud> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the user cruds where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserCrudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of user cruds
	* @param end the upper bound of the range of user cruds (not inclusive)
	* @return the range of matching user cruds
	*/
	public static List<UserCrud> findByGroupId(long groupId, int start, int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the user cruds where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserCrudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of user cruds
	* @param end the upper bound of the range of user cruds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user cruds
	*/
	public static List<UserCrud> findByGroupId(long groupId, int start,
		int end, OrderByComparator<UserCrud> orderByComparator) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the user cruds where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserCrudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of user cruds
	* @param end the upper bound of the range of user cruds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching user cruds
	*/
	public static List<UserCrud> findByGroupId(long groupId, int start,
		int end, OrderByComparator<UserCrud> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first user crud in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user crud
	* @throws NoSuchUserCrudException if a matching user crud could not be found
	*/
	public static UserCrud findByGroupId_First(long groupId,
		OrderByComparator<UserCrud> orderByComparator)
		throws com.liferay.exam.usercrud.exception.NoSuchUserCrudException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first user crud in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user crud, or <code>null</code> if a matching user crud could not be found
	*/
	public static UserCrud fetchByGroupId_First(long groupId,
		OrderByComparator<UserCrud> orderByComparator) {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last user crud in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user crud
	* @throws NoSuchUserCrudException if a matching user crud could not be found
	*/
	public static UserCrud findByGroupId_Last(long groupId,
		OrderByComparator<UserCrud> orderByComparator)
		throws com.liferay.exam.usercrud.exception.NoSuchUserCrudException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last user crud in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user crud, or <code>null</code> if a matching user crud could not be found
	*/
	public static UserCrud fetchByGroupId_Last(long groupId,
		OrderByComparator<UserCrud> orderByComparator) {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the user cruds before and after the current user crud in the ordered set where groupId = &#63;.
	*
	* @param userCrudId the primary key of the current user crud
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user crud
	* @throws NoSuchUserCrudException if a user crud with the primary key could not be found
	*/
	public static UserCrud[] findByGroupId_PrevAndNext(long userCrudId,
		long groupId, OrderByComparator<UserCrud> orderByComparator)
		throws com.liferay.exam.usercrud.exception.NoSuchUserCrudException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(userCrudId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the user cruds where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of user cruds where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching user cruds
	*/
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the user cruds where groupId = &#63; and userCrudId = &#63;.
	*
	* @param groupId the group ID
	* @param userCrudId the user crud ID
	* @return the matching user cruds
	*/
	public static List<UserCrud> findByG_UC(long groupId, long userCrudId) {
		return getPersistence().findByG_UC(groupId, userCrudId);
	}

	/**
	* Returns a range of all the user cruds where groupId = &#63; and userCrudId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserCrudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param userCrudId the user crud ID
	* @param start the lower bound of the range of user cruds
	* @param end the upper bound of the range of user cruds (not inclusive)
	* @return the range of matching user cruds
	*/
	public static List<UserCrud> findByG_UC(long groupId, long userCrudId,
		int start, int end) {
		return getPersistence().findByG_UC(groupId, userCrudId, start, end);
	}

	/**
	* Returns an ordered range of all the user cruds where groupId = &#63; and userCrudId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserCrudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param userCrudId the user crud ID
	* @param start the lower bound of the range of user cruds
	* @param end the upper bound of the range of user cruds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user cruds
	*/
	public static List<UserCrud> findByG_UC(long groupId, long userCrudId,
		int start, int end, OrderByComparator<UserCrud> orderByComparator) {
		return getPersistence()
				   .findByG_UC(groupId, userCrudId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the user cruds where groupId = &#63; and userCrudId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserCrudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param userCrudId the user crud ID
	* @param start the lower bound of the range of user cruds
	* @param end the upper bound of the range of user cruds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching user cruds
	*/
	public static List<UserCrud> findByG_UC(long groupId, long userCrudId,
		int start, int end, OrderByComparator<UserCrud> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByG_UC(groupId, userCrudId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first user crud in the ordered set where groupId = &#63; and userCrudId = &#63;.
	*
	* @param groupId the group ID
	* @param userCrudId the user crud ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user crud
	* @throws NoSuchUserCrudException if a matching user crud could not be found
	*/
	public static UserCrud findByG_UC_First(long groupId, long userCrudId,
		OrderByComparator<UserCrud> orderByComparator)
		throws com.liferay.exam.usercrud.exception.NoSuchUserCrudException {
		return getPersistence()
				   .findByG_UC_First(groupId, userCrudId, orderByComparator);
	}

	/**
	* Returns the first user crud in the ordered set where groupId = &#63; and userCrudId = &#63;.
	*
	* @param groupId the group ID
	* @param userCrudId the user crud ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user crud, or <code>null</code> if a matching user crud could not be found
	*/
	public static UserCrud fetchByG_UC_First(long groupId, long userCrudId,
		OrderByComparator<UserCrud> orderByComparator) {
		return getPersistence()
				   .fetchByG_UC_First(groupId, userCrudId, orderByComparator);
	}

	/**
	* Returns the last user crud in the ordered set where groupId = &#63; and userCrudId = &#63;.
	*
	* @param groupId the group ID
	* @param userCrudId the user crud ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user crud
	* @throws NoSuchUserCrudException if a matching user crud could not be found
	*/
	public static UserCrud findByG_UC_Last(long groupId, long userCrudId,
		OrderByComparator<UserCrud> orderByComparator)
		throws com.liferay.exam.usercrud.exception.NoSuchUserCrudException {
		return getPersistence()
				   .findByG_UC_Last(groupId, userCrudId, orderByComparator);
	}

	/**
	* Returns the last user crud in the ordered set where groupId = &#63; and userCrudId = &#63;.
	*
	* @param groupId the group ID
	* @param userCrudId the user crud ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user crud, or <code>null</code> if a matching user crud could not be found
	*/
	public static UserCrud fetchByG_UC_Last(long groupId, long userCrudId,
		OrderByComparator<UserCrud> orderByComparator) {
		return getPersistence()
				   .fetchByG_UC_Last(groupId, userCrudId, orderByComparator);
	}

	/**
	* Removes all the user cruds where groupId = &#63; and userCrudId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param userCrudId the user crud ID
	*/
	public static void removeByG_UC(long groupId, long userCrudId) {
		getPersistence().removeByG_UC(groupId, userCrudId);
	}

	/**
	* Returns the number of user cruds where groupId = &#63; and userCrudId = &#63;.
	*
	* @param groupId the group ID
	* @param userCrudId the user crud ID
	* @return the number of matching user cruds
	*/
	public static int countByG_UC(long groupId, long userCrudId) {
		return getPersistence().countByG_UC(groupId, userCrudId);
	}

	/**
	* Caches the user crud in the entity cache if it is enabled.
	*
	* @param userCrud the user crud
	*/
	public static void cacheResult(UserCrud userCrud) {
		getPersistence().cacheResult(userCrud);
	}

	/**
	* Caches the user cruds in the entity cache if it is enabled.
	*
	* @param userCruds the user cruds
	*/
	public static void cacheResult(List<UserCrud> userCruds) {
		getPersistence().cacheResult(userCruds);
	}

	/**
	* Creates a new user crud with the primary key. Does not add the user crud to the database.
	*
	* @param userCrudId the primary key for the new user crud
	* @return the new user crud
	*/
	public static UserCrud create(long userCrudId) {
		return getPersistence().create(userCrudId);
	}

	/**
	* Removes the user crud with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userCrudId the primary key of the user crud
	* @return the user crud that was removed
	* @throws NoSuchUserCrudException if a user crud with the primary key could not be found
	*/
	public static UserCrud remove(long userCrudId)
		throws com.liferay.exam.usercrud.exception.NoSuchUserCrudException {
		return getPersistence().remove(userCrudId);
	}

	public static UserCrud updateImpl(UserCrud userCrud) {
		return getPersistence().updateImpl(userCrud);
	}

	/**
	* Returns the user crud with the primary key or throws a {@link NoSuchUserCrudException} if it could not be found.
	*
	* @param userCrudId the primary key of the user crud
	* @return the user crud
	* @throws NoSuchUserCrudException if a user crud with the primary key could not be found
	*/
	public static UserCrud findByPrimaryKey(long userCrudId)
		throws com.liferay.exam.usercrud.exception.NoSuchUserCrudException {
		return getPersistence().findByPrimaryKey(userCrudId);
	}

	/**
	* Returns the user crud with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userCrudId the primary key of the user crud
	* @return the user crud, or <code>null</code> if a user crud with the primary key could not be found
	*/
	public static UserCrud fetchByPrimaryKey(long userCrudId) {
		return getPersistence().fetchByPrimaryKey(userCrudId);
	}

	public static java.util.Map<java.io.Serializable, UserCrud> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the user cruds.
	*
	* @return the user cruds
	*/
	public static List<UserCrud> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the user cruds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserCrudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user cruds
	* @param end the upper bound of the range of user cruds (not inclusive)
	* @return the range of user cruds
	*/
	public static List<UserCrud> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the user cruds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserCrudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user cruds
	* @param end the upper bound of the range of user cruds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user cruds
	*/
	public static List<UserCrud> findAll(int start, int end,
		OrderByComparator<UserCrud> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the user cruds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserCrudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user cruds
	* @param end the upper bound of the range of user cruds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of user cruds
	*/
	public static List<UserCrud> findAll(int start, int end,
		OrderByComparator<UserCrud> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the user cruds from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user cruds.
	*
	* @return the number of user cruds
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static UserCrudPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UserCrudPersistence, UserCrudPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(UserCrudPersistence.class);

		ServiceTracker<UserCrudPersistence, UserCrudPersistence> serviceTracker = new ServiceTracker<UserCrudPersistence, UserCrudPersistence>(bundle.getBundleContext(),
				UserCrudPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}