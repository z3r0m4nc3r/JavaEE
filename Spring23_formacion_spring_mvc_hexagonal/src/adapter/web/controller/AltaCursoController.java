package adapter.web.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Curso;
import service.CursosService;

/**
 * Servlet implementation class AltaCursoAction
 */
@Controller
public class AltaCursoController{
	
	@Autowired
	CursosService service;
	
	@PostMapping("doAltaCurso")
	public String altaCurso(@ModelAttribute("curso") Curso curso, @RequestParam("fecha") String fecha){
		try {	
			//SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			curso.setFechaInicio(LocalDate.parse(fecha));
			//Curso curso=new Curso(0,duracion,format.parse(fechaInicio),nombre);
			service.altaCurso(curso);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return "menu";
	}

}
