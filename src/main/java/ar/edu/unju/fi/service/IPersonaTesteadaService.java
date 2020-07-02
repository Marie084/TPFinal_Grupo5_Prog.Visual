package ar.edu.unju.fi.service;

import ar.edu.unju.fi.testeos.model.PersonaTesteada;

public interface IPersonaTesteadaService {
	
	PersonaTesteada getPersonaTesteadaPorDocumento(String documento);
	

}
