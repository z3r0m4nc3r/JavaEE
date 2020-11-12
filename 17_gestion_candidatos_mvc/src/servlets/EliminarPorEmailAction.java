package servlets;

import java.io.IOException;
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
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CandidatosService service=new CandidatosService();
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
