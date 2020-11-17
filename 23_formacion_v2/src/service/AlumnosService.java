package service;

import java.util.List;

import javax.ejb.Local;

import model.Alumno;
@Local
public interface AlumnosService {

	void altaAlumno(Alumno alumno);

	Alumno buscarAlumnoPorUsuario(String usuario);
	List<Alumno> alumnosNotas(double nota);
	List<Alumno> alumnosCurso(int idCurso);
	List<Alumno> alumnos();
}