<%@page import="java.util.ArrayList"%>
<%@page import="vo.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title></title>
<link rel="stylesheet" href="layui/css/layui.css">
<script src="layui/layui.js"></script>

<style type="text/css">
.deleteButton {
	width: 55%;
	height: 90%;
	margin-top: 1%;
	margin-left: 5%;
}
</style>

</head>
<body>
	<form name="dataDemo" method="post">
		<table class="layui-hide" id="test" lay-filter="test"
			style="margin-top: 0px"></table>
	</form>

	<script type="text/html" id="barDemo">
		<input type="button" class="layui-btn layui-btn-danger layui-btn-xs deleteButton" name="{{d.bid}}" value="延期" lay-event="del">
	</script>
	
	<iframe id="hidden" style="width:0px; height:0px"></iframe>
	
	<script src="layui/layui.js" charset="utf-8"></script>
	<script>
		layui.use('table', function() {
			var table = layui.table;

			var tableIns = table.render({
				elem : '#test'
				,cols: [[
				         {field:'bid', title:'ID', fixed: 'left', unresize: true, sort: true}
				         ,{field:'bname', title:'书名'}
				         ,{field:'bauthor', title:'作者'}
				         ,{field:'bproductor', title:'出版社'}
				         ,{field:'bdeadline', title:'还书日期'}
				         ,{fixed : 'right',title : '操作',toolbar : '#barDemo',width : 160}
				         ]]
				     	,data: [<% ArrayList<Book> list = (ArrayList<Book>)session.getAttribute("rlist");%>
				     				<%if(list.size()!=0){%>
				     					{ "bcondition":"<%=list.get(0).getIsBorrowed() %>",
				     					  "bid":"<%=list.get(0).getBid() %>",
				   					  "bname":"<%=list.get(0).getBname() %>",
				   					  "bauthor":"<%=list.get(0).getBAuthor() %>",
				   					  "bproductor":"<%=list.get(0).getBProducter() %>",
				   					  "bdeadline":"<%=list.get(0).getBDeadLineDate() %>"
				   					  }
				     					<%for(int i=1;i<list.size();i++){%>
				     						,{  "bcondition":"<%=list.get(i).getIsBorrowed() %>",
				     							"bid": "<%=list.get(i).getBid() %>",
				   						  "bname": "<%=list.get(i).getBname() %>",
				   						  "bauthor":"<%=list.get(i).getBAuthor() %>",
				   						  "bproductor":"<%=list.get(i).getBProducter() %>",
					   					  "bdeadline":"<%=list.get(i).getBDeadLineDate() %>"
				     						}
				     					<%}%>		
				     				<%}%>
				     		]
				     	 ,text: {
				   	    none: '暂无相关数据' //默认：无数据。注：该属性为 layui 2.2.5 开始新增
				   	  }
				       ,page: true
			});
			
			//监听行工具事件
			table.on('tool(test)', function(obj) {
				var data = obj.data;
				if (obj.event === 'del') {
					var bid = this.name;
					layer.open({
						  content: '请选择延期时间',
						  area: ['340px', '170px'],
						  btnAlign: 'c',
						  btn: ['3天', '7天', '15天', '30天', '取消']
						  ,yes: function(index, layero){
						    //按钮【按钮一】的回调
						   	document.getElementById("hidden").src="RenewBook?index=3&bid="+bid;	
						    layer.close(index); 
						  }
						  ,btn2: function(index, layero){
						    //按钮【按钮二】的回调
						   	document.getElementById("hidden").src="RenewBook?index=7&bid="+bid;	
						  }
						  ,btn3: function(index, layero){
						    //按钮【按钮三】的回调
							document.getElementById("hidden").src="RenewBook?index=15&bid="+bid;
						  }
						  ,btn4: function(index, layero){
							    //按钮【按钮三】的回调
							document.getElementById("hidden").src="RenewBook?index=30&bid="+bid;
						  }
						  ,btn5: function(index, layero){
							    //按钮【按钮三】的回调
							    layer.msg('取消');	
						  }
						  ,cancel: function(){ 
						    //右上角关闭回调
						    layer.msg('close');	
						    //return false 开启该代码可禁止点击该按钮关闭
						  },end: function(){	
							  window.parent.document.getElementById('btabIframe2').src = 'QueryBCartOrRecord?index=2&id=201801020222';
						  }
					});
					
				}
			});
		});
	</script>


</body>
</html>