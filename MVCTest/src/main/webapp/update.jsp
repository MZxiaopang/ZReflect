<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>
	<form action="update1">
		ID:<input type="text" name="id" value="${list.id }"><br>
		密码:<input type="text" name="password" value="${list.password }"><br>
		名字:<input type="text" name="name" value="${list.name }"><br>
		年级:<input type="text" name="age" value="${list.age }"><br>
		<input type="submit" value="更新"><br>
	</form>

</body>
</html>