<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>展示页面</title>
</head>
<body>
<button type="button" class="btn btn-primary btn-lg" onclick="add()">添加员工</button>
<form action="selectLikeName">
	搜索：<input class="btn btn-primary btn-lg" type="text" name="name">
		<input class="btn btn-primary btn-lg" type="submit" value="提交">
</form>
<table class="table table-bordered">
	<tr>
		<td>序号</td>
		<td>编号</td>
		<td>密码</td>
		<td>姓名</td>
		<td>年龄</td>
		<td>操作</td>
	</tr>
<c:forEach  begin="0" end="${list.size()-1}" var="i" >
	<tr>
		<td>${i+1}</td>
		<td>${list[i].id}</td>
		<td>${list[i].password}</td>
		<td>${list[i].name}</td>
		<td>${list[i].age}</td>
		
		<td><a href="update?id=${list[i].id}&service=update">✎</a>
		<a href="deleteById?id=${list[i].id}&service=delete">X</a></td>
	</tr>
</c:forEach>
</table>
	总共${count}条记录,共${page}
	<c:if test="${count %5==0}">
		<c:set value="${count/5}" var="page"></c:set>
	</c:if>
	<c:if test="${count %5!=0}">
		<c:set value="${count/5+1}" var="page"></c:set>
	</c:if>
	<c:forEach var="i" begin="1" end="${page}">
			<a href="ManagerPageServlet?page=${i}&service=show">第${i}页</a>
	</c:forEach>
<script type="text/javascript">
	function add() {
		location.href="http://localhost:8080/ZZCRM/add?service=add";
	}

</script>


</body>
</html>