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
<script src="/static/js/files.js"></script>

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
					<select class="form-control" id="nfSelect">
						<option value="2011">2012</option>
						<option value="2012">2013</option>
						<option value="2013">2014</option>
						<option value="2014">2015</option>
						<option value="2015">2016</option>
					</select>
				</div>
				<div class="col-md-2">要素选择：</div>
				<div class="col-md-3">
					<select class="form-control" id="ysSelect">
						<c:forEach items="${swyss}" var="swys">
							<option value="${swys.YSDM }">${swys.YSMC }</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-md-2">
					<button class="btn btn-default" onclick="select();">筛选</button>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<h2 style="text-align:center">上一年站点</h2>
					<select multiple class="form-control" style="height:250px" id="old_sts">
					</select>
					<div class="row" style="margin-top:10px">
						<center>
						<button class="btn btn-warning" onclick="rmST();">去掉</button>
						</center>
					</div>
				</div>
				<div class="col-md-3">
					<h2 style="text-align:center">新增站点</h2>
					<select multiple class="form-control" style="height:250px" id="add_sts">
					</select>
					<div class="row" style="margin-top:10px">
						<div class="col-md-2"></div>
						<div class="col-md-3">
							<button class="btn btn-info" id="add" onclick="show(this);">增加</button>
						</div>
						<div class="col-md-3">
							<button class="btn btn-danger" id="add" onclick="rmClick(this);">删除</button>
						</div>
					</div>
					<div class="row" style="margin-top:10px;display:none;" id="add_show">
						<div class="col-md-8">
							<input id="add_st" type="text" class="form-control" placeholder="只输入测站代码"/>
						</div>
						<div class="col-md-4">
							<button class="btn btn-info"  id="add"  onclick="addClick(this)">确认</button>
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<h2 style="text-align:center">去掉站点</h2>
					<select multiple class="form-control" style="height:250px" id="dll_sts">
					</select>
					<div class="row" style="margin-top:10px">
						<div class="col-md-2"></div>
						<div class="col-md-3">
							<button class="btn btn-info" id="dll" onclick="show(this);">增加</button>
						</div>
						<div class="col-md-3">
							<button class="btn btn-danger" id="dll" onclick="rmClick(this);">删除</button>
						</div>
					</div>
					<div class="row" style="margin-top:10px;display:none;" id="dll_show">
						<div class="col-md-8">
							<input id="dll_st" type="text" class="form-control" placeholder="只输入测站代码"/>
						</div>
						<div class="col-md-4">
							<button class="btn btn-info"  id="dll"  onclick="addClick(this)">确认</button>
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