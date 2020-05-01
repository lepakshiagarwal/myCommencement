package edu.ycp.cs320.comm.servlet;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import edu.ycp.cs320.comm.model.Student;
import edu.ycp.cs320.prodb.persist.DatabaseProvider;
import edu.ycp.cs320.prodb.persist.ProjectDatabse;

@MultipartConfig
public class FileUploadServlet extends HttpServlet {

	DatabaseProvider dbp;
	ProjectDatabse db;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Student upload: doGet");	
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/StudentUpload.jsp").forward(req, resp);
	}
	
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		//get the file chosen by the user
		Part filePart = request.getPart("fileToUpload");
		
		//get the InputStream to store the file somewhere
	    InputStream fileInputStream = filePart.getInputStream();
	    
	    Student user =(Student)request.getSession().getAttribute("user");
	    //for example, you can copy the uploaded file to the server
	    //note that you probably don't want to do this in real life!

	    //upload it to a file host like S3 or GCS instead
	    File fileToSave = new File("war/uploaded-files/" +user.getUsername()+"/"+ filePart.getSubmittedFileName());

		Files.copy(fileInputStream, fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);
		
		//get the URL of the uploaded file
		String fileUrl = "war/uploaded-files/" +user.getUsername()+"/"+ filePart.getSubmittedFileName();
		try {
			dbp.setInstance(new ProjectDatabse());
			db = (ProjectDatabse) dbp.getInstance();
			db.insertContentURLByStudentUsername(user.getUsername(), filePart.getSubmittedFileName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//You can get other form data too
	
		//response.getOutputStream().println("<p><img src= filePart.getSubmittedFileName()></p>");

		
		//create output HTML that uses the 
		response.getOutputStream().println("<p>Here's a link to your uploaded file:</p>");
		response.getOutputStream().println("<p><a href=\"" + fileUrl + "\">" + fileUrl + "</a></p>");
		//response.getOutputStream().println("<p>Upload another file <a href=\"http://localhost:8080/index.html\">here</a>.</p>");	
	}
}