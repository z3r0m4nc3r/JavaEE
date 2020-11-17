package service;

import javax.ejb.Local;

import model.Curso;

@Local
public interface CursoService {

	boolean altaCurso(Curso curso);

	Curso recuperarCurso(int idCurso);

}