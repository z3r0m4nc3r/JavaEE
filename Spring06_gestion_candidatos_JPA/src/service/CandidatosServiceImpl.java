package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Candidato;

@Service
public class CandidatosServiceImpl implements CandidatosService {
	@PersistenceContext(name="empresaPU")
	EntityManager em;
	
	@Transactional     //cuando se modifica la BD
	@Override
	public void altaCandidato(Candidato candidato) {
		em.persist(candidato);
	}
	
	@Transactional
	@Override
	public void eliminarCandidato(int idCandidato) {
		Candidato candidato = em.find(Candidato.class, idCandidato);
		if(candidato!=null) {
			em.remove(candidato);
		}
	}
	
	@Override
	public List<Candidato> recuperarCandidatos(){
		String jpql="Select c from Candidato c";
		TypedQuery<Candidato> query = em.createQuery(jpql, Candidato.class);
		return query.getResultList();
	}
}
