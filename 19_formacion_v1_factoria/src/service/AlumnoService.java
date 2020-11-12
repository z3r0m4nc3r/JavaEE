package service;

import model.Alumno;

public interface AlumnoService {

	boolean altaAlumno(Alumno alumno);

	Alumno recuperarAlumno(String usuario);

}