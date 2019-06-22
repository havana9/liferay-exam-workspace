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

package com.liferay.exam.usercrud.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.exam.usercrud.exception.NoSuchUserCrudException;
import com.liferay.exam.usercrud.model.UserCrud;
import com.liferay.exam.usercrud.model.impl.UserCrudImpl;
import com.liferay.exam.usercrud.model.impl.UserCrudModelImpl;
import com.liferay.exam.usercrud.service.persistence.UserCrudPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the user crud service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserCrudPersistence
 * @see com.liferay.exam.usercrud.service.persistence.UserCrudUtil
 * @generated
 */
@ProviderType
public class UserCrudPersistenceImpl extends BasePersistenceImpl<UserCrud>
	implements UserCrudPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserCrudUtil} to access the user crud persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserCrudImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserCrudModelImpl.ENTITY_CACHE_ENABLED,
			UserCrudModelImpl.FINDER_CACHE_ENABLED, UserCrudImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserCrudModelImpl.ENTITY_CACHE_ENABLED,
			UserCrudModelImpl.FINDER_CACHE_ENABLED, UserCrudImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserCrudModelImpl.ENTITY_CACHE_ENABLED,
			UserCrudModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(UserCrudModelImpl.ENTITY_CACHE_ENABLED,
			UserCrudModelImpl.FINDER_CACHE_ENABLED, UserCrudImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(UserCrudModelImpl.ENTITY_CACHE_ENABLED,
			UserCrudModelImpl.FINDER_CACHE_ENABLED, UserCrudImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			UserCrudModelImpl.UUID_COLUMN_BITMASK |
			UserCrudModelImpl.LASTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(UserCrudModelImpl.ENTITY_CACHE_ENABLED,
			UserCrudModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the user cruds where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user cruds
	 */
	@Override
	public List<UserCrud> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserCrud> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<UserCrud> findByUuid(String uuid, int start, int end,
		OrderByComparator<UserCrud> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<UserCrud> findByUuid(String uuid, int start, int end,
		OrderByComparator<UserCrud> orderByComparator, boolean retrieveFromCache) {
		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<UserCrud> list = null;

		if (retrieveFromCache) {
			list = (List<UserCrud>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserCrud userCrud : list) {
					if (!uuid.equals(userCrud.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_USERCRUD_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserCrudModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<UserCrud>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserCrud>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first user crud in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user crud
	 * @throws NoSuchUserCrudException if a matching user crud could not be found
	 */
	@Override
	public UserCrud findByUuid_First(String uuid,
		OrderByComparator<UserCrud> orderByComparator)
		throws NoSuchUserCrudException {
		UserCrud userCrud = fetchByUuid_First(uuid, orderByComparator);

		if (userCrud != null) {
			return userCrud;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchUserCrudException(msg.toString());
	}

	/**
	 * Returns the first user crud in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user crud, or <code>null</code> if a matching user crud could not be found
	 */
	@Override
	public UserCrud fetchByUuid_First(String uuid,
		OrderByComparator<UserCrud> orderByComparator) {
		List<UserCrud> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user crud in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user crud
	 * @throws NoSuchUserCrudException if a matching user crud could not be found
	 */
	@Override
	public UserCrud findByUuid_Last(String uuid,
		OrderByComparator<UserCrud> orderByComparator)
		throws NoSuchUserCrudException {
		UserCrud userCrud = fetchByUuid_Last(uuid, orderByComparator);

		if (userCrud != null) {
			return userCrud;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchUserCrudException(msg.toString());
	}

	/**
	 * Returns the last user crud in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user crud, or <code>null</code> if a matching user crud could not be found
	 */
	@Override
	public UserCrud fetchByUuid_Last(String uuid,
		OrderByComparator<UserCrud> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<UserCrud> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserCrud[] findByUuid_PrevAndNext(long userCrudId, String uuid,
		OrderByComparator<UserCrud> orderByComparator)
		throws NoSuchUserCrudException {
		uuid = Objects.toString(uuid, "");

		UserCrud userCrud = findByPrimaryKey(userCrudId);

		Session session = null;

		try {
			session = openSession();

			UserCrud[] array = new UserCrudImpl[3];

			array[0] = getByUuid_PrevAndNext(session, userCrud, uuid,
					orderByComparator, true);

			array[1] = userCrud;

			array[2] = getByUuid_PrevAndNext(session, userCrud, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserCrud getByUuid_PrevAndNext(Session session,
		UserCrud userCrud, String uuid,
		OrderByComparator<UserCrud> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERCRUD_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(UserCrudModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userCrud);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserCrud> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user cruds where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (UserCrud userCrud : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(userCrud);
		}
	}

	/**
	 * Returns the number of user cruds where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user cruds
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERCRUD_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "userCrud.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "userCrud.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(userCrud.uuid IS NULL OR userCrud.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(UserCrudModelImpl.ENTITY_CACHE_ENABLED,
			UserCrudModelImpl.FINDER_CACHE_ENABLED, UserCrudImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			UserCrudModelImpl.UUID_COLUMN_BITMASK |
			UserCrudModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(UserCrudModelImpl.ENTITY_CACHE_ENABLED,
			UserCrudModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the user crud where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchUserCrudException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user crud
	 * @throws NoSuchUserCrudException if a matching user crud could not be found
	 */
	@Override
	public UserCrud findByUUID_G(String uuid, long groupId)
		throws NoSuchUserCrudException {
		UserCrud userCrud = fetchByUUID_G(uuid, groupId);

		if (userCrud == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchUserCrudException(msg.toString());
		}

		return userCrud;
	}

	/**
	 * Returns the user crud where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user crud, or <code>null</code> if a matching user crud could not be found
	 */
	@Override
	public UserCrud fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the user crud where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching user crud, or <code>null</code> if a matching user crud could not be found
	 */
	@Override
	public UserCrud fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof UserCrud) {
			UserCrud userCrud = (UserCrud)result;

			if (!Objects.equals(uuid, userCrud.getUuid()) ||
					(groupId != userCrud.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_USERCRUD_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<UserCrud> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					UserCrud userCrud = list.get(0);

					result = userCrud;

					cacheResult(userCrud);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (UserCrud)result;
		}
	}

	/**
	 * Removes the user crud where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the user crud that was removed
	 */
	@Override
	public UserCrud removeByUUID_G(String uuid, long groupId)
		throws NoSuchUserCrudException {
		UserCrud userCrud = findByUUID_G(uuid, groupId);

		return remove(userCrud);
	}

	/**
	 * Returns the number of user cruds where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching user cruds
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERCRUD_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "userCrud.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "userCrud.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(userCrud.uuid IS NULL OR userCrud.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "userCrud.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(UserCrudModelImpl.ENTITY_CACHE_ENABLED,
			UserCrudModelImpl.FINDER_CACHE_ENABLED, UserCrudImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(UserCrudModelImpl.ENTITY_CACHE_ENABLED,
			UserCrudModelImpl.FINDER_CACHE_ENABLED, UserCrudImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			UserCrudModelImpl.UUID_COLUMN_BITMASK |
			UserCrudModelImpl.COMPANYID_COLUMN_BITMASK |
			UserCrudModelImpl.LASTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(UserCrudModelImpl.ENTITY_CACHE_ENABLED,
			UserCrudModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the user cruds where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching user cruds
	 */
	@Override
	public List<UserCrud> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserCrud> findByUuid_C(String uuid, long companyId, int start,
		int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<UserCrud> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<UserCrud> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<UserCrud> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<UserCrud> orderByComparator,
		boolean retrieveFromCache) {
		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<UserCrud> list = null;

		if (retrieveFromCache) {
			list = (List<UserCrud>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserCrud userCrud : list) {
					if (!uuid.equals(userCrud.getUuid()) ||
							(companyId != userCrud.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_USERCRUD_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserCrudModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<UserCrud>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserCrud>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public UserCrud findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<UserCrud> orderByComparator)
		throws NoSuchUserCrudException {
		UserCrud userCrud = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (userCrud != null) {
			return userCrud;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchUserCrudException(msg.toString());
	}

	/**
	 * Returns the first user crud in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user crud, or <code>null</code> if a matching user crud could not be found
	 */
	@Override
	public UserCrud fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<UserCrud> orderByComparator) {
		List<UserCrud> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserCrud findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<UserCrud> orderByComparator)
		throws NoSuchUserCrudException {
		UserCrud userCrud = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (userCrud != null) {
			return userCrud;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchUserCrudException(msg.toString());
	}

	/**
	 * Returns the last user crud in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user crud, or <code>null</code> if a matching user crud could not be found
	 */
	@Override
	public UserCrud fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<UserCrud> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<UserCrud> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserCrud[] findByUuid_C_PrevAndNext(long userCrudId, String uuid,
		long companyId, OrderByComparator<UserCrud> orderByComparator)
		throws NoSuchUserCrudException {
		uuid = Objects.toString(uuid, "");

		UserCrud userCrud = findByPrimaryKey(userCrudId);

		Session session = null;

		try {
			session = openSession();

			UserCrud[] array = new UserCrudImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, userCrud, uuid,
					companyId, orderByComparator, true);

			array[1] = userCrud;

			array[2] = getByUuid_C_PrevAndNext(session, userCrud, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserCrud getByUuid_C_PrevAndNext(Session session,
		UserCrud userCrud, String uuid, long companyId,
		OrderByComparator<UserCrud> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_USERCRUD_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(UserCrudModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userCrud);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserCrud> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user cruds where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (UserCrud userCrud : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userCrud);
		}
	}

	/**
	 * Returns the number of user cruds where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching user cruds
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERCRUD_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "userCrud.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "userCrud.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(userCrud.uuid IS NULL OR userCrud.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "userCrud.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(UserCrudModelImpl.ENTITY_CACHE_ENABLED,
			UserCrudModelImpl.FINDER_CACHE_ENABLED, UserCrudImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(UserCrudModelImpl.ENTITY_CACHE_ENABLED,
			UserCrudModelImpl.FINDER_CACHE_ENABLED, UserCrudImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			UserCrudModelImpl.GROUPID_COLUMN_BITMASK |
			UserCrudModelImpl.LASTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(UserCrudModelImpl.ENTITY_CACHE_ENABLED,
			UserCrudModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the user cruds where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching user cruds
	 */
	@Override
	public List<UserCrud> findByGroupId(long groupId) {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserCrud> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<UserCrud> findByGroupId(long groupId, int start, int end,
		OrderByComparator<UserCrud> orderByComparator) {
		return findByGroupId(groupId, start, end, orderByComparator, true);
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
	@Override
	public List<UserCrud> findByGroupId(long groupId, int start, int end,
		OrderByComparator<UserCrud> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<UserCrud> list = null;

		if (retrieveFromCache) {
			list = (List<UserCrud>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserCrud userCrud : list) {
					if ((groupId != userCrud.getGroupId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_USERCRUD_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserCrudModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<UserCrud>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserCrud>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first user crud in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user crud
	 * @throws NoSuchUserCrudException if a matching user crud could not be found
	 */
	@Override
	public UserCrud findByGroupId_First(long groupId,
		OrderByComparator<UserCrud> orderByComparator)
		throws NoSuchUserCrudException {
		UserCrud userCrud = fetchByGroupId_First(groupId, orderByComparator);

		if (userCrud != null) {
			return userCrud;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchUserCrudException(msg.toString());
	}

	/**
	 * Returns the first user crud in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user crud, or <code>null</code> if a matching user crud could not be found
	 */
	@Override
	public UserCrud fetchByGroupId_First(long groupId,
		OrderByComparator<UserCrud> orderByComparator) {
		List<UserCrud> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user crud in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user crud
	 * @throws NoSuchUserCrudException if a matching user crud could not be found
	 */
	@Override
	public UserCrud findByGroupId_Last(long groupId,
		OrderByComparator<UserCrud> orderByComparator)
		throws NoSuchUserCrudException {
		UserCrud userCrud = fetchByGroupId_Last(groupId, orderByComparator);

		if (userCrud != null) {
			return userCrud;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchUserCrudException(msg.toString());
	}

	/**
	 * Returns the last user crud in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user crud, or <code>null</code> if a matching user crud could not be found
	 */
	@Override
	public UserCrud fetchByGroupId_Last(long groupId,
		OrderByComparator<UserCrud> orderByComparator) {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<UserCrud> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserCrud[] findByGroupId_PrevAndNext(long userCrudId, long groupId,
		OrderByComparator<UserCrud> orderByComparator)
		throws NoSuchUserCrudException {
		UserCrud userCrud = findByPrimaryKey(userCrudId);

		Session session = null;

		try {
			session = openSession();

			UserCrud[] array = new UserCrudImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, userCrud, groupId,
					orderByComparator, true);

			array[1] = userCrud;

			array[2] = getByGroupId_PrevAndNext(session, userCrud, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserCrud getByGroupId_PrevAndNext(Session session,
		UserCrud userCrud, long groupId,
		OrderByComparator<UserCrud> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERCRUD_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(UserCrudModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userCrud);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserCrud> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user cruds where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (UserCrud userCrud : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(userCrud);
		}
	}

	/**
	 * Returns the number of user cruds where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching user cruds
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERCRUD_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "userCrud.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_UC = new FinderPath(UserCrudModelImpl.ENTITY_CACHE_ENABLED,
			UserCrudModelImpl.FINDER_CACHE_ENABLED, UserCrudImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_UC",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_UC = new FinderPath(UserCrudModelImpl.ENTITY_CACHE_ENABLED,
			UserCrudModelImpl.FINDER_CACHE_ENABLED, UserCrudImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_UC",
			new String[] { Long.class.getName(), Long.class.getName() },
			UserCrudModelImpl.GROUPID_COLUMN_BITMASK |
			UserCrudModelImpl.USERCRUDID_COLUMN_BITMASK |
			UserCrudModelImpl.LASTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_UC = new FinderPath(UserCrudModelImpl.ENTITY_CACHE_ENABLED,
			UserCrudModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_UC",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the user cruds where groupId = &#63; and userCrudId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userCrudId the user crud ID
	 * @return the matching user cruds
	 */
	@Override
	public List<UserCrud> findByG_UC(long groupId, long userCrudId) {
		return findByG_UC(groupId, userCrudId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserCrud> findByG_UC(long groupId, long userCrudId, int start,
		int end) {
		return findByG_UC(groupId, userCrudId, start, end, null);
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
	@Override
	public List<UserCrud> findByG_UC(long groupId, long userCrudId, int start,
		int end, OrderByComparator<UserCrud> orderByComparator) {
		return findByG_UC(groupId, userCrudId, start, end, orderByComparator,
			true);
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
	@Override
	public List<UserCrud> findByG_UC(long groupId, long userCrudId, int start,
		int end, OrderByComparator<UserCrud> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_UC;
			finderArgs = new Object[] { groupId, userCrudId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_UC;
			finderArgs = new Object[] {
					groupId, userCrudId,
					
					start, end, orderByComparator
				};
		}

		List<UserCrud> list = null;

		if (retrieveFromCache) {
			list = (List<UserCrud>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserCrud userCrud : list) {
					if ((groupId != userCrud.getGroupId()) ||
							(userCrudId != userCrud.getUserCrudId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_USERCRUD_WHERE);

			query.append(_FINDER_COLUMN_G_UC_GROUPID_2);

			query.append(_FINDER_COLUMN_G_UC_USERCRUDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserCrudModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userCrudId);

				if (!pagination) {
					list = (List<UserCrud>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserCrud>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public UserCrud findByG_UC_First(long groupId, long userCrudId,
		OrderByComparator<UserCrud> orderByComparator)
		throws NoSuchUserCrudException {
		UserCrud userCrud = fetchByG_UC_First(groupId, userCrudId,
				orderByComparator);

		if (userCrud != null) {
			return userCrud;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userCrudId=");
		msg.append(userCrudId);

		msg.append("}");

		throw new NoSuchUserCrudException(msg.toString());
	}

	/**
	 * Returns the first user crud in the ordered set where groupId = &#63; and userCrudId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userCrudId the user crud ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user crud, or <code>null</code> if a matching user crud could not be found
	 */
	@Override
	public UserCrud fetchByG_UC_First(long groupId, long userCrudId,
		OrderByComparator<UserCrud> orderByComparator) {
		List<UserCrud> list = findByG_UC(groupId, userCrudId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserCrud findByG_UC_Last(long groupId, long userCrudId,
		OrderByComparator<UserCrud> orderByComparator)
		throws NoSuchUserCrudException {
		UserCrud userCrud = fetchByG_UC_Last(groupId, userCrudId,
				orderByComparator);

		if (userCrud != null) {
			return userCrud;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userCrudId=");
		msg.append(userCrudId);

		msg.append("}");

		throw new NoSuchUserCrudException(msg.toString());
	}

	/**
	 * Returns the last user crud in the ordered set where groupId = &#63; and userCrudId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userCrudId the user crud ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user crud, or <code>null</code> if a matching user crud could not be found
	 */
	@Override
	public UserCrud fetchByG_UC_Last(long groupId, long userCrudId,
		OrderByComparator<UserCrud> orderByComparator) {
		int count = countByG_UC(groupId, userCrudId);

		if (count == 0) {
			return null;
		}

		List<UserCrud> list = findByG_UC(groupId, userCrudId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the user cruds where groupId = &#63; and userCrudId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userCrudId the user crud ID
	 */
	@Override
	public void removeByG_UC(long groupId, long userCrudId) {
		for (UserCrud userCrud : findByG_UC(groupId, userCrudId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userCrud);
		}
	}

	/**
	 * Returns the number of user cruds where groupId = &#63; and userCrudId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userCrudId the user crud ID
	 * @return the number of matching user cruds
	 */
	@Override
	public int countByG_UC(long groupId, long userCrudId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_UC;

		Object[] finderArgs = new Object[] { groupId, userCrudId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERCRUD_WHERE);

			query.append(_FINDER_COLUMN_G_UC_GROUPID_2);

			query.append(_FINDER_COLUMN_G_UC_USERCRUDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userCrudId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_UC_GROUPID_2 = "userCrud.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_UC_USERCRUDID_2 = "userCrud.userCrudId = ?";

	public UserCrudPersistenceImpl() {
		setModelClass(UserCrud.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the user crud in the entity cache if it is enabled.
	 *
	 * @param userCrud the user crud
	 */
	@Override
	public void cacheResult(UserCrud userCrud) {
		entityCache.putResult(UserCrudModelImpl.ENTITY_CACHE_ENABLED,
			UserCrudImpl.class, userCrud.getPrimaryKey(), userCrud);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { userCrud.getUuid(), userCrud.getGroupId() }, userCrud);

		userCrud.resetOriginalValues();
	}

	/**
	 * Caches the user cruds in the entity cache if it is enabled.
	 *
	 * @param userCruds the user cruds
	 */
	@Override
	public void cacheResult(List<UserCrud> userCruds) {
		for (UserCrud userCrud : userCruds) {
			if (entityCache.getResult(UserCrudModelImpl.ENTITY_CACHE_ENABLED,
						UserCrudImpl.class, userCrud.getPrimaryKey()) == null) {
				cacheResult(userCrud);
			}
			else {
				userCrud.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user cruds.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserCrudImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user crud.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserCrud userCrud) {
		entityCache.removeResult(UserCrudModelImpl.ENTITY_CACHE_ENABLED,
			UserCrudImpl.class, userCrud.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((UserCrudModelImpl)userCrud, true);
	}

	@Override
	public void clearCache(List<UserCrud> userCruds) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserCrud userCrud : userCruds) {
			entityCache.removeResult(UserCrudModelImpl.ENTITY_CACHE_ENABLED,
				UserCrudImpl.class, userCrud.getPrimaryKey());

			clearUniqueFindersCache((UserCrudModelImpl)userCrud, true);
		}
	}

	protected void cacheUniqueFindersCache(UserCrudModelImpl userCrudModelImpl) {
		Object[] args = new Object[] {
				userCrudModelImpl.getUuid(), userCrudModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
			userCrudModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		UserCrudModelImpl userCrudModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					userCrudModelImpl.getUuid(), userCrudModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((userCrudModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					userCrudModelImpl.getOriginalUuid(),
					userCrudModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new user crud with the primary key. Does not add the user crud to the database.
	 *
	 * @param userCrudId the primary key for the new user crud
	 * @return the new user crud
	 */
	@Override
	public UserCrud create(long userCrudId) {
		UserCrud userCrud = new UserCrudImpl();

		userCrud.setNew(true);
		userCrud.setPrimaryKey(userCrudId);

		String uuid = PortalUUIDUtil.generate();

		userCrud.setUuid(uuid);

		userCrud.setCompanyId(companyProvider.getCompanyId());

		return userCrud;
	}

	/**
	 * Removes the user crud with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userCrudId the primary key of the user crud
	 * @return the user crud that was removed
	 * @throws NoSuchUserCrudException if a user crud with the primary key could not be found
	 */
	@Override
	public UserCrud remove(long userCrudId) throws NoSuchUserCrudException {
		return remove((Serializable)userCrudId);
	}

	/**
	 * Removes the user crud with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user crud
	 * @return the user crud that was removed
	 * @throws NoSuchUserCrudException if a user crud with the primary key could not be found
	 */
	@Override
	public UserCrud remove(Serializable primaryKey)
		throws NoSuchUserCrudException {
		Session session = null;

		try {
			session = openSession();

			UserCrud userCrud = (UserCrud)session.get(UserCrudImpl.class,
					primaryKey);

			if (userCrud == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserCrudException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userCrud);
		}
		catch (NoSuchUserCrudException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected UserCrud removeImpl(UserCrud userCrud) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userCrud)) {
				userCrud = (UserCrud)session.get(UserCrudImpl.class,
						userCrud.getPrimaryKeyObj());
			}

			if (userCrud != null) {
				session.delete(userCrud);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userCrud != null) {
			clearCache(userCrud);
		}

		return userCrud;
	}

	@Override
	public UserCrud updateImpl(UserCrud userCrud) {
		boolean isNew = userCrud.isNew();

		if (!(userCrud instanceof UserCrudModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(userCrud.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(userCrud);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in userCrud proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UserCrud implementation " +
				userCrud.getClass());
		}

		UserCrudModelImpl userCrudModelImpl = (UserCrudModelImpl)userCrud;

		if (Validator.isNull(userCrud.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			userCrud.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (userCrud.isNew()) {
				session.save(userCrud);

				userCrud.setNew(false);
			}
			else {
				userCrud = (UserCrud)session.merge(userCrud);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!UserCrudModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { userCrudModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					userCrudModelImpl.getUuid(),
					userCrudModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] { userCrudModelImpl.getGroupId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
				args);

			args = new Object[] {
					userCrudModelImpl.getGroupId(),
					userCrudModelImpl.getUserCrudId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_G_UC, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_UC,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((userCrudModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { userCrudModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { userCrudModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((userCrudModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userCrudModelImpl.getOriginalUuid(),
						userCrudModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						userCrudModelImpl.getUuid(),
						userCrudModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((userCrudModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userCrudModelImpl.getOriginalGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { userCrudModelImpl.getGroupId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((userCrudModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_UC.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userCrudModelImpl.getOriginalGroupId(),
						userCrudModelImpl.getOriginalUserCrudId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_G_UC, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_UC,
					args);

				args = new Object[] {
						userCrudModelImpl.getGroupId(),
						userCrudModelImpl.getUserCrudId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_G_UC, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_UC,
					args);
			}
		}

		entityCache.putResult(UserCrudModelImpl.ENTITY_CACHE_ENABLED,
			UserCrudImpl.class, userCrud.getPrimaryKey(), userCrud, false);

		clearUniqueFindersCache(userCrudModelImpl, false);
		cacheUniqueFindersCache(userCrudModelImpl);

		userCrud.resetOriginalValues();

		return userCrud;
	}

	/**
	 * Returns the user crud with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user crud
	 * @return the user crud
	 * @throws NoSuchUserCrudException if a user crud with the primary key could not be found
	 */
	@Override
	public UserCrud findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserCrudException {
		UserCrud userCrud = fetchByPrimaryKey(primaryKey);

		if (userCrud == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserCrudException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userCrud;
	}

	/**
	 * Returns the user crud with the primary key or throws a {@link NoSuchUserCrudException} if it could not be found.
	 *
	 * @param userCrudId the primary key of the user crud
	 * @return the user crud
	 * @throws NoSuchUserCrudException if a user crud with the primary key could not be found
	 */
	@Override
	public UserCrud findByPrimaryKey(long userCrudId)
		throws NoSuchUserCrudException {
		return findByPrimaryKey((Serializable)userCrudId);
	}

	/**
	 * Returns the user crud with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user crud
	 * @return the user crud, or <code>null</code> if a user crud with the primary key could not be found
	 */
	@Override
	public UserCrud fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(UserCrudModelImpl.ENTITY_CACHE_ENABLED,
				UserCrudImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		UserCrud userCrud = (UserCrud)serializable;

		if (userCrud == null) {
			Session session = null;

			try {
				session = openSession();

				userCrud = (UserCrud)session.get(UserCrudImpl.class, primaryKey);

				if (userCrud != null) {
					cacheResult(userCrud);
				}
				else {
					entityCache.putResult(UserCrudModelImpl.ENTITY_CACHE_ENABLED,
						UserCrudImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(UserCrudModelImpl.ENTITY_CACHE_ENABLED,
					UserCrudImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userCrud;
	}

	/**
	 * Returns the user crud with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userCrudId the primary key of the user crud
	 * @return the user crud, or <code>null</code> if a user crud with the primary key could not be found
	 */
	@Override
	public UserCrud fetchByPrimaryKey(long userCrudId) {
		return fetchByPrimaryKey((Serializable)userCrudId);
	}

	@Override
	public Map<Serializable, UserCrud> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, UserCrud> map = new HashMap<Serializable, UserCrud>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			UserCrud userCrud = fetchByPrimaryKey(primaryKey);

			if (userCrud != null) {
				map.put(primaryKey, userCrud);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(UserCrudModelImpl.ENTITY_CACHE_ENABLED,
					UserCrudImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (UserCrud)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_USERCRUD_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (UserCrud userCrud : (List<UserCrud>)q.list()) {
				map.put(userCrud.getPrimaryKeyObj(), userCrud);

				cacheResult(userCrud);

				uncachedPrimaryKeys.remove(userCrud.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(UserCrudModelImpl.ENTITY_CACHE_ENABLED,
					UserCrudImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the user cruds.
	 *
	 * @return the user cruds
	 */
	@Override
	public List<UserCrud> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserCrud> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<UserCrud> findAll(int start, int end,
		OrderByComparator<UserCrud> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<UserCrud> findAll(int start, int end,
		OrderByComparator<UserCrud> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<UserCrud> list = null;

		if (retrieveFromCache) {
			list = (List<UserCrud>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_USERCRUD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERCRUD;

				if (pagination) {
					sql = sql.concat(UserCrudModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserCrud>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserCrud>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the user cruds from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserCrud userCrud : findAll()) {
			remove(userCrud);
		}
	}

	/**
	 * Returns the number of user cruds.
	 *
	 * @return the number of user cruds
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERCRUD);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UserCrudModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user crud persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(UserCrudImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_USERCRUD = "SELECT userCrud FROM UserCrud userCrud";
	private static final String _SQL_SELECT_USERCRUD_WHERE_PKS_IN = "SELECT userCrud FROM UserCrud userCrud WHERE userCrudId IN (";
	private static final String _SQL_SELECT_USERCRUD_WHERE = "SELECT userCrud FROM UserCrud userCrud WHERE ";
	private static final String _SQL_COUNT_USERCRUD = "SELECT COUNT(userCrud) FROM UserCrud userCrud";
	private static final String _SQL_COUNT_USERCRUD_WHERE = "SELECT COUNT(userCrud) FROM UserCrud userCrud WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userCrud.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserCrud exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserCrud exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(UserCrudPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}