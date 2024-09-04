package Construccion.Apirest.service;

import Construccion.Apirest.entities.Proveedor;
import Construccion.Apirest.persistence.IProveedorDAO;
import Construccion.Apirest.service.impl.ProveedorServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import Construccion.Apirest.entities.Proveedor;
import Construccion.Apirest.persistence.IProveedorDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProveedorServiceImplTest {

    @Mock
    private IProveedorDAO proveedorDAO;

    @InjectMocks
    private ProveedorServiceImpl proveedorService;

    @Test
    void testFindAll() {
        // Arrange
        Proveedor proveedor1 = new Proveedor();
        proveedor1.setNombre("Proveedor 1");
        Proveedor proveedor2 = new Proveedor();
        proveedor2.setNombre("Proveedor 2");
        List<Proveedor> proveedores = Arrays.asList(proveedor1, proveedor2);
        when(proveedorDAO.findAll()).thenReturn(proveedores);

        // Act
        List<Proveedor> result = proveedorService.findAll();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Proveedor 1", result.get(0).getNombre());
        assertEquals("Proveedor 2", result.get(1).getNombre());
    }

    @Test
    void testFindById() {
        // Arrange
        Proveedor proveedor = new Proveedor();
        proveedor.setId(1L);
        when(proveedorDAO.findById(1L)).thenReturn(Optional.of(proveedor));

        // Act
        Optional<Proveedor> result = proveedorService.findById(1L);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
    }

    @Test
    void testSave() {
        // Arrange
        Proveedor proveedor = new Proveedor();
        proveedor.setNombre("Nuevo Proveedor");
        doNothing().when(proveedorDAO).save(proveedor);

        // Act
        proveedorService.save(proveedor);

        // Assert
        verify(proveedorDAO, times(1)).save(proveedor);
    }

    @Test
    void testDeleteById() {
        // Act
        proveedorService.deleteByid(1L);

        // Assert
        verify(proveedorDAO, times(1)).deleteByid(1L);
    }
}
