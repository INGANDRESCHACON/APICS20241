package Construccion.Apirest.service.impl;
import Construccion.Apirest.entities.Vehiculo;
import Construccion.Apirest.persistence.IVehiculoDAO;
import Construccion.Apirest.repository.VehiculoRepository;
import Construccion.Apirest.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class VehiculoServiceImpl implements IVehiculoService {

@Autowired
private IVehiculoDAO VehiculoDAO;
    @Autowired
    private VehiculoRepository vehiculoRepository;

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



    //**************************METODOS NUEVOS****************************//






    public boolean validarOdometro(int nuevoOdometro, Long idVehiculo) {
        Optional<Vehiculo> optionalVehiculo = vehiculoRepository.findById(idVehiculo);
        if (optionalVehiculo.isPresent()) {
            Vehiculo vehiculo = optionalVehiculo.get();
            int odometroActual = vehiculo.getOdometro();
            return nuevoOdometro > odometroActual;
        } else {
            // Manejo de caso en que el vehículo no existe con ese ID
            return false;
        }
    }

    @Override
    public void actualizarOdometroVehiculo(Long idVehiculo, int nuevoOdometro) {
        Optional<Vehiculo> optionalVehiculo = vehiculoRepository.findById(idVehiculo);
        if (optionalVehiculo.isPresent()) {
            Vehiculo vehiculo = optionalVehiculo.get();
            vehiculo.setOdometro(nuevoOdometro);
            vehiculoRepository.save(vehiculo);
        } else {
            // Manejo de excepción si no se encuentra el vehículo con el ID dado
        }
    }








}
