package Construccion.Apirest.entities;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.*;
import lombok.*;
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
    private String combustible;


    @NotNull
    @Column(nullable = false)
    private boolean activo;

}