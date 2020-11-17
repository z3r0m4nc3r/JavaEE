package service;

import java.util.List;

import javax.ejb.Local;

import model.Curso;
@Local
public interface CursosService {

	void altaCurso(Curso curso);
	List<Curso> obtenerCursos();
	List<Curso> cursosAlumno(String usuario);
}