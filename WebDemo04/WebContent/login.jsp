<%@page import="java.util.ArrayList"%>
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

	<form action="login" method="post">
		账号：<input type="text" name="username"><br>
		密码：<input type="password" name="password"><br>
		<input type="submit" value="提交">
	</form>${msg}
	
	<c:if test="${!empty msg}">		
			${msg}
	</c:if>
	
	

</body>
</html>