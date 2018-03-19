<%--
  Created by IntelliJ IDEA.
  User: rajim
  Date: 3/19/18
  Time: 5:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
<table border=1>
    <thead>
    <tr>
        <th>User Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>DOB</th>
        <th>Email</th>
        <th colspan=2>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.id}" /></td>
            <td><c:out value="${user.first_name}" /></td>
            <td><c:out value="${user.last_name}" /></td>
            <td><c:out value="${user.dob}" /></td>
            <td><c:out value="${user.email}" /></td>
            <td><a href="UserController?action=edit&userId=<c:out value="${user.id}"/>">Update</a></td>
            <td><a href="UserController?action=delete&userId=<c:out value="${user.id}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="userController?action=insert">Add User</a></p>
</body>
</html>
