package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AlumnosService;

/**
 * Servlet implementation class AlumnosNotaAction
 */
@WebServlet("/AlumnosNotaAction")
public class AlumnosNotaAction extends HttpServlet {
	@EJB
	AlumnosService service;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double nota=Double.parseDouble(request.getParameter("nota"));
		request.setAttribute("alumnosnota", service.alumnosNotas(nota));
	}

}
