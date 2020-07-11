package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.edu.unju.fi.service.RegistroTesteoService;


@Controller
@RequestMapping("/registroTesteo")
public class RegistroTesteoController {
	
	@Autowired
	private RegistroTesteoService registroTesteoService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("registros", registroTesteoService.obtenerRegistros());
		return "registroTesteo/ListaRegistros";
	}
}
