<%@include file="all_tag_libs.jsp" %>
<%@include file="boot.jsp" %>
<html>
<head>
    <title>Genre</title>
</head>
<body>
<div align="center">
    <div align="left">
        <a href="/genre/">
            <button type="button" class="btn btn-outline-primary">Back</button>
        </a>
    </div>
    <h2>Genre Details</h2>
    <div>
        <form:form action="" method="post" modelAttribute="genre">
            <table border="0" cellpadding="5">
                <security:authorize access="hasAuthority('Admin')">
                    <tr>
                        <td>ID:</td>
                        <td>${genre.genreId}
                            <form:hidden path="genreId"/>
                        </td>
                    </tr>
                </security:authorize>
                <tr>
                    <td>GenreName:</td>
                    <td>${genre.genreName}
                        <form:hidden path="genreName"/></td>
                </tr>
            </table>
        </form:form>
    </div>
    <security:authorize access="hasAuthority('Admin')">
        <a href="/genre/edit/${genre.genreId}/">
            <button type="button" class="btn btn-outline-warning">Edit</button>
        </a>

        <a href="/genre/delete/${genre.genreId}/">
            <button type="button" class="btn btn-outline-danger">Delete</button>
        </a>
    </security:authorize>
    <p></p>
    <p></p>

    <c:choose>
        <c:when test="${book.size() gt 0}">
            <table border="1" cellpadding="5">
                <tr>
                        <%--            <th>ID</th>--%>
                    <th>BookName</th>
                    <th>Authors</th>
                    <th>Genres</th>
                    <th>PublishingYear</th>
                    <th>Actions</th>
                </tr>
                <c:forEach items="${book}" var="book">
                    <tr>
                            <%--                <td>${book.bookId}</td>--%>
                        <td onclick="window.location='http://localhost:8080/book/${book.bookId}/'">${book.bookName}</td>
                        <td>
                            <c:forEach items="${book.authors}" var="author">
                                <p><a href="/author/${author.authorId}">${author.concat()}</a></p>
                            </c:forEach>
                        </td>
                        <td>
                            <c:forEach items="${book.genres}" var="genres">
                                <p><a href="/author/${genres.genreId}">${genres.genreName}</a></p>
                            </c:forEach>
                        </td>

                        <td>${book.publishingYear}</td>
                        <td onclick="window.location='http://localhost:8080/book/reserve/${book.bookId}/'">
                            <img src="images/reserve-1-550156.png" width="30" height="30">
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <H5>Unfortunately we have no books on ${genre.genreName} genre :( </H5>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
