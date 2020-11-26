package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Curso;
import service.CursosService;

@Controller
public class CursoController {
	@Autowired
	CursosService service;
	
	@PostMapping("doAltaCurso")
	public String altaCurso(@RequestParam("fechaInicio") String fechaInicio,
			@RequestParam("nombre") String nombre,
			@RequestParam("duracion") Integer duracion) {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Curso curso;
		try {
			curso = new Curso(0,duracion,format.parse(fechaInicio),nombre);
			service.altaCurso(curso);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
			return "../menu";
	
	}
	@GetMapping("doCursos")
	public String listaCursos (HttpServletRequest request) {
		request.setAttribute("cursos", service.obtenerCursos());
		return "seleccioncursos";
	}
	
	@PostMapping("doCursosAlumno")
	public String cursosAlumno (@RequestParam("usuario") String usuario, HttpServletRequest request) {
		request.setAttribute("cursosalumno", service.cursosAlumno(usuario));
		return "cursosalumno";
	}
	
	@PostMapping("doSeleccionCursoMatricular")
	public String cursosDisponibles(@RequestParam("usuario") String usuario,
			HttpServletRequest request,
			HttpSession session) {
		
		session.setAttribute("usuario", usuario);
		request.setAttribute("cursosmatricular", service.cursosDisponibles(usuario));
		return "cursosmatricular";
			
	}

}
