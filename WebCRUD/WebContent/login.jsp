<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="login" name="for1" method="post" onsubmit="return check()">
账户:<input type="text" name="username"><br>
密码:<input type="password" name="password"><br>
	<input type="submit" value="提交"><br>
</form>

	<c:if test="${!empty msg }">
		${msg }
	</c:if>
	<script type="text/javascript">
		function check() {
			if (document.for1.username.value.length<1) {
				alert("账号为空，请输入账号");
				return false;
			}
			if (document.for1.password.value.length<1) {
				alert("密码为空，请输入密码");
				return false;
			}
			return true;
		}
	
	
	</script>

</body>
</html>