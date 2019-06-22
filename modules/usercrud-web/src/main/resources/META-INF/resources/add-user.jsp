<%@ include file="init.jsp" %>

<portlet:renderURL var="viewUsersURL">
    <portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="addUser" var="addUserURL"></portlet:actionURL>

<portlet:resourceURL id="/reloadCaptcha"   var="captchaURL"/>

<aui:form action="${addUserURL}">
<aui:fieldset>
      <aui:input name="firstname" label="Firstname:" value="${firstName}">
        <aui:validator name="required" />
         <aui:validator name="alpha" />
         <aui:validator name="max">50</aui:validator>
      </aui:input>
      <aui:input name="lastname" label="Lastname:" value="${lastName}" >
         <aui:validator name="required" />
          <aui:validator name="alpha" />
          <aui:validator name="max">50</aui:validator>
      </aui:input>
      <aui:input name="birthdate" label="Birthdate(YYYY/MM/dd):" value="${birthDate}">
         <aui:validator name="required" />
          <aui:validator name="date" />
      </aui:input>
      <aui:input name="email" label="Email:" value="${email}" >
         <aui:validator name="required" />
         <aui:validator name="max">75</aui:validator>
         <aui:validator name="email" />

        <aui:validator errorMessage="Please enter a correct format for email." 
        name="custom">
                function(val, fieldNode, ruleValue) {
                        var regex = new RegExp(/^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/);

                        return regex.test(val);
                }
        </aui:validator>
      </aui:input>
      
      <liferay-captcha:captcha url="<%=captchaURL%>" />
</aui:fieldset>   
   
            <aui:button type="submit"></aui:button>
            <aui:button type="cancel" onClick="<%=viewUsersURL.toString() %>"></aui:button>
            
</aui:form>