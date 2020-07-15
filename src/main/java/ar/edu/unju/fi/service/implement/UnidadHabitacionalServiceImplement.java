package ar.edu.unju.fi.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.repository.BarrioRepository;
import ar.edu.unju.fi.repository.UnidadHabitacionalRepository;
import ar.edu.unju.fi.service.UnidadHabitacionalService;
import ar.edu.unju.fi.testeos.model.Barrio;
import ar.edu.unju.fi.testeos.model.UnidadHabitacional;

@Service
public class UnidadHabitacionalServiceImplement implements UnidadHabitacionalService {
    
	@Autowired
	private UnidadHabitacionalRepository unidadHabitacionalRepository;
	
	@Autowired
	private BarrioRepository barrioRepository;
	
	@Override
	public UnidadHabitacional getUnidadHabitacionalPorId(Long id) {
		return this.unidadHabitacionalRepository.getOne(id);
	}

	@Override
	public UnidadHabitacional guardarUnidadHabitacional(UnidadHabitacional unidadHabitacional) {
		return this.unidadHabitacionalRepository.save(unidadHabitacional);
	}

	@Override
	public void eliminarUnidadHabitacional(Long id) {
		this.unidadHabitacionalRepository.deleteById(id);

	}

	@Override
	public List<UnidadHabitacional> obtenerUnidadesHabitacionales() {
		return this.unidadHabitacionalRepository.findAll();
	}

	@Override
	public List<UnidadHabitacional> obtenerUnidadesHabitacionalesPorBarrio(Long barrioId) {
		Barrio barrio = this.barrioRepository.getOne(barrioId);
		List<UnidadHabitacional> list = this.unidadHabitacionalRepository.findAllByBarrio(barrio);
		return list;
	}
	
	@Override
	public UnidadHabitacional buscarUhPorNombre(String direccion) {
		return this.unidadHabitacionalRepository.findByDireccion(direccion);
}
    
}
