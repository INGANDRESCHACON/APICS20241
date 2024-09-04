package Construccion.Apirest.service;
import Construccion.Apirest.entities.OrdenTrabajo;
import Construccion.Apirest.entities.Persona;
import Construccion.Apirest.entities.Proveedor;
import Construccion.Apirest.entities.Vehiculo;
import Construccion.Apirest.repository.OrdenTrabajoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface IOrdenTrabajoService {
    List<OrdenTrabajo> findAll();

    Optional<OrdenTrabajo> findById(Long id);

    void save(OrdenTrabajo ordentrabajo);

    void deleteByid(Long id);


    void enviarCorreoOrdenTrabajo(OrdenTrabajo ordenTrabajo);


    
    
}
