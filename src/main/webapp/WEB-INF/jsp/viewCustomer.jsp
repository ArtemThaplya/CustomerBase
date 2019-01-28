<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Employees List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr>
        <th>Id</th>
        <th>Full Name</th>
        <th>Date</th>
        <th>INN</th>
        <th>Family Status</th>
        <th>Education</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="emp" items="${list}">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.fullName}</td>
            <td>${emp.date}</td>
            <td>${emp.inn}</td>
            <td>${emp.familyStatus}</td>
            <td>${emp.education}</td>
            <td>${emp.status}</td>
            <td><a href="editCustomer/${emp.id}">Edit</a></td>
            <td><a href="deleteCustomer/${emp.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="customerForm">Add New Employee</a>