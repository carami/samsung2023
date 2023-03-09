package sample;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class HelloListener
 *
 */
@WebListener
public class HelloListener implements ServletContextListener {

    public HelloListener() {
        System.out.println("HelloListener 생성자 실행");
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
    	System.out.println("contextDestroyed ##############################################");
    }

    public void contextInitialized(ServletContextEvent arg0)  { 
         System.out.println("contextInitialized #############################################");
    }
	
}
