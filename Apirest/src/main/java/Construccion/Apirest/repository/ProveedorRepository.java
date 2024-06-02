package Construccion.Apirest.repository;

import Construccion.Apirest.entities.Proveedor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface ProveedorRepository extends CrudRepository<Proveedor,Long> {
}
