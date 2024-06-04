package Construccion.Apirest.service.impl;
import Construccion.Apirest.entities.OrdenTrabajo;
import Construccion.Apirest.persistence.IOrdenTrabajoDAO;
import Construccion.Apirest.service.IOrdenTrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;







@Service
public class OrdenTrabajoServiceImpl implements IOrdenTrabajoService {

    @Autowired
    private IOrdenTrabajoDAO OrdenTrabajoDAO;


    @Override
    public List<OrdenTrabajo> findAll() {
        return OrdenTrabajoDAO.findAll();
    }

    @Override
    public Optional<OrdenTrabajo> findById(Long id) {
        return OrdenTrabajoDAO.findById(id);
    }


    @Override
    public void save(OrdenTrabajo ordenTrabajo) {
        OrdenTrabajoDAO.save(ordenTrabajo);
    }

    @Override
    public void deleteByid(Long id) {
        OrdenTrabajoDAO.deleteByid(id);
    }
}
