<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New/Edit User</title>
</head>
<body>
<div align="center">
    <h2><a href="/user">Users</a></h2>
    <h1>New/Edit User</h1>
    <form:form action="save" method="post" modelAttribute="user">
        <table>
            <form:hidden path="userId"/>
            <tr>
                <td>LastName:</td>
                <td><form:input path="lastName" /></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>PatronymicName:</td>
                <td><form:input path="patronymicName" /></td>
            </tr>
            <tr>
                <td>BirthDate:</td>
                <td><form:input path="birthDate" /></td>
            </tr>
            <tr>
                <td>Role:</td>
                <td><form:input path="role" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
