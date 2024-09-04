package Construccion.Apirest.persistence.impl;
import Construccion.Apirest.entities.Trabajo;
import Construccion.Apirest.persistence.ITrabajoDAO;
import Construccion.Apirest.repository.TrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class TrabajoDAOimpl implements ITrabajoDAO {


    @Autowired
    private TrabajoRepository trabajoRepository;

    @Override
    public List<Trabajo> findAll() {
        return (List<Trabajo>) trabajoRepository.findAll();
    }

    @Override
    public Optional<Trabajo> findById(Long id) {
        return trabajoRepository.findById(id);
    }

    @Override
    public void save(Trabajo trabajo) {

        trabajoRepository.save(trabajo);

    }

    @Override
    public void deleteByid(Long id) {
        trabajoRepository.deleteById(id);
    }
}
