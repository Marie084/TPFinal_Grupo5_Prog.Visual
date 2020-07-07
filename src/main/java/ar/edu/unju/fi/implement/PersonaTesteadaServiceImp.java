package ar.edu.unju.fi.implement;

import java.util.List;

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
	private PersonaTesteadaRepository personaTesteadaRepository;

	//desarrollo de los metodos 
	@Override
	public PersonaTesteada getPersonaTesteadaPorDocumento(String documento) {
		
		return personaTesteadaRepository.findByDocumento(documento);
	}

	@Override
	public List<PersonaTesteada> listarAll() {
		
		return personaTesteadaRepository.findAll();
	}
	
	@Override
	public List<PersonaTesteada> buscarPorDocumento(String documento) {
		// TODO Auto-generated method stub
		return this.personaTesteadaRepository.findByDocumentoContaining(documento);
	}
}
