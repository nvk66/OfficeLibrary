<%@include file="all_tag_libs.jsp"%>

<div align="center">
    <h2>User</h2>
    <security:authorize access="hasAuthority('Admin')">
        <h3><a href="/user/new/">New User</a></h3>
    </security:authorize>
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
        <c:forEach items="${listUser}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.lastName}</td>
                <td>${user.name}</td>
                <td>${user.patronymicName}</td>
                <td>${user.birthDate}</td>
                <td>
                    <c:forEach items="${user.roles}" var="roles">
                        <p>${roles.name}</p>
                    </c:forEach>
                </td>
                <td>
                    <a href="/user/edit/${user.id}/">Edit</a>

                    <a href="/user/delete/${user.id}/">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
