package Construccion.Apirest.repository;

import Construccion.Apirest.entities.Trabajo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface TrabajoRepository extends CrudRepository<Trabajo,Long> {
}
