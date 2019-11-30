<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="jQuery/jquery.js"></script>
    <script type="text/javascript" src="jQuery/jquery.validate.min.js"></script>
    <script type="text/javascript" src="jQuery/messages_zh.js"></script>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<form action="userUpdate">
		<div>
			<div>
				<table class="table table-bordered">
					<tr>
						<td>id</td>
						<td>name</td>
						<td>password</td>
						<td>age</td>
					</tr>
					<tr>
						<td><input type="text" name="id"  value="${list.id }"></td>
						<td><input type="text" name="name"  value="${list.name }"></td>
						<td><input type="text" name="password"  value="${list.password }"></td>
						<td><input type="text" name="age"  value="${list.age }"></td>
					</tr>
				</table>
			</div>
			<input type="submit" value="提交">
		</div>
	
	
	</form>
</body>
</html>