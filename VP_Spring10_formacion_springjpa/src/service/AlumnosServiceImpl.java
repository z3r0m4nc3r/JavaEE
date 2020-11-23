package service;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Alumno;
import model.Curso;

@Service
public class AlumnosServiceImpl implements AlumnosService {
	
	@PersistenceContext(unitName = "formacionPU")
	private  EntityManager em;
	
	@Transactional
	@Override
	public void altaAlumno(Alumno alumno) {
		
		em.persist(alumno);
		
	}
	@Override
	public Alumno buscarAlumnoPorUsuario(String usuario) {
		return em.find(Alumno.class, usuario);
	}
	
	@Override
	public List<Alumno> alumnosCurso(int idCurso) {
//		String jpql="Select a From Alumno a join a.matriculas m where m.curso.idCurso=?1";
		String jpql="Select a From Alumno a join a.cursos c where c.idCurso=?1";
		TypedQuery<Alumno> query=em.createQuery(jpql,Alumno.class);
		query.setParameter(1, idCurso);
		return query.getResultList();
	}
	@Override
	public List<Alumno> alumnos() {
		TypedQuery<Alumno> query=em.createNamedQuery("Alumno.findAll",Alumno.class);
		return query.getResultList();
	}
	
}
