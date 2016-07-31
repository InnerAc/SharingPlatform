<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/static/css/bootstrap.css" />
<script src="/static/js/jquery-2.1.4.js"></script>
<script src="/static/js/xzqdm.js"></script>
<title>行政区代码表维护</title>
</head>
<body>
	<div style="width:80%;margin:10%;">
	<div>
		<h1 style="text-align:center">行政区代码表维护</h1>
	</div>
	<div>
	<table class="table table-bordered table-hover">
		<thead>
        <tr>
			<th>行政区代码</th>
			<th>行政区名称</th>
			<th>操作</th>
        </tr>
      </thead>
      <tbody  id="new_item">
      	<c:forEach items="${xzqdms}" var="xzqdm">
        <tr>
			<td edit="false" name="ADDVCD">${xzqdm.ADDVCD }</td>
			<td edit="true" name="XZQMC">${xzqdm.XZQMC }</td>
			<td edit="btn">
	        	<button onclick="xzq_edit(this);">编辑</button>
	        	<button onclick="xzq_drop(this)">删除</button>
			</td>
        </tr>
        </c:forEach>
      </tbody>
	</table> 
	</div>
	<button onclick="xzq_add()" style="float:right;">添加</button>
	</div>
</body>
</html>