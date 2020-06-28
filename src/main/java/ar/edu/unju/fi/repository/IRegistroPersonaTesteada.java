package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.testeos.model.RegistroPersonaTesteada;

@Repository
public interface IRegistroPersonaTesteada extends JpaRepository<RegistroPersonaTesteada, Long>  {

}
