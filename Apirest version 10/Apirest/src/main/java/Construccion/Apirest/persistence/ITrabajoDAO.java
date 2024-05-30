package Construccion.Apirest.persistence;
import Construccion.Apirest.entities.Trabajo;
import java.util.List;
import java.util.Optional;

public interface ITrabajoDAO {

    List<Trabajo> findAll();

    Optional<Trabajo> findById(Long id);

    void save(Trabajo trabajo);

    void deleteByid(Long id);


//aqui van todos los metodos para cumplir  reglas de negocio

}
