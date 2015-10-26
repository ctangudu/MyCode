/**
 * 
 */
package my.webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Chaitanya Tangudu
 *
 */
public class XmlServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2569873523688285100L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String userName = request.getParameter("userName");
		String userId = request.getParameter("userId");
		writer.println("Hello! User! " + userName + " with Id " + userId);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String userName = request.getParameter("userName");
		String fullName = request.getParameter("fullName");
		writer.println("Hell from POST method " + userName + "! We know your full name is " + fullName);
		String prof = request.getParameter("prof");
		String[] locs = request.getParameterValues("loc");
		writer.println("You are a "+prof+" located at ");
		for (String loc : locs) {
			writer.println(loc+"\n");
		}
	}
}
