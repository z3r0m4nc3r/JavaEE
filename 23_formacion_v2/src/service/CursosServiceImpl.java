package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Curso;
@Stateless
public class CursosServiceImpl implements CursosService {
	@PersistenceContext(unitName = "formacionPU")
	private  EntityManager em;
	@Override
	public void altaCurso(Curso curso) {
		em.persist(curso);
	}
	@Override
	public List<Curso> obtenerCursos() {
		String jpql="Select c From Curso c";
		TypedQuery<Curso> query=em.createQuery(jpql,Curso.class);
		return query.getResultList();
	}
	@Override
	public List<Curso> cursosAlumno(String usuario) {
		String jpql="Select c From Curso c join c.matriculas m where m.alumno.usuario=?1";
		TypedQuery<Curso> query=em.createQuery(jpql,Curso.class);
		query.setParameter(1, usuario);
		return query.getResultList();
	}
}
