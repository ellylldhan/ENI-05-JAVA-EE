package fr.eni.javaee.gestionlistescourses.servlets;

import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ListenerDateDemarrage
 *
 */
@WebListener
public class ListenerDateDemarrage implements ServletContextListener {

	private static Date dateDemarrage;
	
    /**
     * Default constructor. 
     */
    public ListenerDateDemarrage() {
        // TODO Auto-generated constructor stub
    }

    
    
	public static Date getDateDemarrage() {
		return dateDemarrage;
	}



	public static void setDateDemarrage(Date dateDemarrage) {
		ListenerDateDemarrage.dateDemarrage = dateDemarrage;
	}



	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
	
}
