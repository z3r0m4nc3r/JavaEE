package repository.adapter.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cursos database table.
 * 
 */
@Entity
@Table(name="cursos")
@NamedQuery(name="Curso.findAll", query="SELECT c FROM CursoEntity c")
public class CursoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCurso;

	private int duracion;

	@Temporal(TemporalType.DATE)
	private Date fechaInicio;

	private String nombre;

	//bi-directional many-to-many association to Alumno
	@ManyToMany()
	@JoinTable(name = "matriculas",  joinColumns =
	//Join-prop: Alumnos
	           @JoinColumn(name="idCurso",referencedColumnName = "idCurso"), 
		                             inverseJoinColumns =
	//Join-inv: Cursos
	           @JoinColumn(name="usuario",referencedColumnName ="usuario"))	
	private List<AlumnoEntity> alumnos;

	public CursoEntity() {
	}
	
	public CursoEntity(int idCurso, int duracion, Date fechaInicio, String nombre) {
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

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<AlumnoEntity> getAlumnos() {
		return this.alumnos;
	}

	public void setAlumnos(List<AlumnoEntity> alumnos) {
		this.alumnos = alumnos;
	}

}