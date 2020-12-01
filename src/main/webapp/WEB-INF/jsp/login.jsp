<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Login</title>--%>
<%--    <%@include file="boot.jsp" %>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div align="center">--%>
<%--<h2>Login</h2>--%>
<%--<form name='f' action="login" method='POST'>--%>
<%--    <table>--%>
<%--        <tr>--%>
<%--            <td>User:</td>--%>
<%--            <td><input type='text' name='username' value=''></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Password:</td>--%>
<%--            <td><input type='password' name='password'/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td><input name="submit" type="submit" value="submit"/></td>--%>
<%--        </tr>--%>
<%--    </table>--%>
<%--</form>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>
<%--






--%>
<html xmlns:th="http://www.thymeleaf.org">
<head th:include="layout :: head(title=~{::title},links=~{})">
    <title>Login</title>
    <%@include file="boot.jsp" %>
</head>
<body th:include="layout :: body" th:with="content=~{::content}">
<div align="center">
    <div th:fragment="content">
        <form name="f" th:action="@{/login}" method="post">
            <fieldset>
                <legend>Please Login</legend>
                <%--                <div th:if="${param.error}" class="alert alert-error">--%>
                <%--                    Invalid username and password.--%>
                <%--                </div>--%>
                <%--                <div th:if="${param.logout}}" class="alert alert-success">--%>
                <%--                    You have been logged out.--%>
                <%--                </div>--%>
                <label for="username">Username</label>
                <input type="text" id="username" name="username"/>
                <label for="password">Password</label>
                <input type="password" id="password" name="password"/>
                <div class="form-actions">
                    <button type="submit" class="btn">Log in</button>
                </div>
            </fieldset>
        </form>
    </div>
</div>
</body>
</html>

<%--





--%>

<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<%--<html>--%>
<%--<body onload='document.loginForm.username.focus();'>--%>
<%--<h1>Spring Security 5 - Login Form</h1>--%>

<%--<c:if test="${not empty errorMessge}"><div style="color:red; font-weight: bold; margin: 30px 0px;">${errorMessge}</div></c:if>--%>

<%--<form name='login' action="/login" method='POST'>--%>
<%--    <table>--%>
<%--        <tr>--%>
<%--            <td>UserName:</td>--%>
<%--            <td><input type='text' name='username' value=''></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Password:</td>--%>
<%--            <td><input type='password' name='password' /></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td colspan='2'><input name="submit" type="submit" value="submit" /></td>--%>
<%--        </tr>--%>
<%--    </table>--%>
<%--    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>