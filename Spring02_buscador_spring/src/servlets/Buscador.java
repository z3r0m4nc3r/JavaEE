package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import model.Item;
import service.BuscadorService;

@WebServlet("/Buscador")
public class Buscador extends HttpServlet {
	
	private static final long serialVersionUID = -1551885365588138769L;
	
	@Autowired
	BuscadorService service;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//le informa al servidor de aplicaciones que Spring va a realizar inyecci�n
				//de objetos en este servlet
				SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

		super.init(config);
	}




	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		String tema=request.getParameter("tema");
		
		List<Item> items=service.buscarItems(tema);
		if(items!=null) {
			//recorremos todos los item de la lista
			for(Item item:items) {
				out.println("<h2><a href='"+item.getUrl()+"'>"+item.getTitulo()+"</a><br/>");
			}
			out.println("</body></html>");
		}
		else {
			//transferimos el control a otro servlet 
			//encargado de generar una p�gina de error
			RequestDispatcher dispatcher=request.getRequestDispatcher("Error");
			dispatcher.forward(request, response);
		}
	}
	

}
