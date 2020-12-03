package repository.adapter.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Alumno;
import repository.adapter.entity.AlumnoEntity;

public interface AlumnosJpaRepository extends JpaRepository<AlumnoEntity, String> {
	
	@Query("Select a From AlumnoEntity a join a.cursos c where c.idCurso=?1")
	List<AlumnoEntity> findByIdCurso(int idCurso);
	
}
