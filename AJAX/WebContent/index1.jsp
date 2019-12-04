<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript" src="jQuery/jquery.js"></script>
<meta charset="UTF-8">
<title>添加</title>
</head>
<body>
	<form action="valiDate" onsubmit="return on()" >
		<input type="text" name="name" id="name" ><i></i>
		<input type="submit">
	</form>
	
	<script type="text/javascript">
		function on() {
			var xmlHttp=new XMLHttpRequest();	//1：获得xmlhttp请求对象
			xmlHttp.onreadystatechange=function(){//2：设定回调函数
				if(xmlHttp.readyState==4&&xmlHttp.status==200){		// 
					if (xmlHttp.responseText) {
						return true;
					}else{
						$("i").html("用户名存在");
						return false;
					}
				}
			};	
			
			xmlHttp.open("GET","valiDate?name="+$("#name").val());   //3：调用open方法连接服务器参数为：请求方式，请求URL
			xmlHttp.send(); // 4：向服务器发送请求
							// 5：执行回调函数
		}
	
	</script>
	
</body>
</html>