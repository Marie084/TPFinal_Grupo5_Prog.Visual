package ar.edu.unju.fi.testeos.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "unidad_habitacional")
public class UnidadHabitacional {
    
	//=======================DEFINICION DE VARIABLES MIEMBROS==================================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="unidad_habitacional_ID")
	private Long id;
	@Column(name = "direccion")
	private String direccion;
	
	@ManyToOne(optional = false)  //Indica la relacion muchos a uno entre unidadHabitacional y barrio.
	@Column(name="barrio_ID")
	private Barrio barrio;
	
	@OneToMany(mappedBy = "unidadHabitacional",fetch = FetchType.EAGER) 
	@Column(name="registro_testeo_ID")
	private Set<RegistroTesteo> registroTesteo= new HashSet<>();
    
	

	//==============DEFINICION DE CONSTRUCTORES CON/SIN PARAMETROS===========================
	/**
	 * Constructor con parametros.
	 * 
	 * @param id
	 * @param direccion
	 * @param barrio
	 */
	public UnidadHabitacional(Long id, String direccion, Barrio barrio) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.barrio = barrio;
	}

	/**
	 * Constructor sin parametros.
	 */
	public UnidadHabitacional() {
	}

	//======================================GET/SET===========================================
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
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the barrio
	 */
	public Barrio getBarrio() {
		return barrio;
	}

	/**
	 * @param barrio the barrio to set
	 */
	public void setBarrio(Barrio barrio) {
		this.barrio = barrio;
	}
	
	/**
	 * @return the registroTesteo
	 */
	public Set<RegistroTesteo> getRegistroTesteo() {
		return registroTesteo;
	}

	/**
	 * @param registroTesteo the registroTesteo to set
	 */
	public void setRegistroTesteo(Set<RegistroTesteo> registroTesteo) {
		this.registroTesteo = registroTesteo;
	}

	//=========================VERIFICACION DE COMO ESTA ANDANDO CADA METODO==============================
	@Override
	public String toString() {
		return "UnidadHabitacional [id=" + id + ", direccion=" + direccion + ", barrio=" + barrio + "]";
	}

}
