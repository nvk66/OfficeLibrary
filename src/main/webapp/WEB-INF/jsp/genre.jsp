<%--
  Created by IntelliJ IDEA.
  User: alexey
  Date: 08.07.2020
  Time: 08:56
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Genre</title>
    <%@include file="boot.jsp" %>
</head>
<body>
<div align="center">
    <%@include file="navigation.jsp"%>
    <h2>Genre</h2>
    <form method="get" action="search">
        <input type="text" name="keyword" />
        <input type="submit" value="Search" />
    </form>
    <h3><a href="/genre/new">New Genre</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Action</th>
        </tr>
        <%--        <jsp:useBean id="listBook" scope="request" type="java.util.List"/>--%>
        <c:forEach items="${listGenre}" var="genre">
            <tr>
                <td>${genre.genreId}</td>
                <td>${genre.genreName}</td>
                <td>
                    <a href="/genre/edit?id=${genre.genreId}">Edit</a>

                    <a href="/genre/delete?id=${genre.genreId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

