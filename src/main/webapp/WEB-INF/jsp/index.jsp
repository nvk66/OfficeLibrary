<%--
  Created by IntelliJ IDEA.
  User: alexey
  Date: 06.07.2020
  Time: 09:29
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Manager</title>
</head>
<body>
<div align="center">
    <h2>User Manager</h2>
    <form method="get" action="search">
        <input type="text" name="keyword" />
        <input type="submit" value="Search" />
    </form>
    <h3><a href="/new">New User</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>LastName</th>
            <th>Name</th>
            <th>PatronymicName</th>
            <th>BirthDate</th>
<%--            <th>UserType</th>--%>
            <th>Action</th>
        </tr>
<%--        <c:forEach items="${listUser}" var="user">--%>
            <tr th:each="user : ${listUser}">
<%--                <td th:text=${user.userId}>${user.userId}</td>--%>
<%--                <td th:text=${user.lastName}>${user.lastName}</td>--%>
<%--                <td th:text=${user.name}>${user.name}</td>--%>
<%--                <td th:text=${user.patronymicName}>${user.patronymicName}</td>--%>
<%--                <td th:text=${user.birthDate}>${user.birthDate}</td>--%>
                <td th:text=${user.userId}></td>
                <td th:text=${user.lastName}></td>
                <td th:text=${user.name}></td>
                <td th:text=${user.patronymicName}></td>
                <td th:text=${user.birthDate}></td>
<%--                <td>${user.usertype}</td>--%>
                <td>
                    <a href="/edit?id=${user.userID}">Edit</a>
                    <a href="/delete?id=${user.userID}">Delete</a>
                </td>
            </tr>
<%--        </c:forEach>--%>
    </table>
</div>
</body>
</html>
<%--<!DOCTYPE html>--%>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<%--<%@ page contentType="text/html; charset=UTF-8" %>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <!-- Подключаем bootstrap CSS,--%>
<%--        Spring boot автоматически замапит ресурс благодаря зависимости webjars в pom.xml -->--%>
<%--    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />--%>
<%--    <!----%>
<%--	<spring:url value="/css/main.css" var="springCss" />--%>
<%--	<link href="${springCss}" rel="stylesheet" />--%>
<%--	 -->--%>
<%--    <c:url value="/css/main.css" var="jstlCss" />--%>
<%--    <link href="${jstlCss}" rel="stylesheet" />--%>
<%--</head>--%>
<%--<body>--%>

<%--<nav class="navbar navbar-inverse">--%>
<%--    <div class="container">--%>
<%--        <div class="navbar-header">--%>
<%--            <a class="navbar-brand" href="#">Spring Boot JSP</a>--%>
<%--        </div>--%>
<%--        <div id="navbar" class="collapse navbar-collapse">--%>
<%--            <ul class="nav navbar-nav">--%>
<%--                <li class="active"><a href="#">Главная</a></li>--%>
<%--                <li><a href="#about">Обо мне</a></li>--%>
<%--            </ul>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</nav>--%>

<%--<div class="container">--%>

<%--    <div class="starter-template">--%>
<%--        <h1>Пример Spring Boot Web JSP</h1>--%>
<%--        <h2>Сообщение: ${message}</h2>--%>
<%--    </div>--%>

<%--</div>--%>
<%--<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
<%--</body>--%>
<%--</html>--%>
