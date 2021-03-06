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
<script src="/static/js/util.js"></script>
<script src="/static/js/applyedit.js"></script>

<title>资料申请</title>
</head>
<body>
	<div id ="applyTable" style="width:80%;margin:10%;" class="panel panel-primary" >
		<div class="panel-heading">
			<h1 class="panel-title" style="text-align:center">资料申请</h1>
		</div>
		<div class="panel-body">
			<div class="row form-inline">
				申请单位：
				<input type="text" class="form-control" id="DW" value="${sqb.DW}"/>
				申请人：
				<input type="text" class="form-control" id="XM" value="${sqb.XM}"/>
				联系方式：
				<input type="text" class="form-control" id="DH" value="${sqb.DH}"/>
			</div>
			<div class="row form-inline hang">
				资料用途：
				<textarea class="form-control" rows="3" id="ZLYT">${sqb.ZLYT }</textarea>
			</div>
			<div class="row form-inline hang">
				<div class="col-md-6">
					要素选择：
					<select class="form-control" id="yaosuxuanze">
						<c:forEach items="${swyss}" var="swys">
							<option>${swys.YSDM },${swys.YSMC },${swys.LX }</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-md-3">
					<button class="btn btn-default" onclick="stClick();">站点选择</button>
				</div>
				<div class="col-md-3">
					<button class="btn btn-default" onclick="dateClick();">时段选择</button>
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
			      <tbody  id="yaosuneirong">
			        <c:forEach items="${sqnrbs}" var="sqnrb">
					<tr>
			        	<td><input type="checkbox" /></td>
						<td name="YSDM">${sqnrb.YSDM },${sqnrb.YSMC },${sqnrb.LX }</td>
						<td name="STCD">${sqnrb.STINFO }</td>
						<td name="QSRQ">${sqnrb.QSRQ }</td>
						<td name="ZZRQ">${sqnrb.ZZRQ }</td>
			        </tr>
					</c:forEach>
			      </tbody>
				</table> 

			</div>
			<div class="row hang">
				<div class="col-md-3">
					<button class="btn btn-primary" onclick="addTR();">增加</button>
				</div>
				<div class="col-md-3">
					<button class="btn btn-danger" onclick="rmTR();">删除</button>
				</div>
				<div class="col-md-3">
					<a class="btn btn-warning" href="/" >取消</a>
				</div>
				<div class="col-md-3">
					<button class="btn btn-success" onclick="commitALL();">提交申请</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 站点筛选 -->
	<div id="stSelect" class="panel panel-success" style="width:50%;margin:10% 25% auto 25%;display:none;">
		<div class="panel-heading">
			<h3 class="panel-title">站点筛选</h3>
		</div>
		<div class="panel-body">
		<div>
			流域：
			<select id="liuyuSelect" multiple="multiple">
			   <c:forEach items="${hlmcs}" var="hlmc">
					<option value="${hlmc.BSHNCD }">${hlmc.BSHNCD }</option>
				</c:forEach>
			</select>
			行政区划：
			<select id="xzqSelect" multiple="multiple">
			    <c:forEach items="${xzqdms}" var="xzqdm">
					<option value="${xzqdm.ADDVCD }" >${xzqdm.XZQMC }</option>
				</c:forEach>
			</select>
			<button class="btn btn-success" onclick="stSelectClick();">筛选</button>
		</div>
		<div class="hang">
			<table class="table table-bordered table-hover">
				<thead>
		        <tr>
					<th>选中</th>
					<th>站点代码</th>
					<th>站点名称</th>
		        </tr>
		      </thead>
		      <tbody  id="zhandianneirong">
		        <tr>
		        	<td><input type="checkbox" /></td>
					<td name="STCD"></td>
					<td name="STNM"></td>
		        </tr>
		      </tbody>
			</table>
		</div>
		<div>
			<button class="btn btn-warning" onclick="selectAll();">全选</button>
			<button class="btn btn-danger" onclick="showTable();">退出</button>
			<button class="btn btn-success" onclick="commitST();" >确认</button>
		</div>
		</div>
	</div>
	
	<!-- 日期选择 -->
	<div id="dateSelect" class="panel panel-success" style="width:50%;margin:10% 25% auto 25%;display:none;">
		<div class="panel-heading">
			<h3 class="panel-title">日期选择</h3>
		</div>
		<div class="panel-body">
			<div class="row">
			<div class="col-xs-3">起始时间：</div>
			<div class="col-xs-2" id="div_st_year">
				<select class="form-control" id="st_year">
				  <option>2011</option>
				  <option>2012</option>
				  <option>2013</option>
				  <option>2014</option>
				  <option>2015</option>
				</select>
			</div>
			<div class="col-xs-1">
				年
			</div>
			<div class="col-xs-3" id="div_st_month" style="display:none;">
				<div class="col-xs-8">
				<select class="form-control" id="st_month">
				  <option>01</option>
				  <option>02</option>
				  <option>03</option>
				  <option>04</option>
				  <option>05</option>
				  <option>06</option>
				  <option>07</option>
				  <option>08</option>
				  <option>09</option>
				  <option>10</option>
				  <option>11</option>
				  <option>12</option>
				</select>
				</div>
				<div class="col-xs-4">
					月
				</div>
			</div>
			<div class="col-xs-3" id="div_st_day" style="display:none;">
				<div class="col-xs-8">
				<select class="form-control" id="st_day">
					<option>01</option>
					<option>02</option>
					<option>03</option>
					<option>04</option>
					<option>05</option>
					<option>06</option>
					<option>07</option>
					<option>08</option>
					<option>09</option>
					<option>10</option>
					<option>11</option>
					<option>12</option>
					<option>13</option>
					<option>14</option>
					<option>15</option>
					<option>16</option>
					<option>17</option>
					<option>18</option>
					<option>19</option>
					<option>20</option>
					<option>21</option>
					<option>22</option>
					<option>23</option>
					<option>24</option>
					<option>25</option>
					<option>26</option>
					<option>27</option>
					<option>28</option>
					<option>29</option>
					<option>30</option>
					<option>31</option>
				</select>
				</div>
				<div class="col-xs-4">
					日
				</div>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-xs-3"></div>
			<div class="col-xs-3" id="div_st_hour" style="display:none;">
				<div class="col-xs-8">
				<select class="form-control" id="st_hour">
				</select>
				</div>
				<div class="col-xs-4">
					时
				</div>
			</div>
			<div class="col-xs-3" id="div_st_minute" style="display:none;">
				<div class="col-xs-8">
				<select class="form-control" id="st_minute">
				</select>
				</div>
				<div class="col-xs-4">
					分
				</div>
			</div>
		</div>
		<br><br>
				<div class="row">
			<div class="col-xs-3">终止时间：</div>
			<div class="col-xs-2" id="div_en_year">
				<select class="form-control" id="en_year">
				  <option>2011</option>
				  <option>2012</option>
				  <option>2013</option>
				  <option>2014</option>
				  <option>2015</option>
				</select>
			</div>
			<div class="col-xs-1">
				年
			</div>
			<div class="col-xs-3" id="div_en_month" style="display:none;">
				<div class="col-xs-8">
				<select class="form-control" id="en_month">
				  <option>01</option>
				  <option>02</option>
				  <option>03</option>
				  <option>04</option>
				  <option>05</option>
				  <option>06</option>
				  <option>07</option>
				  <option>08</option>
				  <option>09</option>
				  <option>10</option>
				  <option>11</option>
				  <option>12</option>
				</select>
				</div>
				<div class="col-xs-4">
					月
				</div>
			</div>
			<div class="col-xs-3" id="div_en_day" style="display:none;">
				<div class="col-xs-8">
				<select class="form-control" id="en_day">
					<option>01</option>
					<option>02</option>
					<option>03</option>
					<option>04</option>
					<option>05</option>
					<option>06</option>
					<option>07</option>
					<option>08</option>
					<option>09</option>
					<option>10</option>
					<option>11</option>
					<option>12</option>
					<option>13</option>
					<option>14</option>
					<option>15</option>
					<option>16</option>
					<option>17</option>
					<option>18</option>
					<option>19</option>
					<option>20</option>
					<option>21</option>
					<option>22</option>
					<option>23</option>
					<option>24</option>
					<option>25</option>
					<option>26</option>
					<option>27</option>
					<option>28</option>
					<option>29</option>
					<option>30</option>
					<option>31</option>
				</select>
				</div>
				<div class="col-xs-4">
					日
				</div>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-xs-3"></div>
			<div class="col-xs-3" id="div_en_hour" style="display:none;">
				<div class="col-xs-8">
				<select class="form-control" id="en_hour">
				  <option>5</option>
				</select>
				</div>
				<div class="col-xs-4">
					时
				</div>
			</div>
			<div class="col-xs-3" id="div_en_minute" style="display:none;">
				<div class="col-xs-8">
				<select class="form-control" id="en_minute">
				</select>
				</div>
				<div class="col-xs-4">
					分
				</div>
			</div>
		</div>
			<button class="btn btn-success" onclick="commitDate();">确认</button>
		</div>
	</div>
	<div style="display:none;">
		<h6 id="XH">${sqb.XH }</h6>
		<h6 id="RQ">${sqb.RQ }</h6>
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