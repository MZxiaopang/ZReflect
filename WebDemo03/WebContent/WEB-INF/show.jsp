<%@page import="com.zhiyou.model.User11"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/login.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>展示页面</title>
</head>
<body>
<!-- 	<jsp:include page="/login.jsp"/> -->



	<%
		ArrayList<User11> list =new ArrayList();
			list=(ArrayList)request.getAttribute("list");
	%>
	<table>
	<%
		for(int i=0;i<list.size();i++){
			%>
			<tr>
				<td><%= list.get(i).getId()%></td>
				<td><%= list.get(i).getName()%></td>
				<td><%= list.get(i).getPassword()%></td>
				<td><%= list.get(i).getAge()%></td>
			</tr>
			<%
		}
	
	%>
	</table>
</body>
</html>