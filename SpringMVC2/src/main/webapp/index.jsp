<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文件上传</title>
</head>
<body>
	<form action="upload2.do" method="post" enctype="multipart/form-data">
		请上传文件:<input type="file" name="fileName">
		<input type="submit" value="上传">
	</form>
</body>
</html>