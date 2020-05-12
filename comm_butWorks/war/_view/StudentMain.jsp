<!DOCTYPE html>

<html>
	<head>
		<title>Student</title>
		<link rel="stylesheet" href="_view/Notification.css">
		<style type="text/css">
			.error {
				color: red;
				font-weight: bold;
			}
			
			td.label {
				text-align: right;
			}
			
			td.book {
				text-align: center;
				color: blue;
				font-weight: bold;
			}
			
			td.bookColHeading {
				text-align: center;
				font-weight: bold;
				max-width: 400px;
			}
			
			td.isbnColHeading {
				text-align: center;
				font-weight: bold;
				max-width: 200px;
				padding-left: 20px;
			}
			
			td.publishedColHeading {
				text-align: center;
				font-weight: bold;
				max-width: 100px;
				padding-left: 20px;
			}

			tr.bookRow {
				text-align: left;
				color: blue;
				font-weight: bold;
			}
			
			td.bookCol {
				text-align: left;
				color: blue;
				font-weight: bold;
				max-width: 400px;
			}
			
			td.isbnCol {
				text-align: left;
				color: blue;
				font-weight: bold;
				max-width: 200px;
				padding-left: 20px;
			}
			
			td.publishedCol {
				text-align: left;
				color: blue;
				font-weight: bold;
				max-width: 100px;
				padding-left: 40px;
			}
			
		</style>
	</head>

	<body>
		<h1>Student Main</h1>
			<button id="myBtn" class="modalbutton" > Inbox</button>

	<div id="myModal" class="modal">

 	 <div class="modal-content">
    	<span class="close">&times;</span>
   	 <ul>
   	 <c:forEach items="${notification}">
		<li><c:out value="${notification}"/> </li>
<p>Advisor has submitted feedback</p>
		</c:forEach>
	</ul>	
  	</div>
  	</div>

		<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
	
		<form action="${pageContext.servletContext.contextPath}/StudentMain" method="post">
			
			<table>
			    <tr>
					<td class="major">Major: <td class="Major">${Major}</td>  </td>
				</tr>
				 <tr>
					<td class="GPA">GPA: <td class="GPA">${GPA}</td> </td>
				</tr>	
				 <tr>
					<td class="AdvisorID">Advisor ID: <td class="AdvisorID">${AdvisorID}</td>  </td>      				
			    </tr>
			    <tr>
					<td class="Status">Status: <td class="Status">${Status}</td>  </td>      				
			    </tr>
			    <tr>
					<td class="Comment">Advisor Comment: <td class="Comment">${Comment}</td>  </td>      				
			    </tr>
			    
			    <tr>
					<td class="studentContent">Upload:   </td>      				
			    </tr>
			        
			   
			    
			</table>
			


			<form action="${pageContext.servletContext.contextPath}/StudentMain" method="post">
			<input type="Submit" name="button" value="Update Content">

		</form>		
		
		<form action="/lab02/StudentUpload" method="POST" enctype="multipart/form-data">
			
			<p>What file do you want to upload?</p>
			<input type="file" name="fileToUpload" multiple>
			<br/><br/>
			<input type="submit" value="Submit">
		</form>
		<form action="${pageContext.servletContext.contextPath}/Static" method="POST">
 		        
 		 <input type="Submit" value="Static" name="button">         
 		 <input type="Submit" value="SlideShow" name="button">                 
 		 <input type="Submit" value="Video" name="button">                 
		</form>
		<br> <br> <br>
<button ><a href=" http://localhost:8081/lab02/index">Log out!</a></button>
	</body>

<script>

var modal = document.getElementById("myModal");
var btn = document.getElementById("myBtn");
var span = document.getElementsByClassName("close")[0];


btn.onclick = function() {
  modal.style.display = "block";
}


span.onclick = function() {
  modal.style.display = "none";
}

window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
</script>
</html>