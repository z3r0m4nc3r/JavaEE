package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.AlumnosService;

/**
 * Servlet implementation class AlumnosCursoAction
 */
@Controller
public class AlumnosCursoController{
	@Autowired
	AlumnosService service;
	@PostMapping("doAlumnosCurso")
	public String alumnosCurso(HttpServletRequest request, @RequestParam("idCurso") int idCurso, Model model) {
		
		model.addAttribute("alumnoscurso", service.alumnosCurso(idCurso));
		return "alumnoscurso";
	}

}
