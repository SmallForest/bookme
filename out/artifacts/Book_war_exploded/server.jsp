<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<%
		String basePath = "/Book_war_exploded";
	%>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书后台管理系统</title>
</head>
<frameset rows="20%,*">
	<frame src="<%=basePath%>/top.jsp"></frame>
	<frameset cols="10%,*">
		<frame src="<%=basePath%>/left.jsp"></frame>
		<frame name="main"></frame>
	</frameset>
</frameset>
</html>