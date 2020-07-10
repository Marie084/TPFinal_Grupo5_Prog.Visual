package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.edu.unju.fi.service.UsuarioService;
import ar.edu.unju.fi.testeos.model.Usuario;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
    
	/**
	 * Abre el html con la lista de usuarios.
	 * @param model
	 * @return documento html con la lista de usuarios.
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("usuarios", usuarioService.obtenerUsuarios());
		model.addAttribute("usuario", new Usuario());
		return "usuario/lista";
	}
	
	/**
	 * Abre el html nuevo donde envia la instancia de nuevo usuario
	 * para ser cargado.
	 * @param model
	 * @return el documento html para la carga del nuevo usuario.
	 */
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public String nuevo(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "usuario/nuevo";
	}

	/**
	 * Este metodo crea al nuevo usuario y guarda los datos.
	 * @param usuario
	 * @param model
	 * @return Devuelve el Html de la lista de usuarios.
	 */
	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public String crear(@Validated Usuario usuario, Model model) {
		usuarioService.guardarUsuario(usuario);
		model.addAttribute("usuarios", usuarioService.obtenerUsuarios());
		return "usuario/lista";
	}
    /**
     * Este metodo valida el id del usuario y abre el html para su edicion.
     * @param id
     * @param model
     * @return Devuelve el html de edicion con los datos del usuario.
     */
	@RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
	public String editar(@PathVariable("id") long id, Model model) {
		model.addAttribute("usuario", usuarioService.getUsuarioPorId(id));
		return "usuario/editar";
	}

	/**
	 * Este metodo valida los datos del usuario editado y abre el html de la lista de
	 * usuarios.
	 * @param usuario
	 * @param bindingResult Contiene el resultado de la validacion de los  datos del usuario.
	 * @param model
	 * @return el documento html con la lista de usuarios.
	 */
	@RequestMapping(value = "/actualizar", method = RequestMethod.POST)
	public String actualizar(@Validated Usuario usuario, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("usuarios", usuarioService.obtenerUsuarios());
			return "usuario/lista";
		}
		usuarioService.guardarUsuario(usuario);
		model.addAttribute("usuarios", usuarioService.obtenerUsuarios());
		return "usuario/lista";
	}
    
	/**
	 * Este metodo elimina un usuario por su ID.
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/borrar/{id}", method = RequestMethod.GET)
	public String borrar(@PathVariable("id") long id, Model model) {
		usuarioService.eliminarUsuario(id);
		model.addAttribute("usuarios", usuarioService.obtenerUsuarios());
		return "usuario/lista";
	}
	
	
	

	/**
	 * Este metodo envia el criterio de busqueda para que mediante buscarPorNombreDeUsuario lo busque
	 * y devuelva las coincidencias.
	 * @param usuario
	 * @param model
	 * @return el html de busqueda.
	 */
	@RequestMapping(value ="/buscar", method = RequestMethod.POST)
    public String usuarioSearch(Usuario usuario, Model model) {

        model.addAttribute("usuarios", usuarioService.buscarPorNombre(usuario.getNombreReal()));

        return "usuario/lista";
    }

}
