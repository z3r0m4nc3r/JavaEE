package service.port;

import java.util.List;

import model.Candidato;

public interface CandidatosService {

	void saveCandidato(Candidato candidato);
	void deleteCandidato(int codigo);
	List<Candidato> findAll();
	
}
