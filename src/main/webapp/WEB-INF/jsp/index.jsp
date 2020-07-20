
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
    <%@include file="boot.jsp" %>
    <%@include file="navigation.jsp" %>
</head>
<body>
<div align="center">
<div class="container">
    <div class="starter-template">
        <h1>Welcome to the E-library</h1>
    </div>
    <a href="/login"><button type="button" class="btn btn-outline-primary">Login</button></a>
    <a href="/registration"><button type="button" class="btn btn-outline-warning">Registration</button></a>
</div>
<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</div>
</body>
</html>
