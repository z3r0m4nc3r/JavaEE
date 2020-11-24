package service;

import java.util.Date;
import java.util.List;



import model.Curso;
public interface CursosService {

	void altaCurso(Curso curso);
	List<Curso> obtenerCursos();
	List<Curso> cursosAlumno(String usuario);
	List<Curso> cursosDisponibles(String usuario);
	Curso recuperarCurso (int idCurso);
	List<Curso> cursosPorFecha(Date fechaInicio, Date fechaFin);
	
}