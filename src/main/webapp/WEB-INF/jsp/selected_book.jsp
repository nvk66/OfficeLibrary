<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Book</title>
</head>
<body>
<div align="center">
<h2>Book Details</h2>
<div>
    <form:form action="" method="post" modelAttribute="book">
        <table border="0" cellpadding="5">
            <tr>
                <td>ID: </td>
                <td>${book.bookId}
                    <form:hidden path="bookId"/>
                </td>
            </tr>
            <tr>
                <td>BookName: </td>
                <td>${book.bookName}
                    <form:hidden path="bookName" /></td>
            </tr>
            <tr>
                <td>Authors: </td>
                <td>
                    <c:forEach items="${book.authors}" var="author">
                        <a href="/book/search?id=${author.authorId}"> ${author.concat()}<a/>
                    </c:forEach>
<%--                        ${book.authors}--%>
<%--                    <form:hidden path="authors" />--%>
                </td>
            </tr>
            <tr>
                <td>Genres: </td>
                <td>
                    <c:forEach items="${book.genres}" var="genres">
                        ${genres.genreName}
                    </c:forEach>
<%--                        ${book.genres}--%>
<%--                    <form:hidden path="genres" />--%>
                </td>
            </tr>
            <tr>
                <td>PublishingYear: </td>
                <td>${book.publishingYear}
                    <form:hidden path="publishingYear" /></td>
            </tr>
            <td colspan="2"><input type="submit" value="Reserve"></td>
            <td colspan="2"><input type="button" value="Edit"></td>
            <td colspan="2"><input type="button" value="Delete"></td>
            </tr>
        </table>
    </form:form>
</div>
</div>

</body>
</html>
