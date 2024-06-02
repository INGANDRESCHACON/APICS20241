package Construccion.Apirest.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
//@Builder crear instancias de una clase de una manera fluida y legible. Es particularmente útil para clases con muchos parámetros en su constructor.
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="repuesto")
public class Repuesto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @NotNull
    @Column(name = "codigoR",nullable = false)
    private String idrepuesto;


    @NotNull
    @Column(nullable = false)
    private String nombre;

    @NotNull
    @Column(nullable = false)
    private String unidad;

    @NotNull
    @Column(nullable = false)
    private String referencia;

    @NotNull
    @Column(nullable = false)
    private String cuentacontable;


    private boolean activo;

    @OneToMany(mappedBy = "repuesto", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<TrabajoRepuesto> trabajoRepuestoList = new ArrayList<>();
}







