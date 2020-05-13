package edu.ycp.cs320.comm.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.prodb.persist.DatabaseProvider2;
import edu.ycp.cs320.prodb.persist.ProjectDatabse;


public class QRServlet extends HttpServlet {
	DatabaseProvider2 dbp;
	ProjectDatabse db;
	private static final long serialVersionUID = 1L;

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
		String status = db.findStatusByUsername(user);
		System.out.println(cont);	
		System.out.println(status);	

		// Forward to view to render the result HTML document
		if(status.equals("Deny")) {
			System.out.println("generic jsp");	

			req.getRequestDispatcher("/_view/QRGeneric.jsp").forward(req, resp);

		}else {
			if(status.equals("NULL")) {
				System.out.println("generic jsp");	
				req.getRequestDispatcher("/_view/QRGeneric.jsp").forward(req, resp);
			}else {
				if(cont.equals("Video")) {
					System.out.println("video jsp");	
					req.getRequestDispatcher("/_view/QRvideo.jsp").forward(req, resp);
				}else if(cont.equals("Static")){
					System.out.println("static jsp");	
					req.getRequestDispatcher("/_view/QRCode.jsp").forward(req, resp);
				}else if(cont.equals("SlideShow")){
					File root = new File("./war/uploaded-files/"+user);
					String[] urls = root.list();
					for(int i=1;i<4;i++)
					{
						try
						{
							req.setAttribute("Url"+i, "uploaded-files/"+user+"/"+urls[i-1]);
							System.out.print(urls[i-1]);
						}
						catch(NullPointerException e)
						{
							e.printStackTrace();
							System.out.print("root directory is returning no files");
						}
					}
					System.out.println("SlideShow jsp");	
					req.getRequestDispatcher("/_view/QRSlide.jsp").forward(req, resp);
				}else{
					System.out.println("no jsp");	
					req.getRequestDispatcher("/_view/QRGeneric.jsp").forward(req, resp);
				}
			}
		}
	}
}