package Construccion.Apirest.persistence;
import Construccion.Apirest.entities.Proveedor;
import java.util.List;
import java.util.Optional;

public interface IProveedorDAO {

    List<Proveedor> findAll();

    Optional<Proveedor> findById(Long id);

    void save(Proveedor proveedor);

    void deleteByid(Long id);


//aqui van todos los metodos para cumplir  reglas de negocio

}
