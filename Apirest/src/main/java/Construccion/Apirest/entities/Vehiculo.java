package Construccion.Apirest.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="vehiculo")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull

    @Column(name = "Placa", nullable = false)
    private String idvehiculo;


    @NotNull
    @Column(nullable = false)
    private String marca;

    @NotNull
    @Column(nullable = false)
    private String linea;

    @NotNull
    @Column(nullable = false)
    private String modelo;

    @NotNull
    @Column(nullable = false)
    private String centrocosto;

    @NotNull
    @Column(nullable = false)
    private int odometro;

    @NotNull
    @Column(nullable = false)
    private String combustible;


    @NotNull
    @Column(nullable = false)
    private boolean activo;


    @OneToMany(mappedBy = "vehiculo", cascade =CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    @JsonIgnore
    private List<OrdenTrabajo> ordenTrabajolist= new ArrayList<>();



}