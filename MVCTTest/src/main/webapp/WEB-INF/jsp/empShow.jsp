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
<a href="empAddShow">添加</a>
	<table>
		<tr>
			<td>员工ID</td>
			<td>员工名字</td>
			<td>员工工作</td>
			<td>员工上级</td>
			<td>入职时间</td>
			<td>工资</td>
			<td>奖金</td>
			<td>部门编号</td>
			<td>操作</td>
		</tr>
		<c:if test="${!empty list}">
			 <tr>
				<c:forEach  begin="0" end="${list.size()-1}" var="i">
					<tr>
						<td>${list[i].EMPNO}</td>
						<td>${list[i].ENAME}</td>
						<td>${list[i].JOB}</td>
						<td>${list[i].MGR}</td>
						<td>${list[i].HIREDATE}</td>
						<td>${list[i].SAL}</td>
						<td>${list[i].COMM}</td>
						<td>${list[i].DEPTNO}</td>
						<td><a href="empUpdateShow?id=${list[i].EMPNO}">✎</a>
							<a href="empDelete?id=${list[i].EMPNO}">X</a>
						</td>
					</tr>
				</c:forEach>
			</tr>
		</c:if> 
	</table>


</body>
</html>