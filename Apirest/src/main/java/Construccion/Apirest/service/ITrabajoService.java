package Construccion.Apirest.service;
import Construccion.Apirest.entities.Trabajo;
import java.util.List;
import java.util.Optional;

public interface ITrabajoService {

    List<Trabajo> findAll();

    Optional<Trabajo> findById(Long id);

    void save(Trabajo trabajo);

    void deleteByid(Long id);





}
