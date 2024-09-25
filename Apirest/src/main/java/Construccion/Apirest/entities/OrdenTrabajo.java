package Construccion.Apirest.entities;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

//@Data: Esta anotación es un atajo para generar automáticamente los getters, setters, toString(), equals(), y hashCode() métodos. Es muy útil para reducir el código repetitivo.


@Setter
@Getter
//@Builder crear instancias de una clase de una manera fluida y legible. Es particularmente útil para clases con muchos parámetros en su constructor.
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ordentrabajo")
//@JsonIgnoreProperties(value = {"vehiculo", "fechaorden", "fechacierre", "odometrot", "proveedor", "persona", "estado", "trabajolist"})
public class OrdenTrabajo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long orden_id;

    @ManyToOne()
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;



    @ManyToOne()
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;


    @ManyToOne()
    @JoinColumn(name = "persona_id")
    @JsonIgnore // Evitar serializar la Orden de Trabajo junto con el Trabajo
    private Persona persona;




    @NotNull
    @Column(nullable = false)
    private LocalDate fechaorden;

    @NotNull
    @Column(nullable = false)
    private LocalDate fechacierre;




    @NotNull
  @JsonIgnore // Evitar serializar la Orden de Trabajo junto con el Trabajo
    private int odometrot=0;



    private boolean estado;



    //orphan si elimino ot elimino de una los trabajos y si es false no los borra
    @OneToMany(mappedBy = "ordentrabajo",cascade =CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Trabajo> trabajolist =new ArrayList<>();


    public int getOdometro() {
        return odometrot;
    }





























}
