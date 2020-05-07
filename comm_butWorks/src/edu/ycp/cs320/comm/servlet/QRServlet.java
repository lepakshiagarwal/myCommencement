package edu.ycp.cs320.comm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.comm.controller.ContentController;
import edu.ycp.cs320.comm.model.Content;
import edu.ycp.cs320.prodb.persist.DatabaseProvider;
import edu.ycp.cs320.prodb.persist.ProjectDatabse;


public class QRServlet extends HttpServlet {
	DatabaseProvider dbp;
	ProjectDatabse db;
	private static final long serialVersionUID = 1L;
	//for validate method
	private String model;
	private ContentController controller;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("QR Servlet: doGet");	

		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/QRCode.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {


		System.out.println("QR Servlet: doPost");
		String errorMessage = null;

		int QR = Integer.parseInt(req.getParameter("QR"));

		System.out.println(QR);	


		dbp.setInstance(new ProjectDatabse());
		db = (ProjectDatabse) dbp.getInstance();
		String fileName = db.findContentByQR(QR);
		String user = db.findUserbyQR(QR);
		System.out.println(fileName);
		System.out.println(user);	
		String contentUrl = "uploaded-files/"+user+"/"+fileName;
		req.setAttribute("Url", contentUrl);

		String cont = db.findContentTypeByUsername(user);

		System.out.println(cont);	

		// Forward to view to render the result HTML document
		if(cont == null) {
			req.getRequestDispatcher("/_view/QRCode.jsp").forward(req, resp);
		}else {
		if(cont.equals("Video")) {
			System.out.println("video jsp");	
			req.getRequestDispatcher("/_view/QRvideo.jsp").forward(req, resp);
		}else if(cont.equals("Static")){
			System.out.println("static jsp");	
			req.getRequestDispatcher("/_view/QRCode.jsp").forward(req, resp);
		}else{
			System.out.println("no jsp");	
			req.getRequestDispatcher("/_view/QRvideo.jsp").forward(req, resp);
		}
	   }
	}
}