package listeners;

import java.util.ArrayList;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import model.Candidato;


@WebListener
public class EscuchadorSesion implements HttpSessionListener {

    
    public void sessionCreated(HttpSessionEvent se)  { 
        HttpSession sesion=se.getSession();
        //crea un atributo de sesi�n cada vez que se inicia sesi�n
        sesion.setAttribute("candidatos", new ArrayList<Candidato>());
    }

	
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
