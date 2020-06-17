package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.testeos.model.Usuario;

/**
 * El repository se comunica con la base de datos. Para hacer las operaciones
 * de insert, select, update, delete, etc.
 * @author Mariela Olivera
 *
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
}
