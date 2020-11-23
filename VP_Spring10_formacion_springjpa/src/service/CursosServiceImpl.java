package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Curso;
@Service
public class CursosServiceImpl implements CursosService {
	@PersistenceContext(unitName = "formacionPU")
	private  EntityManager em;
	
	@Transactional
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
//		String jpql="Select c From Curso c join c.matriculas m where m.alumno.usuario=?1";
//		String jpql="Select c From Curso c join c.alumnos a where a.alumno.usuario=?1"; // error no existe curso
		String jpql="Select c From Curso c join c.alumnos a where a.usuario=?1";
		TypedQuery<Curso> query=em.createQuery(jpql,Curso.class);
		query.setParameter(1, usuario);
		return query.getResultList();
	}
}
