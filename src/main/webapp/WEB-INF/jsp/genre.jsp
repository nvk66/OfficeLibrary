<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="all_tag_libs.jsp" %>
<div align="center" style="overflow: scroll;">
    <h2>Genre</h2>
    <security:authorize access="hasAuthority('Admin')">
        <h3><a href="/genre/">New Genre</a></h3>
    </security:authorize>
    <table border="1" cellpadding="5">
        <tr>
            <th>Action</th>
            <th>Name</th>
        </tr>
        <c:forEach items="${listGenre}" var="genre">
            <tr onclick="window.location='http://localhost:8080/genre/${genre.id}/'">
                <td width="30" height="30">
                    <img src="/images/inspector.png" width="30" height="30"></td>
                <td>${genre.name}</td>
            </tr>
        </c:forEach>
    </table>
</div>

