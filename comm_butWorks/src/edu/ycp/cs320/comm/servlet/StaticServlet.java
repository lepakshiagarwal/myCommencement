package edu.ycp.cs320.comm.servlet;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
public class StaticServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Student static: doGet");	
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/Static.jsp").forward(req, resp);
	}
	
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		
		//get the URL of the uploaded file
		String fileUrl = "http://localhost:8081/lab02/uploaded-files/IMG_6269.JPG";
		
	
		response.getOutputStream();
		response.getOutputStream().println("<p><a href=\"" + fileUrl + "\">" + fileUrl + "</a></p>");
		//response.getOutputStream().println("<p>Upload another file <a href=\"http://localhost:8080/index.html\">here</a>.</p>");	
	}
}