package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Alumno;

public interface AlumnosJpaRepository extends JpaRepository<Alumno, String> {
	
	@Query("Select a From Alumno a join a.cursos c where c.idCurso=?1")
	List<Alumno> findByIdCurso(int idCurso);
}
