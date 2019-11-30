<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>
	<form action="empUpdate1">
			员工ID：<input type="text" name="EMPNO" value="${list.EMPNO }"><br>
			员工名字：<input type="text" name="ENAME" value="${list.ENAME }"><br>
			员工工作：<input type="text" name="JOB" value="${list.JOB }"><br>
			员工上级：<input type="text" name="MGR" value="${list.MGR }"><br>
			入职时间：<input type="text" name="HIREDATE" value="${list.HIREDATE }"><br>
			工资：<input type="text" name="SAL" value="${list.SAL }"><br>
			奖金：<input type="text" name="COMM" value="${list.COMM }"><br>
			部门编号：<input type="text" name="DEPTNO" value="${list.DEPTNO }"><br>
		<input type="submit" value="更新"><br>
	</form>

</body>
</html>