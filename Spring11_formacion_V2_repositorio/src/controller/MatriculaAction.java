package controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import service.MatriculasService;


@WebServlet("/MatriculaAction")
public class MatriculaAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	MatriculasService service;
	
	@Override	
	public void init(ServletConfig config) throws ServletException {
		//le informa al servidor de aplicaciones que Spring va a realizar inyección
		//de objetos en este servlet
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		super.init(config);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = (String) request.getSession().getAttribute("usuario");
		int idCurso = Integer.parseInt(request.getParameter("idCurso"));
		service.MatricularAlumno(usuario, idCurso);
	}

}
