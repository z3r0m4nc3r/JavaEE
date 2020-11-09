package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Autenticar")
public class Autenticar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String contraseña = request.getParameter("contraseña");
		
		if (usuario.contentEquals("admin")) {
			if(contraseña.contentEquals("admin")) {
				HttpSession sesion=request.getSession();
				sesion.setAttribute("usuario", usuario);
				RequestDispatcher dispatcher=request.getRequestDispatcher("buscador.jsp");
				
				//creamos cookie de usuario
				
				crearCookie(response,(String)sesion.getAttribute("usuario"));
				dispatcher.forward(request,response);
			}else {
				RequestDispatcher dispatcher=request.getRequestDispatcher("usuarioRechazado.jsp");
				dispatcher.forward(request,response);
			}
		}else {
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("usuarioRechazado.jsp");
			dispatcher.forward(request,response);
		}
	}
	
	private void crearCookie(HttpServletResponse response, String usuario) {
		
		Cookie user= new Cookie("user", usuario);
		user.setMaxAge(1000);
		response.addCookie(user);
	}

}