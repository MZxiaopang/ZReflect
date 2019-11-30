<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="jQuery/jquery.js"></script>
<meta charset="UTF-8">
<title>JQuery插入元素</title>
<style type="text/css">
.cs{
	color: red;
}

</style>

</head>
<body>
<form action="">
	<i id="i">这是i1标签的一段文字<a href="#">这是a标签的一段文字</a></i>
	
	<i id="i2">这是i2标签的一段文字<a href="#">这是a标签的一段文字</a></i>
	<input type="text" id="name">
</form>
<script type="text/javascript">
	$().ready(function () {// 在加载完文档（.js文件）后执行函数
		$("#name").blur(function () {//input 失去鼠标焦点的时候触发函数
//			$("i").append("<b>,12345,上山打老虎</b>");//在i标签里面追加
//			$("i").prepend("<a href='#'>啦啦啦</a>");//在i标签里面开头追加
//			$("i").after("<b>,456789</b>");//在i标签之后追加
//			$("i").before("<a href='#'>沙拉黑</a>"); //在i标签之前追加
//			$("i").empty();//删除标签内所有内容（包括子标签）
//			$("i").remove("#i");//删除标签及子标签,可以根据参数删除指定标签的内容
			$("#i").append("<b>,12345,上山打老虎</b>")
				  .prepend("<a href='#'>啦啦啦</a>")
				  .after("<b>,456789</b>")
				  .before("<a href='#'>沙拉黑</a>")
				  .remove("#i");
			$("#i2").addClass("cs");//动态添加Class样式,如果有多个可以用空格隔开
			$("#i2").removeClass("cs");//动态删除class样式
			$("#i2").css("color","red");// 动态添加css
//			$("#i2").css({"color":"red","font-size":"80px"});// 动态添加多个css
		
		})
		
	})  
	



</script>


</body>
</html>