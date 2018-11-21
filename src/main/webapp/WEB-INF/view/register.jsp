<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Register</title>
</head>

<body>

<h3>Register</h3>

	<form:form action="registerUser" modelAttribute="user" method="POST">
			   
		<table>
				<tbody>
					
					<tr>
						<td><label>User name:</label></td>
						<td><form:input path="userName" /></td>
					</tr>
					
					<tr>
						<td><label>Password:</label></td>
						<td><form:input path="password" /></td>
					</tr>
					
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName" /></td>
					</tr>
				
					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName" /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Register" /></td>
					</tr>

				
				</tbody>
			</table>
		
	</form:form>

</body>

</html>










