package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import model.Candidato;

public interface CandidatosJpaRepository extends JpaRepository<Candidato, Integer> {

	Candidato findByEmail(String email);
	
	@Query("select c from Candidato c where c.edad>=?1")
	List <Candidato> findByEdadMayor (int edad);
	
	@Transactional
	void deleteCandidatoByEmail(String email);

}
