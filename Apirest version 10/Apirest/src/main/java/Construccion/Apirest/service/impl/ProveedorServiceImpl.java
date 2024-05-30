package Construccion.Apirest.service.impl;
import Construccion.Apirest.entities.Proveedor;
import Construccion.Apirest.persistence.IProveedorDAO;
import Construccion.Apirest.service.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class ProveedorServiceImpl implements IProveedorService {

    @Autowired
    private IProveedorDAO ProveedorDAO;


    @Override
    public List<Proveedor> findAll() {
        return ProveedorDAO.findAll();
    }

    @Override
    public Optional<Proveedor> findById(Long id) {
        return ProveedorDAO.findById(id);
    }


    @Override
    public void save(Proveedor proveedor) {
        ProveedorDAO.save(proveedor);
    }

    @Override
    public void deleteByid(Long id) {
        ProveedorDAO.deleteByid(id);
    }
}


