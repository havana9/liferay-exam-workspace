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

import com.liferay.exam.usercrud.exception.NoSuchUserCrudException;
import com.liferay.exam.usercrud.model.UserCrud;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the user crud service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.exam.usercrud.service.persistence.impl.UserCrudPersistenceImpl
 * @see UserCrudUtil
 * @generated
 */
@ProviderType
public interface UserCrudPersistence extends BasePersistence<UserCrud> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserCrudUtil} to access the user crud persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the user cruds where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching user cruds
	*/
	public java.util.List<UserCrud> findByUuid(String uuid);

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
	public java.util.List<UserCrud> findByUuid(String uuid, int start, int end);

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
	public java.util.List<UserCrud> findByUuid(String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserCrud> orderByComparator);

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
	public java.util.List<UserCrud> findByUuid(String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserCrud> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first user crud in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user crud
	* @throws NoSuchUserCrudException if a matching user crud could not be found
	*/
	public UserCrud findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserCrud> orderByComparator)
		throws NoSuchUserCrudException;

	/**
	* Returns the first user crud in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user crud, or <code>null</code> if a matching user crud could not be found
	*/
	public UserCrud fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserCrud> orderByComparator);

	/**
	* Returns the last user crud in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user crud
	* @throws NoSuchUserCrudException if a matching user crud could not be found
	*/
	public UserCrud findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserCrud> orderByComparator)
		throws NoSuchUserCrudException;

	/**
	* Returns the last user crud in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user crud, or <code>null</code> if a matching user crud could not be found
	*/
	public UserCrud fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserCrud> orderByComparator);

	/**
	* Returns the user cruds before and after the current user crud in the ordered set where uuid = &#63;.
	*
	* @param userCrudId the primary key of the current user crud
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user crud
	* @throws NoSuchUserCrudException if a user crud with the primary key could not be found
	*/
	public UserCrud[] findByUuid_PrevAndNext(long userCrudId, String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserCrud> orderByComparator)
		throws NoSuchUserCrudException;

	/**
	* Removes all the user cruds where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of user cruds where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching user cruds
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the user crud where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchUserCrudException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching user crud
	* @throws NoSuchUserCrudException if a matching user crud could not be found
	*/
	public UserCrud findByUUID_G(String uuid, long groupId)
		throws NoSuchUserCrudException;

	/**
	* Returns the user crud where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching user crud, or <code>null</code> if a matching user crud could not be found
	*/
	public UserCrud fetchByUUID_G(String uuid, long groupId);

	/**
	* Returns the user crud where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching user crud, or <code>null</code> if a matching user crud could not be found
	*/
	public UserCrud fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the user crud where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the user crud that was removed
	*/
	public UserCrud removeByUUID_G(String uuid, long groupId)
		throws NoSuchUserCrudException;

	/**
	* Returns the number of user cruds where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching user cruds
	*/
	public int countByUUID_G(String uuid, long groupId);

	/**
	* Returns all the user cruds where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching user cruds
	*/
	public java.util.List<UserCrud> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<UserCrud> findByUuid_C(String uuid, long companyId,
		int start, int end);

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
	public java.util.List<UserCrud> findByUuid_C(String uuid, long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserCrud> orderByComparator);

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
	public java.util.List<UserCrud> findByUuid_C(String uuid, long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserCrud> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first user crud in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user crud
	* @throws NoSuchUserCrudException if a matching user crud could not be found
	*/
	public UserCrud findByUuid_C_First(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<UserCrud> orderByComparator)
		throws NoSuchUserCrudException;

	/**
	* Returns the first user crud in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user crud, or <code>null</code> if a matching user crud could not be found
	*/
	public UserCrud fetchByUuid_C_First(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<UserCrud> orderByComparator);

	/**
	* Returns the last user crud in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user crud
	* @throws NoSuchUserCrudException if a matching user crud could not be found
	*/
	public UserCrud findByUuid_C_Last(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<UserCrud> orderByComparator)
		throws NoSuchUserCrudException;

	/**
	* Returns the last user crud in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user crud, or <code>null</code> if a matching user crud could not be found
	*/
	public UserCrud fetchByUuid_C_Last(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<UserCrud> orderByComparator);

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
	public UserCrud[] findByUuid_C_PrevAndNext(long userCrudId, String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<UserCrud> orderByComparator)
		throws NoSuchUserCrudException;

	/**
	* Removes all the user cruds where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(String uuid, long companyId);

	/**
	* Returns the number of user cruds where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching user cruds
	*/
	public int countByUuid_C(String uuid, long companyId);

	/**
	* Returns all the user cruds where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching user cruds
	*/
	public java.util.List<UserCrud> findByGroupId(long groupId);

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
	public java.util.List<UserCrud> findByGroupId(long groupId, int start,
		int end);

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
	public java.util.List<UserCrud> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserCrud> orderByComparator);

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
	public java.util.List<UserCrud> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserCrud> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first user crud in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user crud
	* @throws NoSuchUserCrudException if a matching user crud could not be found
	*/
	public UserCrud findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<UserCrud> orderByComparator)
		throws NoSuchUserCrudException;

	/**
	* Returns the first user crud in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user crud, or <code>null</code> if a matching user crud could not be found
	*/
	public UserCrud fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<UserCrud> orderByComparator);

	/**
	* Returns the last user crud in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user crud
	* @throws NoSuchUserCrudException if a matching user crud could not be found
	*/
	public UserCrud findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<UserCrud> orderByComparator)
		throws NoSuchUserCrudException;

	/**
	* Returns the last user crud in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user crud, or <code>null</code> if a matching user crud could not be found
	*/
	public UserCrud fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<UserCrud> orderByComparator);

	/**
	* Returns the user cruds before and after the current user crud in the ordered set where groupId = &#63;.
	*
	* @param userCrudId the primary key of the current user crud
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user crud
	* @throws NoSuchUserCrudException if a user crud with the primary key could not be found
	*/
	public UserCrud[] findByGroupId_PrevAndNext(long userCrudId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<UserCrud> orderByComparator)
		throws NoSuchUserCrudException;

	/**
	* Removes all the user cruds where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroupId(long groupId);

	/**
	* Returns the number of user cruds where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching user cruds
	*/
	public int countByGroupId(long groupId);

	/**
	* Returns all the user cruds where groupId = &#63; and userCrudId = &#63;.
	*
	* @param groupId the group ID
	* @param userCrudId the user crud ID
	* @return the matching user cruds
	*/
	public java.util.List<UserCrud> findByG_UC(long groupId, long userCrudId);

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
	public java.util.List<UserCrud> findByG_UC(long groupId, long userCrudId,
		int start, int end);

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
	public java.util.List<UserCrud> findByG_UC(long groupId, long userCrudId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserCrud> orderByComparator);

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
	public java.util.List<UserCrud> findByG_UC(long groupId, long userCrudId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserCrud> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first user crud in the ordered set where groupId = &#63; and userCrudId = &#63;.
	*
	* @param groupId the group ID
	* @param userCrudId the user crud ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user crud
	* @throws NoSuchUserCrudException if a matching user crud could not be found
	*/
	public UserCrud findByG_UC_First(long groupId, long userCrudId,
		com.liferay.portal.kernel.util.OrderByComparator<UserCrud> orderByComparator)
		throws NoSuchUserCrudException;

	/**
	* Returns the first user crud in the ordered set where groupId = &#63; and userCrudId = &#63;.
	*
	* @param groupId the group ID
	* @param userCrudId the user crud ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user crud, or <code>null</code> if a matching user crud could not be found
	*/
	public UserCrud fetchByG_UC_First(long groupId, long userCrudId,
		com.liferay.portal.kernel.util.OrderByComparator<UserCrud> orderByComparator);

	/**
	* Returns the last user crud in the ordered set where groupId = &#63; and userCrudId = &#63;.
	*
	* @param groupId the group ID
	* @param userCrudId the user crud ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user crud
	* @throws NoSuchUserCrudException if a matching user crud could not be found
	*/
	public UserCrud findByG_UC_Last(long groupId, long userCrudId,
		com.liferay.portal.kernel.util.OrderByComparator<UserCrud> orderByComparator)
		throws NoSuchUserCrudException;

	/**
	* Returns the last user crud in the ordered set where groupId = &#63; and userCrudId = &#63;.
	*
	* @param groupId the group ID
	* @param userCrudId the user crud ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user crud, or <code>null</code> if a matching user crud could not be found
	*/
	public UserCrud fetchByG_UC_Last(long groupId, long userCrudId,
		com.liferay.portal.kernel.util.OrderByComparator<UserCrud> orderByComparator);

	/**
	* Removes all the user cruds where groupId = &#63; and userCrudId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param userCrudId the user crud ID
	*/
	public void removeByG_UC(long groupId, long userCrudId);

	/**
	* Returns the number of user cruds where groupId = &#63; and userCrudId = &#63;.
	*
	* @param groupId the group ID
	* @param userCrudId the user crud ID
	* @return the number of matching user cruds
	*/
	public int countByG_UC(long groupId, long userCrudId);

	/**
	* Caches the user crud in the entity cache if it is enabled.
	*
	* @param userCrud the user crud
	*/
	public void cacheResult(UserCrud userCrud);

	/**
	* Caches the user cruds in the entity cache if it is enabled.
	*
	* @param userCruds the user cruds
	*/
	public void cacheResult(java.util.List<UserCrud> userCruds);

	/**
	* Creates a new user crud with the primary key. Does not add the user crud to the database.
	*
	* @param userCrudId the primary key for the new user crud
	* @return the new user crud
	*/
	public UserCrud create(long userCrudId);

	/**
	* Removes the user crud with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userCrudId the primary key of the user crud
	* @return the user crud that was removed
	* @throws NoSuchUserCrudException if a user crud with the primary key could not be found
	*/
	public UserCrud remove(long userCrudId) throws NoSuchUserCrudException;

	public UserCrud updateImpl(UserCrud userCrud);

	/**
	* Returns the user crud with the primary key or throws a {@link NoSuchUserCrudException} if it could not be found.
	*
	* @param userCrudId the primary key of the user crud
	* @return the user crud
	* @throws NoSuchUserCrudException if a user crud with the primary key could not be found
	*/
	public UserCrud findByPrimaryKey(long userCrudId)
		throws NoSuchUserCrudException;

	/**
	* Returns the user crud with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userCrudId the primary key of the user crud
	* @return the user crud, or <code>null</code> if a user crud with the primary key could not be found
	*/
	public UserCrud fetchByPrimaryKey(long userCrudId);

	@Override
	public java.util.Map<java.io.Serializable, UserCrud> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the user cruds.
	*
	* @return the user cruds
	*/
	public java.util.List<UserCrud> findAll();

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
	public java.util.List<UserCrud> findAll(int start, int end);

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
	public java.util.List<UserCrud> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserCrud> orderByComparator);

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
	public java.util.List<UserCrud> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserCrud> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the user cruds from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of user cruds.
	*
	* @return the number of user cruds
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}