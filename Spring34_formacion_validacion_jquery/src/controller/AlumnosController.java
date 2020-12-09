package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import service.AlumnosService;

/**
 * Servlet implementation class AlumnosAction
 */
@Controller
public class AlumnosController{
	@Autowired
	AlumnosService service;
	@GetMapping("doAlumnos")
	public String alumnos(HttpServletRequest request, Model model) {
		model.addAttribute("alumnos", service.alumnos());
		return "seleccionalumnos";
	}

}
