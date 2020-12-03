package controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import service.CursosService;


@Controller
public class CursosController extends HttpServlet {
	
	private static final long serialVersionUID = -6704063670484398786L;
	@Autowired
	CursosService service;
	@GetMapping("doCursos")
	public String cursos(HttpServletRequest request) {
		request.setAttribute("cursos", service.obtenerCursos());
		return "seleccioncursos";
	}

}
