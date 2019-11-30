<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>修改页面</title>
</head>
<body>
<form action="alter">
	<table class="table table-bordered">
	<tr>
	<c:if test="${!empty user }">
		<td>编号</td>
	</c:if>
		<td>密码</td>
		<td>姓名</td>
		<td>年龄</td>
	</tr>
		<c:if test="${!empty user}">	
		<td><input type="text" readonly="readonly" value="${user.id }" name="id"></td>
		</c:if>
		<td><input type="text" value="${user.password }" name="password"></td>
		<td><input type="text" value="${user.name }" name="name"></td>
		<td><input type="text" value="${user.age }" name="age"></td>
		<input type="hidden" value="alter" name="service">
			<td><input type="submit" value="提交"></td>
	</table>

</form>
</body>
</html>