<%@page import="model.ModelGallery"%>
<%@page import="java.util.List"%>
<%@page import="java.awt.print.Printable"%>
<%@ page import="model.Image"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	ModelGallery gallery = (ModelGallery) request.getAttribute("gallery");
	List<Image> images = gallery.getImages();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gallery</title>
</head>
<body>
	<a href="homepage?action=index">home</a>
	<h1>
		<%
			out.print(gallery.getName() + " gallery");
		%>
	</h1>
	<h3>
		<%
			out.print("Created " + gallery.getCreatedDeate().toString());
		%>
	</h3>
	<table border=1>
		<%
			for (int i = 0; i < gallery.getImages().size(); i++) {
		%>
		<tr>
			<td><img src="<%=images.get(i).getUrl()%>"
				title="<%=images.get(i).getDescription()%>"></td>
		</tr>
		<%
			}
		%>

	</table>
</body>
</html>