<%@include file="all_tag_libs.jsp" %>
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

<div align="center">
    <h1>New Reservation</h1>
    <form:form action="save" method="post" modelAttribute="reservation">
        <div class="container-fluid">
            <div class="container">
                <div class="row">
                    <table>
                        <form:hidden path="historyId"/>
                        <tr>
                            <td>Book:</td>
                            <td>
                                    ${book.name}
                                <input type="hidden" value="${book.id}" name="book">
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

