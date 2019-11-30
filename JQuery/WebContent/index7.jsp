<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="jQuery/jquery.js"></script>
<meta charset="UTF-8">
<title>Happy To You </title>

</head>
<body>
<div id="d1" style="height: 200px;width: 200px; background-color: green;">
	<div id="d2" style="height: 180px;width: 180px; background-color: red;">
		<div id="d3" style="height: 150px;width: 150px; background-color: blue;">
		</div>
	</div>
</div>



<script type="text/javascript">
	$().ready(function () {
		$("#d3").click(function () {
			$("#d3").parent.css(back);
		})
	})

</script>
</body>
</html>