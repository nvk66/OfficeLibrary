<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New/Edit Genre</title>
    <style>
        .error {
            color: #ff0000;
        }

        .errorblock {
            color: #000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
    </style>
</head>
<body>
<div align="center">
    <h2><a href="/genre">Genres</a></h2>
    <h1>New/Edit Genre</h1>
    <form:form action="save" method="post" modelAttribute="genres">
        <form:errors path="*" cssClass="errorblock" element="div"/>
        <c:if test="${fn:length(error) > 0}">
            <div class="error">
                <c:out value="${error}"/>
            </div>
        </c:if>
        <div class="container-fluid">
            <div class="container">
                <div class="row">
                    <table>
                        <form:hidden path="genreId"/>
                        <tr>
                            <td>Name:</td>
                            <td><form:input path="genreName"/>
                                <form:errors path="genreName" cssClass="error"/>
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
