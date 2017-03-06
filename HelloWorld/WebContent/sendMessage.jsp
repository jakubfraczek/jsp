<%@page import="model.MessageConfirm"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% MessageConfirm mc = (MessageConfirm) request.getAttribute("message"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="homepage?action=index">home</a>

<h3>Czesc, <c:out value="${requestScope.message.name}"></c:out>!<br>
Dziekujemy za przeslanie wiadomosci.</h3>
<h4>Twój email to: <c:out value="${requestScope.message.email }"></c:out><br>
Wyslales nastepujaca wiadomosc:</h4>
<p><c:out value="${requestScope.message.message }"></c:out></p>
<h5>Dziekujemy,<br>
javalodz2</h5>

</body>
</html>