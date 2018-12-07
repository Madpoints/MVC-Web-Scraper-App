<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Register</title>
</head>

<body>

<h3>Register</h3>

	<form:form action="register" 
				modelAttribute="user" 
				method="POST">
			  
		<!-- associate this data with user id -->
		<form:hidden path="id" />	  
		
		<form:hidden path="wallet" />	  
		
			   
		<table>
				<tbody>
					
					<tr>
						<td><label>User name:</label></td>
						<td><form:input path="userName" required/></td>
					</tr>
					
					<tr>
						<td><label>Password:</label></td>
						<td><form:input path="password" required/></td>
					</tr>
					
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName" required/></td>
					</tr>
				
					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName" required/></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" required/></td>
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










