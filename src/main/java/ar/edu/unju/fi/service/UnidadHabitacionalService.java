package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.testeos.model.UnidadHabitacional;

public interface UnidadHabitacionalService {
    
	
	UnidadHabitacional getUnidadHabitacionalPorId(Long id);
	
	UnidadHabitacional guardarUnidadHabitacional(UnidadHabitacional unidadHabitacional);
	
	void eliminarUnidadHabitacional(Long id);
	
	List<UnidadHabitacional> obtenerUnidadesHabitacionales();
	
	List<UnidadHabitacional> obtenerUnidadesHabitacionalesPorBarrio(Long barrioId);

}
