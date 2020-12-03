package repository.port;

import java.util.Date;
import java.util.List;

import model.Alumno;
import model.Curso;

public interface CursosRepository {
	void altaCurso(Curso curso);
	Curso cursoPorId(int idCurso);
	void actualizarCurso(Curso curso);
	List<Curso> todosCursos();
	List<Curso> cursosAlumno(String usuario);
	List<Curso> cursosDisponiblesAlumno(String usuario);
	List<Curso> cursosEntreFechas(Date f1, Date f2);
}
