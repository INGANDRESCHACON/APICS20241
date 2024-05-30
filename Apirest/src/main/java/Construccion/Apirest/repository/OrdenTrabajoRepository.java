package Construccion.Apirest.repository;

import Construccion.Apirest.entities.OrdenTrabajo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface OrdenTrabajoRepository extends CrudRepository<OrdenTrabajo,Long> {
}
