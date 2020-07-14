<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Book</title>
</head>
<body>
<div align="center">
    <h2>Book Details</h2>
    <div>
        <form:form action="" method="post" modelAttribute="author">
            <table border="0" cellpadding="5">
                <tr>
                    <td>ID: </td>
                    <td>${author.authorId}
                        <form:hidden path="authorId"/>
                    </td>
                </tr>
                <tr>
                    <td>LastName: </td>
                    <td>${author.lastName}
                        <form:hidden path="lastName" /></td>
                </tr>
                <tr>
                    <td>Name: </td>
                    <td>${author.name}
                        <form:hidden path="name" /></td>
                </tr>
                <tr>
                    <td>PatronymicName: </td>
                    <td>${author.patronymicName}
                        <form:hidden path="patronymicName" /></td>
                </tr>
                <tr>
                    <td>PatronymicName: </td>
                    <td>${author.birthYear}
                        <form:hidden path="birthYear" /></td>
                </tr>
                <tr>
                    <td>Biography: </td>
                    <td>${author.biography}
                        <form:hidden path="biography" /></td>
                </tr>
                <td colspan="2"><input type="submit" value="Reserve"></td>
                <td colspan="2"><input type="button" value="Edit"></td>
                <td colspan="2"><input type="button" value="Delete"></td>
                </tr>
            </table>
        </form:form>
    </div>
</div>

</body>
</html>
