<!DOCTYPE html> 
<html>
<head>
		<title>Video Upload</title>
	</head> 
<body> 

<video width="400" controls>
  <source id="video" src="http://localhost:8081${pageContext.request.contextPath}/${Url}" type="video/mp4">
  Your browser does not support HTML5 video.
</video>
</body> 
</html>