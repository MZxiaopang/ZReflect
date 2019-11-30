<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>
	<form action="deptUpdate">
			员工ID：<input type="text" name="DEPTION" value="${list.DEPTION }"><br>
			员工名字：<input type="text" name="DNAME" value="${list.DNAME }"><br>
			员工工作：<input type="text" name="LOC" value="${list.LOC }"><br>
		<input type="submit" value="更新"><br>
	</form>

</body>
</html>