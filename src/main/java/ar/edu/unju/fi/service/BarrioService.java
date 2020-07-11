package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.testeos.model.Barrio;



public interface BarrioService {

    Barrio getBarrioPorId(Long id);
	
	Barrio guardarBarrio(Barrio barrio);
	
	void eliminarBarrio(Long id);
	
	List<Barrio> obtenerBarrios();
	
	List<Barrio> buscarPorNombre(String nombre);
}
