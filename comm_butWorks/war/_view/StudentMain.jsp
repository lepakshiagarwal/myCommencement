<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
		<h1>Student Name</h1>
		<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
	
		<form action="/StudentMain" method="post" enctype="multipart/form-data">
			
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
			        
			    <c:forEach items="${students}" var="student">
			        <tr class="studentRow">
			           
			            <td class="major">${student.major}</td>
			            <td class="GPA">${book.GPA}</td>	
			            <td class="AdvisorName">${book.advisorName}</td>		            
			        </tr>
			    </c:forEach>
			    
			</table>
			
			
			
			<a href="http://localhost:8081/lab02/StudentUpload">Upload Content!</a>
		
			
			
			
			
		</form>
	</body>
</html>