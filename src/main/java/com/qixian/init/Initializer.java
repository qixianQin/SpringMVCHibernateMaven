package com.qixian.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Initializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(WebAppConfig.class);
		servletContext.addListener(new ContextLoaderListener(context));
		
		context.setServletContext(servletContext);
		
		Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
		
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);

	}

}
