package Construccion.Apirest.controller.dto;
import Construccion.Apirest.entities.TrabajoRepuesto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor


public class RepuestoDTO{
    private long id;
    private String idrepuesto;
    private String nombre;
    private String unidad;
    private String referencia;
    private String cuentacontable;
    private boolean activo;
    private List<TrabajoRepuesto> trabajoRepuestoList = new ArrayList<>();



}





