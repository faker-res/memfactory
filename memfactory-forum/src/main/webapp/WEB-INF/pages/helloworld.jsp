<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring4 MVC</title>
<%-- <script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"/>
<script type="text/javascript">
$(document).ready(function(){
	//var greeting='<%=request.getAttribute("greeting")%>';
	//这种方法取出来是greeting是String类型
    //$("#title").text(greeting);
    //$("#title").html(greeting);
});
</script> --%>
</head>
<body>
	<h1><%=request.getAttribute("greeting")%></h1>
</body>
</html>