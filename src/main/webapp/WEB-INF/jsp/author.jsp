<%--
  Created by IntelliJ IDEA.
  User: alexey
  Date: 07.07.2020
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Authors</title>
</head>
<body>
<div align="center">
    <h2>Authors</h2>
    <form method="get" action="search">
        <input type="text" name="keyword" />
        <input type="submit" value="Search" />
    </form>
    <h3><a href="/author/new">New Author</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>LastName</th>
            <th>Name</th>
            <th>PatronymicName</th>
            <th>BirthYear</th>
            <th>Biography</th>
            <th>Action</th>
        </tr>
        <%--        <jsp:useBean id="listBook" scope="request" type="java.util.List"/>--%>
        <c:forEach items="${listAuthor}" var="author">
            <tr>
                <td>${author.authorID}</td>
                <td>${author.lastName}</td>
                <td>${author.name}</td>
                <td>${author.patronymicName}</td>
                <td>${author.birthYear}</td>
                <td>${author.biography}</td>
                <td>
                    <a href="/edit?id=${author.authorID}">Edit</a>

                    <a href="/delete?id=${author.authorID}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
