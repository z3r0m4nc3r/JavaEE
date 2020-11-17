package service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Curso;

@Stateless
@LocalBean
public class CursoServiceImpl implements CursoService {
	@PersistenceContext(unitName = "formacion")
	private EntityManager em;
	
	@Override
	public boolean altaCurso (Curso curso) {
		
		
		em.persist(curso);
		
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
