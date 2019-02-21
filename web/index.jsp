<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<%
		String basePath = request.getContextPath();
		String username = "";
		String s = request.getParameter("s");
		if(request.getAttribute("username") != null){
			username = (String) request.getAttribute("username");
		}
		String msg="";
		if(request.getAttribute("msg") != null){
			msg = (String) request.getAttribute("msg");
		}
	%>
	<script>
		if(<%=s%>){
			alert("账户未登录！请登录！");
		}
	</script>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书后台管理登录界面</title>
</head>
<body>
	<center>
		<h1>登录 | <a href="<%=basePath%>/register.jsp">注册</a></h1>
		<h6 style="color: red;"><%=msg%></h6>
		<form action="<%=basePath%>/LoginServlet" method="post">
			<table width="350px" cellspacing="0px" cellpadding="0px" border="1px">
				<tr>
					<td>用户名</td>
					<td><input type="text" name="username" value="<%=username%>" placeholder="用户名为3-12位字母数字或下划线组合" pattern="^\w{3,12}$"></td>
				</tr>
				<tr>
					<td>密&nbsp;码</td>
					<td><input type="password" name="password" placeholder="长度为6-12位的纯数字" pattern="^\d{6,12}$"></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center">
						<input type="submit" value="登录">
						<input type="reset" value="取消">
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>