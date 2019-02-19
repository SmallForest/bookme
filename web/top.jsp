<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<%
    String username = "";
    if (session.getAttribute("username") != null) {
        username = (String) session.getAttribute("username");
    }
%>
<body>
<center>
    <h1>
        图书后台管理系统<span style="font-size:12px">您好，<span style="color: red;"><%=username%></span></span>
    </h1>
</center>
</body>
</html>
