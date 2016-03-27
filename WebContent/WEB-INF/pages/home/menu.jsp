<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/common.jsp"%>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${ctp }/static/jquery/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctp}/static/jquery/themes/icon.css">
	<script type="text/javascript" src="${ctp }/static/jquery/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="${ctp }/static/jquery/jquery.easyui.min.js"></script>
	<script type="text/javascript">
	  $(function(){
		$('#tt').tree({
			onClick: function(node){
			//alert(node.text);  // 在用户点击的时候提示
				//node 即为当前被点击的节点. 	且 node 为 JSON 对象
				//text 是每个 node 的必备属性. 所以可以直接点击. 而 attributes.url 不一定存在, 所以需要先判断一下. 
				 if(node.attributes.url){
					//alert(node.attributes.url);
					//使当前窗口的父窗口的 id="content" 的 src 属性等于当前的 url
					window.parent.document.getElementById("content").src = "${ctp}" + node.attributes.url;
				} 
			}
		});
	})
	
	</script>
</head>
<body link="#FFFFFF" marginwidth="1" marginheight="1" onResize="frameResized();" topmargin="0" leftmargin="0" bgcolor="#C4E1FF">
	<div style="margin:10px 0;"></div>
	<ul  id="tt"  class="easyui-tree" data-options="url:'${ctp}/commons/tree_crm.json',method:'get',animate:true"></ul>
</body>
</html>