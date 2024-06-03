package Construccion.Apirest.controller;

import Construccion.Apirest.controller.dto.RepuestoDTO;
import Construccion.Apirest.entities.Repuesto;
import Construccion.Apirest.service.IRepuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/repuesto")
public class RepuestoController {

    @Autowired
    private IRepuestoService repuestoService;

    @GetMapping("/obtenerid/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Repuesto> repuestoOptional = repuestoService.findById(id);

        if (repuestoOptional.isPresent()) {
            Repuesto repuesto = repuestoOptional.get();
            RepuestoDTO repuestoDTO = RepuestoDTO.builder()
                    .id(repuesto.getId())
                    .idrepuesto(repuesto.getIdrepuesto())
                    .nombre(repuesto.getNombre())
                    .unidad(repuesto.getUnidad())
                    .referencia(repuesto.getReferencia())
                    .cuentacontable(repuesto.getCuentacontable())
                    .activo(repuesto.isActivo())
                    // Omitir la lista trabajoRepuestoList por ahora (relación uno a muchos)
                    .build();

            return ResponseEntity.ok(repuestoDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/obtenertodo")
    public ResponseEntity<?> findAll() {
        List<RepuestoDTO> repuestoList = repuestoService.findAll()
                .stream()
                .map(repuesto -> RepuestoDTO.builder()
                        .id(repuesto.getId())
                        .idrepuesto(repuesto.getIdrepuesto())
                        .nombre(repuesto.getNombre())
                        .unidad(repuesto.getUnidad())
                        .referencia(repuesto.getReferencia())
                        .cuentacontable(repuesto.getCuentacontable())
                        .activo(repuesto.isActivo())
                        //.Trabajo(trabajo.gettrabajo())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(repuestoList);
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> save(@RequestBody RepuestoDTO repuestoDTO) throws URISyntaxException {

        if (repuestoDTO.getIdrepuesto().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        Repuesto repuesto = Repuesto.builder()
                .idrepuesto(repuestoDTO.getIdrepuesto())
                .nombre(repuestoDTO.getNombre())
                .unidad(repuestoDTO.getUnidad())
                .referencia(repuestoDTO.getReferencia())
                .cuentacontable(repuestoDTO.getCuentacontable())
                .activo(repuestoDTO.isActivo())

                .build();

        repuestoService.save(repuesto);

        return ResponseEntity.created(new URI("/api/repuesto/guardar")).body("Repuesto guardado");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateRepuesto(@PathVariable Long id, @RequestBody RepuestoDTO repuestoDTO) {
        Optional<Repuesto> repuestoOptional = repuestoService.findById(id);

        if (repuestoOptional.isPresent()) {
            Repuesto repuesto = repuestoOptional.get();
            repuesto.setIdrepuesto(repuestoDTO.getIdrepuesto());
            repuesto.setNombre(repuestoDTO.getNombre());
            repuesto.setUnidad(repuestoDTO.getUnidad());
            repuesto.setReferencia(repuestoDTO.getReferencia());
            repuesto.setCuentacontable(repuestoDTO.getCuentacontable());
            repuesto.setActivo(repuestoDTO.isActivo());

            repuestoService.save(repuesto);

            return ResponseEntity.ok("Registro actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {

        if (id != null) {
            repuestoService.deleteByid(id);
            return ResponseEntity.ok("Registro eliminado");

        }
        return ResponseEntity.notFound().build();
    }


}