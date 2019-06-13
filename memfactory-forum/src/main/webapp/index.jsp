<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	// 获得项目完全路径（假设你的项目叫MyApp，那么获得到的地址就是 http://localhost:8080/MyApp/）: 
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<style type="text/css">
body {
	background-image: url("<%=path%>/images/niupinzhi.jpg");
	background-repeat: no-repeat;
}

h3 {
	text-align: center;
}
</style>
</head>

<body>
	<div>
		<h3>你好，欢迎来到我的网站！</h3>
	</div>
</body>
</html>