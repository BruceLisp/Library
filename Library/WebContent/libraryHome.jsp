<%@page import="dao.VarityDbtools"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.UsersDbTools"%>
<%@page import="vo.Varity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>东鹏图书管理</title>
<link rel="stylesheet" type="text/css" href="layui/css/layui.css"  media="all">
<style>
	#searchButton{
		width:70px;
		height:40px;
		background:#ff0000;
		border-radius:0px 20px 20px 0px; 
	}
	
	#searchDiv{
		width:430px; 
		height:35px; 
		line-height:30px; 
		margin:10px auto;  
	}
	
	#searchText{
		width:330px; 
		height:35px;
		border:solid #ff0000;
		border-radius:20px 0px 0px 20px; 
		text-align:center; 
	}
</style>

<% String userId = (String)session.getAttribute("userId"); %>

<script src="layui/layui.js" charset="utf-8"></script>
<script>
	layui.use('element', function() {
		var element=layui.element;
		element.on('nav(topToolBar)', function(elem) {
			var url = elem.attr('data-url');
			var id = elem.attr('data-id');
			if(id=='1'){
				document.getElementById("homeBody1").style.width="100%";
				document.getElementById("vlist").style.display="none";
				document.getElementById("homeBody1").style.display="";
				document.getElementById("homeBody2").style.display="none";
				document.getElementById("btabIframe").src=encodeURI(url);
			}
			if(id=='2'){
				document.getElementById("vlist").style.display="none";
				document.getElementById("homeBody1").style.display="none";
				document.getElementById("homeBody2").style.display="";
				document.getElementById("btabIframe2").src=encodeURI(url+'<%=userId %>');
			}
			if(id=='3'){
				document.getElementById("vlist").style.display="";
				document.getElementById("homeBody1").style.display="";
				document.getElementById("homeBody1").style.width="88%";
				document.getElementById("homeBody1").style.float="right";
				document.getElementById("homeBody2").style.display="none";
				document.getElementById("btabIframe").src=encodeURI(url);
			}
			if(id=='4'){
				document.getElementById("homeBody1").style.width="100%";
				document.getElementById("vlist").style.display="none";
				document.getElementById("homeBody1").style.display="none";
				document.getElementById("homeBody2").style.display="";
				document.getElementById("btabIframe2").src=encodeURI(url);
			}
		});
	});
	
</script>
<script>
	layui.use('form', function(){
	  	var form = layui.form; 
	  	form.on('submit(searchButton)', function(obj){
	  		document.getElementById("btabIframe").src=encodeURI('QueryBooks?index='+document.getElementById("searchText").value);
		    return false;
		});
	});
</script>

</head>
<body>
<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">
				<img src="img/name.png" style="width: 143%; margin-left: -10px;">
			</div>
			<ul class="layui-nav layui-layout-left" lay-filter="topToolBar">
				<li class="layui-nav-item"><a></a></li>
				<li class="layui-nav-item layui-this"><a data-id='1' data-url='QueryAllBooks?index=1' href="javascript:;">书城首页</a></li>
				<li class="layui-nav-item"><a href="javascript:;" data-id='3' data-url='QueryVarifyBooks?index=1'>图书分类</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="javascript:;" data-id='1' data-url='QueryVarifyBooks?index=1318' >计算机技术</a>
						</dd>
						<dd>
							<a href="javascript:;" data-id='1' data-url='QueryVarifyBooks?index=1001' >武侠小说</a>
						</dd>
						<dd>
							<a href="javascript:;" data-id='1' data-url='QueryVarifyBooks?index=1201' >社会科学</a>
						</dd>
					</dl>
				</li>
				<li class="layui-nav-item"><a href="javascript:;" data-id='2' data-url='QueryBCartOrRecord?index=1&id='>预借记录</a></li>
				<li class="layui-nav-item"><a href="javascript:;" data-id='2' data-url='QueryBCartOrRecord?index=2&id='>借书记录</a></li>
			</ul>
			
			<% 	if(userId.equals("")){%>
					<ul class="layui-nav layui-layout-right">
					<li class="layui-nav-item"><a href="ULoginConfirm?index=1">登录</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="javascript:;">用户登录</a>
						</dd>
						<dd>
							<a href="managerLogin.jsp">管理员登录</a>
						</dd>
					</dl>
					</li>
					<li class="layui-nav-item"><a href="URegisterConfirm?index=2">注册</a></li>
					</ul>3
			<% }else{ %>
			<% UsersDbTools usersDbTools = new UsersDbTools(); %>
				<ul class="layui-nav layui-layout-right" lay-filter="topToolBar">
					<li class="layui-nav-item"><a href="javascript:;" data-id='4' data-url='userMessage.jsp'> <img
							src="http://imgsrc.baidu.com/forum/w=580/sign=a9714efaaf86c91708035231f93c70c6/ddd3ab59d109b3dea0394e6ac4bf6c81810a4c48.jpg"
							class="layui-nav-img"><%=usersDbTools.getUser(userId).getUname()%></a></li>
					<li class="layui-nav-item"><a href="ULoginConfirm?index=3">退出</a></li>
				</ul>
			<%} %>
		</div>
</div>
<div id="homeBody1">
	<div id="searchDiv">
		<form class="layui-form" action="" method="post"> 
			<input type="text" id="searchText" placeholder="请输入书名、ID者作者名" value="" name="searchText" />
			<button lay-filter="searchButton" lay-submit id="searchButton" class="layui-btn layui-btn-danger">搜索</button>
		</form>
	</div>
	<div style="width:98%; height:600px; margin:auto">
		<iframe src="QueryAllBooks?index=1" name="main" 
		width="100%" height="100%" id="btabIframe" frameborder="0" scrolling="yes"></iframe>
	</div>
</div>
<div id="homeBody2" style="display:none">
	<div style="width:98%; height:600px; margin:auto">
		<iframe src="QueryBCartOrRecord?index=1&id=201801020222" name="main" 
		width="100%" height="100%" id="btabIframe2" frameborder="0" scrolling="yes"></iframe>
	</div>
</div>
<%  VarityDbtools varityDbtools = new VarityDbtools();	%>
<% 	ArrayList<Varity> vList = varityDbtools.selectVarity();%>
<div id="vlist" style="display:none" >
	<ul class="layui-nav layui-nav-tree" lay-shrink="all" lay-filter="topToolBar">
	<% for(Varity v : vList){%>
		 <li class="layui-nav-item layui-nav-itemed">
		 	<a href="javascript:;"><%=v.getName() %></a>
		    <% if(v.getId()<15){%>
		    	<dl class="layui-nav-child">
			    <% ArrayList<Varity> vsList = varityDbtools.selectVarities(v.getId()); %>
			    <% for(Varity vs : vsList){%>
			    	<dd><a href="javascript:;" data-id='3' data-url='QueryVarifyBooks?index=<%=vs.getId()%>' ><%=vs.getName() %></a></dd>
			    <% } %>				      
		    	</dl>
		    <% }%>
		 </li>
	<% } %>
	</ul>
</div>

</body>
</html>