<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="jQuery/jquery.js"></script>
<meta charset="UTF-8">
<title>JQuery获取元素值/设置元素值</title>
</head>
<body>
<form action="">
	<i id="i"><a>这是一段文字</a></i>
	<i id="i1"><a>这是一段文字</a></i>
	<input type="text" id="name">
	
</form>
<script type="text/javascript">
	$().ready(function () {// 在加载完文档（.js文件）后执行函数
		$("#name").blur(function () {//input 失去鼠标焦点的时候触发函数
			alert($("i").text());	// 获得文本的值,不带里面的标签，
			alert($("#name").val().length);// 获得输入框的值
			alert($("#i").html());	// 获得文本的值,带里面的标签，
			$("i").text("文本被我改变了");// 修改文本的值
			$("#name").val("账号不见了");//修改输入框的值
			alert();
			$("#i").html("<b>标签不见了</b>");//修改文本的值可以加标签
		})
		
	})  
	



</script>


</body>
</html>