package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CandidatosService;

/**
 * Servlet implementation class EliminarPorEmail
 */
@WebServlet("/EliminarPorEmailAction")
public class EliminarPorEmailAction extends HttpServlet {
	
	private static final long serialVersionUID = 4722950668459709004L;
	@EJB
	CandidatosService service;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");
		if(service.buscarPorEmail(email)!=null) {
			service.eliminarCandidatoPorEmail(email);
			request.setAttribute("resultado", true);
			//request.getRequestDispatcher("menu.html").forward(request, response);
		}else {
			request.setAttribute("resultado", false);
			//request.getRequestDispatcher("noemail.html").forward(request, response);
		}
	}

}
