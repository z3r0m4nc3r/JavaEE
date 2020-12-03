package config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class Inicializador implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// Crea el contexto ra�z de la aplicaci�n Web
	      AnnotationConfigWebApplicationContext rootContext =
	        new AnnotationConfigWebApplicationContext();
	      
	      //registro de la clase de configuraci�n del modelo
	      rootContext.register(SpringConfig.class);   
	      // Gestiona el ciclo de vida del contexto de aplicaci�n
	      servletContext.addListener(new ContextLoaderListener(rootContext));

	}

}
