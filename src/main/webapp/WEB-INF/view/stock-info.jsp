<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Stock-Info</title>
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Stock Info</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<table>
			
				<tr>
					<th>Symbol</th>
					<th>Name</th>
					<th>Price</th>
<!-- 					<th>Change</th> -->
<!-- 					<th>% Change</th> -->
<!-- 					<th>Volume</th> -->
<!-- 					<th>Avg Volume</th> -->
<!-- 					<th>Market Cap</th> -->
<!-- 					<th>PE Ratio</th> -->
				</tr>
				
				<tr>
					<td>${stock.symbol}</td>
					<td>${stock.name}</td>
					<td>${stock.price}</td>
<%-- 					<td>${change}</td> --%>
<%-- 					<td>${percentChange}</td> --%>
<%-- 					<td>${volume}</td> --%>
<%-- 					<td>${avgVolume}</td> --%>
<%-- 					<td>${marketCap}</td> --%>
<%-- 					<td>${peRatio}</td> --%>
				</tr>
				
			</table>
		
		</div>
		
	</div>
	

</body>

</html>