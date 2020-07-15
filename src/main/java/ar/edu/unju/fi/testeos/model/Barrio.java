package ar.edu.unju.fi.testeos.model;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import com.sun.istack.NotNull;

/*
 * @Entity Con esta notacion se le dice al JPA que la clase barrio es una entidad.
 * @Table es la relacion entre el nombre de la tabla de la bd y la entidad.
 */
@Entity
@Table(name = "Barrio")
public class Barrio {
	

	//=======================DEFINICION DE VARIABLES MIEMBROS==================================
	/*
	 * @Id indica que es la clave primaria de la tabla barrio.
	 * 
	 * @GeneratedValue Obliga a que el id de la tabla se autoincrementable.
	 * @NotNull Esta notación sirve para validar los campos, en este caso comprueba que el campo no esté vacío.
	 * @Column  Esta notación relaciona nombre con el nombre de la columna de la tabla. Se utiliza para representar columnas simples.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Column(name = "nombre")  
	private String nombre;
	
	//@OneToMany(mappedBy = "barrio", fetch = FetchType.EAGER) 
	//@Column(name="unidad_habitacional_ID")
	//private Set<UnidadHabitacional> unidadHabitacional= new HashSet<>();
	

	//==============DEFINICION DE CONSTRUCTORES CON/SIN PARAMETROS===========================
	/**
	 * Constructor con parámetros.
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
	
	
	

	//=========================VERIFICACION DE COMO ESTA ANDANDO CADA METODO==============================
	@Override
	public String toString() {
		return "Barrio [id=" + id + ", nombre=" + nombre + "]";
	}

}
