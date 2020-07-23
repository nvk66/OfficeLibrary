<%@include file="all_tag_libs.jsp"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registration</title>
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
    <h1>Registration</h1>
    <form:form action="/registration" method="post" modelAttribute="user">
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
                            <td>Email:</td>
                            <td><form:input path="email"/></td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td><form:password path="password"/></td>
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
</body>
</html>
