<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Person Form</title>
</head>
<body>
	<a href="homepage?action=index">home</a>

	<h3>Add person</h3>

	<form action="/HelloWorld/addperson" method="post">
		<div>
			<label>Name</label><br> <input type="text" name="name">
		</div>
		<div>
			<label>Surname</label><br> <input type="text" name="surname">
		</div>
		<div>
			<label>Born Year</label><br> <input type="text" name="bornYear">
		</div>
		<div>
			<label>Phone Number</label><br> <input type="text"
				name="phoneNumber">
		</div>
		<div>
			<label>Sex</label><br> 
			<input type="radio" name="sex" value="male">Male<br>
			<input type="radio" name="sex" value="female">Female
		</div>
		<input type="submit" value="submit">
	</form>

	<c:if test="${requestScope.msg != null }">
		<h3 style="color: red">
			<c:out value="${requestScope.msg }"></c:out>
		</h3>
	</c:if>

</body>
</html>