package servlets;

import java.io.IOException;
import java.util.List;

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
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CandidatosService service=new CandidatosService();
		List<Candidato> candidatos=service.recuperarCandidatos();
		//guardamos los candidatos en un atributo de petici�n
		//para la p�gina a la que nos enviar� el front controller
		request.setAttribute("candidatos", candidatos);
	}

}
