package service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Alumno;

public class AlumnoServiceImpl implements AlumnoService {
	private static EntityManager em;
	static {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("formacionPU");
		em=factory.createEntityManager();
	}
	
	@Override
	public boolean altaAlumno (Alumno alumno) {
		if(recuperarAlumno(alumno.getNombre())==null) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.persist(alumno);
		tx.commit();
		return true;
		}else return false;
	}
	
	@Override
	public Alumno recuperarAlumno (String usuario) {
		TypedQuery<Alumno> query=em.createNamedQuery("Alumno.findByUsuario",Alumno.class);
		query.setParameter(1, usuario);
		
		try {
			return query.getSingleResult();
		}
		catch(NoResultException|NonUniqueResultException ex) {
			return null;
		}		
	}

}
