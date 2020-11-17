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
 * Servlet implementation class AlumnosAction
 */
@WebServlet("/AlumnosAction")
public class AlumnosAction extends HttpServlet {
	@EJB
	AlumnosService service;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("alumnos", service.alumnos());
	}

}
