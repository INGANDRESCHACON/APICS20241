package Construccion.Apirest.repository;

import Construccion.Apirest.entities.TrabajoRepuesto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface TrabajoRepuestoRepository extends CrudRepository<TrabajoRepuesto,Long> {
}
