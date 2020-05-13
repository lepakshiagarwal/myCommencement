<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {box-sizing: border-box;}
body {font-family: Verdana, sans-serif;}
.mySlides {display: none;}
img {vertical-align: middle;}

/* Slideshow container */
.slideshow-container {
  max-width: 100%;
  max-height: 100%;
  position: relative;
  margin: auto;
display:grid;
}

/* Number text (1/3 etc) */
.numbertext {
  color: #f2f2f2;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}

/* The dots/bullets/indicators */
.dot {
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

.active {
  background-color: #717171;
}

/* Fading animation */
.fade {
  -webkit-animation-name: fade;
  -webkit-animation-duration: 1.5s;
  animation-name: fade;
  animation-duration: 1.5s;
}

@-webkit-keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

@keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

/* On smaller screens, decrease text size */
@media only screen and (max-width: 300px) {
  .text {font-size: 11px}
}
 h1 {
font-size: 50px;
text-align: center;
color:green;
font-family:impact;}
img{
  max-width: 100%;
            max-height: 100vh;
            margin: auto;
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
<h1> Congrats Grad! </h1>
<div class="slideshow-container">

<div class="mySlides fade">
  <div class="numbertext">1 / 3</div>
  <img class="img" src="http://localhost:8081${pageContext.request.contextPath}/${Url1}">

</div>

<div class="mySlides fade">
  <div class="numbertext">2 / 3</div>
  <img class="img" src="http://localhost:8081${pageContext.request.contextPath}/${Url2}" style="width:100%">
</div>

<div class="mySlides fade">
  <div class="numbertext">3 / 3</div>
  <img class ="img"src="http://localhost:8081${pageContext.request.contextPath}/${Url3}" style="width:100%">
</div>

</div>
<br>

<div style="text-align:center">
  <span class="dot"></span> 
  <span class="dot"></span> 
  <span class="dot"></span> 
</div>

<script>
var slideIndex = 0;
showSlides();

function showSlides() {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";  
  }
  slideIndex++;
  if (slideIndex > slides.length) {slideIndex = 1}    
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
  setTimeout(showSlides, 2000); // Change image every 2 seconds
}
</script>

</body>
</html> 
