package jsp;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Image;
import model.ModelGallery;

/**
 * Servlet implementation class InstagramImagesServlet
 */
@WebServlet({ "/InstagramImagesServlet", "/instagramImagesServlet", "/instagramimagesservlet" })
public class InstagramImagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InstagramImagesServlet() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("dupa: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int i = 0;
		String user = request.getParameter("user");
		ModelGallery gallery = new ModelGallery(user);

		int noPhoto = 0;
		try {
			noPhoto = Integer.parseInt(request.getParameter("noPhoto"));
		} catch (NumberFormatException e) {
			response.getWriter().append("Wrong number fomat\n" + e);
			return;
		}

		URL url = new URL("https://www.instagram.com/" + user + "/");
		try (Scanner sc = new Scanner(url.openStream())) {
			String inputLine;
			String a = "alt=\"";
			String s = "src=\"";
			response.getWriter().append("dupa" + ++i);
			while (gallery.getImages().size() != noPhoto) {
				inputLine = sc.nextLine();
				int xa = inputLine.indexOf(a) + a.length();
				int xs = inputLine.indexOf(s) + s.length();
				response.getWriter().append("dupa" + ++i);
				response.getWriter().append(inputLine.substring(xs, inputLine.indexOf("\"")));
				gallery.addImage(new Image(inputLine.substring(xs, inputLine.indexOf("\"")), inputLine.substring(xa, inputLine.indexOf("\""))));
			}
		}
		response.getWriter().append("dupa" + ++i);
		for(Image img : gallery.getImages()){
			System.out.println(img.getUrl());
		}
		
//		request.setAttribute("gallery", gallery);
//		request.getRequestDispatcher("gallery.jsp").forward(request, response);

	}

}