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
				
					<c:url var="stockInfoLink" value="/stock/info">
						<c:param name="stockSymbol" value="${tempStock.symbol}" />
						<c:param name="stockName" value="${tempStock.name}" />
						<c:param name="stockPrice" value="${tempStock.price}" />
						<c:param name="change" value="${tempStock.change}" />
						<c:param name="percentChange" value="${tempStock.percentChange}" />
						<c:param name="volume" value="${tempStock.volume}" />
						<c:param name="avgVolume" value="${tempStock.avgVolume}" />
						<c:param name="marketCap" value="${tempStock.marketCap}" />
						<c:param name="peRatio" value="${tempStock.peRatio}" />
					</c:url>
				
					<tr>
						<td> ${tempStock.symbol} </td>
						<td> ${tempStock.name} </td>
						<td> ${tempStock.price} </td>
						
						<td>
							<a href="${stockInfoLink}">More info</a>
						</td>					
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>
