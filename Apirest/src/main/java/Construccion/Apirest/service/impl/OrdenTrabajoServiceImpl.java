package Construccion.Apirest.service.impl;

import Construccion.Apirest.entities.OrdenTrabajo;
import Construccion.Apirest.entities.Vehiculo;
import Construccion.Apirest.persistence.IOrdenTrabajoDAO;
import Construccion.Apirest.service.IOrdenTrabajoService;
import Construccion.Apirest.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class OrdenTrabajoServiceImpl implements IOrdenTrabajoService {
    @Autowired
    private IVehiculoService vehiculoService;

    @Autowired
    private IOrdenTrabajoDAO ordenTrabajoDAO;

    @Override
    public List<OrdenTrabajo> findAll() {
        return ordenTrabajoDAO.findAll();
    }

    @Override
    public Optional<OrdenTrabajo> findById(Long id) {
        return ordenTrabajoDAO.findById(id);
    }


    @Override
    public void deleteByid(Long id) {
        ordenTrabajoDAO.deleteByid(id);
    }


    @Override
    public void save(OrdenTrabajo ordenTrabajo) {
        if (validarOrdenTrabajo(ordenTrabajo)) {
            ordenTrabajoDAO.save(ordenTrabajo);
            vehiculoService.actualizarOdometroVehiculo(ordenTrabajo.getVehiculo().getId(), ordenTrabajo.getOdometro());
        } else {
            // Aquí podrías lanzar una excepción o manejar el error de otra manera
            throw new IllegalArgumentException("La orden de trabajo no es válida");
        }
    }


   //**************************METODOS NUEVOS****************************//




    // Método para validar una orden de trabajo antes de guardarla
    private boolean validarOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
        LocalDate fechaOrden = ordenTrabajo.getFechaorden();
        LocalDate fechaCierre = ordenTrabajo.getFechacierre();
        LocalDate fechaActual = LocalDate.now();
        Vehiculo vehiculo = ordenTrabajo.getVehiculo();


// Verificar si la fecha de la orden es futura o si la diferencia en días es mayor a 30 días en el pasado
        if (fechaOrden.isAfter(fechaActual) || ChronoUnit.DAYS.between(fechaOrden, fechaActual) > 30 ||
                ChronoUnit.DAYS.between(fechaOrden, fechaCierre) > 30 || fechaCierre.isBefore(fechaOrden)) {
            throw new IllegalArgumentException("La fecha de la orden no cumple con los criterios de validación");
        }


// Validar el odómetro de la orden de trabajo con el servicio de vehículos
// Obtener el id del vehículo de la orden de trabajo
        Long idVehiculo = ordenTrabajo.getVehiculo().getId();
        int nuevoOdometro = ordenTrabajo.getOdometrot();
        System.out.println("idvehiculo: " + ordenTrabajo.getVehiculo().getId());
        System.out.println("Odómetro vehiculo: " + ordenTrabajo.getOdometrot());

        if (!vehiculoService.validarOdometro(nuevoOdometro, idVehiculo)) {
            throw new IllegalArgumentException("El odómetro de la orden de trabajo debe ser mayor que el del vehículo asociado");
        }
        return true;
    }


}












































/*


package Construccion.Apirest.service.impl;
import Construccion.Apirest.entities.OrdenTrabajo;
import Construccion.Apirest.persistence.IOrdenTrabajoDAO;
import Construccion.Apirest.service.IOrdenTrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;



@Service
public class OrdenTrabajoServiceImpl implements IOrdenTrabajoService {

    @Autowired
    private IOrdenTrabajoDAO OrdenTrabajoDAO;


    @Override
    public List<OrdenTrabajo> findAll() {
        return OrdenTrabajoDAO.findAll();
    }

    @Override
    public Optional<OrdenTrabajo> findById(Long id) {
        return OrdenTrabajoDAO.findById(id);
    }


    @Override
    public void save(OrdenTrabajo ordenTrabajo) {
        OrdenTrabajoDAO.save(ordenTrabajo);
    }

    @Override
    public void deleteByid(Long id) {
        OrdenTrabajoDAO.deleteByid(id);
    }




    }

*/


