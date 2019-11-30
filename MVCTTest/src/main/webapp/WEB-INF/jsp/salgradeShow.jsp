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
<a href="salgradeAddShow">添加</a>
	<table>
		<tr>
			<td>薪水等级</td>
			<td>最低工资</td>
			<td>最高工资</td>
			<td>操作</td>
		</tr>
		<c:if test="${!empty list}">
			 <tr>
				<c:forEach  begin="0" end="${list.size()-1}" var="i">
					<tr>
						<td>${list[i].GRADE}</td>
						<td>${list[i].LOSAL}</td>
						<td>${list[i].HISAL}</td>
						<td><a href="salgradeUpdateShow?id=${list[i].GRADE}">✎</a>
							<a href="salgradeDelete?id=${list[i].GRADE}">X</a>
						</td>
					</tr>
				</c:forEach>
			</tr>
		</c:if> 
	</table>


</body>
</html>