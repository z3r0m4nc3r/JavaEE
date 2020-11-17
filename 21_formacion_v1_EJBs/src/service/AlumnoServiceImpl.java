package service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Alumno;

@Stateless
@LocalBean
public class AlumnoServiceImpl implements AlumnoService {
	@PersistenceContext(unitName = "formacion")
	private EntityManager em;
	
	@Override
	public boolean altaAlumno (Alumno alumno) {
		if(recuperarAlumno(alumno.getNombre())==null) {
		
		em.persist(alumno);
		
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
