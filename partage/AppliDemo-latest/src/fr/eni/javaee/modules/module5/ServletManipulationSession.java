package fr.eni.javaee.modules.module5;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletManipulationSession
 */
@WebServlet("/modules/module5/ServletManipulationSession")
public class ServletManipulationSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletManipulationSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	HttpSession session = request.getSession();
	int compteurAccessPendantSession=0;
	if(session.getAttribute("compteurAcces")!=null)
	{
		compteurAccessPendantSession=(int)session.getAttribute("compteurAcces");
	}
	compteurAccessPendantSession+=1;
		session.setAttribute("compteurAcces", compteurAccessPendantSession);
		RequestDispatcher rd = request.getRequestDispatcher(
				"/WEB-INF/modules/module5/afficherSession.jsp");
		rd.forward(request, response);
		//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
