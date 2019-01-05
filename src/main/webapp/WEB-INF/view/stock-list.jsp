<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Stocks</title>
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Stock List</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<table>
			
				<tr>
					<th>Stock Symbol</th>
					<th>Stock Name</th>
					<th>Price</th>
				</tr>
				
				<c:forEach var="tempStock" items="${stocks}">
				
					<tr>
						<td> ${tempStock.symbol} </td>
						<td> ${tempStock.name} </td>
						<td> ${tempStock.price} </td>			
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>
