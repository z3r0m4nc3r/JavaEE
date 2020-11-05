package service;

import java.util.HashMap;
import java.util.Map;

import javax.websocket.Session;

public class SingletonSesiones {
	private static SingletonSesiones obj;
	private static Map<String,Session> sesiones;
	private SingletonSesiones() {
		sesiones=new HashMap<>();
	}
	public static SingletonSesiones getInstance() {
		if(obj==null) {
			obj=new SingletonSesiones();
		}
		return obj;
	}
	
	public void agregarSesion(Session s,String key) {
		sesiones.putIfAbsent(key,s);
	}
	public Map<String,Session> recuperarSesiones(){
		return sesiones;
	}
	public void eliminarSesion(String key) {
		sesiones.remove(key);
	}

	

}
