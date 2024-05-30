package Construccion.Apirest.persistence.impl;
import Construccion.Apirest.entities.TrabajoRepuesto;
import Construccion.Apirest.persistence.ITrabajoRepuestoDAO;
import Construccion.Apirest.repository.TrabajoRepuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class TrabajoRepuestoDAOimpl implements ITrabajoRepuestoDAO {


    @Autowired
    private TrabajoRepuestoRepository trabajoRepuestoRepository;

    @Override
    public List<TrabajoRepuesto> findall() {
        return (List<TrabajoRepuesto>) trabajoRepuestoRepository.findAll();
    }

    @Override
    public Optional<TrabajoRepuesto> findById(Long id) {
        return trabajoRepuestoRepository.findById(id);
    }

    @Override
    public void save(TrabajoRepuesto trabajoRepuesto) {

        trabajoRepuestoRepository.save(trabajoRepuesto);

    }

    @Override
    public void deleteByid(Long id) {
        trabajoRepuestoRepository.deleteById(id);
    }
}
