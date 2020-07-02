package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.testeos.model.Usuario;

/**
 * Es la interfaz con los metodos basicos que va a realizar el servicio.
 * @author Mariela Olivera
 *
 */
public interface UsuarioService {
	
	Usuario getUsuarioPorId(Long id);
	
	Usuario guardarUsuario(Usuario usuario);
	
	void eliminarUsuario(Long id);
	
	List<Usuario> obtenerUsuarios();
	
	
}
