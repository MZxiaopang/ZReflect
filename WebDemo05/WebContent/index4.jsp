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

<style type="text/css">

.error{
	color: red;
	font-style: inherit;
}
</style>
</head>
<body>
<!-- 
	通过jquery来控制表单校验（写在标签外）
	
 -->
			<form action="#" id="form" onsubmit="return vali()">
				<label for="name">账 号：</label><input id="name" name="username" type="text"  > <br>
				<label for="password">密 码1：</label><input type="text"  name="password" id="password" maxlength="12"> <br>
			<input type="submit" value="登录">
		</form>
		<script type="text/javascript">
			function vali() {
				var username=$("#name").val();
				var password=$("#password").val();
				var nameRet=/^[a-zA-Z][a-zA-Z0-9_-]{3,15}$/;
				if (nameRet.test(username)) {
					return true;
				}else  {
					alert("用户名不合法，首位必须为字母，长度在3-20中间");
					return false;
				}	
			}
		</script>
</body>
</html>