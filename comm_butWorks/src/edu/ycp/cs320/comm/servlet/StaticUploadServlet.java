package edu.ycp.cs320.comm.servlet;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import edu.ycp.cs320.comm.model.Content;
import edu.ycp.cs320.comm.model.Student;

@MultipartConfig(maxFileSize = 1699999999)
public class StaticUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//for validate method
	private Student model;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Static Servlet: doGet");	
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/Static.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		

		System.out.println("upload Servlet: doPost");
		
		 try {
			Part filePart = req.getPart("fileToUpload");
			InputStream input = null;
			 if(filePart != null) {
				 long fileSize = filePart.getSize();
				 String cont = filePart.getContentType();
				 input = filePart.getInputStream();
			 }
			 
			 
			 
		 }catch(Exception exe) {
			 exe.printStackTrace();
		 }

	

		// Add parameters as request attributes
		req.setAttribute("fileToUpload", req.getParameter("fileToUpload"));




		
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/StudentMain.jsp").forward(req, resp);
	}
}