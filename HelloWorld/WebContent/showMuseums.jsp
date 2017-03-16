<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Museums Database</title>
<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
	<a href="homepage?action=index">home</a><br><br>

	<form action="/HelloWorld/museum" method="post" id="museumsform">
		<input type="text" name="input">
		<input type="radio" name="attribute" value="id">id
		<input type="radio" name="attribute" value="museumName">Name 
		<input type="radio" name="attribute" value="postalCode">Postal Code 
		<input type="radio" name="attribute" value="city">City 
		<input type="radio" name="attribute" value="street">Street 
		<input type="radio" name="attribute" value="addDate">Added Date 
		<input type="radio" name="attribute" value="status">Status
		<select name="status" form="museumsform">
			<option value="PRIVATE">Private</option>
			<option value="LOCAL_GOVERNMENTS">Local</option>
			<option value="COLEAD_LOCAL">Colead Local</option>
			<option value="COLEAD_NATIONAL">Colead National</option>
			<option value="CHURCH">Church</option>
			<option value="NATIONAL">National</option>
		</select>
		<input type="submit" value="find">
		<input type="submit" name="clear" value="clear">
	</form>
		<table>
			<tr>
				<th>id</th>
				<th>Museum Name</th>
				<th>Address</th>
				<th>Owner</th>
				<th>Added Date</th>
				<th>Status</th>
			</tr>
			<c:forEach items="${requestScope.museums}" var="museum">
				<tr>
					<td>${museum.id}</td>
					<td>${museum.mseumName}</td>
					<td>${museum.address}</td>
					<td>${museum.owner}</td>
					<td>${museum.addDate}</td>
					<td>${museum.status}</td>
					
				</tr>
			</c:forEach>
		</table>

	<c:if test="${requestScope.msg != null }">
		<h3 style="color: red">
			<c:out value="${requestScope.msg }"></c:out>
		</h3>
	</c:if>
</body>
</html>