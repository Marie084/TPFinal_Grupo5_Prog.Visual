package ar.edu.unju.fi.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unju.fi.repository.PersonaTesteadaRepository;
import ar.edu.unju.fi.service.PersonaTesteadaService;
import ar.edu.unju.fi.testeos.model.PersonaTesteada;

@Service
@Transactional
public class PersonaTesteadaServiceImplement implements PersonaTesteadaService {
    
	@Autowired
	private PersonaTesteadaRepository personaTesteadaRepository;
	
	@Override
	public PersonaTesteada getPersonaTesteadaPorId(Long id) {
		return this.personaTesteadaRepository.getOne(id);
	}

	@Override
	public PersonaTesteada guardarPersonaTesteada(PersonaTesteada personaTesteada) {
		return this.personaTesteadaRepository.save(personaTesteada);
	}

	@Override
	public void eliminarPersonaTesteada(Long id) {
		this.personaTesteadaRepository.deleteById(id);

	}

	@Override
	public List<PersonaTesteada> obtenerPersonas() {
		return this.personaTesteadaRepository.findAll();
	}

}
