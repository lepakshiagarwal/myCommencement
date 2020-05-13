package edu.ycp.cs320.comm.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.comm.controller.AdvisorController;
import edu.ycp.cs320.comm.model.Advisor;
import edu.ycp.cs320.comm.model.Student;
import edu.ycp.cs320.prodb.persist.DatabaseProvider;
import edu.ycp.cs320.prodb.persist.IDatabase2;
import edu.ycp.cs320.prodb.persist.ProjectDatabse;

@WebServlet("/AdvisorMainServlet")
public class AdvisorMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int notify;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		DatabaseProvider.setInstance((IDatabase2) new ProjectDatabse());
		ProjectDatabse prodb = (ProjectDatabse) DatabaseProvider.getInstance();

		Advisor model =  (Advisor) req.getSession().getAttribute("user");
		System.out.println("AdvisorMain Servlet: doGet");
		ArrayList<String> notification = new ArrayList<String>();
		notify= prodb.findNotificationByUsernameAdvisor(model.getUsername());
		for(int j= 1; j<= notify; j++) {
			notification.add("Student uploaded content");
		}
		System.out.println(notification);
		//set list of students as attribute
		req.setAttribute("studentList", model.adviseeList());
		req.setAttribute("user", model);
		req.setAttribute("notification", notification);
		// add result objects as attributes

		// call JSP to generate empty form

		req.getRequestDispatcher("/_view/AdvisorMain.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		DatabaseProvider.setInstance((IDatabase2) new ProjectDatabse());
		ProjectDatabse prodb = (ProjectDatabse) DatabaseProvider.getInstance();

		System.out.println("advisor Servlet: doPost");	
		String name = req.getParameter("name");
		System.out.print(name);
		String contentType= prodb.findContentTypeByUsername(name);
		String fileName = prodb.findContentURLByStudentUsername(name);
		String but = req.getParameter("button");
		System.out.println(but);
		if(but.contentEquals("viewContent")) {
			if(contentType.equals("Static")) {
				System.out.println("static jsp");
				String contentUrl = "uploaded-files/"+name+"/"+fileName;
				req.setAttribute("Url", contentUrl);
				req.getRequestDispatcher("/_view/Static.jsp").forward(req, resp);
			}
			else if(contentType.equals("Video")) {
				System.out.println("video jsp");
				String contentUrl = "uploaded-files/"+name+"/"+fileName;
				req.setAttribute("Url", contentUrl);
				req.getRequestDispatcher("/_view/Video.jsp").forward(req, resp);
			}
			else if(contentType.equals("SlideShow")) {
				System.out.println("Slideshow jsp");	
				String contentUrl = "uploaded-files/"+name+"/"+fileName;


				System.out.print(contentUrl);
				File root = new File("./war/uploaded-files/"+name);
				String[] urls = root.list();
				for(int i=1;i<4;i++)
				{
					try
					{
						req.setAttribute("Url"+i, "uploaded-files/"+name+"/"+urls[i-1]);
						System.out.print(urls[i-1]);
					}
					catch(NullPointerException e)
					{
						e.printStackTrace();
						System.out.print("root directory is returning no files");
					}
				}
				req.getRequestDispatcher("/_view/SlideShow.jsp").forward(req, resp);
			}
			else {
				req.getRequestDispatcher("/_view/NoContent.jsp").forward(req, resp);
			}
		}
		String status = req.getParameter("Status") ;
		System.out.print(status);
		String comment = req.getParameter("comment");
		System.out.print(comment);	
		try {
			prodb.insertCommentByUsername(name, comment);
			prodb.insertNotificationByUsername(name, notify++);
			System.out.print("done");
			prodb.insertStatusByUsername(name, status);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(but.equals("submit")) {
			req.getRequestDispatcher("/_view/ResponseRecorded.jsp").forward(req, resp);
		}

		// holds the error message text, if there is any
		String errorMessage = null;

		// result of calculation goes here
		boolean result = false;


	}

	// gets double from the request with attribute named s
	private String getStringFromParameter(String s) {
		if (s == null || s.equals("")) {
			return null;
		} else {
			return s;
		}
	}
}