package service;

import model.Curso;

public interface CursoService {

	boolean altaCurso(Curso curso);

	Curso recuperarCurso(int idCurso);

}