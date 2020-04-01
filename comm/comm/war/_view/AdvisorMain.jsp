<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Advisor Home</title>
</head>
<body>
	<button> Nothing Yet </button>
	
	
	<!-- this is going to be the list of students,
	 retrieved from the student database. The servlet
	  will have to create a list for this jsp to loop through-->
	<ul>
		<c:forEach var="student" items="${studentList}">
			<li> <c:out value="${student}"/> </li>
		</c:forEach>>
	</ul>
</body>
</html>