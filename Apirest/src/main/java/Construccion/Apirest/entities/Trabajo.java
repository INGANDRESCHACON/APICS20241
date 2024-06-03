package Construccion.Apirest.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String codigo;

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
    @JoinColumn(name = "id_ordendetrabajo")
    @JsonIgnore // Evitar serializar la Orden de Trabajo junto con el Trabajo
    private OrdenTrabajo ordentrabajo;






    //orphan si elimino ot elimino de una los trabajos y si es false no los borra
    @OneToMany(mappedBy = "trabajo",cascade =CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)

    private List<Repuesto> repuestoslist = new ArrayList<>();





}
