package Construccion.Apirest.controller.dto;
import Construccion.Apirest.entities.OrdenTrabajo;

import java.util.ArrayList;
import java.util.List;

import Construccion.Apirest.entities.Repuesto;
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
    private String codigo;
    private String nombre;
    private String tipomantenimiento;
    private int periodicidad;
    private String cuentacontable;
    private boolean activo;
    private OrdenTrabajo ordentrabajo;

  private List<Repuesto> repuestolist =new ArrayList<>();

}
