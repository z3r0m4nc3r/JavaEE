package service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Curso;

public class CursoServiceImpl implements CursoService {
	private static EntityManager em;
	static {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("formacionPU");
		em=factory.createEntityManager();
	}
	
	@Override
	public boolean altaCurso (Curso curso) {
		
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.persist(curso);
		tx.commit();
		return true;
		
	}
	
	@Override
	public Curso recuperarCurso (int idCurso) {
		TypedQuery<Curso> query=em.createNamedQuery("Curso.findByIdCurso",Curso.class);
		query.setParameter(1, idCurso);
		
		try {
			return query.getSingleResult();
		}
		catch(NoResultException|NonUniqueResultException ex) {
			return null;
		}		
	}


}
