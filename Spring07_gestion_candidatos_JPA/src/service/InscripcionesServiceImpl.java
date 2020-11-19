package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Inscripciones;
@Service
public class InscripcionesServiceImpl implements InscripcionesService {

	@PersistenceContext(name="empresaPU")
	EntityManager em;
	
	@Transactional
	@Override
	public void registrarInscripcion(Inscripciones inscripcion) {
		em.persist(inscripcion);
		
	}

	@Override
	public List<Inscripciones> obtenerInscripciones() {
		String jpql="Select c from Inscripciones c";
		TypedQuery<Inscripciones> query = em.createQuery(jpql, Inscripciones.class);
		return query.getResultList();
		}
	
}
