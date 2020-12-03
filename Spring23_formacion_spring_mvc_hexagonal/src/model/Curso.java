package model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cursos database table.
 * 
 */

public class Curso  {
	
	private int idCurso;

	private int duracion;

	
	private LocalDate fechaInicio;

	private String nombre;

	
	private List<Alumno> alumnos;

	public Curso() {
	}
	
	public Curso(int idCurso, int duracion, LocalDate fechaInicio, String nombre) {
		super();
		this.idCurso = idCurso;
		this.duracion = duracion;
		this.fechaInicio = fechaInicio;
		this.nombre = nombre;
	}

	public int getIdCurso() {
		return this.idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public int getDuracion() {
		return this.duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public LocalDate getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Alumno> getAlumnos() {
		return this.alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

}