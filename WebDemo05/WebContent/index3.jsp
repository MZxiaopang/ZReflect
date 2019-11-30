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
		$("#form").validate({
			rules:{
				username:{
					required:true,
					minlength:6,
					maxlength:12
				},
				password:{
					required:true,
					minlength:8
				},
				Twopassword:{
					required:true,
					equalTo:"#password"
				},
				email:{
					required:true,
					email:true
				},
				idcard:{
					required:true,
					digits:true,
					minlength:18,
					maxlength:18
				},
				date:{
					required:true,
					dateISO:true	
				},
				www:{
					required:true,
					url:true
				}
			},
			messages:{
				username:{
					required:"请输入账号",
					minlength:"账号长度最小为6位",
					maxlength:"账号长度最大为12位"
				},
				password:{
					required:"请输入密码",
					minlength:"密码长度最小为8位",
				},
				Twopassword:{
					required:"请输入确认密码",
					equalTo:"确认密码需要与密码保持一致"
				},
				email:{
					required:"请输入邮箱",
					email:"请输入正确邮箱格式XXX@XXX.XXX"
				},
				idcard:{
					required:"请输入身份证号码",
					digits:"身份证号码只能是数字",
					minlength:"身份证号码最小是18位",
					maxlength:"身份证号码最长是18位"
				},
				date:{
					required:"请输入时间",
					dateISO:"请输入正确时间格式 例如:1997-08-28"	
				},
				www:{
					required:"请输入URL",
					url:"请输入正确url  例如  : http://www.baidu.com"
				}
				
			}
			
			
		});	
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
	通过jquery来控制表单校验（写在标签外）
	
 -->
		<form action="#" id="form">
		<label for="name">账 号：</label><input id="name" name="username" type="text"  > <br>
			<label for="password">密 码1：</label><input type="text"  name="password" id="password" maxlength="12"> <br>
			<label for="p1">密 码2：</label><input type="text" id="p1"   name="Twopassword" maxlength="12"> <br>
			<label for="e1">邮 箱：</label><input type="email" id="e1"  name="email"> <br>
			<label for="id1">身份证：</label><input type="text" id="id1"  name="idcard" > <br>
			<label for="fa1">发布时间：</label><input type="dateISO" id="fa1"  name="date"><br>
			<label for="www">网址</label>：<input type="url" id="www"  name="www"><br>
				<input type="submit" value="登录">
		
		
		</form>
</body>
</html>