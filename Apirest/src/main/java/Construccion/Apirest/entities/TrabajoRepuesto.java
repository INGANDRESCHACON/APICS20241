
package Construccion.Apirest.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "trabajo_repuesto")
@Data
public class TrabajoRepuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "trabajo_id")
    private Trabajo trabajo;

    @ManyToOne
    @JoinColumn(name = "repuesto_id")
    private Repuesto repuesto;

    // Constructor vacío y constructor con todos los campos
    public TrabajoRepuesto() {}

    public TrabajoRepuesto(Trabajo trabajo, Repuesto repuesto) {
        this.trabajo = trabajo;
        this.repuesto = repuesto;
    }
}
