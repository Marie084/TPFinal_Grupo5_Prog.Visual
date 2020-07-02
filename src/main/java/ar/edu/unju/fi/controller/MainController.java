package ar.edu.unju.fi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.edu.unju.fi.service.IPersonaTesteadaService;






@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private IPersonaTesteadaService personaTesteadaService;
	
	//TE ABRE  LA PANTALLA PARA Q LUEGO EN EL SIGUIENTE METODO TE TRAIGA LOS DATOS Q SE ENCUENTREN CON EL DNI
	
	@RequestMapping(value = "",method = RequestMethod.GET)  
	public String main(Model model) {
		
		return "Consulta/formularioConsulta";
	}
	
	
	//de esta manera implemento el html con el service 
	@RequestMapping(value = "/Consulta/formularioConsulta/{documento}",method = RequestMethod.GET) //SI ESTO ES PARA LLAMAR CON ESTE NOMBRE LA PAGINA HTML 
	//@PathVariable ("documento"): define la variable por la que se va a buscar la informaicion
	public String consultas(@PathVariable ("documento") String documento, Model model) {
		model.addAttribute("personaTesteada", personaTesteadaService.getPersonaTesteadaPorDocumento(documento));
		return "Consulta/formularioConsulta";
	}

}
