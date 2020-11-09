package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Candidato;

@WebServlet("/Registro")
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@SuppressWarnings("unchecked")
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
			
			List <Candidato> listaCandidatos=(List<Candidato>) sesion.getAttribute("listaCandidatos");
			listaCandidatos.add(transformar(request));
			sesion.setAttribute("listaCandidatos", listaCandidatos);
			RequestDispatcher dispatcher=request.getRequestDispatcher("registro.html");
			dispatcher.forward(request,response);
		
		
	}
	
	private Candidato transformar (HttpServletRequest request) {
		return new Candidato((String)request.getParameter("nombre"),
				Integer.parseInt(request.getParameter("edad")),
				(String)request.getParameter("puesto"),
				"urlFoto");
	}

}
