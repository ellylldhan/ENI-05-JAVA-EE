package fr.eni.javaee.modules.module4;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ServletTestPoolConnection
 */
@WebServlet("/modules/module4/ServletTestPoolConnection")
public class ServletTestPoolConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletTestPoolConnection() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
		try { 
			Context context = new InitialContext();
			
			// recherche de la datasource
			DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/pool_cnx");
			
			// Demand une connection ou utilisation d'une connection
			Connection cnx = dataSource.getConnection();
			out.println("La connection est " + (cnx.isClosed()?"fermée":"ouverte") + ".");
			
//			String sql = "insert into avis (identifiant, description, note) values (?,?,?)";
//			PreparedStatement ps = cnx.prepareStatement(sql);
//			ps.setInt(1, 1);
//			ps.setString(2, "Description bla bla");
//			ps.setInt(3, 4);
//			ps.executeUpdate();
			
			
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
			
			// renvoie erreur dans vue
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
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
