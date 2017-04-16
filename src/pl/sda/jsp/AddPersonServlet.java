package pl.sda.jsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.sda.DAO.PersonDAO;
import pl.sda.DAO.PersonDAOJdbcSQliteImpl;
import pl.sda.DAO.PersonSQLiteConnectionMenager;
import pl.sda.model.Person;


@WebServlet({ "/AddPerson", "/addperson" })
public class AddPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddPersonServlet() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PersonSQLiteConnectionMenager sqLiteConnectionMenager = new PersonSQLiteConnectionMenager();
			PersonDAO personDAO = new PersonDAOJdbcSQliteImpl(sqLiteConnectionMenager);
			personDAO.create(new Person(request.getParameter("name"), request.getParameter("surname"), request.getParameter("bornYear"), request.getParameter("phoneNumber"), request.getParameter("sex")));
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
