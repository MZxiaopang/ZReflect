<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="jQuery/jquery.js"></script>
<meta charset="UTF-8">
<title>JQuery插入元素</title>

</head>
<body>
<div id="d1" style="width: 200px;height: 200px;background-color: red;">
	<div id="d2" style="width: 180px;height: 180px;">
		<div id="d3" style="width: 150px;height: 150px;">
			<p id="p1">这里是段落1</p>
			<p id="p2">这里是段落2</p>
			<p id="p3">这里是段落3</p>
			<h3 id="h1">第一个h3</h3>
			<h3 id="h2">第二个h3</h3>
			<h3 id="h3">第三个h3</h3>
		</div>
	</div>
</div>


<script type="text/javascript">
	$().ready(function () {// 在加载完文档（.js文件）后执行函数
	//向上遍历DOM树
//		$("#p1").parents().css("background-color","#BE77FF");//返回所有父标签元素
//		$("#p1").parent().css("background-color","#BE77FF");//返回直接父标签元素
//		$("#p1").parentsUntil("#d1").css("background-color","#BE77FF");//选择两个元素中间的所有元素
	//向下遍历DOM树
//		$("#d1").children().css("background-color","#BE77FF");// 返回所有直接子标签
//		$("#d1").find("#d3").css("background-color","#BE77FF");// 返回指定子标签
	//同胞遍历
//		$("#p3").siblings().css("background-color","#BE77FF");// 返回所有同级标签除了自己
//		$("#p3").next().css("background-color","#BE77FF");//返回下一个统计标签
//		$("#p3").nextAll().css("background-color","#BE77FF");// 返回之后所有同级标签除了自己
		$("#p1").nextUntil("#h2").css("background-color","#BE77FF");//返回p1-h2之间的所有标签
		
	})  
	



</script>


</body>
</html>