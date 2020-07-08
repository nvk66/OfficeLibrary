<%--
  Created by IntelliJ IDEA.
  User: alexey
  Date: 07.07.2020
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Search Result</title>
</head>
<body>
<div align="center">
    <h2>Search Result</h2>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>LastName</th>
            <th>Name</th>
            <th>PatronymicName</th>
            <th>BirthDate</th>
            <th>Role</th>
        </tr>
        <c:forEach items="${result}" var="user">
            <tr>
                <td>${user.userId}</td>
                <td>${user.lastName}</td>
                <td>${user.name}</td>
                <td>${user.patronymicName}</td>
                <td>${user.birthDate}</td>
                <td>${user.role.role}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
