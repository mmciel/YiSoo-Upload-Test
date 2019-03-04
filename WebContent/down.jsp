<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String path = request.getContextPath();  %>  
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
	
	<br/><br/><br/>
	<input type="button"  id="look" value="查看并下载：<%=request.getAttribute("projectName")%>" class="button button-glow button-border button-rounded button-primary" data-toggle="modal" data-target="#myModal1" style="width: 40%">
		</div>
		</div>
		</div>
		</div>
	</header>
</div>

	<!-- 弹出框 -->
	<style type="text/css" >.modal-content {overflow: auto;max-height:300px;}</style>
<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
	<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header" >		

				    <c:forEach var="me" items="${fileNameMap}">
        <c:url value="/TheDownServlet" var="downurl">
            <c:param name="filename" value="${me.value}"></c:param>
        </c:url>
        <p class="button button-glow button-border button-rounded button-primary" style="width: 60%">${me.value}</p>
        <a href="${downurl}" class="button button-glow button-border button-rounded button-primary" style="width: 25%">下载</a>
        <br/>
    </c:forEach>
			</div>
		</div>
	</div>
</div>


</body>
</html>