package src.jsp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.model.Image;

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
		src.model.Gallery gallery = new src.model.Gallery("Murreys");
		fillGallery(gallery);
		request.setAttribute("gallery", gallery);
		request.getRequestDispatcher("gallery.jsp").forward(request, response);
	}

	private void fillGallery(src.model.Gallery gallery) {
		int i = 0;
		File source = Paths.get(System.getProperty("user.home"), "Desktop", "images.txt").toFile();
		try (Scanner sc = new Scanner(source)) {
			while (sc.hasNextLine()) {
				Image image = new Image(sc.nextLine(), ("Murrey no. " + ++i));
				gallery.addImage(image);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		;
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
