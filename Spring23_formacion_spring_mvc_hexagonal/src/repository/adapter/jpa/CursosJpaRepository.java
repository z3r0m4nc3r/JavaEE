package repository.adapter.jpa;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Curso;
import repository.adapter.entity.CursoEntity;

public interface CursosJpaRepository extends JpaRepository<CursoEntity, Integer> {
	@Query("Select c From CursoEntity c join c.alumnos a where a.usuario=?1")
	List<CursoEntity> findByUsuarioAlumno(String usuario);
	
	@Query("Select c From CursoEntity c Where c Not In (Select c From CursoEntity c join c.alumnos a Where a.usuario=?1)")
	List<CursoEntity> findCursosNoAlumno(String usuario);
	@Query("Select c From CursoEntity c join fetch c.alumnos where c.fechaInicio between ?1 and ?2")
	List<CursoEntity> findByFechaInicioBetween(Date desde, Date hasta);
	@Query("Select c From CursoEntity c join fetch c.alumnos where c.idCurso=?1")
	CursoEntity findCursoById(int idCurso);
}
