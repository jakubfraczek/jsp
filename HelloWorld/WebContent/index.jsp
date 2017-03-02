<%@page import="java.time.LocalDate" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dzisiaj jest...</title>
</head>
<body>
<p>Hello world!</p>
<h1><% out.print("Dzisiaj jest ");%></h1>
<h2><%= LocalDate.now().toString() %></h2>

<a href="homepage?action=index">home</a>
<a href="homepage?action=gallery">gallery</a>
<a href="homepage?action=about">about</a>
<a href="homepage?action=contact">contact</a>
</body>
</html>