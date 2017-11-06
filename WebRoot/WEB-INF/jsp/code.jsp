<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>扫一扫向我付款</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<style type="text/css">
img {
	min-width: 100%;
}

.box {
	width: 100%;
	height: 100%;
}

.imgdiv {
	width: 80%;
	margin-top: 350px;
}

.font {
	font-size: 50px;
}
</style>
</head>

<body>
	<div align="center" class="box">
		<c:choose>
			<c:when test="${not empty quser }">
				<div class="imgdiv">
					<span class="font"> 长按识别,向<font color="red">${quser.qname }</font>付款
					</span> <img alt=""
						src="${pageContext.request.contextPath }/statics/images/code/q/${quser.qfile}" />
				</div>
			</c:when>
			<c:when test="${not empty wuser }">
				<div class="imgdiv">
					<span class="font">长按识别,向我付款</span> <img alt=""
						src="${pageContext.request.contextPath }/statics/images/code/w/${wuser.wfile}" />
				</div>
			</c:when>
		</c:choose>
	</div>
</body>
</html>
