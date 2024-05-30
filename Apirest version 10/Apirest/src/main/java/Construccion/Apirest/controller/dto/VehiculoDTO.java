package Construccion.Apirest.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class VehiculoDTO {

    private long id;


    private String idvehiculo;



    private String marca;


    private String linea;


    private String modelo;


    private String centrocosto;


    private String combustible;



    private boolean activo;



}
