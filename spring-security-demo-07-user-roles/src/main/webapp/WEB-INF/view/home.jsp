<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri = "http://www.springframework.org/security/tags" %>

<html>

<head> Real Madrid home page </head>

<body>

<h2>Hala Madrid !! We have 14 Champions Leagues.</h2>

<hr>

<p>Welcome to the best club in the world.</p>

<hr>

<!-- Display username and role -->

<p>
	User: <security:authentication property="principal.username"/>
	<br><br>
	Role: <security:authentication property="principal.authorities"/>
</p>

<hr>

<!-- Adding link to point to other pages for admin/manager -->

<p>
	<a href = "${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
	(Only for Managers)
<p>


<hr>

<!-- Add a logout button -->

<form:form action="${pageContext.request.contextPath}/logout" 
	method="POST">
	
	<input type = "submit" value="Logout"/>

</form:form>

</body>

</html>