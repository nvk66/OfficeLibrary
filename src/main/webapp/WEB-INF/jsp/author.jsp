<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Authors</title>
    <%@include file="boot.jsp" %>
</head>
<body>
<div align="center">
    <%@include file="navigation.jsp" %>
    <h2>Authors</h2>
<%--    <form method="get" action="search">--%>
<%--        <input type="text" name="keyword"/>--%>
<%--        <input type="submit" value="Search"/>--%>
<%--    </form>--%>
    <security:authorize access="hasAuthority('Admin')">
        <h3><a href="/author/new/">New Author</a></h3>
    </security:authorize>
    <table border="1" cellpadding="5">
        <tr>
            <%--            <th>ID</th>--%>
            <th>Action</th>
            <th>LastName</th>
            <th>Name</th>
            <th>PatronymicName</th>
            <th>BirthYear</th>
            <th>Biography</th>
            <%--            <th>Action</th>--%>
        </tr>
        <%--        <jsp:useBean id="listBook" scope="request" type="java.util.List"/>--%>
        <c:forEach items="${listAuthor}" var="author">
            <tr onclick="window.location='http://localhost:8080/author/${author.id}/'">
                    <%--                <td>${author.authorId}</td>--%>
                <td width="30" height="30">
                    <img src="/images/inspector.png" width="30" height="30"></td>
                <td>${author.lastName}</td>
                <td>${author.name}</td>
                <td>${author.patronymicName}</td>
                <td>${author.birthYear}</td>
                <td width="35%">${author.biography}</td>
                    <%--                <td>--%>
                    <%--                    <a href="/author/edit?id=${author.authorId}">Edit</a>--%>

                    <%--                    <a href="/author/id=${author.authorId}">Delete</a>--%>
                    <%--                </td>--%>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
