package fr.eni.javaee.modules.module7;

import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ListenerDemarrageAgent
 *
 */
@WebListener
public class ListenerDemarrageAgent implements ServletContextListener {
private static Date dateDemarrage;
    /**
     * Default constructor. 
     */
    public ListenerDemarrageAgent() {
        // TODO Auto-generated constructor stub
    }

	public static Date getDateDemarrage() {
		return dateDemarrage;
	}

	public static void setDateDemarrage(Date dateDemarrage) {
		ListenerDemarrageAgent.dateDemarrage = dateDemarrage;
	}

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	System.out.println("Arrêt de l'application");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	System.out.println("Démmarage de l'application");
    	ListenerDemarrageAgent.dateDemarrage= new Date();
    	
    }
	
}
