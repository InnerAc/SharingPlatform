<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/static/css/bootstrap.css" />
<script src="/static/js/jquery-2.1.4.js"></script>
<script src="/static/js/swys.js"></script>
<title>水文要素维护</title>
</head>
<body>
	<div style="width:80%;margin:10%;">
	<div>
		<h1 style="text-align:center">水文要素维护</h1>
	</div>
	<div>
	<table class="table table-bordered table-hover">
		<thead>
        <tr>
			<th>要素代码</th>
			<th>要素名称</th>
			<th>所在数据表</th>
			<th>要素内容</th>
			<th>日期字段1</th>
			<th>日期字段2</th>
			<th>日期类型</th>
			<th>资费</th>
			<th>操作</th>
        </tr>
      </thead>
      <tbody  id="new_item">
      	<c:forEach items="${swyss}" var="swys">
        <tr>
			<td edit="true" name="YSDM">${swys.YSDM }</td>
			<td edit="true" name="YSMC">${swys.YSMC }</td>
			<td edit="true" name="BM">${swys.BM }</td>
			<td edit="true" name="YSNR">${swys.YSNR }</td>
			<td edit="true" name="RQZD1">${swys.RQZD1 }</td>
			<td edit="true" name="RQZD2">${swys.RQZD2 }</td>
			<td edit="true" name="LX">${swys.LX }</td>
			<td edit="false" name="ZF">${swys.ZF }</td>
			<td edit="btn">
	        	<button onclick="i_edit(this);">编辑</button>
	        	<button onclick="i_drop(this)">删除</button>
			</td>
        </tr>
        </c:forEach>
      </tbody>
	</table> 
	</div>
	<button onclick="i_add()" style="float:right;">添加</button>
	</div>
	<script>
		//getAllSwys();
	</script>
</body>
</html>