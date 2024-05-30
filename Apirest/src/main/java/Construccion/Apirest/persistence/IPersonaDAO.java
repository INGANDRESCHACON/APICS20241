package Construccion.Apirest.persistence;
import Construccion.Apirest.entities.Persona;
import java.util.List;
import java.util.Optional;

public interface IPersonaDAO {

    List<Persona> findAll();

    Optional<Persona> findById(Long id);

    void save(Persona persona);

    void deleteByid(Long id);

//aqui van todos los metodos para cumplir  reglas de negocio


}
