<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New/Edit Reservation</title>
    <%@include file="boot.jsp" %>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $(function () {
            $("#datepicker").datepicker({dateFormat: 'yy-mm-dd', maxDate: '0', minDate: '0'});
        });
        $(function () {
            $("#datepicker1").datepicker({dateFormat: 'yy-mm-dd', maxDate: '+14', minDate: '+1'});
        });
    </script>
</head>
<body>
<div align="center">
    <h2><a href="/history">History</a></h2>
    <h1>New/Edit Reservation</h1>
    <form:form action="save" method="post" modelAttribute="reservation">
        <div class="container-fluid">
            <div class="container">
                <div class="row">
                    <table>
                        <form:hidden path="historyId"/>
                        <tr>
                            <td>Book:</td>
                            <td>
                                    ${book.bookName}
<%--                                <form:hidden path="book" />--%>
                                <input type="hidden" value="${book.bookId}" name="book">
                            </td>
                        </tr>
                        <tr>
                            <td>User:</td>
                            <td>
                                ${user.userInfo()}
                                <form:hidden path="user"/></td>
                        </tr>
                        <tr>
                            <td>Status:</td>
                            <td>${status}
                                <form:hidden path="stats"/></td>
                        </tr>
                        <tr>
                            <td>StartDate:</td>
                            <td>${reservation.startDate}
                                <form:hidden id="datepicker" path="startDate"/></td>
                        </tr>
                        <tr>
                            <td>DueDate:</td>
                            <td><form:input id="datepicker1" path="dueDate"/></td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center"><input type="submit" value="Reserve" class="btn btn-primary">
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>
