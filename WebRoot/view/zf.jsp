<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/static/css/bootstrap.css" />
<script src="/static/js/jquery-2.1.4.js"></script>
<script src="/static/js/zf.js"></script>
<title>水文要素资费维护</title>
</head>
<body>
	<div style="width:80%;margin:10%;">
	<div>
		<h1 style="text-align:center">水文要素资费维护</h1>
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
			<td edit="false" name="YSDM">${swys.YSDM }</td>
			<td edit="false" name="YSMC">${swys.YSMC }</td>
			<td edit="false" name="BM">${swys.BM }</td>
			<td edit="false" name="YSNR">${swys.YSNR }</td>
			<td edit="false" name="RQZD1">${swys.RQZD1 }</td>
			<td edit="false" name="RQZD2">${swys.RQZD2 }</td>
			<td edit="false" name="LX">${swys.LX }</td>
			<td edit="true" name="ZF">${swys.ZF }</td>
			<td edit="btn">
	        	<button onclick="zf_edit(this);">修改</button>
			</td>
        </tr>
        </c:forEach>
      </tbody>
	</table> 
	</div>
	</div>
	<script>
	</script>
</body>
</html>