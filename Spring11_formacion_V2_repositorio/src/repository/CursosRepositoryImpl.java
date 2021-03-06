package repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Curso;

@Repository
public class CursosRepositoryImpl implements CursosRepository {

	@PersistenceContext(unitName="formacionPU")
	EntityManager em;
	
	@Transactional
	@Override
	public void altaCurso(Curso curso) {
		em.persist(curso);

	}

	@Override
	public Curso cursoPorId(int idCurso) {
		return em.find(Curso.class, idCurso);
	}

	@Override
	public List<Curso> todosCursos() {
		TypedQuery<Curso> query=em.createNamedQuery("Curso.findAll",Curso.class);
		return query.getResultList();
	}

	@Override
	public List<Curso> cursosAlumno(String usuario) {

		String jpql="Select c From Curso c join c.alumnos a where a.usuario=?1";
		TypedQuery<Curso> query=em.createQuery(jpql,Curso.class);
		query.setParameter(1, usuario);
		return query.getResultList();
	}

	@Override
	public List<Curso> cursosDisponiblesAlumno(String usuario) {
		String jpql="Select c From Curso c where c not in"; // todos los cursos que no este en la lista de:
		jpql+="(select c from Curso c join c.alumnos a where a.usuario=?1)"; //cursos del alumno 1
		TypedQuery<Curso> query=em.createQuery(jpql,Curso.class);
		query.setParameter(1, usuario);
		return query.getResultList();
	}

	@Override
	public List<Curso> cursosPorFecha(Date fechaInicio, Date fechaFin) {
		String jpql="Select c From Curso c where c.fechaInicio BETWEEN :fechaInicio AND :fechaFin";
		TypedQuery<Curso> query=em.createQuery(jpql,Curso.class);
		query.setParameter("fechaInicio", fechaInicio);
		query.setParameter("fechaFin", fechaFin);
		return query.getResultList();
	}

}
