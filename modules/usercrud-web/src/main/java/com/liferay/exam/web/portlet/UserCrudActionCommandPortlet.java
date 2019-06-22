package com.liferay.exam.web.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.exam.usercrud.model.UserCrud;
import com.liferay.exam.usercrud.service.UserCrudLocalService;
import com.liferay.exam.web.constants.UserCrudPortletKeys;
import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

@Component(
	    immediate = true,
	    property = {
	    		"javax.portlet.name=" + UserCrudPortletKeys.UserCrud,
	            "mvc.command.name=addUser"
	    },
	    service = MVCActionCommand.class
)
public class UserCrudActionCommandPortlet extends BaseMVCActionCommand{

	private static Log _log = LogFactoryUtil.getLog(UserCrudActionCommandPortlet.class);
	
private UserCrudLocalService _userCrudLocalService;
	
	@Reference(unbind = "-")
	protected void setUserCrudService(UserCrudLocalService userCrudLocalService) {
		_userCrudLocalService = userCrudLocalService;
	}
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String firstName = ParamUtil.getString(actionRequest, "firstname");
		 String lastName = ParamUtil.getString(actionRequest, "lastname");
		 String birthDate = ParamUtil.getString(actionRequest, "birthdate");
		 String email = ParamUtil.getString(actionRequest, "email");
		 
		 try {
			 CaptchaUtil.check(actionRequest);
			 ServiceContext serviceContext = ServiceContextFactory.getInstance(
			            UserCrud.class.getName(), actionRequest);
			_userCrudLocalService.addUser(serviceContext.getUserId(), firstName, lastName, birthDate, email, serviceContext);
			
		   } catch (CaptchaTextException cte) {
			_log.error(cte);
				SessionErrors.add(
				actionRequest, CaptchaTextException.class.getName());
				setRenderParameter(actionResponse, firstName, lastName, birthDate, email);
				
           
           }catch (PortalException e) {
			_log.error("an error has occurred");
			 SessionErrors.add(actionRequest, e.getClass().getName());
			 setRenderParameter(actionResponse, firstName, lastName, birthDate, email);
		}
		
	}

	private void setRenderParameter(ActionResponse actionResponse, String firstName, String lastName, String birthDate,
			String email) {
		actionResponse.setRenderParameter("url", "add_user.jsp");
		actionResponse.setRenderParameter("firstName", firstName);
		actionResponse.setRenderParameter("lastName", lastName);
		actionResponse.setRenderParameter("birthDate", birthDate);
		actionResponse.setRenderParameter("email", email);
	}

}
