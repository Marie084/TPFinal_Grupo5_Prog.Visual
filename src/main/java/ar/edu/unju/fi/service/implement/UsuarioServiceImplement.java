package ar.edu.unju.fi.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unju.fi.repository.UsuarioRepository;
import ar.edu.unju.fi.service.UsuarioService;
import ar.edu.unju.fi.testeos.model.Usuario;

@Service // con esta notación le decimos a la clase que es un servicio y que se va a
			// encargar de la lógica de negocio.
@Transactional // transacciones con la base de datos.
public class UsuarioServiceImplement implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository; // instanciamos al repository.

	/**
	 * Equivale a: SELECT * FROM USUARIO WHERE ID=":ID"
	 */
	@Override
	public Usuario getUsuarioPorId(Long id) {
		return this.usuarioRepository.getOne(id);
	}

	/**
	 * Equivale a: INSERT INTO nombre_tabla (listaDeCampos) 
	 * o UPDATE nombre_tabla
	 *      SET campo1 = valor1,
	 *          campoN = valorN,
	 *          ...
	 *   WHERE condiciones       
	 */
	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}

	/**
	 * Equivale a: DELETE FROM nombre_tabla WHERE condiciones
	 */
	@Override
	public void eliminarUsuario(Long id) {
		this.usuarioRepository.deleteById(id);
	}

	/**
	 * Equivale a: SELECT * FROM USUARIO;
	 */
	@Override
	public List<Usuario> obtenerUsuarios() {
		return this.usuarioRepository.findAll();
	}

}
