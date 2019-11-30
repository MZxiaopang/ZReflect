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
<a href="deptAddShow">添加</a>
	<table>
		<tr>
			<td>部门ID</td>
			<td>部门名字</td>
			<td>部门位置</td>
			<td>操作</td>
		</tr>
		<c:if test="${!empty list}">
			 <tr>
				<c:forEach  begin="0" end="${list.size()-1}" var="i">
					<tr>
						<td>${list[i].DEPTION}</td>
						<td>${list[i].DNAME}</td>
						<td>${list[i].LOC}</td>
						<td><a href="deptUpdateShow?id=${list[i].DEPTION}">✎</a>
							<a href="deptDelete?id=${list[i].DEPTION}">X</a>
						</td>
					</tr>
				</c:forEach>
			</tr>
		</c:if> 
	</table>


</body>
</html>