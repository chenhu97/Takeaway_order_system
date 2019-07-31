package edu.tos.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class AppRootListener
 *
 */
@WebListener
public class AppRootListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public AppRootListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	javax.servlet.ServletContext application=arg0.getServletContext();
    	System.out.println("starting application in AppRootListener");
    	application.setAttribute("AppRootPath", application.getContextPath());
    	application.setAttribute("AppRootDir", application.getRealPath("/"));
    }
	
}
