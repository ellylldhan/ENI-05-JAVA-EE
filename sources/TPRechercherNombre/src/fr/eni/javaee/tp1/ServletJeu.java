package fr.eni.javaee.tp1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletJeu
 */
@WebServlet("/ServletJeu")
public class ServletJeu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int nombreAleatoire;
	private static final int MIN = 0;
	private static final int MAX = 10;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletJeu() {
		super();
		ServletJeu.nombreAleatoire = getNombreAleatoire();
	}

	private static int getNombreAleatoire() {
		Random r = new Random();
		return r.nextInt((MAX - MIN) + 1) + MIN;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		int nombre = -1;
		boolean isInt = false;

		try {
			nombre = Integer.parseInt(request.getParameter("nombre"));
//			nombre = Integer.parseInt(request.getParameter("slider"));
			System.out.println("Nombre tiré : " + nombre);
			isInt = true;
		} catch (NumberFormatException e) {
			System.out.println("Pas un nombre : " + request.getParameter("nombre"));
//			response.sendRedirect("index.html");
			response.getWriter().append("<h1>Erreur</h1>");
			response.getWriter().append("<p>Choisissez un nombre entre 0 et 10 !</p>");
			response.getWriter().append("<p>Pas un nombre : " + request.getParameter("nombre") + "</p>");
		}

		if ((nombre > 10 || nombre < 0) && isInt) {
			response.getWriter().append("<h1>Erreur</h1>");
			response.getWriter().append("<p>Choisissez un nombre entre 0 et 10 !</p>");
			response.getWriter().append("<p>Nombre proposé   : " + nombre + "</p>");

		} else if (nombre != ServletJeu.nombreAleatoire && isInt) {
			response.getWriter().append("<h1>Perdu</h1>");
			response.getWriter().append("<p>Nombre à trouver : " + ServletJeu.nombreAleatoire + "</p>");
			response.getWriter().append("<p>nombre proposé   : " + nombre + "</p>");

		} else if (nombre == ServletJeu.nombreAleatoire) {
			response.getWriter().append("<h1>Gagné</h1>");
			response.getWriter().append("<p>nombre tiré    : " + ServletJeu.nombreAleatoire + "</p>");
			response.getWriter().append("<p>nombre proposé : " + nombre + "</p>");
			ServletJeu.nombreAleatoire = getNombreAleatoire();
		}

		response.getWriter().append("<a href='index.html'>Rejouer ?</a>");

	}

//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
////		response.getWriter().append("Served at: ").append(request.getContextPath());
////		response.getWriter().append("\nNombre donné : ").append(request.getParameter("nombre"));
//
//		int nombre = -1;
//		
//		try {
//			 nombre = Integer.parseInt(request.getParameter("nombre"));
//		} catch(Exception e) {
//			System.out.println("Pas un nombre");
//		}
//		
//		PrintWriter out = response.getWriter();
//		String title = "Titre";
//		String h1 = "h1";
//		String msg = "msg";
//		boolean isHidden = true;
//
//		if (nombre > 10 && nombre < 0) {
//			title = "Erreur";
//			h1 = "Erreur";
//			msg = "Choisissez un nombre entre 0 et 10 !";
//
//			
//		} else if ( nombre != nombreAleatoire ) {
//			title = "Perdu";
//			h1 = "Perdu";
//			msg = "nombre tiré : " + nombreAleatoire;
//			isHidden = false;
//			
//		} else if ( nombre == nombreAleatoire) {
//			title = "Gagné";
//			h1 = "Gagné";
//			msg = "nombre tiré : " + nombreAleatoire;
//			isHidden = false;
//		}
//		
//		out.print("<html>");
//		out.print("<head><title>"+title+"</title></head>");
//		out.print("<body>");
//		out.print("<h1>"+ h1 + "</h1>");
//		out.flush();
//		out.print("<p>"+msg+"</p>");
//		out.print("<a href='index.html' style='"+isHidden+"'>Rejouer ?</a>");
//		out.flush();
//		out.print("</body>");
//		out.print("</html>");
//		out.flush();
//		out.close();
//		
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
