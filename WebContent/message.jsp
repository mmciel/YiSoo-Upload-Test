<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="description" content="">
<meta name="author" content="">

<title>YiSoo</title>


<!-- css -->
<link href="./css/style.css" rel="stylesheet">
<!-- 字体 -->
<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">

<!-- jq和bootstrap -->

<script src="http://www.jq22.com/jquery/jquery-2.1.1.js"></script>
<script src="http://www.jq22.com/jquery/bootstrap-3.3.4.js"></script>
<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/bootstrap-3.3.4.css">
<!-- 按钮 -->
<link rel="stylesheet" href="http://www.bootcss.com/p/buttons/css/buttons.css">
<script type="text/javascript" src="https://cdn.bootcss.com/Buttons/2.0.0/js/buttons.js"></script>
</head>
<body class="index-page">
	<div class="wrap-body">
	<header class="main-header">
		<div class="col-sm-8 col-sm-offset-2">
			<div class="more-button">
			<div class="header-text">
				<div class="header-text-inner">
					<p class="btn btn-header">YiSoo文件上传工具 V1.4</p>
							<center><h1>${message}</h1></center> 
		<br/>
		<br/>
		<input type="button" value="主页" onclick="window.location.href='<%=basePath%>index.jsp'" class="button button-glow button-rounded button-highlight"  style="width: 30%">
		<br/>
		<br/>
		<br/>
		<input type="button" value="查看已经提交" onclick="window.location.href='<%=basePath%>listfile.jsp'" class="button button-glow button-rounded button-highlight" style="width: 30%">
					
</div></div></div></div>
	</header>
</div>
</body>
</html>