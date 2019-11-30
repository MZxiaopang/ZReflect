<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="jQuery/jquery.js"></script>
<script src="jQuery/jquery.validate.min.js"></script>
<script src="jQuery/messages_zh.js"></script>

<title>登录二</title>
<script type="text/javascript">
	$().ready(function () {
		$("#form").validate();
	})

</script>
<style type="text/css">

.error{
	color: red;
	font-style: inherit;
}
</style>
</head>
<body>
<!-- 
	通过jquery来控制表单校验（写在标签内）
	
 -->
		<form action="#" id="form">
		<label for="name">账 号：</label><input id="name" type="text" required="required" minlength="6" maxlength="7"> <br>
			<label for="password">密 码1：</label><input type="text" required="required" name="password" id="password"> <br>
			<label for="p1">密 码2：</label><input type="text" id="p1" required="required" equalTo="#password" name="Twopassword"> <br>
			<label for="e1">邮 箱：</label><input type="email" id="e1" required="required" name="email"> <br>
			<label for="id1">身份证：</label><input type="text" id="id1" required="required" name="idcard" minlength="18" maxlength="18"> <br>
			<label for="fa1">发布时间：</label><input type="dateISO" id="fa1" required="required" name="date"><br>
			<label for="www">网址</label>：<input type="url" id="www" required="required" name="www"><br>
				<input type="submit" value="登录">
		
		
		</form>
</body>
</html>