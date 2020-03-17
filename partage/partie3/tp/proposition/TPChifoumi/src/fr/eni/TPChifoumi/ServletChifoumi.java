package fr.eni.TPChifoumi;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletChifoumi
 */
@WebServlet("/jeu")
public class ServletChifoumi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletChifoumi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("choix")!=null)
		{
			// recuperation du choix du joueur
			int choixJoueur=0;
			int choixOrdi=0;
			int resultat=0; // 0 si égalité 1 si victoire du joueur -1 si victoire ordi 
			choixJoueur = Integer.parseInt(request.getParameter("choix"));
			// ordinateur tire un choix entre 1 et 3
			choixOrdi= new Random().nextInt(3)+1;
			if (choixOrdi==choixJoueur)
			{
				resultat=0;
			}
			else
			{
				if(choixJoueur==1 && choixOrdi==3 || choixJoueur==2 && choixOrdi==1 || choixJoueur==3 && choixOrdi==2)
				{
					resultat=1;
				}
				else
				{
					resultat=-1;
				}
			}
			request.setAttribute("resultat", resultat);
			request.setAttribute("choixJoueur", choixJoueur);
			request.setAttribute("choixOrdi", choixOrdi);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/resultat.jsp");	
			rd.forward(request, response);
		}
		else
		{
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jouez.jsp");	
		rd.forward(request, response);
		}
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
