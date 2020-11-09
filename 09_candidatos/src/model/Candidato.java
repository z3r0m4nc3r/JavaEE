package model;

public class Candidato {
	private String nombre;
	private int edad;
	private String puesto;
	private String urlImagen;
	public Candidato(String nombre, int edad, String puesto, String urlImagen) {
	
		this.nombre = nombre;
		this.edad = edad;
		this.puesto = puesto;
		this.urlImagen = urlImagen;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public String getUrlImagen() {
		return urlImagen;
	}
	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
	
	

}
