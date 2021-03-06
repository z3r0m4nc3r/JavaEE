package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the candidatos database table.
 * 
 */
@Entity
@Table(name="candidatos")
@NamedQuery(name="Candidato.findAll",query="Select c From Candidato c")
@NamedQuery(name="Candidato.findByPuesto",query="Select c From Candidato c Where c.puesto=?1")
@NamedQuery(name="Candidato.findByEmail",query="Select c From Candidato c Where c.email=?1")
@NamedQuery(name="Candidato.deleteByEmail",query="Delete From Candidato c Where c.email=?1")
public class Candidato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCandidato;

	@Column(name = "edad")
	private int edad;

	private String email;

	private String foto;

	private String nombre;

	private String puesto;

	public Candidato() {
	}

	public Candidato(int idCandidato, int edad, String email, String foto, String nombre, String puesto) {
		super();
		this.idCandidato = idCandidato;
		this.edad = edad;
		this.email = email;
		this.foto = foto;
		this.nombre = nombre;
		this.puesto = puesto;
	}

	public int getIdCandidato() {
		return this.idCandidato;
	}

	public void setIdCandidato(int idCandidato) {
		this.idCandidato = idCandidato;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPuesto() {
		return this.puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

}