package fr.eni.javaee.modules.module2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletCycleDeVie
 */
@WebServlet("/modules/module2/ServletCycleDeVie")
public class ServletCycleDeVie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int nombrePassageInit = 0;
	private int nombreAppelServlet = 0;
	private int nombreDestruction = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCycleDeVie() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		nombrePassageInit++;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		nombreAppelServlet++;
//		response.getWriter().append("Servlet Cycle de Vie - Served at: ").append(request.getContextPath());
		response.getWriter().append("nombre appels de Servlet : ").append(String.valueOf(this.nombreAppelServlet));
		response.getWriter().append(System.lineSeparator());
		response.getWriter().append("nombre passage init      : ").append(String.valueOf(this.nombrePassageInit));
		response.getWriter().append(System.lineSeparator());
		response.getWriter().append("nombre Destruction       : ").append(String.valueOf(this.nombreDestruction));
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
	
	@Override
	public void destroy() {
		nombreDestruction++;
		super.destroy();
	}

}
