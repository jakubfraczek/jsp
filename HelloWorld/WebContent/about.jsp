<%@page import="java.util.LinkedList"%>
<%@page import="model.Person"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	List<Person> persons = (LinkedList<Person>) request.getAttribute("persons");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>About</title>
</head>
<body>
	<a href="homepage?action=index">home</a>
	<h1>
		<c:out value="About" /><br>
		size: <%= persons.size() %>
	</h1>

	<c:forEach items="${requestScope.persons}" var="person">
		<c:if test=""></c:if>
		${person}<br>
	</c:forEach>



</body>
</html>