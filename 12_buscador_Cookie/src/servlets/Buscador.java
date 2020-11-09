package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;


@WebServlet("/Buscador")
public class Buscador extends HttpServlet {

	private static final long serialVersionUID = 7031777009866754555L;
	List<Item> items=List.of(new Item("Casa del libro","http://casadellibro.es", new String[]{"libros","lectura","ocio"},"Libros y más cosas"),
			new Item("La web del gamer","http://gamers.es", new String[]{"juegos","ordenadores","ocio"},"Todo sobre video juegos"),
			new Item("My computer","http://computerall.es", new String[]{"informática","ordenadores"},"Ordenadores al mejor precio"),
			new Item("Fnac","http://fnac.es", new String[]{"juegos","ordenadores","libros"},"Bienvenido al mundo del ocio y la cultura"),
			new Item("Todo pelis","http://filmers.es", new String[]{"cine","peliculas","ocio"},"Entra en el mundo del cine"));

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String tematica = request.getParameter("tematica");
		RequestDispatcher dispatcher;
		if(comprobar(tematica)) {
			request.setAttribute("listaItems", items);
			dispatcher=request.getRequestDispatcher("resultado.jsp");
			
			dispatcher.forward(request, response);
			
		}else {
			dispatcher=request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
			
		}
	}

	private boolean comprobar(String t) {
		for(var i : items) {

			for(var te : i.getSeo()) {

				if(te.equalsIgnoreCase(t)) {
					return true;
				}
			}
		}
		return false;
	}
}