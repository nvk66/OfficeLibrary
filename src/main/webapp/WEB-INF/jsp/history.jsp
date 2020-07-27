
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User</title>
    <%@include file="boot.jsp" %>

</head>
<body>
<div align="center">
    <%@include file="navigation.jsp" %>

    <h2>User</h2>
    <form method="get" action="search">
        <input type="text" name="keyword"/>
        <input type="submit" value="Search"/>
    </form>
    <h3><a href="/user/new/">New User</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>User</th>
            <th>Book</th>
            <th>Stats</th>
            <th>StartDate</th>
            <th>DueDate</th>
            <th>ReturnDate</th>
            <th>Actions</th>
        </tr>
        <%--        <jsp:useBean id="listBook" scope="request" type="java.util.List"/>--%>
        <c:forEach items="${listHistory}" var="history">
            <tr>
                <td>${history.id}</td>
                <td>${history.user.userInfo()}</td>
                <td>${history.book.name}</td>
                <td>${history.stats}</td>
                <td>${history.startDate}</td>
                <td>${history.dueDate.toString()}</td>
                <td>${history.returnDate}</td>
                <td>
                    <c:if test="${history.stats.equalsIgnoreCase('Busy')}">
                    <a href="/history/return/${history.id}">Return</a></td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

