package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@MultipartConfig
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option=request.getParameter("option");
		String url="";
		//en función del valor del parámetro option, decidimos que acción realizar y a que vista
		//hay que pasar la petición
		switch(option) {
			case "toAlta":
				url="alta.html";
				break;
			case "toEliminar":
				url="eliminar.html";
				break;
			case "doRecuperar":
				request.getRequestDispatcher("RecuperarAction").include(request, response);
				url="candidatos.jsp";
				break;
			case "doAlta":
				request.getRequestDispatcher("AltaAction").include(request, response);
				url="menu.html";
				break;
			case "doEliminarId":
				request.getRequestDispatcher("EliminarPorIdAction").include(request, response);
				//esto se hace para poder recuperar de nuevo la lista de candidatos
				//y que esté a disposición de la página candidatos.jsp
				request.getRequestDispatcher("RecuperarAction").include(request, response);
				url="candidatos.jsp";
				break;
			case "toMenu":
				url="menu.html";
				break;
			case "doEliminarEmail":
				request.getRequestDispatcher("EliminarPorEmailAction").include(request, response);
				boolean resultado=(boolean)request.getAttribute("resultado");
				url=resultado?"menu.html":"noemail.html";
				break;
		
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
