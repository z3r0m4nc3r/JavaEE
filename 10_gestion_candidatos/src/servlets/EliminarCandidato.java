package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Candidato;

@WebServlet("/EliminarCandidato")
public class EliminarCandidato extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();			
		@SuppressWarnings("unchecked")
		List<Candidato> candidatos=(List<Candidato>) sesion.getAttribute("candidatos");
		if (candidatos.size()!=0) {
			int pos=Integer.parseInt(request.getParameter("posicion"));
			candidatos.remove(pos);	
			request.getRequestDispatcher("candidatos.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("menu.html").forward(request, response);
		}
		
	}

}
