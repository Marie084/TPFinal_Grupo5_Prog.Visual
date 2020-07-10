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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UnidadHabitacional guardarUnidadHabitacional(UnidadHabitacional unidadHabitacional) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarUnidadHabitacional(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<UnidadHabitacional> obtenerUnidadesHabitacionales() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UnidadHabitacional> obtenerUnidadesHabitacionalesPorBarrio(Long barrioId) {
		Barrio barrio = this.barrioRepository.getOne(barrioId);
		List<UnidadHabitacional> list = this.unidadHabitacionalRepository.findAllByBarrio(barrio);
		return list;
	}

}
