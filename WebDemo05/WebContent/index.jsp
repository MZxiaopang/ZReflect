<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>
<!-- 方法一：使用表单自带校验功能
	
	required="required"   证明此项为必填项




 -->
		<form action="#">
			账 号：<input type="text" required="required" minlength="6" maxlength="7"> <br>
			密 码：<input type="text" required="required"> <br>
			邮 箱：<input type="email" required="required"> <br>
			身份证：<input type="text" required="required" minlength="18" maxlength="18"> <br>
				<input type="submit" value="登录">
		
		
		</form>

</body>
</html>