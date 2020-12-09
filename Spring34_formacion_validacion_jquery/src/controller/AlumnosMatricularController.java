package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import service.AlumnosService;

/**
 * Servlet implementation class AlumnosAction
 */
@Controller
public class AlumnosMatricularController{
	@Autowired
	AlumnosService service;
	@GetMapping("doSeleccionAlumnoMatricular")
	public String alumnos(Model model) {
		model.addAttribute("alumnos", service.alumnos());
		return "alumnosmatricular";
	}

}
