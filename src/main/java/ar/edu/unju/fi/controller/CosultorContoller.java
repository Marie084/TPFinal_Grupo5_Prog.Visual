package ar.edu.unju.fi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.edu.unju.fi.service.IPersonaTesteadaService;
import ar.edu.unju.fi.testeos.model.PersonaTesteada;

@Controller
@RequestMapping("/consulta")
public class CosultorContoller {
	
	@Autowired
	private IPersonaTesteadaService personaTesteadaService;
	
	//TE ABRE  LA PANTALLA PARA Q LUEGO EN EL SIGUIENTE METODO TE TRAIGA LOS DATOS Q SE ENCUENTREN CON EL DNI
	
	@RequestMapping(value = "",method = RequestMethod.GET)  
	public String main(Model model) {
		model.addAttribute("personaTesteada", new PersonaTesteada());
		return "consulta/consulta";
	}
	
	
	//de esta manera implemento el html con el service 
	@RequestMapping(value = "/consulta/{documento}",method = RequestMethod.GET) //SI ESTO ES PARA LLAMAR CON ESTE NOMBRE LA PAGINA HTML 
	public String consultas(@PathVariable ("documento") String documento, Model model ) {                         //@PathVariable ("documento"):lo q capta de value
		model.addAttribute("personaTesteada", personaTesteadaService.getPersonaTesteadaPorDocumento(documento));
		return "consulta/consulta";
	}
	
	//este crea un objeto vacio , este objeto vacio se utiliza para la busqueda
	@RequestMapping(value ="/buscar", method = RequestMethod.GET)
    public String personaTesteadaSearch(Model model) {

        model.addAttribute("persona", new PersonaTesteada());

        return "consulta/busqueda";
    }

	//este realiza la busqueda
	/**
	 * Este metodo envia el criterio de busqueda para que mediante buscarPorDocuemnto lo busque
	 * y devuelva las coincidencias.
	 * @param personaTesteada
	 * @param model
	 * @return el html de busqueda.
	 */
	@RequestMapping(value ="/buscar", method = RequestMethod.POST)
    public String personaTesteadaSearch(PersonaTesteada personaTesteada, Model model) {

        model.addAttribute("personas", personaTesteadaService.buscarPorDocumento(personaTesteada.getDocumento()));
        
        return "consulta/busqueda";
    }
	
	@RequestMapping(value ="/buscarPorApellido", method = RequestMethod.POST)
    public String personaTesteadaApellidoSearch(PersonaTesteada personaTesteada, Model model) {

        model.addAttribute("personas", personaTesteadaService.buscarPorApellido(personaTesteada.getApellido()));
        
        return "consulta/busqueda";
    }
	
	
} 