<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>

	<title>Home</title>

</head>

<body>
 
 	<p>Welcome ${theUser.userName}</p>
 	
 	<a href="${pageContext.request.contextPath}/stock/list">View Stocks</a> 
 	
 	<!-- "delete" link with user id -->
	<c:url var="deleteLink" value="/delete">
		<c:param name="userId" value="${theUser.id}" />
	</c:url>
	
	<a href="${deleteLink}"
		onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>		
		
	<a href="${pageContext.request.contextPath}/login">Log Out</a>	
	
	<div id="container">
	
		<div id="content">
		
			<table>
			
				<tr>
					<th>Stock Symbol</th>
					<th>Stock Name</th>
					<th>Price</th>
				</tr>
				
				<c:forEach var="tempStock" items="${stocks}">
				
					<c:url var="stockInfo" value="/stock/info">
						<c:param name="stockId" value="${tempStock.id}" />
					</c:url>
					
					<c:url var="buyStock" value="/stock/buy">
						<c:param name="stockId" value="${tempStock.id}" />
					</c:url>
									
					<tr>
						<td> ${tempStock.symbol} </td>
						<td> ${tempStock.name} </td>
						<td> ${tempStock.price} </td>	
						<td>
							<a href="${stockInfo}">More info</a>
						</td>	
						<td>
							<a href="${sellStock}">Sell</a>
						</td>				
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
  
</body>

</html>