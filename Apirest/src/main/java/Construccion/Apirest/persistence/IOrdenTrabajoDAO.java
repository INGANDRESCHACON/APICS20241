package Construccion.Apirest.persistence;
import Construccion.Apirest.entities.OrdenTrabajo;
import java.util.List;
import java.util.Optional;

public interface IOrdenTrabajoDAO {

    List<OrdenTrabajo> findAll();

    Optional<OrdenTrabajo> findById(Long id);

    void save(OrdenTrabajo ordentrabajo);

    void deleteByid(Long id);

//aqui van todos los metodos para cumplir  reglas de negocio


}
