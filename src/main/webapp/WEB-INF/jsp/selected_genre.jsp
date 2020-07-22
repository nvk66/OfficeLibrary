<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Genre</title>
</head>
<body>
<div align="center">
    <h2>Genre Details</h2>
    <div>
        <form:form action="" method="post" modelAttribute="genre">
            <table border="0" cellpadding="5">
                <tr>
                    <td>ID: </td>
                    <td>${genre.genreId}
                        <form:hidden path="genreId"/>
                    </td>
                </tr>
                <tr>
                    <td>GenreName: </td>
                    <td>${genre.genreName}
                        <form:hidden path="genreName" /></td>
                </tr>
                <td colspan="2"><input type="submit" value="Reserve"></td>
                <td colspan="2"><input type="button" value="Edit"></td>
                <td colspan="2"><input type="button" value="Delete"></td>
                </tr>
            </table>
        </form:form>
    </div>
</div>

</body>
</html>
