package Construccion.Apirest.persistence.impl;
import Construccion.Apirest.entities.Vehiculo;
import Construccion.Apirest.persistence.IVehiculoDAO;
import Construccion.Apirest.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
@Component
public class VehiculoDAOimpl implements IVehiculoDAO {


    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    public List<Vehiculo> findAll() {
        return (List<Vehiculo>) vehiculoRepository.findAll();
    }

    @Override
    public Optional<Vehiculo> findById(Long id) {
        return vehiculoRepository.findById(id);
    }

    @Override
    public void save(Vehiculo vehiculo) {

        vehiculoRepository.save(vehiculo);

    }

    @Override
    public void deleteByid(Long id) {
        vehiculoRepository.deleteById(id);
    }
}
