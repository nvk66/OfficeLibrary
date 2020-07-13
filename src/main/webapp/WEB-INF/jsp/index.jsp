<%--
  Created by IntelliJ IDEA.
  User: alexey
  Date: 08.07.2020
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Welcome</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div align="center">--%>
<%--    <a href="/user">User</a>--%>
<%--    <a href="/genre">Genre</a>--%>
<%--    <a href="/book">Book</a>--%>
<%--    <a href="/author">Author</a>--%>
<%--    <a href="/history">History</a>--%>
<%--    <h1>Welcome to the E-library</h1>--%>
<%--</div>--%>

<%--</body>--%>
<%--</html>--%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

</head>
<body>
<div align="center">
<nav class="navbar navbar-inverse">
    <div class="container">
        <div id="navbar" class="collapse navbar-collapse">
                <a href="/#about">MainPage</a>
                <a href="/user">User</a>
                <a href="/genre">Genre</a>
                <a href="/book">Book</a>
                <a href="/author">Author</a>
                <a href="/history">History</a>
        </div>
    </div>
</nav>

<div class="container">

    <div class="starter-template">
        <h1>Welcome to the E-library</h1>
    </div>

</div>
<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</div>
</body>
</html>
