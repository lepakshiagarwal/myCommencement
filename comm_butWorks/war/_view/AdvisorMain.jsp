
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<title>Advisor Home</title>
</head>
<body>

	<c:out value="${user.username}"></c:out>
	
	
	
	
	<!-- this is going to be the list of students,
	 retrieved from the student database. The servlet
	  will have to create a list for this jsp to loop through-->
	<ul>
		<c:forEach var="student" items="${studentList}">
			<li> > <c:out value="${student.username}"/> </li>
		</c:forEach>
	</ul>
	
	<button> Log out </button>
	
</body>
</html>