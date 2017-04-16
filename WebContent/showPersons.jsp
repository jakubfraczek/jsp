<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>People Database</title>
<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
	<a href="homepage?action=index">home</a>

	<form action="/HelloWorld/showpersons" method="post">
		<table>
			<tr>
				<th>Firstname</th>
				<th>Lastname</th>
				<th>Born Year</th>
				<th>Phone Number</th>
				<th>Sex</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${requestScope.people}" var="person">
				<tr>
					<td>${person.firstName}</td>
					<td>${person.lastName}</td>
					<td>${person.bornYear}</td>
					<td>${person.phoneNumber}</td>
					<td>${person.sex}</td>
					<td><input type="radio" name="delete"
						value="${person.phoneNumber}">
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="delete">
	</form>

	<c:if test="${requestScope.msg != null }">
		<h3 style="color: red">
			<c:out value="${requestScope.msg }"></c:out>
		</h3>
	</c:if>
</body>
</html>