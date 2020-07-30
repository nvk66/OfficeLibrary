<%@include file="all_tag_libs.jsp" %>
<%@include file="boot.jsp" %>
<div align="center">
    <h2>Books</h2>
    <security:authorize access="hasAuthority('Admin')">
        <h3><a href="/book/new/">New Book</a></h3>
    </security:authorize>
    <form method="get" action="search">
        <input type="text" name="keyword" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm"
        style="width: 100px"/>
        <input type="submit" value="Search" class="btn btn-outline-info"/>
    </form>
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
                <td width="30" height="30" onclick="window.location='http://localhost:8080/book/${book.id}/'">
                    <img src="/images/inspector.png" width="30" height="30"></td>
                <td onclick="window.location='http://localhost:8080/book/${book.id}/'">${book.name}</td>
                <td>
                    <c:forEach items="${book.authors}" var="author">
                        <p><a href="/author/${author.id}/">${author.fullName()}</a></p>
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