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

package com.liferay.exam.usercrud.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import com.liferay.exam.usercrud.exception.InvalidBirthdateException;
import com.liferay.exam.usercrud.exception.InvalidEmailException;
import com.liferay.exam.usercrud.exception.InvalidFirstNameException;
import com.liferay.exam.usercrud.model.UserCrud;
import com.liferay.exam.usercrud.service.base.UserCrudLocalServiceBaseImpl;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

/**
 * The implementation of the user crud local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.exam.usercrud.service.UserCrudLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserCrudLocalServiceBaseImpl
 * @see com.liferay.exam.usercrud.service.UserCrudLocalServiceUtil
 */
public class UserCrudLocalServiceImpl extends UserCrudLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.exam.usercrud.service.UserCrudLocalServiceUtil} to access the user crud local service.
	 */
	private static Log _log = LogFactoryUtil.getLog(UserCrudLocalServiceImpl.class);

	
	

public UserCrud addUser (long userId, String firstName, String lastName, String birthDate, String email,ServiceContext serviceContext) throws PortalException {
		
		long groupId = serviceContext.getScopeGroupId();

	    User user = userLocalService.getUserById(userId);

	    Date createDate = new Date();
	    
	    validate(firstName,lastName,birthDate,email);
	    long userCrudiId = counterLocalService.increment();
	    
	   
	    UserCrud userCrud = userCrudPersistence.create(userCrudiId);
	    userCrud.setUserUuid(serviceContext.getUuid());
	    userCrud.setFirstName(firstName);
	    userCrud.setLastName(lastName);
	    userCrud.setBirthDate(toDate(birthDate));
	    userCrud.setEmail(email);
	    
	    userCrud.setUserId(userId);
	    userCrud.setUserName(user.getFullName());
	    userCrud.setGroupId(groupId);
	    userCrud.setCompanyId(user.getCompanyId());
	    userCrud.setCreateDate(serviceContext.getCreateDate(createDate));
	    
	    userCrud.setExpandoBridgeAttributes(serviceContext);

	    userCrudPersistence.update(userCrud);

	    if(_log.isInfoEnabled()) {
	    	_log.info("the user was created..."+userCrud.toString());
	    }
	    sendMail(userCrud.getEmail());
	    return userCrud;
	    
	}
	
/**
 * method to send mail for creating acount
 * @param email user form email
 */
private void sendMail(String email) {
	InternetAddress fromAddress = null;
	InternetAddress toAddress = null;

	try {
    		fromAddress = new InternetAddress("admin@gmail.com");
    		toAddress = new InternetAddress(email);
    		MailMessage mailMessage = new MailMessage();
    		mailMessage.setTo(toAddress);
    		mailMessage.setFrom(fromAddress);
    		mailMessage.setSubject("Account created");
    		mailMessage.setBody("The account was created ...");
    		MailServiceUtil.sendEmail(mailMessage);
    		if(_log.isInfoEnabled()) {
    			_log.info("Send mail to :"+email);
    		}
    		
	} catch (AddressException e) {
	    	_log.error("error to send mail to: "+email,e);
	}
}
	/**
	 * method to transform text to date 
	 * @param dateToParse
	 * @return
	 * @throws PortalException
	 */
	private Date toDate(String dateToParse) throws PortalException {
	
		Date date =null;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd", Locale.US);
			 date = formatter.parse(dateToParse);
		}catch (ParseException e) {
			throw new InvalidBirthdateException("error to parse birthdate");
		}
		
		return date;
	}
	
	/**
	 * method to validate user form params
	 * @param firstName
	 * @param lastName
	 * @param birthDate
	 * @param email
	 * @throws PortalException 
	 */
	protected void validate(String firstName, String lastName, String birthDate, String email)
		    throws PortalException {

		     
		    if (Validator.isNull(firstName) || !Validator.isName(firstName)) {
		        throw new InvalidFirstNameException("the firstname can not be null or contain special characters ");
		    }

		    if (Validator.isNull(lastName) || !Validator.isName(lastName)) {
		        throw new InvalidFirstNameException("the firstname can not be null or contain special characters ");
		    }
		    if (!Validator.isEmailAddress(email)) {
		        throw new InvalidEmailException("The email is invalid");
		    }

		    if (Validator.isNull(birthDate)) {
		        throw new InvalidBirthdateException("the birthdate is invalid");
		    }
		}
	
	
}