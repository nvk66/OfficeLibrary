<%@include file="all_tag_libs.jsp"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Search Result</title>
</head>
<body>
<div align="center">
    <h2>Search Result</h2>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>BookName</th>
            <th>Authors</th>
            <th>Genres</th>
            <th>PublishingYear</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${result}" var="book">
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
                <td> <a href="/book/reserve?id=${book.bookId}">Reserve</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
