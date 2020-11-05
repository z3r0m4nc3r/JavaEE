package service;

import java.time.LocalDateTime;

import dao.DronesDAO;
import dao.DronesDAOFactory;
import model.Registro;

public class DronesServiceImpl implements DronesService {

	@Override
	public void altaRegistro(Registro registro) {
		DronesDAO dronesDAO = DronesDAOFactory.getDronesDAO();
		registro.setMomento(LocalDateTime.now());
		dronesDAO.saveRegistro(registro);

	}

}
