<%@include file="all_tag_libs.jsp"%>
<%@include file="book.jsp"%>
<html>
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
                <td>${book.id}
                    <form:hidden path="id"/>
                </td>
            </tr>
            <tr>
                <td>BookName: </td>
                <td>${book.name}
                    <form:hidden path="name" /></td>
            </tr>
            <tr>
                <td>Authors: </td>
                <td>
                    <c:forEach items="${book.authors}" var="author">
                        <a href="/book/search?id=${author.id}"> ${author.concat()}<a/>
                    </c:forEach>
<%--                        ${book.authors}--%>
<%--                    <form:hidden path="authors" />--%>
                </td>
            </tr>
            <tr>
                <td>Genres: </td>
                <td>
                    <c:forEach items="${book.genres}" var="genres">
                        ${genres.name}
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
