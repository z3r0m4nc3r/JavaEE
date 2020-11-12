package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	
	private static final long serialVersionUID = -8149644786251248979L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option=request.getParameter("option");
		String url="";
		
		switch(option) {
			case "toAltaAlumno":
				url="altaAlumno.html";
				break;
			case "toAltaCurso":
				url="altaCurso.html";
				break;
			case "doAltaAlumno":
				request.getRequestDispatcher("AltaAlumnoAction").include(request, response);
				url=(boolean) request.getAttribute("resultado")?"menu.html":"usuariorepetido.jsp";
				break;
			case "doAltaCurso":
				request.getRequestDispatcher("AltaCursoAction").include(request, response);
				url="menu.html";
				break;
			case "toMenu":
				url="menu.html";
				break;
		
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
