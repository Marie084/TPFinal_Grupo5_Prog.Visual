package ar.edu.unju.fi.util;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.testeos.model.Barrio;
import ar.edu.unju.fi.testeos.model.PersonaTesteada;
import ar.edu.unju.fi.testeos.model.RegistroPersonaTesteada;
import ar.edu.unju.fi.testeos.model.RegistroTesteo;
import ar.edu.unju.fi.testeos.model.UnidadHabitacional;
import ar.edu.unju.fi.testeos.model.Usuario;

public class RegistroUtil {

	private RegistroTesteo registroTesteo;
	private Usuario usuario;
	private Barrio barrio;
	private UnidadHabitacional unidadHabitacional;
	private PersonaTesteada personaTesteada;
	private List<RegistroPersonaTesteada> listaPersonasTesteadas;
	
	public RegistroUtil() {
		super();
		this.personaTesteada = new PersonaTesteada();
		this.unidadHabitacional = new UnidadHabitacional();
		this.barrio = new Barrio();
		this.listaPersonasTesteadas = new ArrayList<>();
		this.usuario = new Usuario();
	}
	
	public RegistroUtil(RegistroTesteo registroTesteo, Usuario usuario, Barrio barrio,
			UnidadHabitacional unidadHabitacional, List<RegistroPersonaTesteada> listaPersonasTesteadas) {
		super();
		this.registroTesteo = registroTesteo;
		this.usuario = usuario;
		this.barrio = barrio;
		this.unidadHabitacional = unidadHabitacional;
		this.listaPersonasTesteadas = listaPersonasTesteadas;
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
	/**
	 * @return the listaPersonasTesteadas
	 */
	public List<RegistroPersonaTesteada> getListaPersonasTesteadas() {
		return listaPersonasTesteadas;
	}
	/**
	 * @param listaPersonasTesteadas the listaPersonasTesteadas to set
	 */
	public void setListaPersonasTesteadas(List<RegistroPersonaTesteada> listaPersonasTesteadas) {
		this.listaPersonasTesteadas = listaPersonasTesteadas;
	}
	
	@Override
	public String toString() {
		return "RegistroUtil [registroTesteo=" + registroTesteo + ", usuario=" + usuario + ", barrio=" + barrio
				+ ", unidadHabitacional=" + unidadHabitacional + ", listaPersonasTesteadas=" + listaPersonasTesteadas
				+ "]";
	}
	
	
	
}
