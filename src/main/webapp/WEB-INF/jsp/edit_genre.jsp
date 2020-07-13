<%--
  Created by IntelliJ IDEA.
  User: alexey
  Date: 08.07.2020
  Time: 08:56
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
    <title>Edit Genre</title>
</head>
<body>
<div align="center">
    <h2>Edit Genre</h2>
    <form:form action="save" method="post" modelAttribute="genres">
        <table border="0" cellpadding="5">
            <tr>
                <td>ID: </td>
                <td>${genres.genreId}
                    <form:hidden path="genreId"/>
                </td>
            </tr>
            <tr>
                <td>Name: </td>
                <td><form:input path="genreName" /></td>
            </tr>
            <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
