package ar.edu.unju.fi.testeos.model;


import java.time.LocalDateTime;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "registro_testeo")
public class RegistroTesteo {
	
	//=======================DEFINICION DE VARIABLES MIEMBROS==================================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "fecha_hora")
	private LocalDateTime fechaHora;
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private UnidadHabitacional unidadHabitacional;

	//==============DEFINICION DE CONSTRUCTORES CON/SIN PARAMETROS===========================
	/**
	 * Constructor sin parametros.
	 */
	public RegistroTesteo() {

	}

	/**
	 * Constructor con parametros.
	 * 
	 * @param id
	 * @param fechaHora
	 * @param usuario
	 * @param unidadHabitacional
	 */
	public RegistroTesteo(Long id, LocalDateTime fechaHora, Usuario usuario, UnidadHabitacional unidadHabitacional) {
		super();
		this.id = id;
		this.fechaHora = fechaHora;
		this.usuario = usuario;
		this.unidadHabitacional = unidadHabitacional;
	}
	
	
	//=========================GET/SET===========================================
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the fechaHora
	 */
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	/**
	 * @param fechaHora the fechaHora to set
	 */
	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the unidadHabitacional
	 */
	public UnidadHabitacional getUnidadHabitacional() {
		return unidadHabitacional;
	}

	/**
	 * @param unidadHabitacional the unidadHabitacional to set
	 */
	public void setUnidadHabitacional(UnidadHabitacional unidadHabitacional) {
		this.unidadHabitacional = unidadHabitacional;
	}
	
	
	//=========================VERIFICACION DE COMO ESTA ANDANDO CDA METODO==============================
	@Override
	public String toString() {
		return "RegistroTesteo [id=" + id + ", fechaHora=" + fechaHora //+ ", usuario=" + usuario
				+ ", unidadHabitacional=" + unidadHabitacional + "]";
	}

}
