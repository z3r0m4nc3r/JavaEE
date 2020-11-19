package service;

import java.util.List;

import model.Inscripciones;

public interface InscripcionesService {
	void registrarInscripcion(Inscripciones inscripcion);
	List<Inscripciones> obtenerInscripciones();
}
