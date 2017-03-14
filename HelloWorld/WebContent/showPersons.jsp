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

	<table>
		<tr>
			<th>Firstname</th>
			<th>Lastname</th>
			<th>Born Year</th>
			<th>Phone Number</th>
			<th>Sex</th>
		</tr>
		<c:forEach items="${requestScope.people}" var="person">
			<tr>
				<td style="width: 20%">${person.firstName}</td>
				<td style="width: 20%">${person.lastName}</td>
				<td style="width: 20%">${person.bornYear}</td>
				<td style="width: 20%">${person.phoneNumber}</td>
				<td style="width: 20%">${person.sex}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>