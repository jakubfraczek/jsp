package src.jsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet({ "/FirstServlet", "/hello", "/homepage" })
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Hello world!").append(request.getRemoteAddr());
		String param = request.getParameter("action");
		switch (param){
		case "index":
			response.sendRedirect("http://localhost:8081/HelloWorld/index.jsp");
			break;
		case "gallery":
			response.sendRedirect("http://localhost:8081/HelloWorld/gallery.jsp");
			break;
		case "about":
			response.sendRedirect("http://localhost:8081/HelloWorld/about.jsp");
			break;
		case "contact":
			response.sendRedirect("http://localhost:8081/HelloWorld/contact.jsp");
			break;
		default:
			break;
		}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}