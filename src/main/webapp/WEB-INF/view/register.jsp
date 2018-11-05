<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Register</title>
</head>

<body>

<h3>Register</h3>

	<form:form action="${pageContext.request.contextPath}/register"
			   method="POST">
			   
		<p>
			User name: <input type="text" name="username" />
		</p>

		<p>
			Password: <input type="password" name="password" />
		</p>
		
		<p>
			Email: <input type="email" name="email" />
		</p>
		
		<input type="submit" value="Login" />
		
	</form:form>

</body>

</html>










