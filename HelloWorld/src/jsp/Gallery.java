package jsp;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Image;
import model.ModelGallery;

/**
 * Servlet implementation class Gallery
 */
@WebServlet({ "/Gallery", "/gallery" })
public class Gallery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Gallery() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelGallery gallery = createGallery();
		request.setAttribute("gallery", gallery);
		request.getRequestDispatcher("gallery.jsp").forward(request, response);
		if(request.getParameter("action") != null && request.getParameter("action").equals("index")){
			response.sendRedirect("index.jsp");
		}
	}

	private model.ModelGallery createGallery() throws IOException {
		ModelGallery gallery = new ModelGallery("Murreys");
		int i = 0;
		try (Scanner sc = new Scanner(Paths.get(System.getProperty("user.home"), "Desktop", "images.txt").toFile())) {
			while (sc.hasNextLine()) {
				Image image = new Image(sc.nextLine(), ("Murrey no. " + ++i));
				gallery.addImage(image);
			}
		}
		;
		return gallery;
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
