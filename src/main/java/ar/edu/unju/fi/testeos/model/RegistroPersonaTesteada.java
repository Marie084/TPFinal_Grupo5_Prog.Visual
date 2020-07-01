package ar.edu.unju.fi.testeos.model;


import javax.persistence.*;

@Entity
@Table(name = "registro_persona_testeada")
public class RegistroPersonaTesteada {
	
	//=======================DEFINICION DE VARIABLES MIEMBROS==================================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="reg_per_testeada_ID")
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	private RegistroTesteo registroTesteo;
	
	@ManyToOne(optional = false)//,fetch = FetchType.EAGER
	@Column(name="persona_testeada_ID")
	private PersonaTesteada personaTesteadas;                                //<PersonaTesteada> personaTesteada =new HashSet<>();
	

	//==============DEFINICION DE CONSTRUCTORES CON/SIN PARAMETROS===========================
	
	/**
	 * Constructor sin parametros
	 */
	public RegistroPersonaTesteada() {

	}

	/**
	 * Constructor con parametros.
	 * 
	 * @param id
	 * @param registroTesteo
	 * @param personaTesteada
	 */
	public RegistroPersonaTesteada(Long id, RegistroTesteo registroTesteo, PersonaTesteada personaTesteadas) {
		super();
		this.id = id;
		this.registroTesteo = registroTesteo;
		this.personaTesteadas = personaTesteadas;
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
	 * @return the registroTesteo
	 */
	public RegistroTesteo getRegistroTesteo() {
		return registroTesteo;
	}

	/**
	 * @param registroTesteo the registroTesteo to set
	 */
	public void setRegistroTesteo(RegistroTesteo registroTesteo) {
		this.registroTesteo = registroTesteo;
	}

	/**
	 * @return the personaTesteadas
	 */
	public PersonaTesteada getPersonaTesteadas() {
		return personaTesteadas;
	}

	/**
	 * @param personaTesteadas the personaTesteadas to set
	 */
	public void setPersonaTesteadas(PersonaTesteada personaTesteadas) {
		this.personaTesteadas = personaTesteadas;
	}
	
	//=========================VERIFICACION DE COMO ESTA ANDANDO CDA METODO==============================
    
	@Override
	public String toString() {
		return "RegistroPersonaTesteada [id=" + id + ", registroTesteo=" + registroTesteo + ", personaTesteada="
				+ personaTesteadas + "]";
	}

	

}
