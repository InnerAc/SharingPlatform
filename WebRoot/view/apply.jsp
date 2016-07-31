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

<link href="/static/css/bootstrap-multiselect.css" rel="stylesheet"/>
<script src="/static/js/bootstrap-multiselect.js"></script>

<link rel="stylesheet" type="text/css" href="/static/css/apply.css" />

<title>资料申请</title>
</head>
<body>
	<div style="width:80%;margin:10%;" class="panel panel-primary">
		<div class="panel-heading">
			<h1 class="panel-title" style="text-align:center">资料申请</h1>
		</div>
		<div class="panel-body">
			<div class="row form-inline">
				申请单位：
				<input type="text" class="form-control" id=""/>
				申请人：
				<input type="text" class="form-control" id=""/>
				联系方式：
				<input type="text" class="form-control" id=""/>
			</div>
			<div class="row form-inline hang">
				资料用途：
				<textarea class="form-control" rows="3" ></textarea>
			</div>
			<div class="row form-inline hang">
				<div class="col-md-6">
					要素选择：
					<select class="form-control">
						<option>哈哈哈哈</option>
						<option>嘿嘿嘿嘿</option>
						<option>吼吼吼吼</option>
					</select>
				</div>
				<div class="col-md-3">
					<button class="btn btn-default" >站点选择</button>
				</div>
				<div class="col-md-3">
					<button class="btn btn-default" >时段选择</button>
				</div>
			</div>
			<div class="row hang">
				<table class="table table-bordered table-hover">
					<thead>
			        <tr>
						<th>选中</th>
						<th>要素</th>
						<th>测站</th>
						<th>起始时间</th>
						<th>终止时间</th>
			        </tr>
			      </thead>
			      <tbody  id="new_item">
			      	
			        <tr>
			        	<td>
			        		 <input type="checkbox" id="blankCheckbox" value="option1" >
			        	</td>
						<td name="BSHNCD">哈哈</td>
						<td name="HNNM">嘿嘿</td>
						<td name="RVNM">吼吼</td>
						<td name="RVNM">吼吼</td>
			        </tr>
			        
			        <tr>
			        	<td>
			        		 <input type="checkbox" id="blankCheckbox" value="option1" >
			        	</td>
						<td name="BSHNCD">黄河流域</td>
						<td name="HNNM">长江水系</td>
						<td name="RVNM">黑龙江</td>
						<td name="RVNM">黑龙江</td>
			        </tr>
			        
			      </tbody>
				</table> 

			</div>
			<div class="row hang">
				<div class="col-md-3">
					<button class="btn btn-primary">增加</button>
				</div>
				<div class="col-md-3">
					<button class="btn btn-danger">删除</button>
				</div>
				<div class="col-md-3">
					<button class="btn btn-warning">取消</button>
				</div>
				<div class="col-md-3">
					<button class="btn btn-success">提交申请</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 站点筛选 -->
	<div class="panel panel-success" style="width:50%;margin:25%;">
		<div class="panel-heading">
			<h3 class="panel-title">站点筛选</h3>
		</div>
		<div class="panel-body">
		<div>
			流域：
			<select id="liuyuSelect" multiple="multiple">
			    <option value="cheese">Cheese</option>
			    <option value="tomatoes">Tomatoes</option>
			    <option value="mozarella">Mozzarella</option>
			    <option value="mushrooms">Mushrooms</option>
			    <option value="pepperoni">Pepperoni</option>
			    <option value="onions">Onions</option>
			</select>
			行政区划：
			<select id="xzqSelect" multiple="multiple">
			    <option value="cheese">Cheese</option>
			    <option value="tomatoes">Tomatoes</option>
			    <option value="mozarella">Mozzarella</option>
			    <option value="mushrooms">Mushrooms</option>
			    <option value="pepperoni">Pepperoni</option>
			    <option value="onions">Onions</option>
			</select>
			<button class="btn btn-success">筛选</button>
		</div>
		<div></div>
		</div>
	</div>
	<script type="text/javascript">
	    $(document).ready(function() {
	        $('#liuyuSelect').multiselect({
				includeSelectAllOption: true,
				enableFiltering: true
	        });
	        $('#xzqSelect').multiselect({
				includeSelectAllOption: true,
				enableFiltering: true
	        });
	    });
</script>
</body>
</html>