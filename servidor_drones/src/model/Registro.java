package model;

import java.time.LocalDateTime;

public class Registro {
	
	private int idRegistro;
	private String dron;
	private double longitud;
	private double latitud;
	private LocalDateTime momento;
	
	public Registro(int idRegistro, String dron, double longitud, double latitud, LocalDateTime momento) {
		super();
		this.idRegistro = idRegistro;
		this.dron = dron;
		this.longitud = longitud;
		this.latitud = latitud;
		this.momento = momento;
	}

	public int getIdRegistro() {
		return idRegistro;
	}

	public String getDron() {
		return dron;
	}

	public void setDron(String dron) {
		this.dron = dron;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public LocalDateTime getMomento() {
		return momento;
	}

	public void setMomento(LocalDateTime momento) {
		this.momento = momento;
	}
	
	
	
}
