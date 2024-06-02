package Construccion.Apirest.persistence;
import Construccion.Apirest.entities.Vehiculo;
import java.util.List;
import java.util.Optional;

public interface IVehiculoDAO {

    List<Vehiculo> findAll();

    Optional<Vehiculo> findById(Long id);

    void save(Vehiculo vehiculo);

    void deleteByid(Long id);


//aqui van todos los metodos para cumplir  reglas de negocio

}
