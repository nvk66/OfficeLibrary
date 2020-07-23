<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title><tiles:getAsString name="title"/></title>
</head>
<body>
<div class="flex-container">
    <tiles:insertAttribute name="header"/>
    <%--    <tiles:insertAttribute name="menu" />--%>
    <%--    <article class="article">--%>
    <tiles:insertAttribute name="body"/>
    <%--    </article>--%>
    <%--    <tiles:insertAttribute name="footer" />--%>
</div>
</body>
</html>

<%--<html>--%>
<%--<head>--%>
<%--    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
<%--    <title><tiles:insertAttribute name="title" ignore="true"/></title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div><tiles:insertAttribute name="header"/></div>--%>
<%--&lt;%&ndash;<div style="float:left;padding:10px;width:15%;"><tiles:insertAttribute name="menu"/></div>&ndash;%&gt;--%>
<%--<div style="float:left;padding:10px;width:80%;border-left:1px solid pink;">--%>
<%--    <tiles:insertAttribute name="body"/></div>--%>
<%--&lt;%&ndash;<div style="clear:both"><tiles:insertAttribute name="footer"/></div>&ndash;%&gt;--%>

<%--</body>--%>
<%--</html>--%>