package service;

public class InfoDronFactory {
	public static InfoDronService getInfoDronService() {
		return new InfoDronServiceImpl();
	}
}
