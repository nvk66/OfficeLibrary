<%--
  Created by IntelliJ IDEA.
  User: alexey
  Date: 07.07.2020
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Books</title>
</head>
<script>
    var author = document.getElementById('searchAuthor');
    author.val();
</script>
<body>
<div align="center">
    <%@include file="head.jsp"%>
    <h2>Books</h2>
<%--            <form:select path="author" items="${author}" size="1" itemValue="authorId" id="searchAuthor">--%>
<%--&lt;%&ndash;                <form:options>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <a href="/book/edit?id=${book.bookId}">&ndash;%&gt;--%>
<%--&lt;%&ndash;                    </a>&ndash;%&gt;--%>
<%--&lt;%&ndash;                </form:options>&ndash;%&gt;--%>
<%--            </form:select>--%>
    <form method="get" action="/book/search">
        <input type="text" name="id" />
        <input type="submit" value="Search" />
    </form>
<%--            <input type="submit" value="Search" onclick="author"/>--%>
<%--        </form:form>--%>
<%--    </form>--%>
    <%--    <form method="get" action="search">--%>
    <%--        <input type="" name="keyword"/>--%>
    <%--        <input type="submit" value="Search"/>--%>
    <%--    </form>--%>
    <h3><a href="/book/new/">New Book</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>BookName</th>
            <th>Authors</th>
            <th>Genres</th>
            <th>PublishingYear</th>
            <th>Actions</th>
        </tr>
        <%--        <jsp:useBean id="listBook" scope="request" type="java.util.List"/>--%>
        <c:forEach items="${listBook}" var="book">
            <tr>
                <td>${book.bookId}</td>
                <td>${book.bookName}</td>
                <td>
                    <c:forEach items="${book.authors}" var="author">
                        <p>${author.concat()}</p>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${book.genres}" var="genres">
                        <p>${genres.genreName}</p>
                    </c:forEach>
                </td>

                <td>${book.publishingYear}</td>
                <td>
                    <a href="/book/edit?id=${book.bookId}">Edit</a>

                    <a href="/book/delete?id=${book.bookId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>