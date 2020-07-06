package ar.edu.unju.fi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unju.fi.repository.IPersonaTesteada;

@Service
@Transactional(readOnly = true)
public class PersonaTesteadaService {
   
	@Autowired
	IPersonaTesteada iPersonaTesteada;
	
}
