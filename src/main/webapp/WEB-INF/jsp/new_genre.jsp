<%--
  Created by IntelliJ IDEA.
  User: alexey
  Date: 08.07.2020
  Time: 08:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>New Genre</title>
</head>
<body>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js">
    function checkParams() {
        const genreName = $('#genreName').val();

        if(genreName.length != 0) {
            $('#submit').removeAttr('disabled');
        } else {
            $('#submit').attr('disabled', 'disabled');
        }
    }
</script>
<div align="center">
    <h2><a href="/genre">Genre</a></h2>
    <h2>New Genre</h2>
    <form:form action="save" method="post" modelAttribute="genres">
        <table border="0" cellpadding="5">
            <tr>
                <td>Name: </td>
                <td><form:input path="genreName" id="genreName" onkeypress="checkParams()" /></td>
            </tr>
                <td colspan="2"><input type="button" id="submit" value="Save" disabled></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
