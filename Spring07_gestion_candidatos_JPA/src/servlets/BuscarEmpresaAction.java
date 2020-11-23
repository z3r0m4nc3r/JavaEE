package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import service.InscripcionesService;


@WebServlet("/BuscarEmpresaAction")
public class BuscarEmpresaAction extends HttpServlet {

	private static final long serialVersionUID = 6241529719444332316L;
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
			
			List<String> nombresEmpresas = new ArrayList<>();
			service.obtenerInscripciones().stream().forEach(i -> nombresEmpresas.add(i.getEmpresa()));
			
			ServletContext context= request.getServletContext();
			
			context.setAttribute("nombresEmpresas", nombresEmpresas.stream().distinct().collect(Collectors.toList()));
			
		}

	}