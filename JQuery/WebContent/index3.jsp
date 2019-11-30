<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="jQuery/jquery.js"></script>
<meta charset="UTF-8">
<title>JQuery滑动</title>
</head>
<body>
<div class="d1">
	<p>这是一段文本</p>
	<p>这是二段文本</p>
	<p>这是三段文本</p>
</div>
	<p id="p1">你点我试试</p>
<script type="text/javascript">
	$().ready(function () {// 在加载完文档（.js文件）后执行函数
		 $("#p1").click(function () {// 当p被点击后
			$(".d1").slideUp(3000,function(){// 向上滑动div块	
				$(".d1").slideDown();// 向下滑动div块	
			});			
		}) 
	//	$("#p1").click(function () {// 当p被点击后
	//		$(".d1").slideToggle();// 向上/下滑动div块	
	//	})
		
	})  
	



</script>


</body>
</html>