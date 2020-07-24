<%@include file="all_tag_libs.jsp"%>

<html>
<head>
    <title>Reservation</title>
</head>
<body>
<div align="center">
    <%@include file="navigation.jsp" %>
    <h2>Reservation</h2>
    <form:form action="save" method="post" modelAttribute="">
        <table border="0" cellpadding="5">
            <tr>
                <td>ID: </td>
                <td>${book.bookId}
                    <form:hidden path="bookId"/>
                </td>
            </tr>
            <tr>
                <td>BookName:</td>
                <td><form:input path="bookName"/></td>
            </tr>
            <tr>
                <td>PublishingYear:</td>
                <td><form:input path="publishingYear"/></td>
            </tr>
            <tr>
                <td>Genres:</td>
                <td>
                    <form:select path="genreIds" items="${genreList}" multiple="true" itemValue="genreId"
                                 itemLabel="genreName">
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Authors:</td>
                <td>
                    <form:select path="authorIds" items="${authorList}" multiple="true" itemLabel="lastName"
                                 itemValue="authorId">
                    </form:select>

                </td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
