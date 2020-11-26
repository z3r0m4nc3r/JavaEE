package controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Alumno;
import service.AlumnosService;

@Controller
public class AlumnoController {
	@Autowired
	AlumnosService service;

	@PostMapping("doAltaAlumno")
	public String altaAlumno(@RequestParam("usuario") String usuario,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("nombre") String nombre,
			@RequestParam("edad") Integer edad) {
		
		if(service.buscarAlumnoPorUsuario(usuario)==null) {
			Alumno alumno=new Alumno(usuario, edad, email, nombre, password);
			service.altaAlumno(alumno);
			return "../menu";
	}else return "../menu";

}
	@GetMapping("doAlumnos")
	public String listaAlumnos(HttpServletRequest request) {
		request.setAttribute("alumnos", service.alumnos());
		return "seleccionalumnos";
	}
	
	@PostMapping("doAlumnosCurso")
	public String alumnosCurso(HttpServletRequest request,
			@RequestParam("idCurso") Integer idCurso) {
		request.setAttribute("alumnoscurso", service.alumnosCurso(idCurso));
		return "alumnoscurso";
		
	}
	
	@GetMapping("doSeleccionAlumnoMatricular")
	public String listaAlumnosMatricular(HttpServletRequest request) {
		request.setAttribute("alumnos", service.alumnos());
		return "alumnosmatricular";
	}
	
	
	
}
