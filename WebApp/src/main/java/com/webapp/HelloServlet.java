package com.webapp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class HelloServlet
 */
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// getting values
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String cb = request.getParameter("cb");

		// setting response
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		if (cb != null) {
			if (cb.equals("Checked")) {
				pw.println("Welcome to HelloServlet Page! <br> <br>");
				pw.println("Your Email is " + email + "<br>");
				pw.println("Your Password is " + pass + "<br>");
			}
		} else {
			pw.println("<h3>Please accept terms and conditions.</h3>");

			// including form in this servlet page
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);

		}

		pw.close();
	}
}
