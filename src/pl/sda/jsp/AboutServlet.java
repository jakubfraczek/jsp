package pl.sda.jsp;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.sda.model.Person;
import pl.sda.model.Sex;


@WebServlet({ "/About", "/about" })
public class AboutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AboutServlet() {
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Person> persons = new LinkedList<>();
		persons.add(new Person("Jan", "Kowalski", 1999, 768938094, Sex.M));
		persons.add(new Person("Ada", "Kowalska", 1967, 938768047, Sex.F));
		persons.add(new Person("Adam", "Nowak", 1908, 466238648, Sex.M));
		persons.add(new Person("Ewa", "Gil", 1997, 458931468, Sex.F));
		persons.add(new Person("Anna", "Kos", 2001, 123456789, Sex.F));
		persons.add(new Person("Krzysztof", "Hope", 1956, 987654321, Sex.M));
		
		request.setAttribute("persons", persons);
		request.getRequestDispatcher("about.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
