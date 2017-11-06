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

<title>上传二维码</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<style type="text/css">
.box {
	
}

.bmg {
	position: relative;
	display: inline-block;
	background: #D0EEFF;
	border: 1px solid #99D3F5;
	border-radius: 4px;
	padding: 96px 288px;
	overflow: hidden;
	color: #1E88C7;
	text-decoration: none;
	text-indent: 0;
	line-height: 20px;
	margin-top: 100px;
	font-size: 90px;
}

.upload {
	position: absolute;
	font-size: 100px;
	right: 0;
	top: 0;
	opacity: 0;
	filter: alpha(opacity = 0);
	cursor: pointer
}

.upload:hover {
	color: #444;
	background: #eee;
	border-color: #ccc;
	text-decoration: none
}

.font {
	font-size: 100px;
}

.submit {
	position: relative;
	display: inline-block;
	background: #8B008B;
	border: 1px solid #99D3F5;
	border-radius: 4px;
	padding: 96px 288px;
	overflow: hidden;
	color: #1E88C7;
	text-decoration: none;
	text-indent: 0;
	line-height: 20px;
	margin-top: 100px;
	font-size: 90px;
}
</style>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/statics/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#w").hide();
		$("#z").hide();
		$("#a").hide();
		$(".upload").change(function() {
			var filePath = $(this).val();
			if (filePath.indexOf("jpg") != -1 || filePath.indexOf("png") != -1) {
				var arr = filePath.split('\\');
				var fileName = arr[arr.length - 1];
				$(".filename").text(fileName);
			} else {
				$(".filename").text("请上传jpg或png格式图片");
				return false
			}
		});


		//点击跳过时:
		$("input[name='forward']").click(function() {
			if (confirm("确定跳过生成该收款码吗?")) {
				$(this).parent().parent().next().show();
				$(this).parent().parent().hide();
				$(".filename").text("");
			}
		});

		/* 文件上传 */
		var qid = "";
		var wid = "";
		var zid = "";

		$(".fileform").submit(function() {
			var action = $(this).attr("action");
			var $form = $(this);
			var flag = true;
			if (null == $(this).find("input[type='file']") || "" == $(this).find("input[type='file']")) {
				alert("请选择文件!");
				flag = false;
			}
			if (flag) {
				$(".filename").text("上传中...");
				$.ajax({
					url : action,
					type : "POST",
					cache : false,
					data : new FormData($form[0]),
					processData : false,
					contentType : false,
					datatype : "json",
					success : function(data) {
						var json = eval(data);
						var result = json.result;
						if (result == "true") {
							var id = $form.attr("name");
							switch (id) {
							case 'q':
								qid = json.qid;
								w();
								break;
							case 'w':
								wid = json.wid;
								z();
								break;
							case 'z':
								zid = json.zid;
								a();
								break;
							}
						} else if (result == "error") {
							alert(json.message);
							$(".filename").text("上传失败");
						}
					}
				});
			}
			return false;
		});

		//生成二维码
		$("#a").submit(function() {
			$("#qid").val(qid);
			$("#wid").val(wid);
			$("#zid").val(zid);
			return true;
		});

		function w() {
			$("#q").hide();
			$("#w").show();
			$("#z").hide();
			$("#a").hide();
			$(".filename").text("");
		}

		function z() {
			$("#w").hide();
			$("#z").show();
			$("#q").hide();
			$("#a").hide();
			$(".filename").text("");
		}

		function a() {
			$("#q").hide();
			$("#a").show();
			$("#z").hide();
			$("#w").hide();
			$(".filename").text("");
		}

	});
</script>
</head>

<body>
	<div align="center">
		<div id="q" class="box">
			<span class="font">请选择<font color="red">QQ</font>收款码
			</span>
			<form action="upload/q" method="post" enctype="multipart/form-data"
				class="fileform" name="q">
				<a href="javascript:void(0);" class="bmg">选择文件 <input
					type="file" name="file" class="upload" /></a><br /> <span
					class="filename" style="font-size: 40px;"></span><br /> <input
					type="button" value="跳过" class="submit" name="forward" /> <br />
				<input type="submit" value="上传" class="submit" />
			</form>
		</div>
		<div id="w" class="box">
			<span class="font">请选择<font color="red">微信</font>收款码
			</span>
			<form action="upload/w" method="post" enctype="multipart/form-data"
				class="fileform" name='w'>
				<a href="javascript:void(0);" class="bmg">选择文件 <input
					type="file" name="file" class="upload" /></a><br /> <span
					class="filename" style="font-size: 40px;"></span><br /> <input
					type="button" value="跳过" class="submit" name="forward" /> <br />
				<input type="submit" value="上传" class="submit" />
			</form>
		</div>
		<div id="z" class="box">
			<span class="font">请选择<font color="red">支付宝</font>收款码
			</span>
			<form action="upload/z" method="post" enctype="multipart/form-data"
				class="fileform" name='z'>
				<a href="javascript:void(0);" class="bmg">选择文件 <input
					type="file" name="file" class="upload" /></a><br /> <span
					class="filename" style="font-size: 40px;"></span><br /> <input
					type="button" value="跳过" class="submit" name="forward" /> <br />
				<input type="submit" value="上传" class="submit" />
			</form>
		</div>
		<div id="a" class="box">
			<form action="upload/a" enctype="post">
				<input type="hidden" name="qid" value="" id="qid" /> <input
					type="hidden" name="wid" value="" id="wid" /> <input type="hidden"
					name="zid" value="" id="zid" /> <input type="submit"
					value="生成我的专属收款码" class="submit" />
			</form>
		</div>
	</div>
</body>
</html>
