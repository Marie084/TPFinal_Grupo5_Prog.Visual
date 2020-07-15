package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	/**
	 * Es la primera vista que se muestra al usuario que esta por loguearse
	 * @return retorna la vista del login
	 */
	
	@GetMapping({"/","/login"})
	public String getLogin(Model model) {
		return "login/login";
	}
}
