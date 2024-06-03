package Construccion.Apirest.controller;
import Construccion.Apirest.controller.dto.VehiculoDTO;
import Construccion.Apirest.entities.Vehiculo;
import Construccion.Apirest.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/vehiculo")
public class VehiculoController {
    @Autowired
    private IVehiculoService vehiculoService;

    @GetMapping("/obtenerid/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Vehiculo> vehiculoOptional = vehiculoService.findById(id);


        if (vehiculoOptional.isPresent()) {

            Vehiculo vehiculo = vehiculoOptional.get();
            VehiculoDTO vehiculoDTO = VehiculoDTO.builder()
                    .id(vehiculo.getId())
                    .idvehiculo(vehiculo.getIdvehiculo())
                    .marca(vehiculo.getMarca())
                    .linea(vehiculo.getLinea())
                    .modelo(vehiculo.getModelo())
                    .centrocosto(vehiculo.getCentrocosto())
                    .odometro(vehiculo.getOdometro())
                    .combustible(vehiculo.getCombustible())
                    .activo(vehiculo.isActivo()) // Añadir el campo activo
                    .build();

            return ResponseEntity.ok(vehiculoDTO);


        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/obtenertodo")
    public ResponseEntity<?> findAll() {


        List<VehiculoDTO> vehiculoList = vehiculoService.findAll()
                .stream()
                .map(vehiculo -> VehiculoDTO.builder()
                        .id(vehiculo.getId())
                        .idvehiculo(vehiculo.getIdvehiculo())
                        .marca(vehiculo.getMarca())
                        .linea(vehiculo.getLinea())
                        .modelo(vehiculo.getModelo())
                        .centrocosto(vehiculo.getCentrocosto())
                        .odometro(vehiculo.getOdometro())
                        .combustible(vehiculo.getCombustible())
                        .activo(vehiculo.isActivo()) // Añadir el campo activo
                        .build())
                .collect(Collectors.toList());//=toList()
        return ResponseEntity.ok(vehiculoList);
    }


   @PostMapping("/guardar")
    public ResponseEntity<?> save(@RequestBody VehiculoDTO vehiculoDTO) throws URISyntaxException {

        if (vehiculoDTO.getIdvehiculo().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        {

            Vehiculo vehiculo = (Vehiculo.builder()
                    .idvehiculo(vehiculoDTO.getIdvehiculo())
                    .marca(vehiculoDTO.getMarca())
                    .linea(vehiculoDTO.getLinea())
                    .modelo(vehiculoDTO.getModelo())
                    .centrocosto(vehiculoDTO.getCentrocosto())
                    .odometro(vehiculoDTO.getOdometro())
                    .combustible(vehiculoDTO.getCombustible())
                    .activo(vehiculoDTO.isActivo())
                    .build());
                    vehiculoService.save(vehiculo);

        }

      // return ResponseEntity.created(new URI("/api/maker/save")).build();
       return ResponseEntity.created(new URI("/api/maker/guardar")).body("Vehículo guardado");
    }


  @PutMapping("/update/{id}")
    public ResponseEntity<?> updateVehiculo(@PathVariable Long id, @RequestBody VehiculoDTO vehiculoDTO) {
        Optional<Vehiculo> vehiculoOptional = vehiculoService.findById(id);

// isEmpty() hace lo mismo inverso
        if (vehiculoOptional.isPresent()) {

        Vehiculo vehiculo = vehiculoOptional.get();
        vehiculo.setIdvehiculo(vehiculoDTO.getIdvehiculo());
        vehiculo.setMarca(vehiculoDTO.getMarca());
        vehiculo.setLinea(vehiculoDTO.getLinea());
        vehiculo.setModelo(vehiculoDTO.getModelo());
        vehiculo.setCentrocosto(vehiculoDTO.getCentrocosto());
        vehiculo.setOdometro(vehiculoDTO.getOdometro());
        vehiculo.setCombustible(vehiculoDTO.getCombustible());
        vehiculo.setActivo(vehiculoDTO.isActivo());
        vehiculoService.save(vehiculo);

        return ResponseEntity.ok("Registro actualizado");
    }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {


        if (id != null) {
            
            vehiculoService.deleteByid(id);
            return ResponseEntity.ok("Registro eliminado");
        } 
            
            return ResponseEntity.notFound().build();
        
    }































































}


































