package Construccion.Apirest.persistence;
import Construccion.Apirest.entities.TrabajoRepuesto;
import java.util.List;
import java.util.Optional;

public interface ITrabajoRepuestoDAO {

    List<TrabajoRepuesto> findall();

    Optional<TrabajoRepuesto> findById(Long id);

    void save(TrabajoRepuesto trabajorepuesto);

    void deleteByid(Long id);


//aqui van todos los metodos para cumplir  reglas de negocio

}
