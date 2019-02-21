<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<%
		String basePath = request.getContextPath();
	%>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书后台管理</title>
</head>
<body>
	<p><a href="<%=basePath%>/catgory.jsp" target="main">分类添加</a></p>
	<p><a href="<%=basePath%>/AddBookServlet" target="main">图书添加</a></p>
	<p><a href="<%=basePath%>/ShowBooksServlet" target="main">图书查询</a></p>
</body>
</html>