package Construccion.Apirest.persistence.impl;
import Construccion.Apirest.entities.Repuesto;
import Construccion.Apirest.persistence.IRepuestoDAO;
import Construccion.Apirest.repository.RepuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class RepuestoDAOimpl implements IRepuestoDAO {


    @Autowired
    private RepuestoRepository repuestoRepository;

    @Override
    public List<Repuesto> findAll() {
        return (List<Repuesto>) repuestoRepository.findAll();
    }

    @Override
    public Optional<Repuesto> findById(Long id) {
        return repuestoRepository.findById(id);
    }

    @Override
    public void save(Repuesto repuesto) {

        repuestoRepository.save(repuesto);

    }

    @Override
    public void deleteByid(Long id) {
        repuestoRepository.deleteById(id);
    }
}
