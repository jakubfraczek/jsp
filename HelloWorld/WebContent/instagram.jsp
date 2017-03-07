<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Istagram Getter</title>
</head>
<body>
	<a href="homepage?action=index">home</a>
	<form method="post" action="/HelloWorld/InstagramImagesServlet">
		Istagrem User Name<br> <input type="text" name="user"><br>
		Number of photo<br> <input type="text" name="noPhoto"><br>
		<input type="submit" value="get photos">
	</form>
</body>
</html>