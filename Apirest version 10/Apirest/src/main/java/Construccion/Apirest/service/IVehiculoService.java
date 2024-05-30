package Construccion.Apirest.service;

import Construccion.Apirest.entities.Vehiculo;

import java.util.List;
import java.util.Optional;

public interface IVehiculoService {

    List<Vehiculo> findAll();

    Optional<Vehiculo> findById(Long id);

     Vehiculo save(Vehiculo vehiculo) ;


    void deleteByid(Long id);




}
