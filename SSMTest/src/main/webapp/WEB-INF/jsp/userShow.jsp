<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 	<script type="text/javascript" src="jQuery/jquery.js"></script>
    <script type="text/javascript" src="jQuery/jquery.validate.min.js"></script>
    <script type="text/javascript" src="jQuery/messages_zh.js"></script>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
	<div>
		<div>
			<form action="search">
				<a href="userAddShow">添加</a>
				<input type="text" name="chose">
				<select name="select">
					<option value="1">名字</option>
					<option value="2">年龄</option>
				</select>
				<input type="submit" value="提交">
			</form>
		</div>
		
		<div>
			<table class="table table-bordered">
				<tr>
					<td>id</td>
					<td>name</td>
					<td>password</td>
					<td>age</td>
					<td>操作</td>
				</tr>
				<c:forEach begin="0" end="${list.size()-1}" var="i">
					<tr>
						<td>${ list[i].id}</td>
						<td>${ list[i].name}</td>
						<td>${ list[i].password}</td>
						<td>${ list[i].age}</td>
						<td><a href="userUpdeteShow?id=${list[i].id}">更改</a>
							<a href="userDelete?id=${list[i].id}">删除</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div>
			<c:if test="${count%5==0 }">
				<c:set var="page" value="${count/5 }"></c:set>
			</c:if>
			<c:if test="${count%5!=0 }">
				<c:set var="page" value="${count/5+1 }"></c:set>
			</c:if>
			<fmt:parseNumber var="page" value="${page}" integerOnly="true" />
			共${count }条数据，共${page }页
			<c:forEach begin="1" end="${page }" var="i">	
				<a href="userShow?page=${i }">第${i }页</a>
			</c:forEach>
			
			
			
		</div>
	
	</div>

</body>
</html>