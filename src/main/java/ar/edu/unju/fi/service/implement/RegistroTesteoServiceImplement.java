package ar.edu.unju.fi.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unju.fi.repository.RegistroTesteoRepository;
import ar.edu.unju.fi.service.RegistroTesteoService;
import ar.edu.unju.fi.testeos.model.RegistroTesteo;

@Service
@Transactional
public class RegistroTesteoServiceImplement implements RegistroTesteoService {
     
	@Autowired
	private RegistroTesteoRepository registroTesteoRepository;
	
	@Override
	public RegistroTesteo getRegistroTesteoPorId(Long id) {
		return this.registroTesteoRepository.getOne(id);
	}

	@Override
	public RegistroTesteo guardarRegistroTesteo(RegistroTesteo registroTesteo) {
		return this.registroTesteoRepository.save(registroTesteo);
	}

	@Override
	public void eliminarRegistroTesteo(Long id) {
		this.registroTesteoRepository.deleteById(id);
	}

	@Override
	public List<RegistroTesteo> obtenerRegistros() {
		return this.registroTesteoRepository.findAll();
	}

}
