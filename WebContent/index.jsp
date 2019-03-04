<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<jsp:useBean id="userdata" class="com.mmciel.Bean.UserDataList" />
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

	<form action="UploadServlet" method="post" enctype="multipart/form-data" onSubmit="return uploadCheck()">
		<p class="button button-glow button-border button-rounded button-primary">项目名:</p>&nbsp;&nbsp;&nbsp;&nbsp;
		<select id="projectkey" name="projectkey" class="button button-glow button-border button-rounded button-primary" style="width: 25%"><option value="0" selected>===请选择===</option></select>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<p class="button button-glow button-border button-rounded button-primary">姓&nbsp;&nbsp;&nbsp;名:</p>&nbsp;&nbsp;&nbsp;&nbsp;
		<select id="userkey" name="userkey" class="button button-glow button-border button-rounded button-primary" style="width: 25%"><option value="0"  selected>===请选择===</option></select>
		<br/>
		<input type=button id=filebutton value=browser onclick="file.click()" class="button button-glow button-border button-rounded button-primary">&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="textfield" value="请点击左侧按钮" id=filepath class="button button-glow button-border button-rounded button-primary" style="width: 72%">
		<input type="file" name = "file" id="file" class="button button-glow button-border button-rounded button-primary" style="display:none;" onchange=filepath.value=this.value>
		
		<br/><br/><br/>
		<input type="submit" value="提交" class="button button-glow button-border button-rounded button-primary">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" value="查看已经提交" class="button button-glow button-border button-rounded button-primary" onclick="window.location.href='<%=basePath%>listfile.jsp'">
	</form>		
		
		<br/>	<br/><br/><br/><br/>
		<input type="button" value="管理员登录" class="button button-glow button-border button-rounded button-primary" data-toggle="modal" data-target="#myModal1" >

		</div>
		</div>
		</div>
		</div>
	</header>
</div>
<!-- 弹出框 -->
<div class="modal fade" id="myModal1" tabindex="-1" role="dialog">
	<div class="modal-dialog">
	<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>

	<form action="LoginServlet" method="post" onSubmit="return loginCheck()">
		<p>用户名：</p>&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="text" name = "username" id = "username" >
		<br/>
		<p>密&nbsp;码：</p>&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="password" name = "password" id = "password" >
		<br/>
		<input type="submit" value="登录" class="button button-glow button-border button-rounded button-primary">
	</form>			
	</div>
		</div>
	</div>
</div>
	<script>
		var data = '<jsp:getProperty name="userdata" property="dataList"/>'.slice(1,-1).split(', ');
		var obj=document.getElementById("userkey");
		for(var i=0;i<data.length;i++){
			obj.options.add(new Option(data[i],data[i]));
		}
		var data2 = '<jsp:getProperty name="projectdata" property="dataList"/>'.slice(1,-1).split(', ')
		var obj2=document.getElementById("projectkey");
		for(var i=0;i<data2.length;i++){
				obj2.options.add(new Option(data2[i],data2[i]));
		}
		</script>
		<script type="text/javascript">
		//表单校验
		function uploadCheck(){

			var user=document.getElementById("userkey").value;
			var project=document.getElementById("projectkey").value;
			var s = document.getElementById("file").value.length;
			if(user == 0 || project == 0 || s == 0){
				alert("请确认姓名/文件/项目全都选择！");
				return false;
			}else
				return true;
		}
		</script>
		<script type="text/javascript">
		function loginCheck(){
			var user=document.getElementById("username").value;
			var pw=document.getElementById("password").value;
			if(user=="" || pw == ""){
				alert("用户名或密码不能为空");
				return false;	
			}else
				return true;
		}
	</script>
	<!-- JS 
	<script src="./js/main.js"></script>
	<script type="text/javascript" src="./js/validator.min.js"></script>
	<script type="text/javascript" src="./js/form-scripts.js"></script>
-->
</body>
</html>