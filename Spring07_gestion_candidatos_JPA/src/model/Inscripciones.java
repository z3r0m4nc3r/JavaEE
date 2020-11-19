package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the inscripciones database table.
 * 
 */
@Entity
@Table(name="inscripciones")
@NamedQuery(name="Inscripciones.findAll", query="SELECT i FROM Inscripciones i")
public class Inscripciones implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idInscripcion;

	private String empresa;

	private String posicion;

	private double salario;

	//bi-directional many-to-one association to Candidato
	@ManyToOne
	@JoinColumn(name="idCandidato", referencedColumnName ="idCandidato")
	private Candidato candidato;

	public Inscripciones() {
	}

	public Inscripciones(int idInscripcion, String empresa, String posicion, double salario, Candidato candidato) {
		super();
		this.idInscripcion = idInscripcion;
		this.empresa = empresa;
		this.posicion = posicion;
		this.salario = salario;
		this.candidato = candidato;
	}



	public int getIdInscripcion() {
		return this.idInscripcion;
	}

	public void setIdInscripcion(int idInscripcion) {
		this.idInscripcion = idInscripcion;
	}

	public String getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getPosicion() {
		return this.posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public double getSalario() {
		return this.salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Candidato getCandidato() {
		return this.candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

}