package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import model.Curso;
import service.CursosService;


@WebServlet("/ListaMatriculasAction")
public class ListaMatriculasAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	CursosService service;

	@Override
	public void init(ServletConfig config) throws ServletException {
		//le informa al servidor de aplicaciones que Spring va a realizar inyección
		//de objetos en este servlet
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		super.init(config);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date fechaInicio = format.parse(request.getParameter("fechaInicio"));
			Date fechaFin = format.parse(request.getParameter("fechaFin"));
			List <Curso> cursosFecha = service.cursosPorFecha(fechaInicio, fechaFin);
			request.setAttribute("cursosFecha", cursosFecha);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
	}

}
