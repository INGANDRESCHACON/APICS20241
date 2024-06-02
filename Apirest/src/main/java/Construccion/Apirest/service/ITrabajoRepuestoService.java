package Construccion.Apirest.service;

import Construccion.Apirest.entities.TrabajoRepuesto;

import java.util.List;
import java.util.Optional;

public interface ITrabajoRepuestoService {

    List<TrabajoRepuesto> findall();

    Optional<TrabajoRepuesto> findById(Long id);

    void save(TrabajoRepuesto trabajorepuesto);

    void deleteByid(Long id);









}
