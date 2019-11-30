<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="../WebDemo04/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

页面：<%= pageContext.findAttribute("msg")== null?"":pageContext.findAttribute("msg")%><br>
请求：<%= request.getAttribute("msg")== null?"":request.getAttribute("msg")%><br>
会话：<%= session.getAttribute("msg")== null?"":session.getAttribute("msg")%><br>
应用：<%= application.getAttribute("msg")== null?"":application.getAttribute("msg")%><br>
<hr>
页面：${msg}<br>
请求：${requestScope.msg}<br>
会话：${sessionScope.msg}<br>
应用：${applicationScope.msg}<br>

${123+"987"}<br>
<%-- ${123+"987"+"asv"}<br> --%>
${123==123 ? "等于":"不等于" }<br>
${"张三"=="张三" ? "等于":"不等于" }<br>
<hr>
${user["id"]}<br>
${user.name}
<hr>
${!empty requestScope.msg }
<%
ArrayList list1= new ArrayList();
	list1.add("asd");
%>

${!empty list1 ? "空":"不空"}<br>
全部：${list}<br>
单个：${list[0] }<br>
属性：${list[0].name }<br>

<hr>

<!-- 
	 if标签一般配合EL表达式使用
	 test  里面写boolean  表达式 类似于java中的if() 
	 var	把test里面的结果的返回值声明一个变量
	 scope 	指定var声明的变量作用域    page,request,session,application

-->
<c:if test="${age<16 }" var="s" scope="page">	
	少年
</c:if>

<c:if test="${age<30 && age>=16 }" var="n" scope="page">
	中年
</c:if>
<c:if test="${age>=30 && age<100 }" >
	老年
</c:if>
<br>
s的值：${s }<br>
n的值：${n }<br>
<hr>
<!-- 类似于java的switch
		c:when类似于case  但是与case不同的是，在其中需要写boolean表达式 并支持范围判断
 		c:otherwise：所有when都不匹配  则执行里面的代码
 
 -->
<c:choose>
	<c:when test="${age<16 }">
		年龄小于16
	</c:when>
	<c:when test="${age<30 }">
		年龄小于30
	</c:when>
	<c:when test="${age<100 }">
		年龄小于100
	</c:when>
	<c:otherwise>
		年龄大于100
	</c:otherwise>
</c:choose>


<table class="table table-bordered">
	<tr>
		<td>编号</td>
		<td>密码</td>
		<td>名字</td>
		<td>年龄</td>
	</tr>
	
	<!-- 
		items:需要遍历的集合
		var：每次循环的时候会讲集合中的原始取出来并赋值给变量
	 -->
	
<c:forEach  items="${list }" var="i">
	<tr>

		<td>${i.id }</td>
		<td>${i.name }</td>
		<td>${i.password }</td>
		<td>${i.age }</td>
	</tr>
		
		
</c:forEach>
	<tr>
		<td>序号</td>
		<td>编号</td>
		<td>密码</td>
		<td>名字</td>
		<td>年龄</td>
		<td>操作</td>
	</tr>
	<!-- 
		begin:循环从几开始
		end:循环到多少结束
		var:声明一个变量，初始值会自动等于begin，在每次循环都会自动+1，当值为end时自动结束循环
	 -->
	
<c:forEach  begin="0" end="${list.size()-1 }" var="i">
	<tr>
		<td>${i+1}</td>
		<td>${list[i].id }</td>
		<td>${list[i].password }</td>
		<td>${list[i].name }</td>
		<td>${list[i].age }</td>
		<td><a href="">✎</a><a href="deleteById?id=${list[i].id }">X</a></td>
	</tr>	
</c:forEach>
</table>
</body>
</html>