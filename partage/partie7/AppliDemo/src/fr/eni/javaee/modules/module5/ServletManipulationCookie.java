package fr.eni.javaee.modules.module5;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletManipulationCookie
 */
@WebServlet("/modules/module5/ServletManipulationCookie")
public class ServletManipulationCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletManipulationCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	PrintWriter out = response.getWriter();
	Cookie[] cookies = request.getCookies();
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	if(cookies==null)
	{
		out.println("Il n'y a pas de cookies");
		out.println("C'est peut être le premier passage de l'user?");
		out.println("Ou l'user a peut être désactivé les cookies?");
		out.println("Date ="+sdf.format(new Date()));
		out.println("");
		out.println("Voici les nouveaux cookies : ");
		for(int i=0;i<3;i++)
		{
			Random rd = new Random();
			Cookie unCookie= new Cookie("unNom"+rd.nextInt(1000),
					"UneValeur"+rd.nextInt(1000));
			unCookie.setMaxAge(rd.nextInt(10));
			out.println(unCookie.getName()+"="+unCookie.getValue()+
					",durée="+unCookie.getMaxAge()+" secondes");
		
		response.addCookie(unCookie);
		}
		
	}
	else
	{
		out.println("Voici les cookies transitant sur le réseau :");
		for(Cookie cookie: cookies)
		{
			out.println(cookie.getName()+"="+cookie.getValue());
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
