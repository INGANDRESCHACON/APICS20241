package Construccion.Apirest.service;

import Construccion.Apirest.entities.Repuesto;

import java.util.List;
import java.util.Optional;

public interface IRepuestoService {


    List<Repuesto> findAll();

    Optional<Repuesto> findById(Long id);

    void save(Repuesto repuesto);

    void deleteByid(Long id);


}
