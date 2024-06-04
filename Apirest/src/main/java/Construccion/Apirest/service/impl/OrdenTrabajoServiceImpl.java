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
    private EmailServiceImpl emailService;

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
           // enviarCorreoOrdenTrabajo(ordenTrabajo);
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










    public void enviarCorreoOrdenTrabajo(OrdenTrabajo ordenTrabajo) {


        String to = "mantenimiento@transportesayb.com";
        String subject = "Nueva Orden de Trabajo Creada: # " + ordenTrabajo.getOrden_id();
        String text = generarContenidoCorreo(ordenTrabajo);

        emailService.sendEmail(to, subject, text);
    }




    private String generarContenidoCorreo(OrdenTrabajo ordenTrabajo) {
        StringBuilder body = new StringBuilder();
        body.append("*****************Detalles de la Orden de Trabajo: # ").append(ordenTrabajo.getOrden_id()).append("");
        body.append("*************\n\n");
        body.append("Vehículo ID: ").append(ordenTrabajo.getVehiculo().getId()).append("\n");
        body.append("Fecha de Orden: ").append(ordenTrabajo.getFechaorden()).append("\n");
        body.append("Fecha de Cierre: ").append(ordenTrabajo.getFechacierre()).append("\n");
        body.append("Proveedor ID: ").append(ordenTrabajo.getProveedor().getId()).append("\n");
        body.append("Odómetro: ").append(ordenTrabajo.getOdometrot()).append("\n");
        body.append("Persona ID: ").append(ordenTrabajo.getPersona().getId()).append("\n\n");
       // body.append("Activo: ").append(ordenTrabajo.isActivo()).append("\n");
        body.append("*****************GRACIAS POR CONFIAR EN NOSOTROS************ \n\n");
        return body.toString();

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


