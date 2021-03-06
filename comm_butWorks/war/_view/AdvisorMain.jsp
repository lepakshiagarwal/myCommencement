
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="_view/Notification.css">
<title>Advisor Home</title>
</head>
<body>

	<b> Hello <c:out value="${user.username}"></c:out>!</b>
	<button id="myBtn" class="modalbutton" > Inbox</button>

	<div id="myModal" class="modal">

 	 <div class="modal-content">
    	<span class="close">&times;</span>
	<ul>
   	 <c:forEach items="${notification}">
		<li><c:out value="${notification}"/> </li>
		</c:forEach>
	</ul>	
  	</div>

	</div>
	<!-- this is going to be the list of students,
	 retrieved from the student database. The servlet
	  will have to create a list for this jsp to loop through-->
	<ul>
		<c:forEach var="student" items="${studentList}">
			<li> > <c:out value="${student.username}"/> </li>
		</c:forEach>
	</ul>	
	<form action="${pageContext.request.contextPath}/AdvisorMainServlet" method="post">
		Student Username: <input type="text" name="name"> 
		<br>
		<br>
		<input type="submit" name="button" value="viewContent">
            <br>
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
  		<input type="submit" name="button" value="submit">
	<br>
	<br>
	</form>
	<!--Button for log out-->
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