package com.darian.lesson5;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

public class ServletContextListener implements javax.servlet.ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContext sc =  sce.getServletContext();
		ClassLoader classLoader = sc.getClassLoader();
		while (true) {
			System.out.println(classLoader.getClass().getName());
			classLoader = classLoader.getParent();
			if(classLoader == null) {
				break;
			}
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}


}
