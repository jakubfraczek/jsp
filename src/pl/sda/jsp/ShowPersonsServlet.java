package pl.sda.jsp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.sda.DAO.PersonDAO;
import pl.sda.DAO.PersonDAOJdbcSQliteImpl;
import pl.sda.DAO.PersonSQLiteConnectionMenager;
import pl.sda.model.Person;

/**
 * Servlet implementation class ShowPersonsServlet
 */
@WebServlet({ "/ShowPersonsServlet", "/ShowPersons", "/showpersons" })
public class ShowPersonsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowPersonsServlet() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PersonSQLiteConnectionMenager sqLiteConnectionMenager = new PersonSQLiteConnectionMenager();
			PersonDAO personDAO = new PersonDAOJdbcSQliteImpl(sqLiteConnectionMenager);
			List<Person> people = personDAO.getPeople();
			request.setAttribute("people", people);
			request.getRequestDispatcher("showPersons.jsp").forward(request, response);
		} catch (Exception e) {
			String error = e.toString();
			request.setAttribute("error", error);
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;

		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			PersonSQLiteConnectionMenager sqLiteConnectionMenager = new PersonSQLiteConnectionMenager();
			PersonDAO personDAO = new PersonDAOJdbcSQliteImpl(sqLiteConnectionMenager);
			personDAO.delete(Integer.parseInt(request.getParameter("delete")));
		} catch (Exception e) {
			e.printStackTrace();
			String error = e.toString();
			request.setAttribute("error", error);
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;

		}

		
		String msg = "Person deleted successfully";
		request.setAttribute("msg", msg);
		doGet(request, response);
	}

}
