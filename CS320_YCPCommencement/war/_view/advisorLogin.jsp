<!DOCTYPE html>

<html>
	<head>
		<title>Advisor Login</title>
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
		<h1>Advisor Login</h1>
		<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
	
		<form action="${pageContext.servletContext.contextPath}/guessingGame" method="post">
			<table>
				<tr>
					<td class="label">Advisor Username:</td>
					<td><input type="text" name="first" size="12" value="${first}" /></td>
				</tr>
				<tr>
					<td class="label">Advisor Password:</td>
					<td><input type="text" name="second" size="12" value="${second}" /></td>
				</tr>
				
					
				<tr>
					
				</tr>
			</table>
			<input type="Submit" name="submit" value="Login!">
			<a href="http://localhost:8081/lab02a_smelendez/index">Back!</a>
		</form>
	</body>
</html>