<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %>

<html>

<head> Real Madrid home page </head>

<body>

<h2>Hala Madrid !! We have 14 Champions Leagues.</h2>

<hr>

<p>Welcome to the best club in the world.</p>

<hr>

<!-- Add a logout button -->

<form:form action="${pageContext.request.contextPath}/logout" 
	method="POST">
	
	<input type = "submit" value="Logout"/>

</form:form>

</body>

</html>