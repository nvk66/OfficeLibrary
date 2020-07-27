<%@include file="all_tag_libs.jsp" %>
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
<div align="center">
    <h2><a href="/author/">Authors</a></h2>
    <h1>New/Edit Author</h1>
    <form:form action="/author/save/" method="post" modelAttribute="author">
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
                            <td>LastName:</td>
                            <td>
                                <form:input path="lastName"/>
                                <form:errors path="lastName" cssClass="error"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Name:</td>
                            <td>
                                <form:input path="name"/>
                                <form:errors path="name" cssClass="error"/>
                            </td>
                        </tr>
                        <tr>
                            <td>PatronymicName:</td>
                            <td>
                                <form:input path="patronymicName"/>
                                <form:errors path="patronymicName" cssClass="error"/>
                            </td>
                        </tr>
                        <tr>
                            <td>BirthYear:</td>
                            <td>
                                <form:input path="birthYear"/>
                                <form:errors path="birthYear" cssClass="error"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Biography:</td>
                            <td>
                                <form:input path="biography"/>
                                <form:errors path="biography" cssClass="error"/>
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
