package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Candidato;

public class CandidatosService {
	private static EntityManager em;
	static {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("empresaPU");
		em=factory.createEntityManager();
	}
	public void altaCandidato(Candidato candidato) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.persist(candidato);
		tx.commit();
	}
	
	public void eliminarCandidato(int idCandidato) {
		Candidato candidato=em.find(Candidato.class, idCandidato);
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		if(candidato!=null) {
			em.remove(candidato);
		}
		tx.commit();
	}
	
	public List<Candidato> recuperarCandidatos(){
		String jpql="Select c From Candidato c";
		TypedQuery<Candidato> query=em.createQuery(jpql,Candidato.class);
		return query.getResultList();
	}
	public List<Candidato> recuperarCandidatosPuesto(String puesto){
		String jpql="Select c From Candidato c Where c.puesto=?1";
		TypedQuery<Candidato> query=em.createQuery(jpql,Candidato.class);
		query.setParameter(1, puesto);
		return query.getResultList();
	}
	
	public Candidato buscarPorEmail(String email) {
		String jpql="Select c From Candidato c Where c.email=?1";
		TypedQuery<Candidato> query=em.createQuery(jpql,Candidato.class);
		query.setParameter(1, email);
		/*List<Candidato> candidatos=query.getResultList();
		return candidatos.size()>0?candidatos.get(0):null;*/
		try {
			return query.getSingleResult();
		}
		catch(NoResultException|NonUniqueResultException ex) {
			return null;
		}		
	}
	
	public void eliminarCandidatoPorEmail(String email) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();//iniciamos tx siempre que sea consulta de acción
		String jpql="Delete From Candidato c Where c.email=?1";
		Query query=em.createQuery(jpql);
		query.setParameter(1, email);
		query.executeUpdate();
		tx.commit(); 
	}
}
