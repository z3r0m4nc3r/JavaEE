package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Alumno;
import service.AlumnoService;

@WebServlet("/AltaAlumnoAction")
public class AltaAlumnoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	AlumnoService service;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("usuario");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String nombre = request.getParameter("nombre");
		int edad = Integer.parseInt(request.getParameter("edad"));
		if (service.recuperarAlumno(usuario)==null) {
			Alumno alumno = new Alumno (usuario, edad, email, nombre, password);
			service.altaAlumno(alumno);
			request.setAttribute("resultado", true);
		}else request.setAttribute("resultado", false);
	}

}
