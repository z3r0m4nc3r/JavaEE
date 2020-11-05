package dao;

public class DronesDAOFactory {
	public static DronesDAO getDronesDAO() {
		return new DronesDAOImpl();
	}

}
