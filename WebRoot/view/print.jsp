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

<link rel="stylesheet" type="text/css" href="/static/css/print.css" />
<script src="/static/js/print/jspdf.min.js"></script>
<script src="/static/js/print/html2pdf.js"></script>

<title>资料申请</title>
</head>
<body>
	<div id ="applyTable" style="width:90%;margin:5%;" class="panel panel-primary" >
		<div class="panel-heading">
			<h1 class="panel-title" style="text-align:center">江苏省水文资料申请单</h1>
		</div>
		<div class="panel-body" id="iii">
			<div class="row">
				<div class="col-md-9 print_neirong">
					<h1 style="text-align:center">江苏省水文资料申请单</h1>
					<div class="row print_content font_center">
						<div class="col-md-3 cell_left">
							资料使用单位
						</div>
						<div class="col-md-3 cell_left">
							${sqb.DW }
						</div>
						<div class="col-md-3 cell_left">
							申请人
						</div>
						<div class="col-md-3 cell_right">
							${sqb.XM }
						</div>
					</div>
					<div class="row print_content font_center">
						<div class="col-md-3 cell_left">
							申请日期
						</div>
						<div class="col-md-3 cell_left">
							${sqb.RQ }
						</div>
						<div class="col-md-3 cell_left">
							联系方式
						</div>
						<div class="col-md-3 cell_right">
							${sqb.DH }
						</div>
					</div>
					<div class="row print_content">
						<div class="col-md-12 cell_right">
							资料内容
						</div>
					</div>
					<div class="row print_content font_center">
						<div class="col-md-3 cell_left">
							要素名
						</div>
						<div class="col-md-3 cell_left">
							站点编号+站点名
						</div>
						<div class="col-md-6 cell_right">
							起止日期
						</div>
						<c:forEach items="${sqnrbs}" var="sqnrb">
							<div class="col-md-3 cell_left">
								${sqnrb.YSMC }
							</div>
							<div class="col-md-3 cell_left">
								${sqnrb.STINFO }
							</div>
							<div class="col-md-6 cell_right">
								${sqnrb.QSRQ } - ${sqnrb.ZZRQ }
							</div>
						</c:forEach>
					</div>
					<div class="row print_content">
						<div class="col-md-12 cell_right">
							<strong>资料用途：</strong>
							${sqb.ZLYT }
						</div>
					</div>
					<div class="row print_content">
						<div class="col-md-12 cell_right">
							<strong>资料使用部门意见：</strong>
						</div>
						<div class="col-md-12 cell_midd">
							<br>
							<br>
							<br>
							<div class="col-md-7">
							</div>
							<strong>负责人签字：</strong>
						</div>
					</div>
					<div class="row print_content">
						<div class="col-md-12 cell_right">
							<strong>局领导指示和会办意见：</strong>
						</div>
						<div class="col-md-12 cell_midd">
							<br>
							<br>
							<br>
							<br>
							<br>
							<br>
						</div>
					</div>
					<div class="row print_content">
						<div class="col-md-6 cell_left cell_bottom">
							资料提供人签字：
						</div>
						<div class="col-md-6 cell_right cell_bottom">
							资料接受人签字：
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="row font_center" >
						<br><br>
						<div class="col-md-12">
							<h3>资费额：${sqb.ZF }</h3>
						</div>
					</div>
					<br><br><br>
					<div class="row font_center" >
						<a href="/apply/download/${sqb.XH }" class="btn btn-primary" >打印</a>
					</div>
					<br><br>
					<div class="row font_center" >
						<a class="btn btn-warning" href="/">退出</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>