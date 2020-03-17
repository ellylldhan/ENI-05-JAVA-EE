package fr.eni.javaee.suivirepas.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.suivirepas.bll.RepasManager;
import fr.eni.javaee.suivirepas.bo.Repas;

/**
 * Servlet implementation class ServletAjoutRepas
 */
@WebServlet("/ServletAjoutRepas")
public class ServletAjoutRepas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAjoutRepas() {
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

//		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/ajoutRepas.jsp");
		RequestDispatcher rd = this.getServletContext().getNamedDispatcher("AjoutRepas");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		String flagSucces = "false";
		
		request.setCharacterEncoding("UTF-8");

		String date = request.getParameter("dateRepas");
		String heure = request.getParameter("heureRepas");
		String aliments = request.getParameter("aliments");

		RepasManager repasManager = new RepasManager();
		
		try {
			Repas repas = repasManager.ajouter(date, heure, aliments);
			flagSucces = "true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("succes", flagSucces);

//		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ajoutRepas.jsp");
		RequestDispatcher rd = this.getServletContext().getNamedDispatcher("AjoutRepas");
		rd.forward(request, response);
	}
}
