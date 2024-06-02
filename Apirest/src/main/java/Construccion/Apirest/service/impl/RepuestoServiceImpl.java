package Construccion.Apirest.service.impl;
import Construccion.Apirest.entities.Repuesto;
import Construccion.Apirest.persistence.IRepuestoDAO;
import Construccion.Apirest.service.IRepuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


    @Service
    public class RepuestoServiceImpl implements IRepuestoService {

        @Autowired
        private IRepuestoDAO RepuestoDAO;


        @Override
        public List<Repuesto> findAll() {
            return RepuestoDAO.findAll();
        }

        @Override
        public Optional<Repuesto> findById(Long id) {
            return RepuestoDAO.findById(id);
        }


        @Override
        public void save(Repuesto repuesto) {
            RepuestoDAO.save(repuesto);
        }

        @Override
        public void deleteByid(Long id) {
            RepuestoDAO.deleteByid(id);
        }
    }






