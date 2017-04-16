package pl.sda.jsp;

import java.io.IOException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.sda.model.Image;
import pl.sda.model.ModelGallery;

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
		String user = request.getParameter("user");
		ModelGallery gallery = new ModelGallery(user);

		int noPhoto = 0;
		try {
			noPhoto = Integer.parseInt(request.getParameter("noPhoto"));
		} catch (NumberFormatException e) {
			String error = e.toString();
			request.setAttribute("error", error);
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}

		URL url = new URL("https://www.instagram.com/" + user + "/");
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

		int code;
		if ((code = connection.getResponseCode()) == 200) {

			try (Scanner sc = new Scanner(url.openStream())) {
				String inputLine;
				while (sc.hasNext()) {
					inputLine = sc.nextLine();
					gallery = parserHTML(inputLine, gallery, noPhoto);

				}

			} catch (NoSuchElementException e) {
				response.getWriter().append(e.getMessage());
			}

		} else {
			String error = "Server response code: " + code + " " + connection.getResponseMessage();
			request.setAttribute("error", error);
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}

		request.setAttribute("gallery", gallery);
		request.getRequestDispatcher("gallery.jsp").forward(request, response);
	}

	private ModelGallery parserHTML(String inputLine, ModelGallery gallery, int noPhoto) {
		Image image = null;
		if (inputLine.contains("<img alt")) {
			String a = " alt=\"";
			String s = "src=\"";
			String j = "jpg\"";
			String[] splitedLine = inputLine.split("img");

			for (int i = 0; i < splitedLine.length; i++) {

				if (splitedLine[i].startsWith(" alt")) {
					int xa = splitedLine[i].indexOf(a) + a.length();
					int xs = splitedLine[i].indexOf(s) + s.length();
					int xj = splitedLine[i].indexOf(j) + j.length() - 1;

					String photoUrl = splitedLine[i].substring(xs, xj);

					String descriptionSubString = splitedLine[i].substring(xa);
					String description = descriptionSubString.substring(0, descriptionSubString.indexOf("\""));
					image = new Image(photoUrl, description);

					if (gallery.getImages().size() == 0) {
						gallery.addImage(image);
					} else if (!gallery.getImages().get(gallery.getImages().size() - 1).getUrl().equals(photoUrl)
							&& gallery.getImages().size() < noPhoto) {
						gallery.addImage(image);
					}
				}
			}
		}
		return gallery;
	}

}