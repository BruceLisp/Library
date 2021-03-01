<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>管理员登录</title>
<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
<style>
body {
	background: #e7e7e7;
	background: #e7e7e7 url('img/logo.png');
}

.container {
	width: 400px;
	height: 257px;
	position: absolute;
	left: 50%;
	top: 50%;
	margin-left: -200px;
	margin-top: -140px;
	border-radius: 8px;
	background: #fff;
	box-shadow: 0 3px 18px rgba(100, 0, 0, .5);
}
</style>
<script>
	//Demo
	/* 	layui.use('form', function() {
	 var form = layui.form;

	 //监听提交
	 form.on('submit(formDemo)', function(data) {

	 if (data.field.username == "hnucm"
	 && data.field.password == "123456") {
	 layer.msg("登录成功！");
	 } else {
	 layer.msg("登录失败！");
	 }
	 return false;
	 });
	 }); */
</script>
</head>
<body>

	<form class="layui-form" action="loginJudge" method="post">
		<div class="container">
			<header
				style="margin-top: 15px; margin-bottom: 20px; text-align: center">
			<h1>管理员登录</h1>
			</header>
			<div class="layui-form-item">
				<label class="layui-form-label">用户名</label>
				<div class="layui-input-inline ">
					<i class="layui-icon layui-icon-username"
						style="font-size: 20px; position: absolute; margin-left: 3px; margin-top: 5px"></i>
					<input type="text" name="username" lay-verify="required"
						autocomplete="off" placeholder="请输入用户名" class="layui-input"
						style="padding-left: 25px">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">密 &nbsp;&nbsp;码</label>
				<div class="layui-input-inline">
					<i class="layui-icon layui-icon-password"
						style="font-size: 20px; position: absolute; margin-left: 3px; margin-top: 5px"></i>
					<input type="password" name="password" required
						lay-verify="required" placeholder="请输入密码" autocomplete="off"
						class="layui-input" style="padding-left: 25px">
				</div>
			</div>
			<div class="layui-form-item"
				style="text-align: center; margin-top: 25px;">
				<button type="submit" class="layui-btn layui-btn-radius" lay-submit
					lay-filter="formDemo">登&nbsp;&nbsp;录</button>
				<button type="reset" class="layui-btn layui-btn-radius">重&nbsp;&nbsp;置</button>
			</div>
			<!-- 				<div class="layui-form-item">
					<a href="" style="margin-left: 80px">忘记密码?</a><a href="register.html" style="margin-left: 100px">立即注册</a>
				</div> -->
		</div>
	</form>
</body>
</html>