package fr.eni.javaee.modules.module6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.modules.module6.bo.Voiture;

/**
 * Servlet implementation class ServletBalisesJSTL
 */
@WebServlet("/modules/module6/ServletBalisesJSTL")
public class ServletBalisesJSTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBalisesJSTL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	Random random = new Random();
	if (random.nextBoolean())
	{
		Voiture voiture = new Voiture("Renault","ZOE","AA123BB",5236);
		request.setAttribute("voiture", voiture);

	}
	List<Voiture> voitures = new ArrayList<>();
	voitures.add(new Voiture("Audi","A3","AA333BB",526) );
	voitures.add(new Voiture("Citroën","4L","LL333BB",526000) );
	voitures.add(new Voiture("Mercedes","Classe C","ER789DF",1526) );
	voitures.add(new Voiture("Peugeot","206","AM788DF",10000) );
	request.setAttribute("voitures", voitures);
	RequestDispatcher rd = request.getRequestDispatcher(""
			+ "/modules/module6/pageBaliseJSTL.jsp");
	rd.forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
