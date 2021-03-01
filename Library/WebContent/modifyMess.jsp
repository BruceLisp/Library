<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>用户信息修改</title>
<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
<style type="text/css">
body {
	background:#e7e7e7 ;
 	background: #e7e7e7 url(' img/logo.png');
}

.container {
	width: 380px;
	height: 250px;
	position: absolute;
	left: 50%;
	top: 50%;
	margin-left: -190px;
	margin-top: -125px;
	border-radius: 8px;
	background: #fff;
	box-shadow: 0 3px 18px rgba(100, 0, 0, .5);
}
</style>
<script src="layui/layui.js"></script>
</head>
<%String userId = (String)session.getAttribute("userId"); %>
<body>
	<div class="container">
		<form class="layui-form" action="ModifyMess" method="post">
			<input name="index" value="1" type="hidden"/>
			<input name="id" value="<%=userId %>" type="hidden"/>
			<header
				style="margin-top: 20px; margin-bottom: 20px; text-align: center">
				<fieldset class="layui-elem-field layui-field-title site-title"><legend><p>修改信息</p></legend></fieldset>
			</header>
			<div class="layui-form-item">
				<label class="layui-form-label">用&nbsp;&nbsp;户&nbsp;&nbsp;名：</label>
				<div class="layui-input-inline ">
					<input type="text" id="username" name="username" lay-verify="required|username" 
						autocomplete="off" placeholder="请输入你的名字" class="layui-input"/>
				</div>
			</div>
			
			<div class="layui-form-item">
				<label class="layui-form-label">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：</label>
				<div class="layui-input-inline">
					<input type="text" name="email" id="email"
						lay-verify="email" placeholder="请输入邮箱" autocomplete="off"
						class="layui-input" />
				</div>
			</div>
			
			<div class="layui-form-item" style="text-align: center;  margin-top:20px">
				<button type="submit" class="layui-btn layui-btn-radius"  lay-submit lay-filter="formDemo">修&nbsp;&nbsp;改</button>
				<button type="reset" class="layui-btn layui-btn-radius">重&nbsp;&nbsp;置</button>
			</div>
			<div class="layui-form-item">
		</form>
	</div>
</body>



</html>