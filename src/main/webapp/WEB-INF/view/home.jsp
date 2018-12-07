<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>

	<title>Home</title>

</head>

<body>
 
 	<p>Welcome ${theUser.userName}</p>
 	
 	<!-- "delete" link with user id -->
	<c:url var="deleteLink" value="/delete">
		<c:param name="userId" value="${theUser.id}" />
	</c:url>
	
	<a href="${deleteLink}"
		onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>			
  
</body>

</html>