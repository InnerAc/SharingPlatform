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
	<table class="table table-bordered table-hover">
		<thead>
        <tr>
          <th>#</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Username</th>
          <th>操作</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <th scope="row">1</th>
          <td><input type="text" value="Mark" readonly="true"/></td>
          <td><input type="text" value="Otto" readonly="true"/></td>
          <td><input type="text" value="@mdo" readonly="true"/></td>
          <td>
          	<button id="ss" onclick="edit(this);">编辑</button>
          	<button>删除</button>
          </td>
        </tr>
        <tr>
          <th scope="row">2</th>
          <td edit="true">Jacob</td>
          <td edit="true">Thornton</td>
          <td edit="true">@fat</td>
          <td>
          	<button onclick="edit(this);">编辑</button>
          	<button>删除</button>
          </td>
        </tr>
        <tr>
          <th scope="row">3</th>
          <td>Larry</td>
          <td>the Bird</td>
          <td>@twitter</td>
          <td>
          	<button>编辑</button>
          	<button>删除</button>
          </td>
        </tr>
      </tbody>
	</table> 
</body>
</html>