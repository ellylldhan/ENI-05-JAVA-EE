package fr.eni.javaee.gestionlistescourses.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLectureCookie
 */
@WebServlet("/ServletLectureCookie")
public class ServletLectureCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLectureCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recuperation des cookies presents
		Cookie[] cookies = request.getCookies();
		
		// s'il y a des cookies, il est possible de les lire
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				// Affichage de cle/vsaleur du cookie
				System.out.print("Cookie : " + cookie.getName() );
				System.out.println(" => Valeur : " + cookie.getValue());
			}
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
