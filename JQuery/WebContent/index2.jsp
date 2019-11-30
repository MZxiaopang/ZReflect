<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="jQuery/jquery.js"></script>
<meta charset="UTF-8">
<title>JQuery淡入/淡出</title>
</head>
<body>
<div id="d1" style="width: 300px;height: 300px;display:none; background-color: red;"></div>

<div id="d2" style="width: 300px;height: 300px;display:none; background-color:blue;"></div>
<button id="b1">淡入</button>
<button id="b2">淡出</button>
<button id="b3">淡入/淡出</button>
<script type="text/javascript">
	$().ready(function () {// 在加载完文档（.js文件）后执行函数
		$("#b1").click(function () {// 当按钮被点击后
			$("#d1").fadeIn(5000);		// 淡入id是d1的元素			
		})
		$("#b2").click(function () {// 当按钮被点击后
			$("#d1").fadeOut(5000);		// 淡出id是d1的元素			
		})
		$("#b3").click(function () {// 当按钮被点击后
			$("#d1").fadeToggle(5000,function(){
				$("#d1").fadeToggle(5000);
			});
			$("#d2").fadeTo(5000,0.5);// 指定透明度
		})
		
	})  
	



</script>


</body>
</html>