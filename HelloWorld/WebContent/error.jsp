<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error!</title>
</head>
<body>
	<a href="homepage?action=index">home</a>
	<a href="homepage?action=instagram">try again</a>
	<h2>Oops! Something goes wrong :(</h2>

	<c:out value="${requestScope.error }"></c:out>
</body>
</html>