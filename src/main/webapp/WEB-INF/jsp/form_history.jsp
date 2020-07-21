<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New/Edit Author</title>
    <%@include file="boot.jsp"%>
</head>
<body>
<div align="center">
    <h2><a href="/author">Authors</a></h2>
    <h1>New/Edit Author</h1>
    <form:form action="save" method="post" modelAttribute="author">
    <div class="container-fluid">
        <div class="container">
            <div class="row">
        <table>
            <form:hidden path="authorId"/>
            <tr>
                <td>LastName:</td>
                <td><form:input path="lastName" /></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>PatronymicName:</td>
                <td><form:input path="patronymicName" /></td>
            </tr>
            <tr>
                <td>BirthYear:</td>
                <td><form:input path="birthYear" /></td>
            </tr>
            <tr>
                <td>Biography:</td>
                <td><form:input path="biography" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save" class="btn btn-primary"></td>
            </tr>
        </table>
            </div>
        </div>
    </div>
    </form:form>
</div>
</body>
</html>
