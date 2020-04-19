<html>
	<head>
		<title>Uploaded Content</title>
	</head>
	<body>
		<form action="/lab02/StudentUpload" method="POST" enctype="multipart/form-data">
			
			<p>What file do you want to upload?</p>
			<input type="file" name="fileToUpload">
			<br/><br/>
			<input type="submit" value="Submit">
		</form>
	</body>
</html>