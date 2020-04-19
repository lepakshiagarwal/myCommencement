<!DOCTYPE html>
<html>
<head>
		<title>Static Upload</title>
	</head>
<body>

<form action="${pageContext.servletContext.contextPath}/Static" method="post" enctype="multipart/form-data">
    Select image to upload:
    <input type="file" name="fileToUpload" id="fileToUpload">
    <input type="submit" value="Upload Image" name="submit">
</form>

</body>
</html>