<!DOCTYPE html>

<html>
	<head>
		<title>Student</title>
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
		<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
	
		<form action="${pageContext.servletContext.contextPath}/StudentMain" method="post">
			
			<table>
			    <tr>
					<td class="major">Major: <td class="Major">${Major}</td>  </td>
				</tr>
				 <tr>
					<td class="GPA">GPA: <td class="GPA">${GPA}</td>	
					  </td>
				</tr>	
				 <tr>
					<td class="AdvisorID">Advisor ID: <td class="AdvisorID">${AdvisorID}</td>  </td>      				
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
			<input type="file" name="fileToUpload">
			<br/><br/>
			<input type="submit" value="Submit">
		</form>
		<form action="${pageContext.servletContext.contextPath}/Static" method="POST">
 		        
 		 <input type="Submit" name="Static" value="Static">         
 		 <input type="submit" value="Slideshow" name="button">                 
 		 <input type="submit" value="Video" name="button">                 
		</form>
		<br> <br> <br>
	</body>
</html>