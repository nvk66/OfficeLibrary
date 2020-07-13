<%--
  Created by IntelliJ IDEA.
  User: alexey
  Date: 07.07.2020
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>New Book</title>
</head>
<body>
<div align="center">
    <h2><a href="/book">Book</a></h2>
    <h2>New Book</h2>
    <form:form action="save" method="post" modelAttribute="book">
        <table border="0" cellpadding="5">
            <tr>
                <td>BookName:</td>
                <td><form:input path="bookName"/></td>
            </tr>
            <tr>
                <td>PublishingYear:</td>
                <td><form:input path="publishingYear"/></td>
            </tr>
            <tr>
                <td>Genres:</td>
                <td>
                    <form:select path="genreIds" items="${genreList}" multiple="true" itemValue="genreId"
                                 itemLabel="genreName">
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Authors:</td>
                <td>
                    <form:select path="authorIds" items="${authorList}" multiple="true" itemLabel="lastName"
                                 itemValue="authorId">
<%--                        <c:forEach items="${authorList}" var="authors">--%>
<%--                            ${authors.concat()}--%>
<%--                        </c:forEach>--%>
                    </form:select>

                </td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>

