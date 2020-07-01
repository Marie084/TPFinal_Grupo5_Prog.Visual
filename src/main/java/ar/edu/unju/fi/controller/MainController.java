package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.service.IPersonaTesteadaService;




@Controller
@RequestMapping("/")
public class MainController {
	
	/*@Autowired
	private IPersonaTesteadaService personaTesteadaService;*/
	
	@RequestMapping("/tablaConsulta") //SI ESTO ES PARA LLAMAR CON ESTE NOMBRE LA PAGINA HTML 
	public String consultas(Model model) {
		return "Consulta";
	}

}
