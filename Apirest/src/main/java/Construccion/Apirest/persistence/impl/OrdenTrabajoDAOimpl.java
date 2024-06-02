package Construccion.Apirest.persistence.impl;
import Construccion.Apirest.entities.OrdenTrabajo;
import Construccion.Apirest.persistence.IOrdenTrabajoDAO;
import Construccion.Apirest.repository.OrdenTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class OrdenTrabajoDAOimpl implements IOrdenTrabajoDAO {


    @Autowired
    private OrdenTrabajoRepository ordenTrabajoRepository;

    @Override
    public List<OrdenTrabajo> findAll() {
        return (List<OrdenTrabajo>) ordenTrabajoRepository.findAll();
    }

    @Override
    public Optional<OrdenTrabajo> findById(Long id) {
        return ordenTrabajoRepository.findById(id);
    }

    @Override
    public void save(OrdenTrabajo OrdenTrabajo) {

        ordenTrabajoRepository.save(OrdenTrabajo);

    }

    @Override
    public void deleteByid(Long id) {
        ordenTrabajoRepository.deleteById(id);
    }
}


