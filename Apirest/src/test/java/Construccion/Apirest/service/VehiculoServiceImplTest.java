package Construccion.Apirest.service;

import Construccion.Apirest.entities.Vehiculo;
import Construccion.Apirest.repository.VehiculoRepository;
import Construccion.Apirest.service.impl.VehiculoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class VehiculoServiceImplTest {

    @Mock
    private VehiculoRepository vehiculoRepository;

    @InjectMocks
    private VehiculoServiceImpl vehiculoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void validarOdometro_When_ValidOdometro_ReturnsTrue() {
        // Arrange
        int nuevoOdometro = 100;
        Long vehiculoId = 1L;
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setOdometro(50); // Odómetro actual
        when(vehiculoRepository.findById(vehiculoId)).thenReturn(Optional.of(vehiculo));

        // Act
        boolean result = vehiculoService.validarOdometro(nuevoOdometro, vehiculoId);

        // Assert
        assertTrue(result);
    }

    @Test
    void validarOdometro_When_InvalidOdometro_ReturnsFalse() {
        // Arrange
        int nuevoOdometro = 50;
        Long vehiculoId = 1L;
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setOdometro(100); // Odómetro actual
        when(vehiculoRepository.findById(vehiculoId)).thenReturn(Optional.of(vehiculo));

        // Act
        boolean result = vehiculoService.validarOdometro(nuevoOdometro, vehiculoId);

        // Assert
        assertFalse(result);
    }

    // Aquí podrías agregar más pruebas para los otros métodos como actualizarOdometroVehiculo y verificarVehiculoActivo si lo necesitas
}
