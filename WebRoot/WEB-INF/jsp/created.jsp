<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>二维码生成</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
.box {
	width: 90px;
	margin-top: 100px;
}

img {
	min-width: 100%;
}

.font {
	font-size: 25px;
}
</style>
</head>

<body>
	<div align="center">
		<div class="box">
			<span class="font">请将此码保存,作为你的收款码</span> <img alt=""
				src="${pageContext.request.contextPath }/statics/images/code/a/${url}">
		</div>
	</div>
</body>
</html>
