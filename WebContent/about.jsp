<%@page import="pl.sda.model.Sex"%>
<%@page import="java.util.LinkedList"%>
<%@page import="pl.sda.model.Person"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css" type="text/css">
<style>
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>About</title>
</head>
<body>
	<a href="homepage?action=index">home</a>
	<h1>
		<c:out value="List of hardcoded people" />
		<br>
	</h1>

	<table>
		<tr>
			<th>Firstname</th>
			<th>Lastname</th>
			<th>Born Year</th>
			<th>Phone Number</th>
			<th>Sex</th>
		</tr>
		<c:forEach items="${requestScope.persons}" var="person">
			<c:if test="${person.sex == 'M'}">
				<tr>
					<td>${person.firstName}</td>
					<td>${person.lastName}</td>
					<td>${person.bornYear}</td>
					<td>${person.phoneNumber}</td>
					<td>${person.sex.sex}</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
	<br>
	<table>
		<tr>
			<th>Firstname</th>
			<th>Lastname</th>
			<th>Born Year</th>
			<th>Phone Number</th>
			<th>Sex</th>
		</tr>
		<c:forEach items="${requestScope.persons}" var="person">
			<c:if test="${person.sex == 'F'}">
				<tr>
					<td style="width: 20%">${person.firstName}</td>
					<td style="width: 20%">${person.lastName}</td>
					<td style="width: 20%">${person.bornYear}</td>
					<td style="width: 20%">${person.phoneNumber}</td>
					<td style="width: 20%">${person.sex.sex}</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>



</body>
</html>