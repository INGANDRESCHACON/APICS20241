package Construccion.Apirest.controller;
import Construccion.Apirest.controller.dto.PersonaDTO;
import Construccion.Apirest.entities.Persona;
import Construccion.Apirest.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/persona")
public class PersonaController {

    @Autowired
    private IPersonaService personaService;

    @GetMapping("/obtenerid/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Persona> personaOptional = personaService.findById(id);

        if (personaOptional.isPresent()) {
            Persona persona = personaOptional.get();
            PersonaDTO personaDTO = PersonaDTO.builder()
                    .id(persona.getId())
                    .idpersona(persona.getIdpersona())
                    .nombre(persona.getNombre())
                    .telefono(persona.getTelefono())
                    .correo(persona.getCorreo())
                    .direccion(persona.getDireccion())
                    .activo(persona.isActivo())
                    .build();

            return ResponseEntity.ok(personaDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/obtenertodo")
    public ResponseEntity<?> findAll() {
        List<PersonaDTO> personaList = personaService.findAll()
                .stream()
                .map(persona -> PersonaDTO.builder()
                        .id(persona.getId())
                        .idpersona(persona.getIdpersona())
                        .nombre(persona.getNombre())
                        .telefono(persona.getTelefono())
                        .correo(persona.getCorreo())
                        .direccion(persona.getDireccion())
                        .activo(persona.isActivo())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(personaList);
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> save(@RequestBody PersonaDTO personaDTO) throws URISyntaxException {

        if (personaDTO.getIdpersona().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        Persona persona = Persona.builder()
                .id(personaDTO.getId())
                .idpersona(personaDTO.getIdpersona())
                .nombre(personaDTO.getNombre())
                .telefono(personaDTO.getTelefono())
                .correo(personaDTO.getCorreo())
                .direccion(personaDTO.getDireccion())
                .activo(personaDTO.isActivo())
                .build();

        personaService.save(persona);

        return ResponseEntity.created(new URI("/api/persona/guardar")).body("Persona guardada");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePersona(@PathVariable Long id, @RequestBody PersonaDTO personaDTO) {
        Optional<Persona> personaOptional = personaService.findById(id);

        if (personaOptional.isPresent()) {
            Persona persona = personaOptional.get();
            persona.setIdpersona(personaDTO.getIdpersona());
            persona.setNombre(personaDTO.getNombre());
            persona.setTelefono(personaDTO.getTelefono());
            persona.setCorreo(personaDTO.getCorreo());
            persona.setDireccion(personaDTO.getDireccion());
            persona.setActivo(personaDTO.isActivo());

            personaService.save(persona);

            return ResponseEntity.ok("Registro actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {

        if (id != null) {
            personaService.deleteByid(id);
            return ResponseEntity.ok("Registro eliminado");
        }

        return ResponseEntity.notFound().build();
    }
}
