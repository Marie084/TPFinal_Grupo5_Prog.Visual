package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.testeos.model.PersonaTesteada;

public interface PersonaTesteadaService {

    PersonaTesteada getPersonaTesteadaPorId(Long id);
	
	PersonaTesteada guardarPersonaTesteada(PersonaTesteada personaTesteada);
	
	void eliminarPersonaTesteada(Long id);
	
	List<PersonaTesteada> obtenerPersonas();
	
	
}
