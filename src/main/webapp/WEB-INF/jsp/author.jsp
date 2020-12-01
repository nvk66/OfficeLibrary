<%@include file="all_tag_libs.jsp" %>
<div align="center">
    <h2>Authors</h2>
    <security:authorize access="hasAuthority('Admin')">
        <h3><a href="/author/new/">New Author</a></h3>
    </security:authorize>
    <table border="1" cellpadding="5">
        <tr>
            <th>Action</th>
            <th>LastName</th>
            <th>Name</th>
            <th>PatronymicName</th>
            <th>BirthYear</th>
            <th>Biography</th>
        </tr>
        <c:forEach items="${listAuthor}" var="author">
            <tr onclick="window.location='http://localhost:8080/author/${author.id}/'">
                <td width="30" height="30">
                    <img src="/images/inspector.png" width="30" height="30"></td>
                <td>${author.lastName}</td>
                <td>${author.name}</td>
                <td>${author.patronymicName}</td>
                <td>${author.birthYear}</td>
                <td width="35%">${author.biography}</td>
            </tr>
        </c:forEach>
    </table>
</div>
