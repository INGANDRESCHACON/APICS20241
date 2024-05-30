package Construccion.Apirest.service.impl;
import Construccion.Apirest.entities.Persona;
import Construccion.Apirest.persistence.IPersonaDAO;
import Construccion.Apirest.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    private IPersonaDAO PersonaDAO;


    @Override
    public List<Persona> findAll() {
        return PersonaDAO.findAll();
    }

    @Override
    public Optional<Persona> findById(Long id) {
        return PersonaDAO.findById(id);
    }


    @Override
    public void save(Persona persona) {
        PersonaDAO.save(persona);
    }

    @Override
    public void deleteByid(Long id) {
        PersonaDAO.deleteByid(id);
    }
}


