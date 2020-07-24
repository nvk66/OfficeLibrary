<html>
<head>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
    <%@include file="boot.jsp" %>
    <%@include file="navigation.jsp" %>
<%--    <title><tiles:getAsString name="title" /></title>--%>
    <title>Welocome!</title>
</head>
<body>
<div align="center">
<div class="container">
    <div class="starter-template">
        <h1>Welcome to the E-library</h1>
    </div>
    <security:authorize access="!hasAnyAuthority('User', 'Admin')">
        <a href="/login"><button type="button" class="btn btn-outline-primary">Login</button></a>
        <a href="/registration"><button type="button" class="btn btn-outline-warning">Registration</button></a>
    </security:authorize>
    <security:authorize access="hasAnyAuthority('User', 'Admin')">
        <a href="/logout"><button type="button" class="btn btn-outline-primary">Logout</button></a>
    </security:authorize>
</div>
    <p></p>
    <p></p>
    <p></p>
<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <img src="/images/cookie1.jpg">
</div>
</body>
</html>
