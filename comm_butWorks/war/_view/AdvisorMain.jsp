!DOCTYPE html>
<html>
<head>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<meta charset="ISO-8859-1">
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
			<input type="checkbox"> View Content
            <br>
            
          <textarea name="comment" cols="40" rows="6" placeholder="write comment here"></textarea><br>
            <br>
            <br>
      <!-- this is a droup down menu for advisor to approve or deny content-->
		<label for="Status">Status: </label>
  		<select id="Status" name="Status">
    			<option value="Approve">Approve</option>
   			<option value="Deny">Deny</option>
  		</select>
        <br>
        <br>
  		<input type="submit">
		</c:forEach>
	</ul>
	<!--Button for log out-->
	<button ><a href=" http://localhost:8081/lab02/index">Log out!</a></button>
</body>
</html>