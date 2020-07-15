package ar.edu.unju.fi.testeos.model;



import javax.persistence.*;

@Entity
@Table(name = "persona_testeada")
public class PersonaTesteada {
	
	//============================DEFINICION DE VARIABLES MIEMBROS==================================
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="per_testeada_ID")
	private Long id;
	
	@Column(name = "documento")
	private String documento;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "resultado_testeo")
	private Boolean resultadoTesteo;
	
	//mappedBy ="personaTesteadas" : me permite
	//@OneToMany(mappedBy ="personaTesteadas" , fetch = FetchType.LAZY)
	//@Column(name="reg_per_testeada_ID") //dentro pudo agregar  mappedby="personaTesteada": solo me gusta acceder a las marcas  private set<regPERSONATesteada> PERSONASregistradastesteadas= new hashset<>()
	//private Set<RegistroPersonaTesteada> registroPersonaTesteada = new HashSet<>();
	
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
