<!DOCTYPE html>

<html>
	<head>
		<link rel="stylesheet" href="_view/PCA.css">
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
	
		<form action="${pageContext.servletContext.contextPath}/Advisorlogin" method="post">
			<table>
				<tr>
					<td class="label">Advisor Username:</td>
					<td><input type="text" name="username" size="12" value="${username}" /></td>
				</tr>
				<tr>
					<td class="label">Advisor Password:</td>
					<td><input type="text" name="password" size="12" value="${password}" /></td>
				</tr>
				
					
				<tr>
					
				</tr>
			</table>
			<input type="Submit" name="submit" value="Login!">
			<a href="http://localhost:8081/lab02/index">Back!</a>
		</form>
	</body>
</html>