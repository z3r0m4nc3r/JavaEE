package service;

public class DronesServiceFactory {
	public static DronesService getDronesService() {
		return new DronesServiceImpl();
	}

}
