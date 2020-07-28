<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@include file="/WEB-INF/jsp/boot.jsp" %>
<div style="position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 60px;
            background-color: lightcyan">
    <nav class="navbar navbar-light navbar-expand-md bg-faded justify-content-center">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsingNavbar3">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="navbar-collapse collapse " id="collapsingNavbar3">
            <ul class="navbar-nav justify-content-center">
                <security:authorize access="hasAnyAuthority('User','Admin')">
                    <li class="nav-item">
                        <a class="nav-link" href="/#about">MainPage</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/genre">Genre</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/book/">Book</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/author/">Author</a>
                    </li>
                </security:authorize>
                <security:authorize access="hasAnyAuthority('Admin')">
                    <li class="nav-item">
                        <a class="nav-link" href="/history/">History</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/user/">User</a>
                    </li>
                </security:authorize>
            </ul>
            <ul class="nav navbar-nav ml-auto w-100 justify-content-end">
                <security:authorize access="!hasAnyAuthority('User', 'Admin')">
                    <li class="nav-item rounded border">
                        <a class="nav-link bg-success text-white" href="/login">Login</a>
                    </li>
                    <li class="nav-item rounded border">
                        <a class="nav-link bg-info text-white" href="/registration">Registration</a>
                    </li>
                </security:authorize>
                <security:authorize access="hasAnyAuthority('User', 'Admin')">
                    <li class="nav-item rounded border">
                        <a class="nav-link bg-danger text-white" href="/logout">Logout</a>
                    </li>
                </security:authorize>
            </ul>
        </div>
    </nav>
</div>