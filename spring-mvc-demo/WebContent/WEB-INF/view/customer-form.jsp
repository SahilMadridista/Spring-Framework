<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>

	<title>Customer registration form</title>
	
	<style>
	
		.error{
			color:red
		}
	
	</style>

</head>

<body>

<h4>* indicates the required field</h4>

<form:form action="processForm" modelAttribute="customer">


	First name : <form:input path="firstName" />
	
	<br><br>
	
	Last name* : <form:input path="lastName" />
	<form:errors path="lastName" cssClass="error" />

	<br><br>
	
	Free passes : <form:input path="freePasses" />
	<form:errors path="freePasses" cssClass="error" />

	<br><br>
	
	Postal code : <form:input path="postalCode" />
	<form:errors path="postalCode" cssClass="error" />
	
	<br><br>
	
	Course code : <form:input path="courseCode" />
	<form:errors path="courseCode" cssClass="error" />
	
	<br><br>

	<input type="submit" value="submit"/>

</form:form>



</body>


</html>