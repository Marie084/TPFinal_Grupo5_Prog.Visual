package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.testeos.model.PersonaTesteada;

public interface IPersonaTesteadaService {
	
	//definicion de metodos
	
	PersonaTesteada getPersonaTesteadaPorDocumento(String documento);
	
	public List<PersonaTesteada> listarAll();
	
        List<PersonaTesteada> buscarPorDocumento(String documento);
        
}

