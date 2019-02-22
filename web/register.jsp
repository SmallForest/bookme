<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<%
		String basePath = request.getContextPath();
		String s = request.getParameter("s");
		String msg="";
		if(request.getAttribute("msg") != null){
			msg = (String) request.getAttribute("msg");
		}
	%>
	<script>
		if(<%=s%>){
			alert("账户未注册！请注册！");
		}
	</script>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册界面</title>
</head>
<body>
	<center>
		<h1>用户注册</h1>
		<h6 style="color: red;"><%=msg%></h6>
		<form action="<%=basePath%>/RegisterServlet" method="post">
			<table width="400px" cellspacing="0px" cellpadding="0px" border="1px">
				<tr>
					<td>用户名</td>
					<td><input type="text" name="username" placeholder="用户名为3-12位字母数字或下划线组合" pattern="^\w{3,12}$"></td>
				</tr>
				<tr>
					<td>密&nbsp;码</td>
					<td><input type="password" name="password" placeholder="密码长度为6-12位的纯数字"  id="password1" pattern="^\d{6,12}$"></td>
				</tr>
				<tr>
					<td>确认密码</td>
					<td><input type="password" name="checkPWD" placeholder="密码长度为6-12位的纯数字" id="password2" pattern="^\d{6,12}$"></td>
				</tr>
				<tr>
					<td>手机号码</td>
					<td><input type="text" name="phone" placeholder="请输入正确的手机号码格式" id="mobile" pattern="^1\d{10}$"></td>
				</tr>
				<tr>
					<td>邮箱</td>
					<td><input type="email" name="email" placeholder="请输入正确邮箱格式" required="required"></td>
				</tr>
				<tr>
					<td>验证码</td>
					<td><input type="text" name="code" placeholder="长度为4位" pattern="^\w{4}$"></td>
				</tr>
				<tr>
					<td>图片</td>
					<td>
						<img id="captcha_img" alt="点击更换" title="点击更换" onclick="changeVerifyCode(this)" src="<%=basePath%>/Kaptcha">
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center">
						<input type="submit" value="注册" id="submit">
						<input type="reset" value="重置">
					</td>
				</tr>
			</table>
		</form>
	</center>
	<script src="http://libs.baidu.com/jquery/1.9.0/jquery.min.js"></script>
	<script>
		$("#password2").blur(function(){
			if($(this).val() !== $("#password1").val()){
				alert("密码不一致");
				return;
			}
		});
		$("form").submit(function(){
			var reg = '^\d{6,12}$';
			if(!$("#password1").val().test(reg)){
				alert("密码只能是6-12位数字！");
				return false;
			}
			//校验密码一致性
			if($("#password1").val() !== $("#password2").val()){
				alert("密码不一致");
				return false;
			}
			//检查手机号码格式
			var reg2 = /^(1\d{10})$/;
			if(!$("#mobile").val().test(reg2)){
				alert("手机号码格式错误！");
				return false;
			}
		});
	</script>
</body>
</html>