package service;

import java.util.List;

import model.Matricula;

public interface MatriculasService {
	void matricularAlumno(String usuario,int idCurso);
	List<Matricula> consultarMatriculas(String f1, String f2);
}
