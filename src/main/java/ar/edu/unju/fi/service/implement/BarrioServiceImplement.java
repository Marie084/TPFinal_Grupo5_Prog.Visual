package ar.edu.unju.fi.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unju.fi.repository.BarrioRepository;

import ar.edu.unju.fi.service.BarrioService;
import ar.edu.unju.fi.testeos.model.Barrio;

@Service
@Transactional
public class BarrioServiceImplement implements BarrioService {
	@Autowired
	private BarrioRepository barrioRepository;
	@Override
	public Barrio getBarrioPorId(Long id) {
		// TODO Auto-generated method stub
		return this.barrioRepository.getOne(id);
	}

	@Override
	public Barrio guardarBarrio(Barrio barrio) {
		return this.barrioRepository.save(barrio);
	}

	@Override
	public void eliminarBarrio(Long id) {
		this.barrioRepository.deleteById(id);

	}

	@Override
	public List<Barrio> obtenerBarrios() {
		return this.barrioRepository.findAll();
	}

}
