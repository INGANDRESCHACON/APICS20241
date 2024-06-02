
package Construccion.Apirest.persistence;
import Construccion.Apirest.entities.Repuesto;
import java.util.List;
import java.util.Optional;

public interface IRepuestoDAO {

    List<Repuesto> findAll();

    Optional<Repuesto> findById(Long id);

    void save(Repuesto repuesto);

    void deleteByid(Long id);


//aqui van todos los metodos para cumplir  reglas de negocio

}
