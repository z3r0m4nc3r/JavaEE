package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Candidato;
import service.CandidatosService;

/**
 * Servlet implementation class EliminarCandidato
 */
@WebServlet("/EliminarCandidato")
public class EliminarCandidato extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CandidatosService service=new CandidatosService();		
		int idCandidato=Integer.parseInt(request.getParameter("idCandidato"));
		service.eliminarCandidato(idCandidato);
		request.getRequestDispatcher("candidatos.jsp").forward(request, response);
	}

}
