package Construccion.Apirest.service.impl;
import Construccion.Apirest.entities.Vehiculo;
import Construccion.Apirest.persistence.IVehiculoDAO;
import Construccion.Apirest.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class VehiculoServiceImpl implements IVehiculoService {

@Autowired
private IVehiculoDAO VehiculoDAO;


    @Override
    public List<Vehiculo> findAll()
    {
        return VehiculoDAO.findAll();
    }

    @Override
    public Optional<Vehiculo> findById(Long id)
    {
        return VehiculoDAO.findById(id);
    }


    @Override
    public Vehiculo save(Vehiculo vehiculo)
    {
        VehiculoDAO.save(vehiculo);
        return vehiculo;
    }

    @Override
    public void deleteByid(Long id)
    {
VehiculoDAO.deleteByid(id);
    }
}
