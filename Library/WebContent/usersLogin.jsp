<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>登录界面</title>
<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
<style type="text/css">
body {
	background:#e7e7e7 ;
 	background: #e7e7e7 url('img/logo.png');
}

.container {
	width: 400px;
	height: 290px;
	position: absolute;
	left: 50%;
	top: 50%;
	margin-left: -200px;
	margin-top: -155px;
	border-radius: 8px;
	background: #fff;
	box-shadow: 0 3px 18px rgba(100, 0, 0, .5);
}
</style>
<script src="layui/layui.js"></script>
<script>
</script>
</head>

<body>
	<div class="container">
		<form class="layui-form" method="post" action="ULoginConfirm">
			<input name="index" value="2" type="hidden" />
			<header
				style="margin-top: 20px; margin-bottom: 20px; text-align: center">
				<fieldset class="layui-elem-field layui-field-title"><legend><p>用户登录</p></legend></fieldset>
			</header>
			<div class="layui-form-item">
				<label class="layui-form-label">用户名</label>
				<div class="layui-input-inline ">
					<i class="layui-icon layui-icon-username"
						style="font-size: 20px; position: absolute; margin-top: 9px; margin-left: 5px"></i>
					<input type="text" name="username" lay-verify="required" required
						autocomplete="off" placeholder="请输入用户名" class="layui-input"
						style="padding-left: 26px">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">密&nbsp;&nbsp;&nbsp;&nbsp;码</label>
				<div class="layui-input-inline">
					<i class="layui-icon layui-icon-password"
						style="font-size: 20px; position: absolute; margin-top: 9px; margin-left: 5px"></i>
					<input type="password" name="password" required
						lay-verify="required" placeholder="请输入密码" autocomplete="off"
						class="layui-input" style="padding-left: 26px">
				</div>
			</div>
			<p style="text-align: center; color:#ff0000 
			<% String index = "true";
			   index = (String)session.getAttribute("index");
			   if(index.equals("true")){
				   out.print(";visibility:hidden");
			   }%>
			">用户名或密码错误，请重试！</p>
			<div class="layui-form-item" style="text-align: center; margin-top:10px">
				<button type="submit" class="layui-btn layui-btn-radius"  lay-submit lay-filter="formDemo">登&nbsp;&nbsp;录</button>
				<button type="reset" class="layui-btn layui-btn-radius">重&nbsp;&nbsp;置</button>
			</div>
		</form>	
		<div>
				<a href="" style="margin-left: 80px">忘记密码?</a>
				<a href="URegisterConfirm?index=2" style="margin-left: 110px">注册账号</a>
		</div>
	</div>	
</body>
</html>