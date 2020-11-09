package listeners;

import java.util.ArrayList;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import model.Candidato;

@WebListener
public class SesionListener implements HttpSessionListener {

    
    public void sessionCreated(HttpSessionEvent se)  { 
    	HttpSession sesion = se.getSession();
    	
		sesion.setAttribute("listaCandidatos", new ArrayList<Candidato>());
    }

	
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	HttpSession sesion = se.getSession();
    	sesion.removeAttribute("listaCandidatos");
    }
	
}
