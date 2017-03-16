package pl.sda.jsp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.sda.DAO.MuseumDAO;
import pl.sda.DAO.MuseumDAOJdbcSQLiteIpml;
import pl.sda.DAO.MuseumSQLiteConnectionMenager;
import pl.sda.model.Museum;
import pl.sda.model.MuseumStatus;

/**
 * Servlet implementation class Museums
 */
@WebServlet({ "/Museums", "/museum" })
public class MuseumsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Museum> museums;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MuseumsServlet() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			MuseumSQLiteConnectionMenager museumSQLiteConnectionMenager = new MuseumSQLiteConnectionMenager();
			MuseumDAO museumDAO = new MuseumDAOJdbcSQLiteIpml(museumSQLiteConnectionMenager);
			if (museums == null) {
				museums = museumDAO.getAll();
			}
			request.setAttribute("museums", museums);
			request.getRequestDispatcher("showMuseums.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
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
		try {
			MuseumSQLiteConnectionMenager museumSQLiteConnectionMenager = new MuseumSQLiteConnectionMenager();
			MuseumDAO museumDAO = new MuseumDAOJdbcSQLiteIpml(museumSQLiteConnectionMenager);

			findMuseum(request, museumDAO);
		} catch (Exception e) {
			e.printStackTrace();
			String error = e.toString();
			request.setAttribute("error", error);
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;

		}

		doGet(request, response);
	}

	private void findMuseum(HttpServletRequest request, MuseumDAO museumDAO) throws Exception {
		String input = request.getParameter("input");
		String attribute = request.getParameter("attribute");
		if (attribute != null) {
			switch (attribute) {
			case "id":
				int id = Integer.parseInt(input);
				System.out.println(id);
				museums = museumDAO.getById(id);
				break;
			case "museumName":
				museums = museumDAO.getByName(input);
				break;
			case "postalCode":
				museums = museumDAO.getByPostal(input);
				break;
			case "city":
				museums = museumDAO.getByCity(input);
				break;
			case "street":
				museums = museumDAO.getByStreet(input);
				break;
			case "addDate":
				museums = museumDAO.getByDate(input);
				break;
			case "status":
				findByStatus(request, museumDAO);
				break;
			default:
				break;

			}
		}
		if (request.getParameter("clear") != null && request.getParameter("clear").equals("clear")) {
			museums = museumDAO.getAll();
		}
	}

	private void findByStatus(HttpServletRequest request, MuseumDAO museumDAO) throws Exception {
		String status = request.getParameter("status");
		switch (status) {
		case "PRIVATE":
			museums = museumDAO.getByStatus(MuseumStatus.PRIVATE.getStatus());
			break;
		case "LOCAL_GOVERNMENTS":
			museums = museumDAO.getByStatus(MuseumStatus.LOCAL_GOVERNMENTS.getStatus());
			break;
		case "COLEAD_LOCAL":
			museums = museumDAO.getByStatus(MuseumStatus.COLEAD_LOCAL.getStatus());
			break;
		case "COLEAD_NATIONAL":
			museums = museumDAO.getByStatus(MuseumStatus.COLEAD_NATIONAL.getStatus());
			break;
		case "NATIONAL":
			museums = museumDAO.getByStatus(MuseumStatus.NATIONAL.getStatus());
			break;
		case "CHURCH":
			museums = museumDAO.getByStatus(MuseumStatus.CHURCH.getStatus());
			break;
		default:
			break;
		}
	}

}
