package Construccion.Apirest.controller;
import Construccion.Apirest.controller.dto.RepuestoDTO;
import Construccion.Apirest.controller.dto.TrabajoDTO;
import Construccion.Apirest.entities.Repuesto;
import Construccion.Apirest.entities.Trabajo;
import Construccion.Apirest.service.ITrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

    @RestController
    @RequestMapping("/api/trabajo")
    public class TrabajoController {

        @Autowired
        private ITrabajoService trabajoService;
 @GetMapping("/obtenerid/{id}")
        public ResponseEntity<?> findById(@PathVariable Long id) {
            Optional<Trabajo> trabajoOptional = trabajoService.findById(id);

            if (trabajoOptional.isPresent()) {
                Trabajo trabajo = trabajoOptional.get();
                TrabajoDTO trabajoDTO = TrabajoDTO.builder()
                        .id(trabajo.getId())
                        .codigo(trabajo.getCodigo())
                        .nombre(trabajo.getNombre())
                        .tipomantenimiento(trabajo.getTipomantenimiento())
                        .periodicidad(trabajo.getPeriodicidad())
                        .cuentacontable(trabajo.getCuentacontable())
                        .activo(trabajo.isActivo())
                       //.ordentrabajo(trabajo.getOrdentrabajo()) // Assuming relationship exists


                        .build();

                return ResponseEntity.ok(trabajoDTO);
            }
            return ResponseEntity.notFound().build();
        }

        @GetMapping("/obtenertodo")
        public ResponseEntity<?> findAll() {
            List<TrabajoDTO> trabajoList = trabajoService.findAll()
                    .stream()
                    .map(trabajo -> TrabajoDTO.builder()
                            .id(trabajo.getId())
                            .codigo(trabajo.getCodigo())
                            .nombre(trabajo.getNombre())
                            .tipomantenimiento(trabajo.getTipomantenimiento())
                            .periodicidad(trabajo.getPeriodicidad())
                            .cuentacontable(trabajo.getCuentacontable())
                            .activo(trabajo.isActivo())

                           //.ordentrabajo(trabajo.getOrdentrabajo())

                            .build())
                    .collect(Collectors.toList());

            return ResponseEntity.ok(trabajoList);
        }

        @PostMapping("/guardar")
        public ResponseEntity<?> save(@RequestBody TrabajoDTO trabajoDTO) throws URISyntaxException {

            if (trabajoDTO.getCodigo().isBlank()) {
                return ResponseEntity.badRequest().build();
            }

            Trabajo trabajo = Trabajo.builder()
                    .codigo(trabajoDTO.getCodigo())
                    .nombre(trabajoDTO.getNombre())
                    .tipomantenimiento(trabajoDTO.getTipomantenimiento())
                    .periodicidad(trabajoDTO.getPeriodicidad())
                    .cuentacontable(trabajoDTO.getCuentacontable())
                    .activo(trabajoDTO.isActivo())
                    // Set OrdenTrabajo and TrabajoRepuestoList with proper logic (assuming relationships exist)
                    .build();

            trabajoService.save(trabajo);

            return ResponseEntity.created(new URI("/api/trabajo/guardar")).body("Trabajo guardado");
        }

        @PutMapping("/update/{id}")
        public ResponseEntity<?> updateTrabajo(@PathVariable Long id, @RequestBody TrabajoDTO trabajoDTO) {
            Optional<Trabajo> trabajoOptional = trabajoService.findById(id);

            if (trabajoOptional.isPresent()) {
                Trabajo trabajo = trabajoOptional.get();
                trabajo.setCodigo(trabajoDTO.getCodigo());
                trabajo.setNombre(trabajoDTO.getNombre());
                trabajo.setTipomantenimiento(trabajoDTO.getTipomantenimiento());
                trabajo.setPeriodicidad(trabajoDTO.getPeriodicidad());
                trabajo.setCuentacontable(trabajoDTO.getCuentacontable());
                trabajo.setActivo(trabajoDTO.isActivo());
                // Update OrdenTrabajo and TrabajoRepuestoList with proper logic (assuming relationships exist)

                trabajoService.save(trabajo);

                return ResponseEntity.ok("Registro actualizado");
            }
            return ResponseEntity.notFound().build();
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deleteById(@PathVariable Long id) {

            if (id != null) {
                trabajoService.deleteByid(id);
                return ResponseEntity.ok("Registro eliminado");

            }
            return ResponseEntity.notFound().build();
        }


    }