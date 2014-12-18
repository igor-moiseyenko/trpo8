package com.imoiseyenko.spastructure.frontend.webclient;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet to start SPA.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Apr 1, 2014
 */
@WebServlet(name = "webclient", urlPatterns = { "/app" })
public class WebClientServlet extends HttpServlet {

	/** Serial version id. */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(
				"/WEB-INF/view/application.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}
}
