<html>

<body>

<h3> Spring REST demo </h3>

<hr>

<!-- One way of adding link to the desired page -->

<a href ="${pageContext.request.contextPath}/test/hello">Click here (Using context path)</a>

<br>
<br>

<!-- Other way to do it -->

<a href ="test/hello">Click here (Using the mapping only)</a>

</body>



</html>