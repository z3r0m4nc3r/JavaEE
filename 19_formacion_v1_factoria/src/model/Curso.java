package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="cursos")
@NamedQuery(name="Curso.findAll", query="SELECT c FROM Curso c")
@NamedQuery(name="Curso.findByIdCurso",query="Select c From Curso c Where c.idCurso=?1")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCurso;
	
	@Temporal(TemporalType.DATE)
	private Date fechaInicio;

	private int duracion;

	private String nombre;

	public Curso(int idCurso, Date fechaInicio, int duracion, String nombre) {
		super();
		this.idCurso = idCurso;
		this.fechaInicio = fechaInicio;
		this.duracion = duracion;
		this.nombre = nombre;
	}

	public Curso() {
	}

	public int getIdCurso() {
		return this.idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public int getDuracion() {
		return this.duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}


	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}