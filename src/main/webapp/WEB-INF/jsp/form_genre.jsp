<%@include file="all_tag_libs.jsp" %>

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
<%@include file="boot.jsp" %>

<div align="center">
    <h2><a href="/genre">Genres</a></h2>
    <h1>New/Edit Genre</h1>
    <form:form action="/genre/save/" method="post" modelAttribute="genre">
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
                        <form:hidden path="id"/>
                        <tr>
                            <td>Name:</td>
                            <td><form:input path="name"/>
                                <form:errors path="name" cssClass="error"/>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center">
                                <input type="submit" value="Save" class="btn btn-primary">
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </form:form>
</div>
<%--</body>--%>
<%--</html>--%>
