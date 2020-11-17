package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CursosService;

/**
 * Servlet implementation class CursosAlumnoAction
 */
@WebServlet("/CursosAlumnoAction")
public class CursosAlumnoAction extends HttpServlet {
	@EJB
	CursosService service;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario=request.getParameter("usuario");
		request.setAttribute("cursosalumno", service.cursosAlumno(usuario));
	}

}
