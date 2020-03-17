package fr.eni.javaee.gestionlistescourses.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletValidationConditionUtilisation
 */
@WebServlet("/accept")
public class ServletValidationConditionUtilisation extends HttpServlet {
	private static final long serialVersionUID = 6L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletValidationConditionUtilisation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		Cookie cookie = new Cookie("conditionUtilisationOk","ok");
		cookie.setMaxAge(Integer.MAX_VALUE);
		response.addCookie(cookie);
		RequestDispatcher rd =request.getRequestDispatcher("/listes");
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
