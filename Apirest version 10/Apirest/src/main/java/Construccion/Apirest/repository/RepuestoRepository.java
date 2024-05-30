package Construccion.Apirest.repository;

import Construccion.Apirest.entities.Repuesto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface RepuestoRepository extends CrudRepository<Repuesto,Long> {
}
