<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>写邮件</title>
<script  src="jQuery/jquery.js"></script>
<script  src="jQuery/jquery.validate.min.js"></script>
<script  src="jQuery/messages_zh.js"></script>

<script type="text/javascript">
	$().ready(function() {
		$("#form1").validate({
			rules:{
				receiver:{
					required:true,
					digits:true
				},
				subject:{
					required:true,
					minlength:1
				},
				content:{
					required:true,
					minlength:1
				}
				
				
			},
			messages:{
				receiver:{
					required:"请输入角色名称",
					digits:"只能是数字"
				},
				subject:{
					required:"请输入主题名字",
					minlength:"主题名字最少是1个字"
				},
				content:{
					required:"请输入内容名字",
					minlength:"内容最少是1个字"
				}
			}
		});
	}) 
</script>

<style type="text/css">
		.td1{
		text-align: center;
		width: 100px;
		}
		.error{
			color: red;
		}
</style>
</head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

<body>

<div>
<form action="MessageAlter" method="post" id="form1" onsubmit="return on()">
	<div>
		
		
		<input type="hidden" name="send_status" value="2">
		<input type="hidden" name="send_delete" value="2">
		<input type="hidden" name="receive_delete" value="2">
		<input type="hidden" name="receive_status" value="2">
		<table class="table table-bordered">
			<tr>
			<td class="td1">收件人:<input type="hidden" name="id" value="${list.message_id }"></td>
			
			<td><input type="text" id="receiver" name="receiver" value="${list.receiver }" onblur="oon()"><i></i></td>
			</tr>
			<tr>
			<td class="td1">主题:</td>
			<td><input type="text" name="subject" value="${list.subject }"></td>
			</tr>
			<tr>
			<td class="td1">内容:</td>
			<td><textarea name="content">${list.content }</textarea></td>
			</tr>
			
		</table>
	</div>
		<div>	
			<input type="hidden" name="service" value="MessageAlter">
			<input type="submit"  value="确认发送" >
			<input type="hidden" name="text" id="InputText">
			<input type="submit"  onclick="f1()" value="保存邮件" >
			<input type="button" onclick="f()" value="返回">
		
	</div>
	</form>
	
</div>

<script type="text/javascript">
	function f1() {
		var a=document.getElementById("InputText");
			a.value="text";
	}
	function f() {
		location.href="${pageContext.request.contextPath }//MessageServlet?service=MessageGuanLi";
	}
	
	var i=false;
	function oon() {
		$.ajax({
			url:"MessageServlet?service=selectUser",
			data:{
				username:$("#receiver").val()
			},
			success:function(data){
				if(data=="true"){
					$("i").css("color","blue");
					$("i").text("存在用户请放心发送");
					i=true;
					
				}else {
					$("i").css("color","red");
					$("i").text("不存在当前用户");
					i=false;
				}
				
			}
			
			
		})
	}
	function on() {
		return i;
	}

</script>
</body>
</html>