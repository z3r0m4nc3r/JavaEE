package service;

public class FormacionFactory {
	
	public static CursoService getCursoService() {
		return new CursoServiceImpl();
		
	}
	
	public static AlumnoService getAlumnoService() {
		return new AlumnoServiceImpl();
		
	}

}
