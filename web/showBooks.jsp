<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
	<%
		String basePath = request.getContextPath();
	%>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书查询</title>
</head>
<body>
	<center>
		<h1>图书查询</h1>
		<p>
			图书ID：<input type="text" name="bookID">
			图书名：<input type="text" name="bookName">
			分类：<input type="text" name="catgoryName">
			<input type="submit" value="查询" id="search">
		</p>
		<hr>
		<table width="800px" cellspacing="0px" cellpadding="0px" border="1px">
			<thead>
				<tr>
					<th>图书ID</th>
					<th>书名</th>
					<th>分类</th>
					<th>价格</th>
					<th>描述</th>
				</tr>
			</thead>
			<tbody id="cont">
			<c:forEach items="${requestScope.list}" var="p" varStatus="idx">
				<tr>
					<td>${p.getId()}</td>
					<td>${p.getName()}</td>
					<td>${p.getCate_name()}</td>
					<td>${p.getPrice()}</td>
					<td>${p.getDesc()}</td>
				</tr>
			</c:forEach>

				
			</tbody>
		</table>
	</center>
	<script src="http://libs.baidu.com/jquery/1.9.0/jquery.min.js"></script>
	<script>
		$('#search').click(function () {
			var bookID = $("input[name=bookID]").val();
			var bookName = $("input[name=bookName]").val();
			var catgoryName = $("input[name=catgoryName]").val();
			$.post("<%=basePath%>/ShowBooksServlet",{bookID:bookID,bookName:bookName,catgoryName:catgoryName},function (data) {
				$("#cont").empty();
				if(data){
					var json = JSON.parse(data);
					$.each(json,function (n,item) {
						var html = "<tr>\n" +
								"\t\t\t\t\t<td>"+item.id+"</td>\n" +
								"\t\t\t\t\t<td>"+item.name+"</td>\n" +
								"\t\t\t\t\t<td>"+item.cate_name+"</td>\n" +
								"\t\t\t\t\t<td>"+item.price+"</td>\n" +
								"\t\t\t\t\t<td>"+item.desc+"</td>\n" +
								"\t\t\t\t</tr>"
						$("#cont").append(html);
					})
				}
			})
		});
	</script>
</body>
</html>