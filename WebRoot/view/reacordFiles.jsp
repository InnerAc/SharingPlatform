<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="/static/css/bootstrap.css" />
<script src="/static/js/jquery-2.1.4.js"></script>
<script src="/static/js/bootstrap.js"></script>

<title>资料归档</title>
</head>
<body>
	<div style="width:80%;margin:10%;" class="panel panel-primary" >
		<div class="panel-heading">
			<h1 class="panel-title" style="text-align:center">资料归档</h1>
		</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-md-2">年份选择：</div>
				<div class="col-md-3">
					<select class="form-control">
						<option>2012</option>
						<option>2013</option>
						<option>2014</option>
						<option>2015</option>
						<option>2016</option>
					</select>
				</div>
				<div class="col-md-2">要素选择：</div>
				<div class="col-md-3">
					<select class="form-control">
						<c:forEach items="${swyss}" var="swys">
							<option value="${swys.YSDM }">${swys.YSMC }</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-md-2">
					<button class="btn btn-default">筛选</button>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<h2 style="text-align:center">上一年站点</h2>
					<select multiple class="form-control" style="height:250px">
						<option>水文</option>
						<option>水资源</option>
						<option>防办</option>
						<option>河道局</option>
						<option>小湾</option>
					</select>
				</div>
				<div class="col-md-3">
					<h2 style="text-align:center">新增站点</h2>
					<select multiple class="form-control" style="height:250px">
						<option>水文</option>
						<option>水资源</option>
						<option>防办</option>
						<option>河道局</option>
						<option>小湾</option>
					</select>
					<div class="row" style="margin-top:10px">
						<div class="col-md-2"></div>
						<div class="col-md-3">
							<button class="btn btn-info">增加</button>
						</div>
						<div class="col-md-3">
							<button class="btn btn-danger">删除</button>
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<h2 style="text-align:center">去掉站点</h2>
					<select multiple class="form-control" style="height:250px">
						<option>水文</option>
						<option>水资源</option>
						<option>防办</option>
						<option>河道局</option>
						<option>小湾</option>
					</select>
					<div class="row" style="margin-top:10px">
						<div class="col-md-2"></div>
						<div class="col-md-3">
							<button class="btn btn-info">增加</button>
						</div>
						<div class="col-md-3">
							<button class="btn btn-danger">删除</button>
						</div>
					</div>
				</div>
				<div class="col-md-3">
				<center>
					<br>
					<br>
					<br>
					<br>
					<br>
					<button class="btn btn-info">确认</button>
					<br>
					<br>
					<button class="btn btn-danger">退出</button>
				</center>	
				</div>
			</div>
		</div>
	</div>
</body>
</html>