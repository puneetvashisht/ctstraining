<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>I18N Page</title>
</head>
<body>

Language : <a href="?language=en">English</a> |<a href="?language=fr">France |<a href="?language=hi">Hindi</a>

<p>${message}</p>



</html>
