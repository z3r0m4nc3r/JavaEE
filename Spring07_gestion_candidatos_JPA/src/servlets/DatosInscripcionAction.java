package servlets;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import service.InscripcionesService;


@WebServlet("/DatosInscripcionAction")
public class DatosInscripcionAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Autowired
	InscripcionesService service;
	@Override
	public void init(ServletConfig config) throws ServletException {
		//le informa al servidor de aplicaciones que Spring va a realizar inyección
		//de objetos en este servlet
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		super.init(config);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion=request.getSession();
		
		
		sesion.setAttribute("empresaSeleccionada", service.obtenerInscripciones().stream()
				.filter(i -> i.getEmpresa()
						.equals((String)request.getParameter("empresa")))
				.collect(Collectors.toList()));
	}

}
