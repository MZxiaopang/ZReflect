<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="add.jsp">添加</a>
	<table>
		<tr>
			<td>id</td>
			<td>password</td>
			<td>name</td>
			<td>age</td>
			<td>操作</td>
		</tr>
		<c:if test="${!empty list}">
			 <tr>
				<c:forEach  begin="0" end="${list.size()-1}" var="i">
					<tr>
						<td>${list[i].id}</td>
						<td>${list[i].password}</td>
						<td>${list[i].name}</td>
						<td>${list[i].age}</td>
						<td><a href="selectById?id=${list[i].id}">✎</a>
							<a href="delete?id=${list[i].id}">X</a>
						</td>
					</tr>
				</c:forEach>
			</tr>
		</c:if> 
	</table>


</body>
</html>