<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 

		ArrayList list=new ArrayList();
		list.add(12);
		list.add(19);
		list.add(32);
		for(int i=0;i<list.size();i++){
			%>
				= list.get(i)%>
			
		}
		request.getAttribute("name"); %>

 -->
	<!-- jsp 的第一种注释 对客户端隐藏 -->
	<%--	jap的第二种注释 对客户端隐藏 --%>
	<p>hello jsp</p>
	<!--  在jsp中书写 java代码，Java代码为了与HTML分隔开  需要写在《%%》 中间 -->

	<%
		String name = "张三";
		Integer age=18;
	%>
	姓名:<%= name %><br>
	年龄<%= age %><br>

	<%!
		public void method(){
		System.out.print("5");	
	}
	%>
	
	<%
		
	
	%>
	<form action="login" method="post">
		账号：<input type="text" name="username"><br>
		密码：<input type="password" name="password"><br>
		<input type="submit" value="提交">
	</form>
	
	
	
	

</body>
</html>