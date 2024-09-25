package Construccion.Apirest.service.impl;
import Construccion.Apirest.entities.Trabajo;
import Construccion.Apirest.persistence.ITrabajoDAO;
import Construccion.Apirest.service.ITrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class TrabajoServiceImpl implements ITrabajoService {

    @Autowired
    private ITrabajoDAO TrabajoDAO;


    @Override
    public List<Trabajo> findAll() {
        return TrabajoDAO.findAll();
    }

    @Override
    public Optional<Trabajo> findById(Long id) {
        return TrabajoDAO.findById(id);
    }


    @Override
    public void save(Trabajo trabajo) {
        TrabajoDAO.save(trabajo);
    }

    @Override
    public void deleteByid(Long id) {
        TrabajoDAO.deleteByid(id);
    }
}


