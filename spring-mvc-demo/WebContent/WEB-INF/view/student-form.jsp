<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>

	<title>Student registration form</title>

</head>

<body>

	<!-- modelAttribute name will be the same that we used in the controller -->

	<!-- When we load the form, Spring MVC will call the get methods from Student class -->

	<!-- When we submit the form, String MVC will call the set methods from Student class -->

	<form:form action="processForm" modelAttribute="student">
	
	First name: <form:input path="firstName"/>
	
	<br><br>
		
	Last name: <form:input path="lastName"/>
	
	<input type = "submit" value="Submit" />
	
	</form:form>





</body>



</html>