<!DOCTYPE html>

<html>
	<head>
		<title>QR Code</title>
		<style type="text/css">
		.error {
			color: red;
		}
		
		td.label {
			text-align: right;
		}
		</style>
	</head>

	<body>
		<h1>QR Code</h1>
		<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
	
		<form action="${pageContext.servletContext.contextPath}/QRCode" method="post">
			<table>
				<tr>
					<td class="label">Student's QR:</td>
					<td><input type="text" name="QR" size="12" value="${QR}" /></td>
				</tr>
			</table>
			<form action="${pageContext.servletContext.contextPath}/QRCode" method="post">
			<input type="Submit" name="studentMain" value="Find Content!">
			<a href="http://localhost:8081/lab02/index">Back!</a>
		</form>	
			
		</form>
		<img src="_view\download.jpg"/>
	</body>
</html>