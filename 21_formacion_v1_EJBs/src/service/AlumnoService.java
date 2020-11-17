package service;

import javax.ejb.Local;

import model.Alumno;

@Local
public interface AlumnoService {

	boolean altaAlumno(Alumno alumno);

	Alumno recuperarAlumno(String usuario);

}