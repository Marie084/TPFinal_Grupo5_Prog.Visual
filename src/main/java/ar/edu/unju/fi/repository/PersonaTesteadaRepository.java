package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.testeos.model.PersonaTesteada;

@Repository
public interface PersonaTesteadaRepository extends JpaRepository<PersonaTesteada, Long> {
      
	PersonaTesteada findByDocumento(String documento);
	List<PersonaTesteada> findByDocumentoContaining(String Documento);
	
	PersonaTesteada findByApellido(String apellido);
	List<PersonaTesteada> findByApellidoContaining(String Apellido);
}
