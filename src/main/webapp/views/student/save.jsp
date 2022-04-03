<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student</title>
</head>
<body>
	Hi! ${student.fullName()} from ${student.country } with postal code ${student.postalCode } good at ${student.favoriteLanguage } working in below operating systems:
	<ul>
	<c:forEach var="operatingSystem" items="${student.operatingSystem }">
		<li>${operatingSystem }</li>
	</c:forEach>
	</ul>
	You are ${student.age } years old.
</body>
</html>