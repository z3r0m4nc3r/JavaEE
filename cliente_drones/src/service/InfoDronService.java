package service;

import model.Dron;

public interface InfoDronService {
	Dron recuperarDatos(String nombre);
	void actualizarEstado(String nombre, String estado);
	void actualizarPosicion(String nombre,double longitud, double latitud);
}
