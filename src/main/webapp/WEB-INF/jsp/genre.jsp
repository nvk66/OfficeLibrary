<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="all_tag_libs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Genre</title>
    <%@include file="boot.jsp" %>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<%--    <script>--%>
<%--        $(".delete").restintag(optionsObj, function (data) {--%>
<%--                console.log(data);--%>
<%--            },--%>
<%--            function (error) {--%>
<%--                console.log(error);--%>
<%--            });--%>
<%--    </script>--%>
</head>
<body>
<div align="center">
    <%@include file="navigation.jsp" %>
    <h2>Genre</h2>
    <form method="get" action="search">
        <input type="text" name="keyword"/>
        <input type="submit" value="Search"/>
    </form>
    <h3><a href="/genre/">New Genre</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <security:authorize access="hasAuthority('Admin')">
                <th>ID</th>
            </security:authorize>
            <th>Name</th>
            <security:authorize access="hasAuthority('Admin')">
                <th>Action</th>
            </security:authorize>
        </tr>
        <c:forEach items="${listGenre}" var="genre">
            <tr>
                <security:authorize access="hasAuthority('Admin')">
                    <td>${genre.genreId}</td>
                </security:authorize>
                <td>${genre.genreName}</td>
                <security:authorize access="hasAuthority('Admin')">
                    <td>
                        <a href="/genre/edit/${genre.genreId}">Edit</a>

                        <a href="/genre/${genre.genreId}/">Delete</a>
                    </td>
                </security:authorize>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

