<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Edit Employee</h1>
<form:form method="POST" action="/SpringMVCCRUDSimple/editsave">
    <table>
        <tr>
            <td></td>
            <td><form:hidden path="id"/></td>
        </tr>
        <tr>
            <td>Full Name :</td>
            <td><form:input path="fullName"/></td>
        </tr>
        <tr>
            <td>Date :</td>
            <td><form:input path="date"/></td>
        </tr>
        <tr>
            <td>INN :</td>
            <td><form:input path="inn"/></td>
        </tr>
        <tr>
            <td>Family Status :</td>
            <td><form:input path="familyStatus"/></td>
        </tr>
        <tr>
            <td>Education :</td>
            <td><form:input path="education"/></td>
        </tr>
        <tr>
            <td>Status :</td>
            <td><form:input path="status"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Edit Save"/></td>
        </tr>
    </table>
</form:form>
