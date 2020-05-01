package edu.ycp.cs320.comm.servlet;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import edu.ycp.cs320.comm.model.Student;
import edu.ycp.cs320.prodb.persist.DatabaseProvider;
import edu.ycp.cs320.prodb.persist.ProjectDatabse;

@MultipartConfig
public class StaticServlet extends HttpServlet 
{
	DatabaseProvider dbp;
	ProjectDatabse db;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3223385844681294829L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Student static: doGet");	
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/Static.jsp").forward(req, resp);
	}
	
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
/*
			File f = new File("C:/Users/melen/git/myCommencement/comm_butWorks/war/uploaded-files/IMG_6269.JPG");
			Image i = ImageIO.read(f);
			
			request.setAttribute("image", i);
	*/		
			dbp.setInstance(new ProjectDatabse());
			db = (ProjectDatabse) dbp.getInstance();
			Student user = (Student) request.getSession().getAttribute("user");
			System.out.print(user.getUsername());
			String fileName = db.findContentURLByStudentUsername(user.getUsername());
			String contentUrl = "uploaded-files/"+user.getUsername()+"/"+fileName;
			request.setAttribute("Url", contentUrl);
			request.getRequestDispatcher("/_view/Static.jsp").forward(request, response);;
		
		
		/*
			response.setContentType("image/jpeg");  
		    
			
			ServletOutputStream out;  
		    out = response.getOutputStream();   
		    FileInputStream fin = new FileInputStream(request.getContextPath()+"/uploaded-files/IMG_6269.JPG");
		    /*
		  /*  BufferedInputStream bin = new BufferedInputStream(fin);  
		    BufferedOutputStream bout = new BufferedOutputStream(out);  
		    int ch = 0; ;  
		    while((ch=bin.read())!=-1)  
		    {  
		    bout.write(ch);  
		    }  
		      
		    bin.close();  
		    fin.close();  
		    bout.close();  
		    
		    out.close();  
		   */
		}
	}
