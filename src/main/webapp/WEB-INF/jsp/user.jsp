<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User</title>
    <%@include file="boot.jsp" %>

</head>
<body>
<div align="center">
    <%@include file="navigation.jsp"%>

    <h2>User</h2>
    <form method="get" action="search">
        <input type="text" name="keyword" />
        <input type="submit" value="Search" />
    </form>
    <h3><a href="/user/new/">New User</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>LastName</th>
            <th>Name</th>
            <th>PatronymicName</th>
            <th>BirthDate</th>
            <th>Role</th>
            <th>Actions</th>
        </tr>
        <%--        <jsp:useBean id="listBook" scope="request" type="java.util.List"/>--%>
        <c:forEach items="${listUser}" var="user">
            <tr>
                <td>${user.userId}</td>
                <td>${user.lastName}</td>
                <td>${user.name}</td>
                <td>${user.patronymicName}</td>
                <td>${user.birthDate}</td>
                <td>
                    <c:forEach items="${user.roles}" var="roles">
                        <p>${roles.roleName}</p>
                    </c:forEach>
                </td>
                <td>
                    <a href="/user/edit?id=${user.userId}">Edit</a>

                    <a href="/user/delete?id=${user.userId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
