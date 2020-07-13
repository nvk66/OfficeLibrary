<%--
  Created by IntelliJ IDEA.
  User: alexey
  Date: 07.07.2020
  Time: 19:46
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
    <title>New Author</title>
</head>
<body>
<div align="center">
    <h2><a href="/author">Book</a></h2>
    <h2>New Author</h2>
    <form:form action="save" method="post" modelAttribute="author">
        <table border="0" cellpadding="5">
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
                <td>BirthYear: </td>
                <td><form:input path="birthYear" /></td>
            </tr>
            <tr>
                <td>Biography: </td>
                <td><form:textarea path="biography" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>