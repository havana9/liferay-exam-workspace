<%@ include file="/init.jsp" %>


<portlet:renderURL var="addUserURL">
    <portlet:param name="mvcPath" value="/add-user.jsp"></portlet:param>
</portlet:renderURL>



<aui:button-row>
    <aui:button value="Add User" onClick="<%= addUserURL.toString() %>"></aui:button>
</aui:button-row>


<liferay-ui:search-container total="${total}">
<liferay-ui:search-container-results
    results="${userList}" />

<liferay-ui:search-container-row
    className="com.liferay.exam.usercrud.model.UserCrud" modelVar="userCrud">

    <liferay-ui:search-container-column-text property="firstName" />
    <liferay-ui:search-container-column-text property="lastName" />
   <liferay-ui:search-container-column-text name="Date ">
   <fmt:formatDate value="<%= userCrud.getBirthDate() %>"
    pattern="dd/MM/yyyy" />
  </liferay-ui:search-container-column-text>

    <liferay-ui:search-container-column-text property="email" />


</liferay-ui:search-container-row>

<liferay-ui:search-iterator />

</liferay-ui:search-container>
