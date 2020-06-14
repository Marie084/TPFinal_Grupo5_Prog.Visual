package ar.edu.unju.fi.testeos.model;

import javax.persistence.*;

@Entity
@Table(name = "registro_persona_testeada")
public class RegistroPersonaTesteada {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private RegistroTesteo registroTesteo;
	@ManyToOne
	private PersonaTesteada personaTesteada;

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
	public RegistroPersonaTesteada(Long id, RegistroTesteo registroTesteo, PersonaTesteada personaTesteada) {
		super();
		this.id = id;
		this.registroTesteo = registroTesteo;
		this.personaTesteada = personaTesteada;
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
	 * @return the personaTesteada
	 */
	public PersonaTesteada getPersonaTesteada() {
		return personaTesteada;
	}

	/**
	 * @param personaTesteada the personaTesteada to set
	 */
	public void setPersonaTesteada(PersonaTesteada personaTesteada) {
		this.personaTesteada = personaTesteada;
	}

	@Override
	public String toString() {
		return "RegistroPersonaTesteada [id=" + id + ", registroTesteo=" + registroTesteo + ", personaTesteada="
				+ personaTesteada + "]";
	}

}
