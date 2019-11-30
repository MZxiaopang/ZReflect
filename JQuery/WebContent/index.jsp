<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="jQuery/jquery.js"></script>
<meta charset="UTF-8">
<title>JQuery显示隐藏</title>
</head>
<body>
<div id="d1" style="width: 300px;height: 300px;background-color: red;">

</div>
<button id="b1">隐藏</button>
<button id="b2">显示</button>
<button id="b3">隐藏/显示</button>
<script type="text/javascript">
	$().ready(function () {// 在加载完文档（.js文件）后执行函数
		$("#b1").click(function () {// 当按钮被点击后
			$("#d1").hide();		// 隐藏id是d1的元素			
		})
		$("#b2").click(function () {// 当按钮被点击后
			$("#d1").show();		// 显示id是d1的元素			
		})
		$("#b3").click(function () {// 当按钮被点击后
			$("#d1").toggle(5000,function(){
				$("#d1").toggle(5000);// 隐藏/显示id是d1的元素			
				
			});		
		})
		
	})  
	



</script>


</body>
</html>