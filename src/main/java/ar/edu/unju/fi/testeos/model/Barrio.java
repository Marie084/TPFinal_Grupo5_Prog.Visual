package ar.edu.unju.fi.testeos.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * @Entity me dice q esta clase se va ah comportar como entidad
 * @Table es la relacion entre el nombre de la tabla de la bd y la entidad.
 */
@Entity
@Table(name = "Barrio")
public class Barrio {
	

	//=======================DEFINICION DE VARIABLES MIEMBROS==================================
	/*
	 * @Id indica que es la clave primaria de la tabla barrio.
	 * 
	 * @GeneratedValue lo que hace es generar el id automaticamente.
	 * 
	 * @Column relaciona nombre con el nombre de la columna de la tabla.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Barrio_ID")
	private Long id;
	
	@Column(name = "nombre",length = 150, nullable = true)
	private String nombre;
	
	@OneToMany(mappedBy = "barrio", fetch = FetchType.EAGER) 
	@JoinColumn(name="Unidad_Habitacional")
	private Set<UnidadHabitacional> unidadHabitacional= new HashSet<>();
	

	//==============DEFINICION DE CONSTRUCTORES CON/SIN PARAMETROS===========================
	/**
	 * Constructor con parametros.
	 * 
	 * @param id
	 * @param nombre
	 */
	public Barrio(Long id, String nombre) {

		this.id = id;
		this.nombre = nombre;
	}

	/*
	 * Constructor sin parametros.
	 */
	public Barrio() {
	}
	
	
	//=========================GET/SET==============================

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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	/**
	 * @return the unidadHabitacional
	 */
	public Set<UnidadHabitacional> getUnidadHabitacional() {
		return unidadHabitacional;
	}

	/**
	 * @param unidadHabitacional the unidadHabitacional to set
	 */
	public void setUnidadHabitacional(Set<UnidadHabitacional> unidadHabitacional) {
		this.unidadHabitacional = unidadHabitacional;
	}

	//=========================VERIFICACION DE COMO ESTA ANDANDO CADA METODO==============================
	@Override
	public String toString() {
		return "Barrio [id=" + id + ", nombre=" + nombre + "]";
	}

}
