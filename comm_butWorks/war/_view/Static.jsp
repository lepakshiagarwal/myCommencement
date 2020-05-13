<!DOCTYPE html>
<html>

<head>
		<title>Static view</title>
<style>
 h1 {
font-size: 50px;
text-align: center;
color:green;
font-family:impact;}
.img {
  margin: auto;
  position: absolute;
  top: 0; left: 0; bottom: 0; right: 0;
  width: 700px;
  height: 400px;
}
</style>
</head>
<body>
<h1> CONGRATS GRAD! </h1>
<img class="img" src="http://localhost:8081${pageContext.request.contextPath}/${Url}"/>

</body>
</html>