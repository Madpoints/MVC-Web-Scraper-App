<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
	<title>Login</title>
</head>

<body>

<h3>Login</h3>

	<form:form action="${pageContext.request.contextPath}/login"
			   modelAttribute="login"
			   method="POST">
			   
		<p>
			User name: <input type="text" name="username" />
		</p>

		<p>
			Password: <input type="password" name="password" />
		</p>
		
		<input type="submit" value="Login" />
		
	</form:form>
	
	<a href="${pageContext.request.contextPath}/register/new">New user? Register here</a>

</body>

</html>










