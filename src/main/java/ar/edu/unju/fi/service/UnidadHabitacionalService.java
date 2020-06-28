package ar.edu.unju.fi.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unju.fi.repository.IUnidadHabitacional;
import ar.edu.unju.fi.testeos.model.UnidadHabitacional;

@Service
@Transactional(readOnly = true)
public class UnidadHabitacionalService {

	@Autowired
	IUnidadHabitacional iUnidadHabitacional;
	
	public List<UnidadHabitacional> findAll() {
		
		return iUnidadHabitacional.findAll();
	}
}
