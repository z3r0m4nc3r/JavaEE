package repository.adapter.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Alumno;
import model.Curso;
import repository.adapter.entity.CursoEntity;
import repository.adapter.entity.Utilidades;
import repository.port.CursosRepository;
@Repository
public class CursosRepositorySpringDataJpaImpl implements CursosRepository {
	@Autowired
	CursosJpaRepository repository;
	
	@Override
	public void altaCurso(Curso curso) {
		repository.save(Utilidades.cursoEntityBuilder(curso));
		
	}
	//este método se llama durante el proceso de matriculación
	//por ello, hay que incluir también los alumnos
	@Override
	public Curso cursoPorId(int idCurso) {
		CursoEntity entity=repository.findCursoById(idCurso);
		if(entity!=null) {
			Curso curso=Utilidades.cursoBuilder(entity);
			curso.setAlumnos(entity.getAlumnos()!=null?entity.getAlumnos()
								.stream()
								.map(a->Utilidades.alumnoBuilder(a))
								.collect(Collectors.toList()):new ArrayList<Alumno>());
			return curso;
		}
		return null;
		
	}

	@Override
	public List<Curso> todosCursos() {
		return repository.findAll()
				.stream()
				.map(c->Utilidades.cursoBuilder(c))
				.collect(Collectors.toList());
	}

	@Override
	public List<Curso> cursosAlumno(String usuario) {
		return repository.findByUsuarioAlumno(usuario)
				.stream()
				.map(c->Utilidades.cursoBuilder(c))
				.collect(Collectors.toList());
	}

	@Override
	public List<Curso> cursosDisponiblesAlumno(String usuario) {
		return repository.findCursosNoAlumno(usuario)
				.stream()
				.map(c->Utilidades.cursoBuilder(c))
				.collect(Collectors.toList());
	}

	@Override
	public List<Curso> cursosEntreFechas(Date f1, Date f2) {
		List<CursoEntity> entities= repository.findByFechaInicioBetween(f1, f2);
		List<Curso> cursos=entities
				.stream()
				.map(c->{				
							Curso curso=Utilidades.cursoBuilder(c);
							curso.setAlumnos(c.getAlumnos()!=null?c.getAlumnos()
												.stream()
												.map(a->Utilidades.alumnoBuilder(a))
												.collect(Collectors.toList()):new ArrayList<Alumno>());
							return curso;
						})
				.collect(Collectors.toList());
		return cursos;
	}

	@Override
	public void actualizarCurso(Curso curso) {
		/*****
			Está incompleto, falta convertir la lista de alumnos del curso
			en AlumnoEntity para que al salvar el curso, los alumnos enten dentro
			y se actualice también la tabla de matrículas
		
		*/
		repository.save(Utilidades.cursoEntityBuilder(curso));
		
	}

}
