package dao;

import java.util.List;

import model.Registro;

public interface DronesDAO {
	void saveRegistro(Registro registro);
	List <Registro> findRegistros();
	List <Registro> findRegistrosByDron(String dron);

}
