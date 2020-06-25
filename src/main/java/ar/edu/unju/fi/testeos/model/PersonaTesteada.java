package ar.edu.unju.fi.testeos.model;

import javax.persistence.*;

@Entity
@Table(name = "persona_testeada")
public class PersonaTesteada {
	
	//============================DEFINICION DE VARIABLES MIEMBROS==================================
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Per_Testeada_ID")
	private Long id;
	
	@Column(name = "documento", unique = true,length = 200, nullable = true)
	private String documento;
	
	@Column(name = "apellido", nullable = true)
	private String apellido;
	
	@Column(name = "nombre", nullable = true)
	private String nombre;
	
	@Column(name = "Resultado_Testeo", nullable = true)
	private Boolean resultadoTesteo;
	
	//NO SE PUEDE REALIZAR EL GET O SET RAZONES NO CONOCIDAS
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="Reg_Per_Testeada_ID") //dentro pudo agregar  mappedby="personaTesteada": solo me gusta acceder a las marcas  private set<regPERSONATesteada> PERSONASregistradastesteadas= new hashset<>()
	private RegistroPersonaTesteada registroPersonaTesteada;
	
	//=======================DEFINICION DE CONSTRUCTORES CON/SIN PARAMETROS===========================

	/**
	 * Constructor sin parametros
	 */
	public PersonaTesteada() {

	}

	/**
	 * Constructor con parametros.
	 * 
	 * @param id
	 * @param documento
	 * @param apellido
	 * @param nombre
	 * @param resultadoTesteo
	 */

	public PersonaTesteada(Long id, String documento, String apellido, String nombre, Boolean resultadoTesteo) {
		super();
		this.id = id;
		this.documento = documento;
		this.apellido = apellido;
		this.nombre = nombre;
		this.resultadoTesteo = resultadoTesteo;
	}
	
	//====================================GET/SET===========================================

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
	 * @return the documento
	 */
	public String getDocumento() {
		return documento;
	}

	/**
	 * @param documento the documento to set
	 */
	public void setDocumento(String documento) {
		this.documento = documento;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
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
	 * @return the resultadoTesteo
	 */
	public Boolean getResultadoTesteo() {
		return resultadoTesteo;
	}

	/**
	 * @param resultadoTesteo the resultadoTesteo to set
	 */
	public void setResultadoTesteo(Boolean resultadoTesteo) {
		this.resultadoTesteo = resultadoTesteo;
	}
	
	//=========================VERIFICACION DE COMO ESTA ANDANDO CDA METODO==============================

	@Override
	public String toString() {
		return "PersonaTesteada [id=" + id + ", documento=" + documento + ", apellido=" + apellido + ", nombre="
				+ nombre + ", resultadoTesteo=" + resultadoTesteo + "]";
	}

}
