package pl.sda.jsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.sda.DAO.PersonDAOJdbcSQliteImpl;
import pl.sda.DAO.SQLiteConnectionMenager;
import pl.sda.model.Person;

/**
 * Servlet implementation class AddPerson
 */
@WebServlet({ "/AddPerson", "/addperson" })
public class AddPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPersonServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			SQLiteConnectionMenager sqLiteConnectionMenager = new SQLiteConnectionMenager();
			PersonDAOJdbcSQliteImpl personDAOJdbcSQliteImpl = new PersonDAOJdbcSQliteImpl(sqLiteConnectionMenager);
			personDAOJdbcSQliteImpl.create(new Person(request.getParameter("name"), request.getParameter("surname"), request.getParameter("bornYear"), request.getParameter("phoneNumber"), request.getParameter("sex")));
			String msg = "Person added successfully";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("addPerson.jsp").forward(request, response);
				
		} catch (Exception e) {
			String error = e.toString();
			request.setAttribute("error", error);
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}
		
	}

}
