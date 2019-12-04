<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="jQuery/jquery.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="add" onsubmit="return on()" >
		<input type="text" name="name" id="name" onblur="oon()"><i></i>
		<input type="submit">
	</form>
<script type="text/javascript">
	function oon() {
		$.ajax({
			url:"valiDate",	//指定url
			type:"get",		//指定请求方式
			data:{			//请求附带参数
				name1:$("#name").val()
			},
			success:function(data){//成功后的回调函数 data代表服务器响应的数据
				if (data=="true") {
					$("i").text("");
				}else {
					$("i").text("用户已存在");
				}
			}
			/* error:function(XMLHttpRequest,textStatus,errorThrown){// 失败后的回调函数
				alert(textStatus);
				alert(errorThrown);
			} */
			
		})
	}
		
	
</script>
</body>
</html>