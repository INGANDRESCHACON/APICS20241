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
@Table(name="proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @NotNull
    @Column(nullable = false)
    private String idproveedor;

    @NotNull
    @Column(nullable = false)
    private int dv;

    @NotNull
    @Column(nullable = false)
    private String nombre;

    @NotNull
    @Column(nullable = false)
    private String direccion;

    @NotNull
    @Column(nullable = false)
    private String telefono;

    @NotNull
    @Column(nullable = false)
    private String correo;

    private boolean activo;


    @OneToMany(mappedBy = "proveedor", cascade =CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    @JsonIgnore
    private List<OrdenTrabajo> ordenTrabajolist= new ArrayList<>();






}
