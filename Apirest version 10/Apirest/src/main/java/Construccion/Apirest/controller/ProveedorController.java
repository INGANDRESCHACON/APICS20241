package Construccion.Apirest.controller;
import Construccion.Apirest.controller.dto.ProveedorDTO;
import Construccion.Apirest.entities.Proveedor;
import Construccion.Apirest.service.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/proveedor")
public class ProveedorController {

    @Autowired
    private IProveedorService proveedorService;

    @GetMapping("/obtenerid/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Proveedor> proveedorOptional = proveedorService.findById(id);

        if (proveedorOptional.isPresent()) {
            Proveedor proveedor = proveedorOptional.get();
            ProveedorDTO proveedorDTO = ProveedorDTO.builder()
                    .id(proveedor.getId())
                    .idproveedor(proveedor.getIdproveedor())
                    .dv(proveedor.getDv())
                    .nombre(proveedor.getNombre())
                    .direccion(proveedor.getDireccion())
                    .telefono(proveedor.getTelefono())
                    .correo(proveedor.getCorreo())
                    .activo(proveedor.isActivo())
                    .build();

            return ResponseEntity.ok(proveedorDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/obtenertodo")
    public ResponseEntity<?> findAll() {
        List<ProveedorDTO> proveedorList = proveedorService.findAll()
                .stream()
                .map(proveedor -> ProveedorDTO.builder()
                        .id(proveedor.getId())
                        .idproveedor(proveedor.getIdproveedor())
                        .dv(proveedor.getDv())
                        .nombre(proveedor.getNombre())
                        .direccion(proveedor.getDireccion())
                        .telefono(proveedor.getTelefono())
                        .correo(proveedor.getCorreo())
                        .activo(proveedor.isActivo())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(proveedorList);
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> save(@RequestBody ProveedorDTO proveedorDTO) throws URISyntaxException {

        if (proveedorDTO.getIdproveedor().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        Proveedor proveedor = Proveedor.builder()
                .idproveedor(proveedorDTO.getIdproveedor())
                .dv(proveedorDTO.getDv())
                .nombre(proveedorDTO.getNombre())
                .direccion(proveedorDTO.getDireccion())
                .telefono(proveedorDTO.getTelefono())
                .correo(proveedorDTO.getCorreo())
                .activo(proveedorDTO.isActivo())
                .build();

        proveedorService.save(proveedor);

        return ResponseEntity.created(new URI("/api/proveedor/guardar")).body("Proveedor guardado");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProveedor(@PathVariable Long id, @RequestBody ProveedorDTO proveedorDTO) {
        Optional<Proveedor> proveedorOptional = proveedorService.findById(id);

        if (proveedorOptional.isPresent()) {
            Proveedor proveedor = proveedorOptional.get();
            proveedor.setIdproveedor(proveedorDTO.getIdproveedor());
            proveedor.setDv(proveedorDTO.getDv());
            proveedor.setNombre(proveedorDTO.getNombre());
            proveedor.setDireccion(proveedorDTO.getDireccion());
            proveedor.setTelefono(proveedorDTO.getTelefono());
            proveedor.setCorreo(proveedorDTO.getCorreo());
            proveedor.setActivo(proveedorDTO.isActivo());

            proveedorService.save(proveedor);

            return ResponseEntity.ok("Registro actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {

        if (id != null) {
            proveedorService.deleteByid(id);
            return ResponseEntity.ok("Registro eliminado");
        }

        return ResponseEntity.notFound().build();
    }
}
