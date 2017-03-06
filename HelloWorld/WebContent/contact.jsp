<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact</title>
</head>
<body>
<a href="homepage?action=index">home</a>
	<h1>Contact</h1>
	<form method="post" action="/HelloWorld/contact">
		<h3>Form</h3>
		Name:<br> <input type="text" name="name"> <br>
		Surname:<br> <input type="text" name="surname"> <br>
		Email:<br> <input type="text" name="email"> <br>
		Message:<br> <textarea rows="4" cols="50" name="message"></textarea> <br>
		<input type="submit" name="Send message">
		<input type="reset"	value="Reset">
	</form>


</body>
</html>