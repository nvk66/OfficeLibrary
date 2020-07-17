<%--
  Created by IntelliJ IDEA.
  User: alexey
  Date: 08.07.2020
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User</title>
    <%@include file="boot.jsp" %>

</head>
<body>
<div align="center">
    <%@include file="navigation.jsp"%>

    <h2>User</h2>
    <form method="get" action="search">
        <input type="text" name="keyword" />
        <input type="submit" value="Search" />
    </form>
    <h3><a href="/user/new/">New User</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>LastName</th>
            <th>Name</th>
            <th>PatronymicName</th>
            <th>BirthDate</th>
            <th>Role</th>
            <th>Actions</th>
        </tr>
        <%--        <jsp:useBean id="listBook" scope="request" type="java.util.List"/>--%>
        <c:forEach items="${listUser}" var="user">
            <tr>
                <td>${user.userId}</td>
                <td>${user.lastName}</td>
                <td>${user.name}</td>
                <td>${user.patronymicName}</td>
                <td>${user.birthDate}</td>
                <td>
                    <c:forEach items="${user.role}" var="roles">
                        <p>${roles.roleName}</p>
                    </c:forEach>
                </td>
                <td>
                    <a href="/user/edit?id=${user.userId}">Edit</a>

                    <a href="/user/delete?id=${user.userId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
