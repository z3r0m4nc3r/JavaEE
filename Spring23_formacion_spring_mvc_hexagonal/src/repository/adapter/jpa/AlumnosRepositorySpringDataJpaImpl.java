package repository.adapter.jpa;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Alumno;
import repository.adapter.entity.AlumnoEntity;
import repository.adapter.entity.Utilidades;
import repository.port.AlumnosRepository;

@Repository
public class AlumnosRepositorySpringDataJpaImpl implements AlumnosRepository {
	@Autowired
	AlumnosJpaRepository repository;
	
	
	@Override
	public void guardarAlumno(Alumno alumno) {
		repository.save(Utilidades.alumnoEntityBuilder(alumno));
	}

	@Override
	public Alumno buscarAlumnoPorUsuario(String usuario) {
		AlumnoEntity entity=repository.findById(usuario).orElse(null);
		return entity!=null?Utilidades.alumnoBuilder(entity):null;
		
	}
	@Transactional
	@Override
	public void actualizarAlumno(Alumno alumno) {
		repository.save(Utilidades.alumnoEntityBuilder(alumno));
	}

	@Override
	public List<Alumno> alumnosCurso(int idCurso) {
		
		return repository.findByIdCurso(idCurso)
				.stream()
				.map(a->Utilidades.alumnoBuilder(a))
				.collect(Collectors.toList());
	}

	@Override
	public List<Alumno> todosAlumnos() {
		return repository.findAll()
				.stream()
				.map(a->Utilidades.alumnoBuilder(a))
				.collect(Collectors.toList());
	}

}
