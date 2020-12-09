package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.CursosService;

/**
 * Servlet implementation class CursosAlumnoAction
 */
@Controller
public class CursosAlumnoAction {
	@Autowired
	CursosService service;
	@PostMapping("doCursosAlumno")
	public String cursosAlumno(Model model, @RequestParam("usuario") String usuario) throws ServletException, IOException {
		
		model.addAttribute("cursosalumno", service.cursosAlumno(usuario));
		return "cursosalumno";
	}

}
