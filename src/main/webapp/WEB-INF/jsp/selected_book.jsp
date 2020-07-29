<%--<%@include file="all_tag_libs.jsp"%>--%>
<%--<%@include file="book.jsp"%>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Book</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div align="center">--%>
<%--<h2>Book Details</h2>--%>
<%--<div>--%>
<%--    <form:form action="" method="post" modelAttribute="book">--%>
<%--        <table border="0" cellpadding="5">--%>
<%--            <tr>--%>
<%--                <td>ID: </td>--%>
<%--                <td>${book.id}--%>
<%--                    <form:hidden path="id"/>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>BookName: </td>--%>
<%--                <td>${book.name}--%>
<%--                    <form:hidden path="name" /></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Authors: </td>--%>
<%--                <td>--%>
<%--                    <c:forEach items="${book.authors}" var="author">--%>
<%--                        <a href="/book/search?id=${author.id}"> ${author.concat()}<a/>--%>
<%--                    </c:forEach>--%>
<%--&lt;%&ndash;                        ${book.authors}&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <form:hidden path="authors" />&ndash;%&gt;--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Genres: </td>--%>
<%--                <td>--%>
<%--                    <c:forEach items="${book.genres}" var="genres">--%>
<%--                        ${genres.name}--%>
<%--                    </c:forEach>--%>
<%--&lt;%&ndash;                        ${book.genres}&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <form:hidden path="genres" />&ndash;%&gt;--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>PublishingYear: </td>--%>
<%--                <td>${book.publishingYear}--%>
<%--                    <form:hidden path="publishingYear" /></td>--%>
<%--            </tr>--%>
<%--            <td colspan="2"><input type="submit" value="Reserve"></td>--%>
<%--            <td colspan="2"><input type="button" value="Edit"></td>--%>
<%--            <td colspan="2"><input type="button" value="Delete"></td>--%>
<%--            </tr>--%>
<%--        </table>--%>
<%--    </form:form>--%>
<%--</div>--%>
<%--</div>--%>

<%--</body>--%>
<%--</html>--%>

<%@include file="all_tag_libs.jsp" %>

<div align="center">
    <div align="left">
        <a href="/book/">
            <button type="button" class="btn btn-outline-primary">Back</button>
        </a>
    </div>
    <h2>Book Details</h2>
    <div>
        <form:form action="" method="post" modelAttribute="book">
        <table border="0" cellpadding="5">
            <security:authorize access="hasAuthority('Admin')">
                <tr>
                    <td>ID:</td>
                    <td>${book.id}
                        <form:hidden path="id"/>
                    </td>
                </tr>
            </security:authorize>
            <tr>
                <td>Name:</td>
                <td>${book.name}
                    <form:hidden path="name"/></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td>${book.authors}
                    <form:hidden path="name"/>
                    <c:forEach items="${book.authors}" var="author">
                        <p><a href="/author/${author.id}/">${author.concat()}</a></p>
                    </c:forEach>
                </td>
            </tr>
            <tr>
                <td>Genres:</td>
                <td>${book.genres}
                    <form:hidden path="genres"/>
                    <c:forEach items="${book.genres}" var="genres">
                        <p><a href="/genre/${genres.id}/">${genres.name}</a></p>
                    </c:forEach>
                </td>
            </tr>
            <tr>
                <td>PublishingYear:</td>
                <td>${book.publishingYear}
                    <form:hidden path="publishingYear"/></td>
            </tr>
        </table>
        </form:form>
        <security:authorize access="hasAuthority('Admin')">
        <a href="/book/edit/${book.id}/">
            <button type="button" class="btn btn-outline-warning">Edit</button>
        </a>

        <a href="/book/delete/${book.id}/">
            <button type="button" class="btn btn-outline-danger">Delete</button>
        </a>
        </security:authorize>
        <a href="/book/reserve/${book.id}/">
            <button type="button" class="btn btn-outline-warning">Reserve</button>
        </a>
        <p></p>
        <p></p>
    </div>
</div>
