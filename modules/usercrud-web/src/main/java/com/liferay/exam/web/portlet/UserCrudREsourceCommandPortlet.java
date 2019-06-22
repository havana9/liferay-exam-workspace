package com.liferay.exam.web.portlet;


import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.exam.web.constants.UserCrudPortletKeys;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;

@Component(
	    immediate = true,
	    property = {
	    		"javax.portlet.name=" + UserCrudPortletKeys.UserCrud,
	            "mvc.command.name=/reloadCaptcha"
	    },
	    service = MVCResourceCommand.class
)
public class UserCrudREsourceCommandPortlet implements MVCResourceCommand{

	@Override
    public boolean serveResource(
        ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
        
        try {
            CaptchaUtil.serveImage(resourceRequest, resourceResponse);
            return false;
        }
        catch (Exception e) {
          
            
            return true;
        }
    }

	

	
}
