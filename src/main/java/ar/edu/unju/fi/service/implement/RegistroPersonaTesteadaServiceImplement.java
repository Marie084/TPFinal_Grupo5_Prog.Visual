package ar.edu.unju.fi.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unju.fi.repository.RegistroPersonaTesteadaRepository;
import ar.edu.unju.fi.service.RegistroPersonaTesteadaService;
import ar.edu.unju.fi.testeos.model.RegistroPersonaTesteada;
import ar.edu.unju.fi.testeos.model.RegistroTesteo;

@Service
@Transactional
public class RegistroPersonaTesteadaServiceImplement implements RegistroPersonaTesteadaService {

	@Autowired
	private RegistroPersonaTesteadaRepository registroPersonaTesteadaRepository;
	
	@Override
	public RegistroPersonaTesteada getRegistroPersonaTesteadaPorId(Long id) {
		return this.registroPersonaTesteadaRepository.getOne(id);
	}

	@Override
	public RegistroPersonaTesteada guardarRegistroPersonaTesteada(RegistroPersonaTesteada registroPersonaTesteada) {
		return this.registroPersonaTesteadaRepository.save(registroPersonaTesteada);
	}

	@Override
	public void eliminarRegistroPersonaTesteada(Long id) {
		this.registroPersonaTesteadaRepository.deleteById(id);

	}

	@Override
	public List<RegistroPersonaTesteada> obtenerRegistroPersonaTesteada(RegistroTesteo registroTesteo) {
		return this.registroPersonaTesteadaRepository.findByRegistroTesteo(registroTesteo);
	}

}
