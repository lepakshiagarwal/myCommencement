<!DOCTYPE html> 
<html>
<head>
		<title>Video </title>
<style>
 h1 {
font-size: 50px;
text-align: center;
color:green;
font-family:impact;}
.video {
  margin: auto;
  position: absolute;
  top: 0; left: 0; bottom: 0; right: 0;
  width: 700px;
  height: 400px;
}
</style>
	</head> 
<body> 

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
<h1> CONGRATS GRAD! </h1>
<video class="video" controls autoplay>
  <source id="video" src="http://localhost:8081${pageContext.request.contextPath}/${Url}" type="video/mp4">
  Your browser does not support HTML5 video.
</video>
</body> 
</html>