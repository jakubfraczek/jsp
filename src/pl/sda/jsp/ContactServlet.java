package pl.sda.jsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.sda.model.Email;
import pl.sda.model.MessageConfirm;

@WebServlet({ "/Contact", "/contact" })
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContactServlet() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		MessageConfirm mc = new MessageConfirm(name, surname, email, message);
		Email mail = new Email(mc);
		
		mail.send();
		
		request.setAttribute("message", mc);
		request.getRequestDispatcher("sendMessage.jsp").forward(request, response);
	}

}
