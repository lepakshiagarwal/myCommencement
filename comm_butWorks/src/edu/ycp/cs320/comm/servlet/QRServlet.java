package edu.ycp.cs320.comm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.comm.controller.ContentController;
import edu.ycp.cs320.comm.model.Content;


public class QRServlet extends HttpServlet {
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

		int QR = req.getIntHeader("QR");


		controller = new ContentController();
		model = controller.ContentbyQR(QR);
		if (model.equals(null)) {
			errorMessage = "QR you have entered is not valid.";
		} else {
			
		}


			// Forward to view to render the result HTML document
			req.getRequestDispatcher("/_view/QRCode.jsp").forward(req, resp);
		}
	}