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
							<a href="${buyStock}">Buy</a>
						</td>			
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>
