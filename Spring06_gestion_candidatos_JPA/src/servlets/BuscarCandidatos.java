package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import service.CandidatosService;

@WebServlet("/BuscarCandidatos")
public class BuscarCandidatos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	CandidatosService service;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//le informa al servidor de aplicaciones que Spring va a realizar inyecci�n
				//de objetos en este servlet
				SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

		super.init(config);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("candidatos", service.recuperarCandidatos());
		request.getRequestDispatcher("candidatos.jsp").forward(request, response);
		
	}

}
