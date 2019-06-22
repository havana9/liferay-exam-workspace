package com.liferay.exam.web.portlet;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.exam.usercrud.model.UserCrud;
import com.liferay.exam.usercrud.service.UserCrudLocalService;
import com.liferay.exam.web.constants.UserCrudPortletKeys;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;

@Component(immediate = true,
property = {
	    	"javax.portlet.name=" + UserCrudPortletKeys.UserCrud,
            "mvc.command.name=/",
            "mvc.command.name=/view"
}, service = MVCRenderCommand.class)
public class UserCrudRenderCommandPortlet implements MVCRenderCommand {

	private UserCrudLocalService _userCrudLocalService;
	
	@Reference(unbind = "-")
	protected void setUserCrudService(UserCrudLocalService userCrudLocalService) {
		_userCrudLocalService = userCrudLocalService;
	}
	
	private static Log _log = LogFactoryUtil.getLog(UserCrudRenderCommandPortlet.class);
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		if(!SessionErrors.isEmpty(renderRequest)) {
			if(_log.isDebugEnabled()){
				_log.debug("session error present");
			}
			String firstName =renderRequest.getParameter("firstName");
			String lastName =renderRequest.getParameter("lastName");
			String birthDate =renderRequest.getParameter("birthDate");
			String email =renderRequest.getParameter("email");
			renderRequest.setAttribute("firstName", firstName);
			renderRequest.setAttribute("lastName", lastName);
			renderRequest.setAttribute("birthDate", birthDate);
			renderRequest.setAttribute("email", email);
			return "/add-user.jsp";
		}
		
		List<UserCrud>_userList = _userCrudLocalService.getUserCruds(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		renderRequest.setAttribute("userList",_userList);
		renderRequest.setAttribute("total", _userList.size());
		return "/view.jsp";
	}

}
