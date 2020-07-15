package ar.edu.unju.fi.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.edu.unju.fi.service.BarrioService;
import ar.edu.unju.fi.service.PersonaTesteadaService;
import ar.edu.unju.fi.service.RegistroPersonaTesteadaService;
import ar.edu.unju.fi.service.RegistroTesteoService;
import ar.edu.unju.fi.service.UnidadHabitacionalService;
import ar.edu.unju.fi.service.UsuarioService;
import ar.edu.unju.fi.testeos.model.Barrio;
import ar.edu.unju.fi.testeos.model.PersonaTesteada;
import ar.edu.unju.fi.testeos.model.RegistroPersonaTesteada;
import ar.edu.unju.fi.testeos.model.RegistroTesteo;
import ar.edu.unju.fi.testeos.model.UnidadHabitacional;
import ar.edu.unju.fi.testeos.model.Usuario;
import ar.edu.unju.fi.util.RegistroUtil;

@Controller
@RequestMapping("/registroTesteo")
public class RegistroTesteoController {

	@Autowired
	private RegistroTesteoService registroTesteoService;
	@Autowired
	private PersonaTesteadaService personaTesteadaService;
	@Autowired
	private RegistroPersonaTesteadaService registroPersonaTesteadaService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private UnidadHabitacionalService unidadHabitacionalService;
	@Autowired
	private BarrioService barrioService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("registros", registroTesteoService.obtenerRegistros());
		//model.addAttribute("registro", new RegistroTesteo());
		return "registroTesteo/ListaRegistros";
	}

	@RequestMapping(value = "/detalle/{id}", method = RequestMethod.GET)
	public String editar(@PathVariable("id") long id, Model model) {
		RegistroTesteo registroTesteo = this.registroTesteoService.getRegistroTesteoPorId(id);
		List<RegistroPersonaTesteada> listaPersonas = this.registroPersonaTesteadaService
				.obtenerRegistroPersonaTesteada(registroTesteo);
		model.addAttribute("registroTesteo", registroTesteo);
		model.addAttribute("registroPersonasTesteadas", listaPersonas);
		return "registroTesteo/detalle";
	}

	@RequestMapping(value = "/nuevo2", method = RequestMethod.GET)
	public String nuevo2(Model model) {
		RegistroTesteo registroT = new RegistroTesteo();
		registroT.setFechaHora(LocalDateTime.now());
		RegistroTesteo registroTesteo = this.registroTesteoService.guardarRegistroTesteo(registroT);
		RegistroUtil registroUtil = new RegistroUtil();
		registroUtil.setRegistroTesteo(registroTesteo);
		
		model.addAttribute("registroTesteoUtil", registroUtil);

		return "registroTesteo/nuevoRegistro";
	}
	
	@RequestMapping(value = "/agregarPersona", method = RequestMethod.POST)
	public String agregarPersona(RegistroUtil registroUtil, Model model) {
		RegistroTesteo regTest = this.registroTesteoService.getRegistroTesteoPorId(registroUtil.getRegistroTesteo().getId());
		
		Barrio barrio = this.barrioService.guardarBarrio(new Barrio(null, registroUtil.getBarrio().getNombre()));
		
		UnidadHabitacional unidadHabitacional = this.unidadHabitacionalService
				.guardarUnidadHabitacional(new UnidadHabitacional(null, registroUtil.getUnidadHabitacional().getDireccion(), barrio));
		
		regTest.setUnidadHabitacional(unidadHabitacional);
		
		Usuario usuario = this.usuarioService.buscarPorNombre(registroUtil.getUsuario().getNombreReal()).get(0);
		regTest.setUsuario(usuario);
		regTest.setFechaHora(LocalDateTime.now());
		
		this.registroTesteoService.guardarRegistroTesteo(regTest);
		
		PersonaTesteada personaTesteada = this.personaTesteadaService.guardarPersonaTesteada(registroUtil.getPersonaTesteada());
		
	
		RegistroPersonaTesteada registroPersonaTesteada = new RegistroPersonaTesteada();
		registroPersonaTesteada.setPersonaTesteada(personaTesteada);
		registroPersonaTesteada.setRegistroTesteo(registroUtil.getRegistroTesteo());
		this.registroPersonaTesteadaService.guardarRegistroPersonaTesteada(registroPersonaTesteada);
		
		
		registroUtil.getListaPersonasTesteadas().addAll(this.registroPersonaTesteadaService.obtenerRegistroPersonaTesteada(registroUtil.getRegistroTesteo()));
		registroUtil.setPersonaTesteada(new PersonaTesteada());
		
		
		model.addAttribute("registroTesteoUtil", registroUtil);

		return "registroTesteo/nuevoRegistro";
	}

	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public String crear(@Validated RegistroUtil personaTesteada, Model model) {

		return "registroTesteo/ListaRegistros";
	}

	
	@RequestMapping(value = "/borrar/{id}", method = RequestMethod.GET)
	public String borrar(@PathVariable("id") long id, Model model) {
		registroTesteoService.eliminarRegistroTesteo(id);
		model.addAttribute("registros", registroTesteoService.obtenerRegistros());
		return "registroTesteo/ListaRegistros";
}
}