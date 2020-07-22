<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@include file="all_tag_libs.jsp" %>
<div align="center">
    <security:authorize access="hasAnyAuthority('User','Admin')">
        <a href="/#about">MainPage</a>
        <a href="/genre">Genre</a>
        <a href="/book">Book</a>
        <a href="/author">Author</a>
    </security:authorize>
    <security:authorize access="hasAnyAuthority('Admin')">
        <a href="/history">History</a>
        <a href="/user">User</a>
    </security:authorize>
</div>
