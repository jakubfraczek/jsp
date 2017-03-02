<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dzisiaj jest...</title>
</head>
<body>
	<h2>
		<%
			out.print("Dzisiaj jest ");
		%>
	</h2>
	<h2><%=LocalDate.now().toString()%></h2>

	<h3>MENU:</h3>
	<ul>
		<li><a href="homepage?action=index">home</a></li>
		<li><a href="homepage?action=gallery">gallery</a></li>
		<li><a href="homepage?action=about">about</a></li>
		<li><a href="homepage?action=contact">contact</a></li>
	</ul>
</body>
</html>