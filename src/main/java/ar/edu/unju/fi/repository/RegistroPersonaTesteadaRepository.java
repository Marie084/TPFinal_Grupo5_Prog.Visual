package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.testeos.model.RegistroPersonaTesteada;
import ar.edu.unju.fi.testeos.model.RegistroTesteo;

@Repository
public interface RegistroPersonaTesteadaRepository extends JpaRepository<RegistroPersonaTesteada, Long> {

	List<RegistroPersonaTesteada> findByRegistroTesteo(RegistroTesteo registroTesteo);
	
}
