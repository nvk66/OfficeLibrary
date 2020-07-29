<%@include file="all_tag_libs.jsp"%>
<%@include file="boot.jsp"%>
<div align="center">
    <h2>Reservation History</h2>
    <h3><a href="/history/new/">Create new reservation</a></h3>
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
