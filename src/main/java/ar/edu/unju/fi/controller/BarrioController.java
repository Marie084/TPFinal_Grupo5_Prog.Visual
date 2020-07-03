package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.edu.unju.fi.service.BarrioService;
import ar.edu.unju.fi.service.UnidadHabitacionalService;
import ar.edu.unju.fi.testeos.model.Barrio;


@Controller
@RequestMapping("/barrio")
public class BarrioController {
	
	@Autowired
	private BarrioService barrioService;
	
	@Autowired
	private UnidadHabitacionalService unidadHabitacionalService;
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("barrios", barrioService.obtenerBarrios());
		return "barrio/listaDeBarrios";
	}
	
	@RequestMapping(value="/nuevo", method = RequestMethod.GET)
    public String nuevo(Model model) {
    	model.addAttribute("barrio", new Barrio());
    	return "barrio/nuevoBarrio";
	}
	
	@RequestMapping(value="/crear", method=RequestMethod.POST)
    public String crear(@Validated Barrio barrio,
    		BindingResult bindingResult, Model model) {
    barrioService.guardarBarrio(barrio);
    model.addAttribute("barrios", barrioService.obtenerBarrios());
    return "barrio/listaDeBarrios";
    }
    
	/*
	 * "/editar/{id}  es la ruta que aparece en la barra de navegacion del navegador.
	 * @PathVariable establece que el id se carga en el path.
	 */
    @RequestMapping(value="/editar/{id}", method=RequestMethod.GET)
    public String editar(@PathVariable("id") long id, Model model){
    	model.addAttribute("barrio",barrioService.getBarrioPorId(id)); 
    	model.addAttribute("unidades", unidadHabitacionalService.obtenerUnidadesHabitacionalesPorBarrio(id));
    	return "barrio/editarBarrio";
    }
    
    @RequestMapping(value="/actualizar", method=RequestMethod.POST)
    public String actualizar(@Validated Barrio barrio, BindingResult bindingResult, Model model) {
   	if(bindingResult.hasErrors()) {
   		model.addAttribute("barrios", barrioService.obtenerBarrios());
   		return "barrio/listaDeBarrios";	
   	}
   	barrioService.guardarBarrio(barrio);
   	model.addAttribute("barrios", barrioService.obtenerBarrios());
		return "barrio/listaDeBarrios";
   }
   
   @RequestMapping(value="/borrar/{id}", method=RequestMethod.GET)
     public String borrar(@PathVariable("id") long id, Model model) {
   	barrioService.eliminarBarrio(id);
   	model.addAttribute("barrios", barrioService.obtenerBarrios());
   	return "barrio/listaDeBarrios";
   }
    
    
    
    
}

