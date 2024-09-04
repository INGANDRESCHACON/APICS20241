package Construccion.Apirest.service;
import Construccion.Apirest.entities.Proveedor;
import java.util.List;
import java.util.Optional;

public interface IProveedorService {

    List<Proveedor> findAll();

    Optional<Proveedor> findById(Long id);

    void save(Proveedor proveedor);

    void deleteByid(Long id);




}
