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
 * Servlet implementation class CursoAction
 */
@WebServlet("/CursosAction")
public class CursosAction extends HttpServlet {
	@EJB
	CursosService service;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("cursos", service.obtenerCursos());
	}

}
