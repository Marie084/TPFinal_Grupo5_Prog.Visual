package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.testeos.model.RegistroTesteo;

public interface RegistroTesteoService {

    RegistroTesteo getRegistroTesteoPorId(Long id);
	
	RegistroTesteo guardarRegistroTesteo(RegistroTesteo registroTesteo);
	
	void eliminarRegistroTesteo(Long id);
	
	List<RegistroTesteo> obtenerRegistros();
	
	
}
