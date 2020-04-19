<!DOCTYPE html>

<html>
	<head>
		<title>CS320 Books</title>
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
		<h1>Student Name</h1>
		<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
	
		<form action="${pageContext.servletContext.contextPath}/StudentMain" method="post">
			
			<table>
			    <tr>
					<td class="major">Major:   </td>
				</tr>
				 <tr>
					<td class="GPA">GPA:   </td>
				</tr>	
				 <tr>
					<td class="AdvisorName">Advisor Name:   </td>      				
			    </tr>
			    <tr>
					<td class="studentContent">Upload:   </td>      				
			    </tr>
			        
			    <c:forEach items="${students}" var="student">
			        <tr class="studentRow">
			           
			            <td class="major">${student.major}</td>
			            <td class="GPA">${student.GPA}</td>	
			            <td class="AdvisorName">${student.advisorName}</td>		
			            <td class="studentContent">${student.studentContent}</td>		             
			        </tr>
			    </c:forEach>
			    
			</table>
			
			<form action="${pageContext.servletContext.contextPath}/StudentMain" method="post">
			<input type="Submit" name="submithome" value="Update Content">
		</form>		
		</form>
		<a href="http://localhost:8081/lab02/Static">  
 		<input type="button" value="Static view" />
		</a>
		<a href="http://localhost:8081/lab02/Slideshow">  
 		<input type="button" value="Slideshow view" />
		</a>
		<a href="http://localhost:8081/lab02/Video">  
 		<input type="button" value="Video view" />
		</a>
		<br> <br> <br>
	</body>
</html>