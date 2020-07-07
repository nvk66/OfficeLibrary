<%--
  Created by IntelliJ IDEA.
  User: alexey
  Date: 07.07.2020
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Edit Customer</title>
</head>
<body>
<div align="center">
    <h2>Edit Customer</h2>
    <form:form action="save" method="post" modelAttribute="user">
        <table border="0" cellpadding="5">
            <tr>
                <td>ID: </td>
                <td>${user.userId}
                    <form:hidden path="userId"/>
                </td>
            </tr>
            <tr>
                <td>LastName: </td>
                <td><form:input path="lastName" /></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>PatronymicName: </td>
                <td><form:input path="patronymicName" /></td>
            </tr>
            <tr>
                <td>BirthDate: </td>
                <td><form:input path="birthDate" /></td>
            </tr>
            <tr>
                <td>Role: </td>
                <td><form:input path="roleId" /></td>
            </tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
