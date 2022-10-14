<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>

<head>

	<title>Custom Login Page</title>
	
	<style>
	
		.failed{
			color:red;
		}
	
	</style>

</head>

<body>

	<h3>My Custom Login Page</h3>


	<form:form action="${pageContext.request.contextPath}/authenticateTheUser"
		method="POST">
		
		
		<p>
			User name: <input type="text" name="username"/>
		</p>
		
		<p>
			Password: <input type="password" name="password"/>
		</p>
		
		<c:if test="${param.error != null}">
		
			<i class="failed">You've entered wrong username/password. Please try again!</i>
		
		</c:if>
		
		<br>
		
		<input type="submit" value="Login"/>
		
		
	</form:form>

</body>

</html>