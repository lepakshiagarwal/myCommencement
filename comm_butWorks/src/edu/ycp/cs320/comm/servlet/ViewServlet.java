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

import edu.ycp.cs320.comm.model.Advisor;
import edu.ycp.cs320.comm.model.Content;
import edu.ycp.cs320.comm.model.Student;

@MultipartConfig(maxFileSize = 1699999999)
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//for validate method
	private Student model;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("View Servlet: doGet");	
		
		String action = req.getParameter("action");
		if (action.equals("static")){ 
			req.getRequestDispatcher("/_view/Static.jsp").forward(req, resp);
		}else if (action.equals("slideshow")){ 
			req.getRequestDispatcher("/_view/SlideShow.jsp").forward(req, resp);
		}else if (action.equals("video")){ 
			req.getRequestDispatcher("/_view/Video.jsp").forward(req, resp);
		}
		// call JSP to generate empty form
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		

		System.out.println("view Servlet: doPost");
	
		Student model = (Student) req.getSession().getAttribute("user");


		// Add parameters as request attributes
		String action = req.getParameter("action");
		if (action.equals("static")){ 
			req.setAttribute("img", model.getContent());
			req.getRequestDispatcher("/_view/Static.jsp").forward(req, resp);
		}else if (action.equals("slideshow")){ 
			req.setAttribute("", model.getContent());
			req.getRequestDispatcher("/_view/SlideShow.jsp").forward(req, resp);
		}else if (action.equals("video")){ 
			req.setAttribute("video", model.getContent());
			req.setAttribute("audio", model.getContent());
			req.getRequestDispatcher("/_view/Video.jsp").forward(req, resp);
		}

		
	}
}