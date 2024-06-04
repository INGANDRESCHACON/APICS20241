package Construccion.Apirest.service;

import Construccion.Apirest.entities.OrdenTrabajo;
import Construccion.Apirest.persistence.IOrdenTrabajoDAO;
import Construccion.Apirest.service.impl.EmailServiceImpl;
import Construccion.Apirest.service.impl.OrdenTrabajoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrdenTrabajoServiceImplTest {

    @Mock
    private IOrdenTrabajoDAO ordenTrabajoDAO;

    @Mock
    private IVehiculoService vehiculoService;

    @Mock
    private EmailServiceImpl emailService;

    @InjectMocks
    private OrdenTrabajoServiceImpl ordenTrabajoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void save_InvalidOrder_Trabajo() {
        OrdenTrabajo ordenTrabajo = new OrdenTrabajo();
        ordenTrabajo.setFechaorden(LocalDate.now().plusDays(1)); // Fecha de orden en el futuro
        ordenTrabajo.setFechacierre(LocalDate.now()); // Fecha de cierre en el presente

        // Mock de comportamiento para vehiculoService.verificarVehiculoActivo
        when(vehiculoService.verificarVehiculoActivo(anyLong())).thenReturn(true);

        // Mock de comportamiento para vehiculoService.validarOdometro
        when(vehiculoService.validarOdometro(anyInt(), anyLong())).thenReturn(true);

        assertThrows(IllegalArgumentException.class, () -> ordenTrabajoService.save(ordenTrabajo));
        verify(ordenTrabajoDAO, never()).save(ordenTrabajo);
        verify(vehiculoService, never()).actualizarOdometroVehiculo(anyLong(), anyInt());
        verify(emailService, never()).sendEmail(anyString(), anyString(), anyString());
    }
}
