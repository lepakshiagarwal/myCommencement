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
		<video width="400" controls>
  			<source id="video" src="http://localhost:8081${pageContext.request.contextPath}/${Url}" type="video/mp4">
 				 Your browser does not support HTML5 video.
</video>
	</body>
</html>