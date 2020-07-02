package ar.edu.unju.fi.implement;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.repository.PersonaTesteadaRepository;
import ar.edu.unju.fi.service.IPersonaTesteadaService;
import ar.edu.unju.fi.testeos.model.PersonaTesteada;

@Service
@Transactional
public class PersonaTesteadaServiceImp implements IPersonaTesteadaService {
	@Autowired
	PersonaTesteadaRepository personaTesteadaRepository;

	@Override
	public PersonaTesteada getPersonaTesteadaPorDocumento(String documento) {
		
		return personaTesteadaRepository.findByDocumento(documento);
	}
	
	

}
