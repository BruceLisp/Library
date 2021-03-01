<%@page import="java.util.ArrayList"%>
<%@page import="vo.Book"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>Layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" type="text/css" href="layui/css/layui.css"  media="all">
</head>
<body>
 
<table class="layui-hide" id="test" lay-filter="test"></table>
<iframe id="hidden" style="width:0px; height:0px"></iframe>
<script type="text/html" id="checkboxTpl">
	<input type="checkbox" name="condition" class="condition" value="{{d.bid}}" title="{{ d.bcondition == 1 ? '预借' : '已借' }}" 
	lay-filter="lockDemo" {{ d.bcondition == 1 & d.userId != '' ? 'checked' : 'disabled' }}>
</script>
              
          
<script src="layui/layui.all.js" charset="utf-8"></script>

<script>
layui.use(['table','form'], function(){
  var table = layui.table;
  var form = layui.form;
  
  table.render({
    elem: '#test'
    ,cols: [[
      {field:'bid', title:'ID', fixed: 'left', unresize: true, sort: true}
      ,{field:'bname', title:'书名'}
      ,{field:'bauthor', title:'作者'}
      ,{field:'bproductor', title:'出版社'}
      ,{field:'lock', title:'是否预借', width:110, templet: '#checkboxTpl', unresize: true}
      ,{field:'bcondition', title:'',hide:true}
      ,{field:'userId', title:'',hide:true}
      ]]
  	,data: [<% ArrayList<Book> list = (ArrayList<Book>)session.getAttribute("list");%>
  				<%if(list.size()!=0){%>
  					{ "bcondition":"<%=list.get(0).getIsBorrowed() %>",
  					  "bid":"<%=list.get(0).getBid() %>",
					  "bname":"<%=list.get(0).getBname() %>",
					  "bauthor":"<%=list.get(0).getBAuthor() %>",
					  "bproductor":"<%=list.get(0).getBProducter() %>",
					  "userId":"<%=session.getAttribute("userId") %>"
					  }
  					<%for(int i=1;i<list.size();i++){%>
  						,{  "bcondition":"<%=list.get(i).getIsBorrowed() %>",
  							"bid": "<%=list.get(i).getBid() %>",
						  "bname": "<%=list.get(i).getBname() %>",
						  "bauthor":"<%=list.get(i).getBAuthor() %>",
						  "bproductor":"<%=list.get(i).getBProducter() %>",
						  "userId":"<%=session.getAttribute("userId") %>"						  
  						}
  					<%}%>		
  				<%}%>
  		]
  	 ,text: {
	    none: '暂无相关数据' //默认：无数据。注：该属性为 layui 2.2.5 开始新增
	  }
    ,page: true
  });

	form.on('checkbox(lockDemo)', function(obj){	
  		if(obj.elem.checked){
  			layer.msg("该书已经被预借或被借出");
        }else{
        	obj.elem.title="已借";
        	document.getElementById("hidden").src="ChangeCondition?bid="+this.value+"&id=<%=session.getAttribute("userId") %>";
        	obj.elem.disabled=true;
        }
        form.render('checkbox'); //更新复选框
	    return true;
	}); 
	
});

</script>

</body>
</html>