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
	height: 290px;
	position: absolute;
	left: 50%;
	top: 50%;
	margin-left: -190px;
	margin-top: -145px;
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
<%String userId = (String)session.getAttribute("userId"); %>
</head>
<body>
	<div class="container">
		<form class="layui-form" action="ModifyMess" method="post">
			<input name="index" value="2" type="hidden"/>
			<input name="id" value="<%=userId %>" type="hidden"/>
			<header
				style="margin-top: 20px; margin-bottom: 20px; text-align: center">
				<fieldset class="layui-elem-field layui-field-title site-title"><legend><p>修改密码</p></legend></fieldset>
			</header>
			<div class="layui-form-item">
				<label class="layui-form-label">原始密码：</label>
				<div class="layui-input-inline">
					<input type="password" id="oldPass" name="oldPass" required
					 placeholder="请输入原始密码" autocomplete="off"
						class="layui-input"/>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">新密码：</label>
				<div class="layui-input-inline">
					<input type="password" id="password" name="password" required
						lay-verify="password" placeholder="请输入新密码" autocomplete="off"
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
			<p style="text-align: center; color:#ff0000 
			<% String index = "true";
			   index = (String)session.getAttribute("mindex");
			   if(index.equals("true")){
				   out.print(";visibility:hidden");
			   }%>
			">原始密码错误，请重试！</p>
			<div class="layui-form-item" style="text-align: center;  margin-top:0px">
				<button type="submit" class="layui-btn layui-btn-radius"  lay-submit lay-filter="formDemo">修&nbsp;&nbsp;改</button>
				<button type="reset" class="layui-btn layui-btn-radius">重&nbsp;&nbsp;置</button>
			</div>
			<div class="layui-form-item">  
		</form>
	</div>
</body>



</html>