package pl.sda.jsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet({ "/hello", "/homepage" })
public class HomepageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomepageServlet() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Hello world!").append(request.getRemoteAddr());

		String param = request.getParameter("action");
		switch (param) {
		case "index":
			response.sendRedirect("index.jsp");
			break;
		case "gallery":
			response.sendRedirect("gallery");
			break;
		case "about":
			response.sendRedirect("about");
			break;
		case "contact":
			response.sendRedirect("contact.jsp");
			break;
		case "instagram":
			response.sendRedirect("instagram.jsp");
			break;
		case "addperson":
			response.sendRedirect("addPerson.jsp");
			break;
		case "showpersons":
			response.sendRedirect("showpersons");
			break;
		case "museums":
			response.sendRedirect("museum");
			break;
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
