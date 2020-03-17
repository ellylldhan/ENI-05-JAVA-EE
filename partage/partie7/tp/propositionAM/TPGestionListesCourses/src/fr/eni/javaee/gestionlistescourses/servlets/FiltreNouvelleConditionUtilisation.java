package fr.eni.javaee.gestionlistescourses.servlets;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class FiltreNouvelleConditionUtilisation
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
		}
					, urlPatterns = {
							"/listes",
							"/panier",
							"/nouvelle",
							"/supprimer"
							})
public class FiltreNouvelleConditionUtilisation implements Filter {

    /**
     * Default constructor. 
     */
    public FiltreNouvelleConditionUtilisation() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse rep=(HttpServletResponse)response;
	//	System.out.println(httpRequest.getServletPath());
		Cookie[] cookies =httpRequest.getCookies();
		if (cookies==null)
		{
					// redirection vers la servlet condition d'utilisation
			RequestDispatcher rd =httpRequest.getRequestDispatcher("/WEB-INF/condition_utilisation.jsp");
			rd.forward(httpRequest, rep);
		}
		else
		{
			for(Cookie cookie:cookies)
			{
				if (cookie.getName().equalsIgnoreCase("conditionUtilisationOk"))
				{
						chain.doFilter(request, response);	
				}
			}
			// redirection vers la servlet condition d'utilisation
			RequestDispatcher rd =httpRequest.getRequestDispatcher("/WEB-INF/condition_utilisation.jsp");
			rd.forward(httpRequest, rep);
		}
	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
