package fr.eni.javaee.modules.module2;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLectureToutesLesEntetes
 */
@WebServlet("/modules/module2/ServletLectureToutesLesEntetes")
public class ServletLectureToutesLesEntetes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLectureToutesLesEntetes() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		StringBuilder sb = new StringBuilder();
		String userAgent = request.getHeader("user-agent");
		Enumeration<String> listeEntetes = request.getHeaderNames();

		sb.append("user Agent : ").append(userAgent).append(System.lineSeparator());
		           	
		while (listeEntetes.hasMoreElements()) {
			String entete = listeEntetes.nextElement();
			sb.append(entete).append("\t : ");

			Enumeration<String> valeurs = request.getHeaders(entete);

			while (valeurs.hasMoreElements()) {

				sb.append(valeurs.nextElement());

				if (valeurs.hasMoreElements()) {
					sb.append(", ");
				}
			}
			sb.append(System.lineSeparator());

		}
		response.getWriter().append(sb.toString());

	}

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
