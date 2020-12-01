<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><tiles:getAsString name="title"/></title>
</head>

<body>
<table width="100%">
    <tr>
        <td colspan="2">
            <tiles:insertAttribute name="header"/>
        </td>
    </tr>
    <tr>
        <td width="80%" style="padding-bottom: 100px; padding-top: 60px">
            <tiles:insertAttribute name="body"/>
        </td>
    </tr>
    <tr>
        <div>
            <tiles:insertAttribute name="footer"/>
        </div>
    </tr>
</table>
</body>
</html>
