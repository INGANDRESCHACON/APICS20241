package Construccion.Apirest.service.impl;
import Construccion.Apirest.entities.TrabajoRepuesto;
import Construccion.Apirest.persistence.ITrabajoRepuestoDAO;
import Construccion.Apirest.service.ITrabajoRepuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class TrabajoRepuestoServiceImpl implements ITrabajoRepuestoService {

    @Autowired
    private ITrabajoRepuestoDAO TrabajoRepuestoDAO;


    @Override
    public List<TrabajoRepuesto> findall() {

        return TrabajoRepuestoDAO.findall();
    }

    @Override
    public Optional<TrabajoRepuesto> findById(Long id) {

        return TrabajoRepuestoDAO.findById(id);
    }


    @Override
    public void save(TrabajoRepuesto trabajoRepuesto) {

        TrabajoRepuestoDAO.save(trabajoRepuesto);
    }

    @Override
    public void deleteByid(Long id) {

        TrabajoRepuestoDAO.deleteByid(id);
    }
}
