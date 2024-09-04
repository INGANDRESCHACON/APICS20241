package Construccion.Apirest.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ProveedorDTO {
    private long id;
    private String idproveedor;
    private int dv;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;
    private boolean activo;


}
