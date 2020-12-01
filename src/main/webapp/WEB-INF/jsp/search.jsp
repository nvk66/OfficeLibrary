<%@include file="all_tag_libs.jsp" %>

<div align="center">
    <div align="left">
        <a href="/book/">
            <button type="button" class="btn btn-outline-primary">Back</button>
        </a>
    </div>
    <h2>Search Results</h2>
    <div>
        <table border="1" cellpadding="5">
            <tr>
                <th>Actions</th>
                <th>BookName</th>
                <th>Authors</th>
                <th>Genres</th>
                <th>PublishingYear</th>
            </tr>
            <c:forEach items="${result}" var="book">
                <tr>
                    <td width="30" height="30" onclick="window.location='http://localhost:8080/book/${book.id}/'">
                        <img src="/images/inspector.png" width="30" height="30"></td>
                    <td onclick="window.location='http://localhost:8080/book/${book.id}/'">${book.name}</td>
                    <td>
                        <c:forEach items="${book.authors}" var="author">
                            <p><a href="/author/${author.id}/">${author.concat()}</a></p>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${book.genres}" var="genres">
                            <p><a href="/author/${genres.id}/">${genres.name}</a></p>
                        </c:forEach>
                    </td>

                    <td>${book.publishingYear}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
