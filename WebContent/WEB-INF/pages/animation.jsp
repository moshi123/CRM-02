<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/common.jsp"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>Animation Tree - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="${ctp }/static/jquery/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctp}/static/jquery/themes/icon.css">
	<script type="text/javascript" src="${ctp }/static/jquery/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="${ctp }/static/jquery/jquery.easyui.min.js"></script>
</head>
<body>
	<div style="margin:10px 0;"></div>
	<ul class="easyui-tree" data-options="url:'${ctp}/commons/tree_crm.json',method:'get',animate:true"></ul>
</body>
</html>