package Construccion.Apirest.controller.dto;
import Construccion.Apirest.entities.OrdenTrabajo;
import Construccion.Apirest.entities.TrabajoRepuesto;
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

public class TrabajoDTO {
    private long id;
    private String idtrabajo;
    private String nombre;
    private String tipomantenimiento;
    private int periodicidad;
    private String cuentacontable;
    private boolean activo;
    private OrdenTrabajo ordentrabajo;
    private List<TrabajoRepuesto> trabajoRepuestoList = new ArrayList<>();

}
