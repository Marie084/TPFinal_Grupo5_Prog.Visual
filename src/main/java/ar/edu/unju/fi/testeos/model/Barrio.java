package ar.edu.unju.fi.testeos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * @Entity 
 * @Table es la relacion entre el nombre de la tabla de la bd y la entidad.
 */
@Entity
@Table(name = "barrio")
public class Barrio {
	/*
	 * @Id indica que es la clave primaria de la tabla barrio.
	 * 
	 * @GeneratedValue lo que hace es generar el id automaticamente.
	 * 
	 * @Column relaciona nombre con el nombre de la columna de la tabla.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre")
	private String nombre;

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

	@Override
	public String toString() {
		return "Barrio [id=" + id + ", nombre=" + nombre + "]";
	}

}
