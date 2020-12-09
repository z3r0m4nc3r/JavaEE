package controller;

import javax.servlet.http.HttpServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import service.CursosService;


@Controller
public class CursosController extends HttpServlet {
	
	private static final long serialVersionUID = -6704063670484398786L;
	@Autowired
	CursosService service;
	@GetMapping("doCursos")
	public String cursos(Model model) {
		model.addAttribute("cursos", service.obtenerCursos());
		return "seleccioncursos";
	}

}
