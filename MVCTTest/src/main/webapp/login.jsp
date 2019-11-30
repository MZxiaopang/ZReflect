<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
   <link rel="stylesheet" type="text/css" href="Css/logincss.css" charset="utf-8"/> 
</head>
<body >
<div id="Max_div">
    <div id="div1">
        <div id="div2">
            <img src="img/login.png">
            <h3>智游客户关系管理系统</h3>
        </div>
        <div id="div4">
        	<form action="login" method="post" name="for1" onsubmit="return check()">
	            <input type="text" class="text1" name="name">
	            <br>
	            <br>
	            <input type="password" class="text1" name="password">
	            <br>
	            <br>
	            <input type="submit" id="input1" class="button1" value="登录" >
            </form>
            <c:if test="${!empty msg }">
            	${msg}
            </c:if>
        </div>
    </div>
</div>
<c:if test="">


</c:if>
<script type="text/javascript">
	
	function check() {
		if(document.for1.username.value.length<1){
			alert("账号不能为空！");
			return false;
		}
		if(document.for1.password.value.length<1){
			alert("密码不能为空！");
			return false;
		}
		return true;
	}
	
</script>

</body>
</html>