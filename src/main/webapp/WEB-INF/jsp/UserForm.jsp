<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New/Edit User</title>
    <%@include file="boot.jsp" %>

<%--    --%>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $( function() {
            $( "#datepicker" ).datepicker({ dateFormat: 'yy-mm-dd', maxDate: '-3650' });
        } );
    </script>
<%--    --%>
</head>
<body>
<div align="center">
    <h2><a href="/user">Users</a></h2>
    <h1>New/Edit User</h1>
    <form:form action="save" method="post" modelAttribute="user">
        <div class="container-fluid">
            <div class="container">
                <div class="row">
                    <table>
                        <form:hidden path="userId"/>
                        <tr>
                            <td>LastName:</td>
                            <td><form:input path="lastName"/></td>
                        </tr>
                        <tr>
                            <td>Name:</td>
                            <td><form:input path="name"/></td>
                        </tr>
                        <tr>
                            <td>PatronymicName:</td>
                            <td><form:input path="patronymicName"/></td>
                        </tr>
                        <tr>
                            <td>BirthDate:</td>
                            <td><form:input id="datepicker" path="birthDate"/></td>
                        </tr>
                        <tr>
                            <td>Role: </td>
                            <td>
                                <form:select path="roleIds" items="${roleList}" multiple="true" itemLabel="roleName" itemValue="roleId"/>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center"><input type="submit" value="Save" class="btn btn-primary">
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
