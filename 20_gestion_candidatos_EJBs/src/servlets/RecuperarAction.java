package servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Candidato;
import service.CandidatosService;

/**
 * Servlet implementation class RecuperarAction
 */
@WebServlet("/RecuperarAction")
public class RecuperarAction extends HttpServlet {
	
	private static final long serialVersionUID = -6138142073152984642L;
	@EJB
	CandidatosService service;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Candidato> candidatos=service.recuperarCandidatos();
		//guardamos los candidatos en un atributo de petición
		//para la página a la que nos enviará el front controller
		request.setAttribute("candidatos", candidatos);
	}

}
