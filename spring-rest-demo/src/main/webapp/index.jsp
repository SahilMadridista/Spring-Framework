<html>

<body>

<h3> Spring REST demo </h3>

<hr>

<!-- One way of adding link to the desired page -->

<a href ="${pageContext.request.contextPath}/test/hello">Home page (Using context path)</a>

<br>
<br>

<!-- Other way to do it -->

<a href ="test/hello">Home page (Using the mapping only)</a>

<br>
<br>

<!-- Link for getting students list -->

<a href ="${pageContext.request.contextPath}/api/students">Student List</a>

</body>



</html>