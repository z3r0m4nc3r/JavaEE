package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.CursosService;

/**
 * Servlet implementation class CursosMatricularAction
 */
@Controller
public class CursosMatricularController {
	@Autowired
	CursosService service;
	@PostMapping("doSeleccionCursoMatricular")
	public String cursosMatricular(Model model, HttpSession sesion, @RequestParam("usuario") String usuario) {
		sesion.setAttribute("usuario", usuario);//se recuerde a la hora de matricular
		model.addAttribute("cursosmatricular", service.cursosDisponibles(usuario));
		return "cursosmatricular";
	}

}
