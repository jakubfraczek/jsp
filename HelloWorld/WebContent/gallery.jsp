<%@page import="java.util.List"%>
<%@page import="src.model.Gallery"%>
<%@page import="java.awt.print.Printable"%>
<%@ page import="src.model.Image"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<% Gallery gallery = (Gallery) request.getAttribute("gallery");
	List<Image> images = gallery.getImages();
	int k = 0;%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gallery</title>
</head>
<body>
	<h1><% 
	out.print(gallery.getName() + " gallery");
	%></h1>
	<table>
	<% for(int i = 0; i < 3; i ++){ %>
		<tr>
		<% for(int j = 0; j < 3; j++){ %>
			<td><img src="<%= images.get(k).getUrl() %>" title="<%= images.get(k++).getDescription() %>"></td>
			<%} %>
		</tr>
		<% } %>
		
	</table>
</body>
</html>