package fr.eni.javaee.tp1;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletRechercheNombre
 */
@WebServlet("/ServletRechercheNombre")
public class ServletRechercheNombre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int nat = 0; // nombreATrouver
	private static final int MIN = 0;
	private static final int MAX = 10;
	private boolean trouve = false;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletRechercheNombre() {
		super();
		// TODO Auto-generated constructor stub
	}

	// voir CYCLE DE VIE

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		this.nat = getNombreAleatoire();
		System.out.println("nombre à trouver : " + this.nat);
	}

	private static int getNombreAleatoire() {
		return new Random().nextInt((MAX - MIN) + 1) + MIN;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ns = request.getParameter("nombre");   // nombreSaisi
		
		// trouve = false, pour eviter que plusieurs joueurs jouent la meme reponse (sic)
		if (ns.contentEquals(String.valueOf(nat)) || ! trouve) {
			response.sendRedirect("gagne.html");
			this.trouve = true;
		} else {
			response.sendRedirect("perdu.html");
		}
		
	}

}
