<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>用户注册</title>
<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
<style type="text/css">
body {
	background:#e7e7e7 ;
 	background: #e7e7e7 url(' img/logo.png');
}

.container {
	width: 380px;
	height: 480px;
	position: absolute;
	left: 50%;
	top: 50%;
	margin-left: -190px;
	margin-top: -240px;
	border-radius: 8px;
	background: #fff;
	box-shadow: 0 3px 18px rgba(100, 0, 0, .5);
}
</style>
<script src="layui/layui.js"></script>
<script>
layui.use('form', function() {
	var form = layui.form;
	form.verify({
		id:function(value){
			if(value.length!=12){
				return '学号格式不正确';
			}
		},
		username:function(value){
			if(value.length>6){
				return '用户名过长';
			}
		},
		password:[/^[\S]{6,12}$/,'密码必须6到12位，且不能出现空格'],
		confirmpass:function(value){
			$=layui.jquery;
			var password1=$('#password').val();
			if(password1!=value){
				return '两次密码输入不一致';
			}
		}	    
	});
	form.on('submit(formDemo)', function(data) {
		return true;
	});
});
</script>

</head>
<body>
	<div class="container">
		<form class="layui-form" action="URegisterConfirm" method="post">
			<input name="index" value="1" type="hidden"/>
			<header
				style="margin-top: 10px; margin-bottom: 20px; text-align: center">
				<fieldset class="layui-elem-field layui-field-title site-title"><legend><p>用户注册</p></legend></fieldset>
			</header>
			<div class="layui-form-item">
				<label class="layui-form-label">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</label>
				<div class="layui-input-inline ">
					<input type="text" id="id" name="id" lay-verify="required|id" 
						autocomplete="off" placeholder="请输入学号" class="layui-input"/>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">用&nbsp;&nbsp;户&nbsp;&nbsp;名：</label>
				<div class="layui-input-inline ">
					<input type="text" id="username" name="username" lay-verify="required|username" 
						autocomplete="off" placeholder="请输入你的名字" class="layui-input"/>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
				<div class="layui-input-inline">
					<input type="password" id="password" name="password" required
						lay-verify="password" placeholder="请输入密码" autocomplete="off"
						class="layui-input"/>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">确认密码：</label>
				<div class="layui-input-inline">
					<input type="password" name="confirmpass" id="confirmpass" required
						lay-verify="password|confirmpass" placeholder="请输入确认密码" autocomplete="off"
						class="layui-input" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">手机号码：</label>
				<div class="layui-input-inline">
					<input type="text" name="phone" id="phone"
						lay-verify="phone" placeholder="请输入手机号码" autocomplete="off"
						class="layui-input" />
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
			<p style="text-align: center; color:#ff0000
			<% String index = "true";
			   index = (String)session.getAttribute("rindex");
			   if(index.equals("true")){
				   out.print(";visibility:hidden");
			   }%>
			">手机号或者学号已被注册！请重试！</p>
			<div class="layui-form-item" style="text-align: center;  margin-top:10px">
				<button type="submit" class="layui-btn layui-btn-radius"  lay-submit lay-filter="formDemo">注&nbsp;&nbsp;册</button>
				<button type="reset" class="layui-btn layui-btn-radius">重&nbsp;&nbsp;置</button>
			</div>
			<div class="layui-form-item">
		</form>
		<a href="ULoginConfirm?index=1" style="margin-left: 310px">用户登录</a>
	</div>
</body>



</html>