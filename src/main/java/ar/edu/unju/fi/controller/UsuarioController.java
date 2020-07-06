package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.edu.unju.fi.service.UsuarioService;
import ar.edu.unju.fi.testeos.model.Usuario;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("usuarios", usuarioService.obtenerUsuarios());
		return "usuario/lista";
	}
	
    @RequestMapping(value="/nuevo", method = RequestMethod.GET)
    public String nuevo(Model model) {
    	model.addAttribute("usuario", new Usuario());
    	return "usuario/nuevo";
    }
    
    @RequestMapping(value="/crear", method=RequestMethod.POST)
    public String crear(@Validated Usuario usuario,
    	BindingResult bindingResult, Model model) {
    	usuarioService.guardarUsuario(usuario);
    	model.addAttribute("usuarios", usuarioService.obtenerUsuarios());
    return "usuario/lista";
    }
}
