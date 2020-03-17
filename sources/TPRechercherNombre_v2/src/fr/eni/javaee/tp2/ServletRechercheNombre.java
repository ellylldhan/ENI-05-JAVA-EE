package fr.eni.javaee.tp2;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletRechercheNombre
 */
@WebServlet(urlPatterns = { "/modules/module2/ServletRechercheNombre" }, initParams = {
		@WebInitParam(name = "MIN", value = "0"), @WebInitParam(name = "MAX", value = "10") })
public class ServletRechercheNombre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int nat = 0; // nombreATrouver
	private static int MIN = 0;
	private static int MAX = 10;
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
		if(this.getInitParameter("MIN") != null) {
			MIN = Integer.valueOf(this.getInitParameter("MIN"));
		}
		
		if(this.getInitParameter("MAX") != null) {
			MAX = Integer.valueOf(this.getInitParameter("MAX"));
		}
		
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
//		MAX = Integer.parseInt(request.getAttribute("slider").toString());
//		response.getWriter().append(" *** " + MAX);
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ns = request.getParameter("nombre"); // nombreSaisi

		if (ns.contentEquals(String.valueOf(nat)) && !trouve) {
			response.sendRedirect("gagne.html");
			this.trouve = true;
		} else {
			response.sendRedirect("perdu.html");
		}

	}

}