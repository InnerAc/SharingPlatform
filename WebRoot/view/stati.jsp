<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/static/css/bootstrap.css" />
<script src="/static/js/jquery-2.1.4.js"></script>
<title>资料使用情况统计</title>
</head>
<body>
	<div style="width:80%;margin:10%;" class="panel panel-primary" >
		<div class="panel-heading">
			<h1 class="panel-title" style="text-align:center">资料使用情况统计</h1>
		</div>
		<div class="panel-body">
			<form class="form-inline">
				<div class="form-group">
					<label for="exampleInputName2">输入年份</label>
					<input type="text" name="year" class="form-control" placeholder="2016"/>
				</div>
				<button type="submit" class="btn btn-default">查询</button>
			</form>
			<br>
			<table class="table table-bordered table-hover">
				<thead>
		        <tr>
					<th> </th>
					<th>申请数</th>
					<th>资费额</th>
		        </tr>
		      </thead>
		      <tbody>
		        <tr>
					<th>内部</th>
					<td>${inner }</td>
					<td>${innerZF }</td>
		        </tr>
		        <tr>
					<th>外部</th>
					<td>${outer }</td>
					<td>${outerZF }</td>
		        </tr>
		        <tr>
					<th>合计</th>
					<td>${all }</td>
					<td>${allZF }</td>
		        </tr>
		      </tbody>
			</table> 
		</div>
	</div>
</body>
</html>