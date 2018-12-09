<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
	<title>Login</title>
</head>

<body>

<h3>Login</h3>

	<form:form action="login"
			   modelAttribute="login"
			   method="POST">
			   
		<p>
			User name: <form:input path="userName" required/>
		</p>

		<p>
			Password: <form:input path="password" type="password" required/>
		</p>
		
		<input type="submit" value="Login" />
		
	</form:form>
	
	<a href="${pageContext.request.contextPath}/register">New user? Register here</a>

</body>

</html>










