<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@include file="/WEB-INF/jsp/boot.jsp" %>
<div style="position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 60px;
            background-color: lightcyan">
    <div align="center" style="margin-top: 10px">
        <security:authorize access="hasAnyAuthority('User','Admin')">
            <a href="/#about">MainPage</a>
            <a href="/genre">Genre</a>
            <a href="/book/">Book</a>
            <a href="/author/">Author</a>
        </security:authorize>
        <security:authorize access="hasAnyAuthority('Admin')">
            <a href="/history/">History</a>
            <a href="/user/">User</a>
        </security:authorize>
    </div>
    <div align="right">
        <security:authorize access="!hasAnyAuthority('User', 'Admin')">
            <a href="/login">
                <button type="button" class="btn btn-outline-primary">Login</button>
            </a>
            <a href="/registration">
                <button type="button" class="btn btn-outline-warning">Registration</button>
            </a>
        </security:authorize>
        <security:authorize access="hasAnyAuthority('User', 'Admin')">
            <a href="/logout">
                <button type="button" class="btn btn-outline-primary">Logout</button>
            </a>
        </security:authorize>
    </div>
</div>
