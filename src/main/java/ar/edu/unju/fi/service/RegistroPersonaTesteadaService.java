package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.testeos.model.RegistroPersonaTesteada;
import ar.edu.unju.fi.testeos.model.RegistroTesteo;

public interface RegistroPersonaTesteadaService {
    
    RegistroPersonaTesteada getRegistroPersonaTesteadaPorId(Long id);
	
	RegistroPersonaTesteada guardarRegistroPersonaTesteada(RegistroPersonaTesteada registroPersonaTesteada);
	
	void eliminarRegistroPersonaTesteada(Long id);
	
	List<RegistroPersonaTesteada> obtenerRegistroPersonaTesteada(RegistroTesteo registroTesteo);
	
	
}

