package Construccion.Apirest.controller;

import Construccion.Apirest.controller.dto.OrdenTrabajoDTO;
import Construccion.Apirest.entities.OrdenTrabajo;
import Construccion.Apirest.entities.Vehiculo;
import Construccion.Apirest.service.IOrdenTrabajoService;
import Construccion.Apirest.service.impl.OrdenTrabajoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ordentrabajo")
public class OrdenTrabajoController {



    @Autowired
    private IOrdenTrabajoService ordenTrabajoService;
    @Autowired
    private OrdenTrabajoServiceImpl ordenTrabajoServiceImpl;

    @GetMapping("/obtenerid/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<OrdenTrabajo> ordenTrabajoOptional = ordenTrabajoService.findById(id);

        if (ordenTrabajoOptional.isPresent()) {
            OrdenTrabajo ordenTrabajo = ordenTrabajoOptional.get();
            OrdenTrabajoDTO ordenTrabajoDTO = OrdenTrabajoDTO.builder()
                    .orden_id(ordenTrabajo.getOrden_id())
                    .vehiculo(ordenTrabajo.getVehiculo()) // Assuming relationship exists

                    .fechaorden(ordenTrabajo.getFechaorden())
                    .fechacierre(ordenTrabajo.getFechacierre())
                    .proveedor(ordenTrabajo.getProveedor()) // Assuming relationship exists
                    .odometrot(ordenTrabajo.getOdometrot())
                    .persona(ordenTrabajo.getPersona()) // Assuming relationship exists
                    .activo(ordenTrabajo.isActivo())
                    .trabajolist(ordenTrabajo.getTrabajolist()) // Assuming relationship exists
                    .build();

            return ResponseEntity.ok(ordenTrabajoDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/obtenertodo")
    public ResponseEntity<?> findAll() {
        List<OrdenTrabajoDTO> ordenTrabajoList = ordenTrabajoService.findAll()
                .stream()
                .map(ordenTrabajo -> OrdenTrabajoDTO.builder()
                        .orden_id(ordenTrabajo.getOrden_id())
                        .vehiculo(ordenTrabajo.getVehiculo()) // Assuming relationship exists

                        .fechaorden(ordenTrabajo.getFechaorden())
                        .fechacierre(ordenTrabajo.getFechacierre())
                        .proveedor(ordenTrabajo.getProveedor()) // Assuming relationship exists
                        .odometrot(ordenTrabajo.getOdometrot())
                        .persona(ordenTrabajo.getPersona()) // Assuming relationship exists
                        .activo(ordenTrabajo.isActivo())
                        .trabajolist(ordenTrabajo.getTrabajolist()) // Assuming relationship exists
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(ordenTrabajoList);
    }






     @PostMapping("/abrirot")
    public ResponseEntity<?> save(@RequestBody OrdenTrabajoDTO ordenTrabajoDTO) throws URISyntaxException {

        if (ordenTrabajoDTO.getVehiculo() == null || ordenTrabajoDTO.getFechaorden() == null ||
                ordenTrabajoDTO.getFechacierre() == null || ordenTrabajoDTO.getProveedor() == null ||
                ordenTrabajoDTO.getOdometrot() <= 0 || ordenTrabajoDTO.getPersona() == null) {
            return ResponseEntity.badRequest().build();
        }
              // vehiculo.getOdometro()
        // Crear una instancia de OrdenTrabajo a partir de OrdenTrabajoDTO
        OrdenTrabajo ordenTrabajo = OrdenTrabajo.builder()
                .vehiculo(ordenTrabajoDTO.getVehiculo())
                .fechaorden(ordenTrabajoDTO.getFechaorden())
                .fechacierre(ordenTrabajoDTO.getFechacierre())
                .proveedor(ordenTrabajoDTO.getProveedor())
                .odometrot(ordenTrabajoDTO.getOdometrot())
                .persona(ordenTrabajoDTO.getPersona())
                .activo(ordenTrabajoDTO.isActivo())
                .trabajolist(ordenTrabajoDTO.getTrabajolist()) // Asignar la lista de trabajos desde el DTO
                .build();

        ordenTrabajoService.save(ordenTrabajo); // Guardar la orden de trabajo usando el servicio

        return ResponseEntity.created(new URI("/api/ordentrabajo/abrirot")).body("Orden de trabajo guardada");
    }




/*

    @PostMapping("/guardar")
    public ResponseEntity<?> save(@RequestBody OrdenTrabajoDTO ordenTrabajoDTO) throws URISyntaxException {

        if (ordenTrabajoDTO.getVehiculo() == null || ordenTrabajoDTO.getFechaorden() == null ||
                ordenTrabajoDTO.getFechacierre() == null || ordenTrabajoDTO.getProveedor() == null ||
                ordenTrabajoDTO.getOdometrot() == 0 || ordenTrabajoDTO.getPersona() == null) {
            return ResponseEntity.badRequest().build();
        }

        // Crear una instancia de OrdenTrabajo a partir de OrdenTrabajoDTO
        OrdenTrabajo ordenTrabajo = OrdenTrabajo.builder()
                .vehiculo(ordenTrabajoDTO.getVehiculo())

                .fechaorden(ordenTrabajoDTO.getFechaorden())
                .fechacierre(ordenTrabajoDTO.getFechacierre())
                .proveedor(ordenTrabajoDTO.getProveedor())
                .odometrot(ordenTrabajoDTO.getOdometrot())
                .persona(ordenTrabajoDTO.getPersona())
                .activo(ordenTrabajoDTO.isActivo())
                .trabajolist(ordenTrabajoDTO.getTrabajolist()) // Asignar la lista de trabajos desde el DTO
                .build();

        ordenTrabajoService.save(ordenTrabajo); // Guardar la orden de trabajo usando el servicio

        return ResponseEntity.created(new URI("/api/ordentrabajo/guardar")).body("Orden de trabajo guardada");
    }




    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateOrdenTrabajo(@PathVariable Long id, @RequestBody OrdenTrabajoDTO ordenTrabajoDTO) {
        Optional<OrdenTrabajo> ordenTrabajoOptional = ordenTrabajoService.findById(id);

        if (ordenTrabajoOptional.isPresent()) {
            OrdenTrabajo ordenTrabajo = ordenTrabajoOptional.get();
            ordenTrabajo.setVehiculo(ordenTrabajoDTO.getVehiculo()); // Assuming relationship exists
            ordenTrabajo.setFechaorden(ordenTrabajoDTO.getFechaorden());
            ordenTrabajo.setFechacierre(ordenTrabajoDTO.getFechacierre());
            ordenTrabajo.setProveedor(ordenTrabajoDTO.getProveedor()); // Assuming relationship exists
            ordenTrabajo.setOdometrot(ordenTrabajoDTO.getOdometrot());
            ordenTrabajo.setPersona(ordenTrabajoDTO.getPersona()); // Assuming relationship exists
            ordenTrabajo.setActivo(ordenTrabajoDTO.isActivo());
            // Update TrabajoList with proper logic (assuming relationships exist)

            ordenTrabajoService.save(ordenTrabajo);

            return ResponseEntity.ok("Orden de trabajo actualizada");
        }
        return ResponseEntity.notFound().build();
    }
*/



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {

        if (id != null) {
            ordenTrabajoService.deleteByid(id);
            return ResponseEntity.ok("Orden de trabajo eliminada");
        }

        return ResponseEntity.notFound().build();
    }






}