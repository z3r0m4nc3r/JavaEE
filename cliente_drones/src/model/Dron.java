package model;

public class Dron {
	private String nombre;
	private String estado;
	private double longitud;
	private double latitud;
	public Dron(String nombre, String estado, double longitud, double latitud) {
		super();
		this.nombre = nombre;
		this.estado = estado;
		this.longitud = longitud;
		this.latitud = latitud;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
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
	
}
