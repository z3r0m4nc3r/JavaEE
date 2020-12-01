package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Candidato;
import repository.port.CandidatosRepository;
import service.port.CandidatosService;

@Service
public class CandidatosServiceImpl implements CandidatosService {

	@Autowired
	CandidatosRepository repository;
	
	@Override
	public void saveCandidato(Candidato candidato) {
		if(repository.findByEmail(candidato.getEmail())==null) {
			repository.saveCandidato(candidato);
		}

	}

	@Override
	public void deleteCandidato(int codigo) {
		if(repository.findByCodigo(codigo)!=null) {
			repository.deleteCandidato(codigo);
		}

	}

	@Override
	public List<Candidato> findAll() {
		return repository.findAll();
	}

}
