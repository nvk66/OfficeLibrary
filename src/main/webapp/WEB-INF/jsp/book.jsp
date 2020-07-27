<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Books</title>
    <%@include file="boot.jsp" %>

</head>
<script>
    var author = document.getElementById('searchAuthor');
    author.val();
</script>
<body>
<div align="center">
    <%@include file="navigation.jsp" %>
    <h2>Books</h2>
    <security:authorize access="hasAuthority('Admin')">
        <h3><a href="/book/new/">New Book</a></h3>
    </security:authorize>
    <table border="1" cellpadding="5">
        <tr>
            <th>Actions</th>
            <th>BookName</th>
            <th>Authors</th>
            <th>Genres</th>
            <th>PublishingYear</th>
        </tr>
        <c:forEach items="${listBook}" var="book">
            <tr>
                <td width="30" height="30" onclick="window.location='http://localhost:8080/author/${book.id}/'">
                    <img src="/images/inspector.png" width="30" height="30"></td>
                <td onclick="window.location='http://localhost:8080/author/${book.id}/'">${book.name}</td>
                <td>
                    <c:forEach items="${book.authors}" var="author">
                        <p><a href="/author/${author.id}">${author.concat()}</a></p>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${book.genres}" var="genres">
                        <p><a href="/author/${genres.id}">${genres.name}</a></p>
                    </c:forEach>
                </td>

                <td>${book.publishingYear}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>