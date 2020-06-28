package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unju.fi.repository.IRegistroPersonaTesteada;
import ar.edu.unju.fi.testeos.model.RegistroPersonaTesteada;

@Service
@Transactional(readOnly = true)
public class RegistroPersonaTesteadaService {

	@Autowired
	IRegistroPersonaTesteada iRegistroPersonaTesteada;
	
	public List<RegistroPersonaTesteada> findAll(){
		return iRegistroPersonaTesteada.findAll();
	}
}
