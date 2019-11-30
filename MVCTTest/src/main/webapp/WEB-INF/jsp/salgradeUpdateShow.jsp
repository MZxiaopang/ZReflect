<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>
	<form action="salgradeUpdate">
		薪水等级:<input type="text" name="GRADE" value="${list.GRADE }"><br>
		最低工资:<input type="text" name="LOSAL" value="${list.LOSAL }"><br>
		最高工资:<input type="text" name="HISAL" value="${list.HISAL }"><br>
		<input type="submit" value="更新"><br>
	</form>

</body>
</html>