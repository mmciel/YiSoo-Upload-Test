<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String path = request.getContextPath();  %>
<%
	if(session.getAttribute("username")==null){
		response.sendRedirect("index.jsp");
	}
%>
<jsp:useBean id="projectdata" class="com.mmciel.Bean.ProjectDataList" />
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
	
		<form action="<%=path%>/DownServlet" onsubmit="return check01()">
		<p class="button button-glow button-rounded button-royal" style="width: 20%">文件下载：</p>&nbsp;&nbsp;&nbsp;&nbsp;
		<select id="downkey" name="downkey" class="button button-glow button-rounded button-royal" style="width: 25%"><option value="0"  selected>===请选择===</option></select>&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="确定" class="button button-glow button-rounded button-royal" style="width: 20%">
		</form>

		<form action="<%=path%>/AllDownServlet" onsubmit="return check02()">
		<p class="button button-glow button-rounded button-royal" style="width: 20%">打包下载：</p>&nbsp;&nbsp;&nbsp;&nbsp;
		<select id="alldownkey" name="alldownkey" class="button button-glow button-rounded button-royal" style="width: 25%"><option value="0" selected>===请选择===</option></select>&nbsp;&nbsp;&nbsp;&nbsp;

		<input type="submit" value="确定" class="button button-glow button-rounded button-royal" style="width: 20%">
		</form>
		
			<form action="<%=path %>/DelServlet" onsubmit="return check04()" >
		<p class="button button-glow button-rounded button-royal" style="width: 20%">项目删除：</p>&nbsp;&nbsp;&nbsp;&nbsp;
		<select id="delkey" name="delkey" class="button button-glow button-rounded button-royal" style="width: 25%"><option value="0" selected>===请选择===</ption></select>&nbsp;&nbsp;&nbsp;&nbsp;

		<input type="submit" value="确定" class="button button-glow button-rounded button-royal" style="width: 20%">
	</form>
		
		<form action="<%=path%>/AddServlet" onsubmit="return check03()">

		<p class="button button-glow button-rounded button-royal" style="width: 20%">项目添加：</p>&nbsp;&nbsp;&nbsp;&nbsp;

		<input type="textfield" name="addkey" id = "addkey" class="button button-glow button-rounded button-royal" style="width: 25%">&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="确定" class="button button-glow button-rounded button-royal" style="width: 20%">
		
		</form>

		</div>
		</div>
				</div>
		</div>
	</header>
</div>

	<script>
		var data = '<jsp:getProperty name="projectdata" property="dataList"/>'.slice(1,-1).split(', ')
		var obj=document.getElementById("downkey");
		for(var i=0;i<data.length;i++){
				obj.options.add(new Option(data[i],data[i]));
		}
		var obj2=document.getElementById("delkey");
		for(var i=0;i<data.length;i++){
				obj2.options.add(new Option(data[i],data[i]));
		}
		var obj3=document.getElementById("alldownkey");
		for(var i=0;i<data.length;i++){
				obj3.options.add(new Option(data[i],data[i]));
		}
		
		function check01(){
			var downkey =document.getElementById("downkey").value;
			if(downkey == 0){
				alert("请先选择！");
				return false;
			}
			return true;
		}
		function check02(){
			var alldownkey =document.getElementById("alldownkey").value;
			if(alldownkey == 0){
				alert("请先选择！");
				return false;
			}
			return true;
		}
		function check03(){
			var addkey =document.getElementById("addkey").value;
			if(addkey == ""){
				alert("请先输入项目名称！");
				return false;
			}
			return true;
		}
		function check04(){
			var delkey =document.getElementById("delkey").value;
			if(delkey == 0){
				alert("请先选择！");
				return false;
			}
			return true;
		}
	</script>
</body>
</html>