package Construccion.Apirest.persistence.impl;
import Construccion.Apirest.entities.Proveedor;
import Construccion.Apirest.persistence.IProveedorDAO;
import Construccion.Apirest.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class ProveedorDAOimpl implements IProveedorDAO {


    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> findAll() {
        return (List<Proveedor>) proveedorRepository.findAll();
    }

    @Override
    public Optional<Proveedor> findById(Long id) {
        return proveedorRepository.findById(id);
    }

    @Override
    public void save(Proveedor proveedor) {

        proveedorRepository.save(proveedor);

    }

    @Override
    public void deleteByid(Long id) {
        proveedorRepository.deleteById(id);
    }
}
