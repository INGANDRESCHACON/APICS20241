package Construccion.Apirest.persistence.impl;
import Construccion.Apirest.entities.Persona;
import Construccion.Apirest.persistence.IPersonaDAO;
import Construccion.Apirest.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class PersonaDAOimpl implements IPersonaDAO {


    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<Persona> findAll() {
        return (List<Persona>) personaRepository.findAll();
    }

    @Override
    public Optional<Persona> findById(Long id) {
        return personaRepository.findById(id);
    }

    @Override
    public void save(Persona persona) {

        personaRepository.save(persona);

    }

    @Override
    public void deleteByid(Long id) {
        personaRepository.deleteById(id);
    }
}

