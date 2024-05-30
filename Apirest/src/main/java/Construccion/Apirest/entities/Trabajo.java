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
@Table(name="trabajo")
public class Trabajo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "codigo",nullable = false)
    private String idtrabajo;

    @NotNull
    @Column(nullable = false)
    private String nombre;

    @NotNull
    @Column(name = "tipo",nullable = false)
    private String tipomantenimiento;


    @NotNull
    @Column(nullable = false)
    private int periodicidad;

    @NotNull
    @Column(nullable = false)
    private String cuentacontable;


    private boolean activo;

    @ManyToOne
    //nullable siempre la relacion
    @JoinColumn(name = "id_ordendetrabajo",nullable = false)
    private OrdenTrabajo ordentrabajo;

//LAZI SOLO CARGA LA LISTA CUANDO SE NECESITA
    //orphan si elimino trabajo elimino de una repuestos y si es false no los borra


    @OneToMany(mappedBy = "trabajo", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<TrabajoRepuesto> trabajoRepuestoList = new ArrayList<>();



}
