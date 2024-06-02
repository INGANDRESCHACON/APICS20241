package Construccion.Apirest.service;
import Construccion.Apirest.entities.Persona;
import java.util.List;
import java.util.Optional;

public interface IPersonaService {

    List<Persona> findAll();

    Optional<Persona> findById(Long id);

    void save(Persona persona);

    void deleteByid(Long id);



}
