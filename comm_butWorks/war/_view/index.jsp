<!DOCTYPE html>

<html>
	<head>
		<link rel="stylesheet" href="_view/PCA.css">
		<title>Index view</title>
	</head>

	<body>
	<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
		<h1>Welcome to the YCP Commencement Application</h1>
		<a href="http://localhost:8081/lab02/Studentlogin">Student Login</a>
		<br> <br> <br>
	</body>
	<body>
		<a href="http://localhost:8081/lab02/Advisorlogin">Advisor Login</a>
		<br> <br> <br>
	</body>
	<body>
		<a href="http://localhost:8081/lab02/QRCode">QR code</a>
		<br> <br> <br>
	</body>
</html>
