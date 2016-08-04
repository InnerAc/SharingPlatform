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

<title>资料修改</title>
</head>
<body>
	<div style="width:80%;margin:10%;" class="panel panel-primary" >
		<div class="panel-heading">
			<h1 class="panel-title" style="text-align:center">资料修改</h1>
		</div>
		<div class="panel-body">
			<div class="row form-inline">
			<form action="" method="POST">
				申请单位：
				<input type="text" class="form-control" name="DW"/>
				申请人：
				<input type="text" class="form-control" name="XM"/>
				申请单号：
				<input type="text" class="form-control" name="XH"/>
				<input type="submit" class="btn btn-default" value="查询"/>
			</form>
			</div>
		</div>
	</div>
</body>
</html>