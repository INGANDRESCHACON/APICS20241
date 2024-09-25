package Construccion.Apirest.repository;

import Construccion.Apirest.entities.OrdenTrabajo;
import Construccion.Apirest.entities.Persona;
import Construccion.Apirest.entities.Proveedor;
import Construccion.Apirest.entities.Vehiculo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository


public interface OrdenTrabajoRepository extends CrudRepository<OrdenTrabajo,Long> {

    @Query(value = "SELECT * FROM ordentrabajo WHERE vehiculo_id = :vehiculoId " +
            "AND proveedor_id = :proveedorId AND persona_id = :personaId " +
            "AND estado = :estado",
            nativeQuery = true)
    List<OrdenTrabajo> findAllByFiltros(@Param("vehiculoId") Long vehiculoId,
                                        @Param("proveedorId") Long proveedorId,
                                        @Param("personaId") Long personaId,
                                        @Param("estado") boolean estado);


}
