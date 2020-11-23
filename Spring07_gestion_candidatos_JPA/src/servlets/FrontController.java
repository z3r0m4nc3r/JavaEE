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
		String url="";
		String option=request.getParameter("option");
		switch(option) {
			case "doAltaCandidato":
				request.getRequestDispatcher("AltaCandidatoAction").include(request, response);
				url="menu.html";
				break;
			case "doAltaInscripcion":
				request.getRequestDispatcher("AltaInscripcionAction").include(request, response);
				url="menu.html";
				break;
			case "doBuscarCandidatos":
				request.getRequestDispatcher("BuscarCandidatosAction").include(request, response);
				url="candidatos.jsp";
				break;
			case "doBuscarInscripciones":
				request.getRequestDispatcher("BuscarInscripcionesAction").include(request, response);
				url="inscripciones.jsp";
				break;
			case "doCargarCandidatos":
				request.getRequestDispatcher("BuscarCandidatosAction").include(request, response);
				url="ofertas.jsp";
				break;
			case "doEliminarCandidato":
				request.getRequestDispatcher("EliminarCandidatoAction").include(request, response);
				request.getRequestDispatcher("BuscarCandidatosAction").include(request, response);
				url="candidatos.jsp";
				break;
			case "toSelectEmpresa":
				request.getRequestDispatcher("BuscarEmpresaAction").include(request, response);
				url="candidatosEmpresa.jsp";
				break;
			case "doDatosInscripcion":
				request.getRequestDispatcher("DatosInscripcionAction").include(request, response);
				url="candidatosEmpresa.jsp";
				break;
			case "toMenu":
				url="menu.html";
				break;
			case "toAlta":
				url="alta.html";
				break;
			case "toSeleccionarEmpresa":
				url="candidatosEmpresa.jsp";
				break;
						
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
