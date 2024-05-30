package Construccion.Apirest.controller.dto;
import Construccion.Apirest.entities.Persona;
import Construccion.Apirest.entities.Proveedor;
import Construccion.Apirest.entities.Vehiculo;
import java.time.LocalDate;
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
    private int odometro;
    private Persona persona;
    private boolean activo;




}
