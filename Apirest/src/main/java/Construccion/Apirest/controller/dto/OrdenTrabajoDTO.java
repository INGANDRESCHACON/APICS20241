package Construccion.Apirest.controller.dto;
import Construccion.Apirest.entities.Persona;
import Construccion.Apirest.entities.Proveedor;
import Construccion.Apirest.entities.Trabajo;
import Construccion.Apirest.entities.Vehiculo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class OrdenTrabajoDTO {
    private long orden_id;
    private Vehiculo vehiculo;
    private LocalDate fechaorden;
    private LocalDate fechacierre;
    private Proveedor proveedor;
    private int odometrot;
    private Persona persona;
    private boolean activo;
 private List<Trabajo> trabajolist =new ArrayList<>();



}
