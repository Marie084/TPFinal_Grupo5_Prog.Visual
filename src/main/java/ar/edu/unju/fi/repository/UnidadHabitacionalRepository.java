package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.testeos.model.Barrio;
import ar.edu.unju.fi.testeos.model.UnidadHabitacional;

@Repository
public interface UnidadHabitacionalRepository extends JpaRepository<UnidadHabitacional, Long> {
       List<UnidadHabitacional> findAllByBarrio(Barrio barrio);
}
