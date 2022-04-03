<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error{
	color: red;
}
</style>
</head>
<body>
	Fill out form. Asterisk(*) means mandatory.
	<form:form action="process" modelAttribute="student">
		First Name(*): <form:input path="firstName"/>
		<form:errors path="firstName" cssClass="error" />
		<br><br>
		Last Name(*): <form:input path="lastName"/>
		<form:errors path="lastName" cssClass="error" />
		<br><br>
		Age(*): <form:input path="age"/>
		<form:errors path="age" cssClass="error" />
		<br><br>
		Country(*): <form:select path="country">
						<form:options items="${student.countryOptions }"/>
					</form:select>
				<form:errors path="country" cssClass="error" />
		<br><br>
		Postal Code(*): <form:input path="postalCode"/>
		<form:errors path="postalCode" cssClass="error" />
		<br><br>
		Favorite Language(*):
		<br>
		<form:radiobuttons path="favoriteLanguage" items="${student.languages}"/>
		<form:errors path="favoriteLanguage" cssClass="error" />
		<br><br>
		Operating System(*):
		<br>
		<form:checkboxes items="${student.operatingSystems }" path="operatingSystem"/>
		<form:errors path="operatingSystem" cssClass="error" />
		<br><br>
		Course Code(*): <form:input path="courseCode"/>
		<form:errors path="courseCode" cssClass="error" />
		<br><br>
		<button type="submit">Save</button>
	</form:form>
</body>
</html>