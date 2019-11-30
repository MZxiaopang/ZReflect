<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jQuery/jquery.js"></script>
</head>
<body>
	<input type="checkbox" name="on">吃<br>
	<input type="checkbox" name="on">喝<br>
	<input type="checkbox" name="on">玩<br>
	<input type="checkbox" name="on">乐<br>
	<input type="button" value="全选" id="1">
	<input type="button" value="全部不选" id="2">
	<input type="button" value="反选" id="3">
	
	<script type="text/javascript">
		$(function(){
			$("#1").click(function(){
				$("input[name='on']").prop("checked","true");	
			})
			
		});
		
		$(function(){
			$("#2").click(function(){
				$("input[name='on']").prop("checked","false");	
			})
			
		});
		
		$(function(){
			$("#3").click(function(){
				
				if($(this).prop("true")){
					$("input[name='on']").prop("checked","true");
				}else{
					$("input[name='on']").prop("checked","false");
				}	
			})
			
		});
	
	</script>
</body>
</html>