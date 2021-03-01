<%@page import="dao.UsersDbTools"%>
<%@page import="vo.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
<title>个人中心</title>
<style type="text/css">
.container {
	width: 300px;
	height: 360px;
	position: absolute;
	left: 50%;
	top: 50%;
	padding: 24px;
	margin-left: -150px;
	margin-top: -180px;
	border-radius: 8px;
	background: #fff;
	color:#333;
	box-shadow: 0 3px 18px rgba(100, 0, 0, .5);
}


a{
	text-decoration:none;
}
</style>

</head>
<body>
<div class="container">
<% String userId = (String)session.getAttribute("userId"); %>
<% UsersDbTools usersDbTools = new UsersDbTools(); %>
<% User user = usersDbTools.getUser(userId); %>
<% usersDbTools.close(); %>
<header
	style="margin-top: 20px; margin-bottom: 20px; text-align: center">
	<fieldset class="layui-elem-field layui-field-title site-title"><legend><p>个人信息</p></legend></fieldset>
</header>
<br>&nbsp;姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名&nbsp;：<%=user.getUname() %><br><br>
&nbsp;学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号&nbsp;：<%=user.getUid() %><br><br>
&nbsp;手&nbsp;机&nbsp;号&nbsp;：<%=user.getUPhone() %><br><br>
&nbsp;邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱&nbsp;：<%=user.getUEmail() %><br><br>
注册时间：<%=user.getURegDate() %><br><br><br>
<a href="modifyMess.jsp">修改个人信息<img src="img/acx.png" style="width:28px; height:28px"/></a><br><br>
<a href="ModifyMess?index=3&id=<%=user.getUid() %>">修改密码<img src="img/acx.png"  style="width:28px; height:28px"/></a>
</div>
</body>
</html>