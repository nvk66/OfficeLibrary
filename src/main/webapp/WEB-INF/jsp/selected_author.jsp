<%@include file="all_tag_libs.jsp" %>

<div align="center">
    <div align="left">
        <a href="/author/">
            <button type="button" class="btn btn-outline-primary">Back</button>
        </a>
    </div>
    <h2>Author Details</h2>
    <div>
        <form:form action="" method="post" modelAttribute="author">
            <table border="0" cellpadding="5">
                <security:authorize access="hasAuthority('Admin')">
                    <tr>
                        <td>ID:</td>
                        <td>${author.id}
                            <form:hidden path="id"/>
                        </td>
                    </tr>
                </security:authorize>
                <tr>
                    <td>LastName:</td>
                    <td>${author.lastName}
                        <form:hidden path="lastName"/></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td>${author.name}
                        <form:hidden path="name"/></td>
                </tr>
                <tr>
                    <td>PatronymicName:</td>
                    <td>${author.patronymicName}
                        <form:hidden path="patronymicName"/></td>
                </tr>
                <tr>
                    <td>PatronymicName:</td>
                    <td>${author.birthYear}
                        <form:hidden path="birthYear"/></td>
                </tr>
                <tr>
                    <td>Biography:</td>
                    <td>${author.biography}
                        <form:hidden path="biography"/></td>
                </tr>
                </tr>
            </table>
        </form:form>
        <security:authorize access="hasAuthority('Admin')">
            <a href="/author/edit/${author.id}/">
                <button type="button" class="btn btn-outline-warning">Edit</button>
            </a>

            <a href="/author/delete/${author.id}/">
                <button type="button" class="btn btn-outline-danger">Delete</button>
            </a>
        </security:authorize>
        <p></p>
        <p></p>
        <%--            <td colspan="2"><input type="button" value="Edit"></td>--%>
        <%--            <td colspan="2"><input type="button" value="Delete"></td>--%>
        <h5>Books of greatest ${author.fullName()}</h5>
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
                            <td onclick="window.location='http://localhost:8080/book/${book.id}/'">${book.name}</td>
                            <td>
                                <c:forEach items="${book.authors}" var="author">
                                    <p><a href="/author/${author.id}">${author.fullName()}</a></p>
                                </c:forEach>
                            </td>
                            <td>
                                <c:forEach items="${book.genres}" var="genres">
                                    <p><a href="/author/${genres.id}">${genres.name}</a></p>
                                </c:forEach>
                            </td>
                            <td>${book.publishingYear}</td>
                            <td onclick="window.location='http://localhost:8080/book/reserve/${book.id}/'">
                                    <%--                        <a href="/book/reserve/${book.bookId}/">Reserve</a>--%>
                                <img src="images/reserve-1-550156.png" width="30" height="30">
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <H5>Unfortunately ${author.fullName()} has no books in our library</H5>
            </c:otherwise>
        </c:choose>
    </div>
</div>
