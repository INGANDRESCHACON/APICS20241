package Construccion.Apirest.service;
import Construccion.Apirest.entities.OrdenTrabajo;
import java.util.List;
import java.util.Optional;





































public interface IOrdenTrabajoService {
    List<OrdenTrabajo> findAll();

    Optional<OrdenTrabajo> findById(Long id);

    void save(OrdenTrabajo ordentrabajo);

    void deleteByid(Long id);




}
