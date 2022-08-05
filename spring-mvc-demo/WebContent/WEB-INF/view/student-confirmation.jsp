<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>

	<title>Student confirmation page</title>

</head>

<body>

<h2>The student name is : </h2>

${student.firstName} ${student.lastName}

<!-- The above statement will call student.getFirstName and student.getLastName respectively. -->

<br> <br>

Country: ${student.country}

<br> <br>

Favorite language is: ${student.favoriteLanguage}

<br> <br>

Operating Systems:

<ul>

	<c:forEach var="temp" items="${student.operatingSystems}">

	<li>${temp}</li>
	
	</c:forEach>

</ul>

</body>



</html>