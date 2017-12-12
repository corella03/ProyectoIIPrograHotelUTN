/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.bo;
import java.util.ArrayList;
import proyectoiiprograhotelutn.dao.DetalleReservacionDAO;
import proyectoiiprograhotelutn.entities.DetalleReservacion;
import proyectoiiprograhotelutn.entities.MiError;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 11/12/2017
 **/
public class DetalleReservacionBO {
    DetalleReservacionDAO detalledao;
    public DetalleReservacionBO() {
        detalledao = new DetalleReservacionDAO();
    }
    public boolean registrarDetalleReservacion(DetalleReservacion detalle) {
        if (String.valueOf(detalle.getIdUsuario().getId()).isEmpty()) {
            throw new MiError("Se Requiere que ingrese el id del Usuario.");
        }
        if (String.valueOf(detalle.getIdHabitacion().getId()).isEmpty()) {
            throw new MiError("Se Requiere que ingrese el id de la habitación.");
        }
        if(detalle.getFechaReservacion() == null) {
            throw new MiError("Se Requiere que ingrese la contraseña del usuario.");
        }
        if(detalle.getFechaEntrada() == null) {
            throw new MiError("Se Requiere que ingrese la contraseña del usuario.");
        }
        if(detalle.getFechaSalida() == null) {
            throw new MiError("Se Requiere que ingrese la contraseña del usuario.");
        }
        
        if(detalle.getId() == 0) {
            return detalledao.insertarDetalle(detalle);
        } else {
            return detalledao.modificarDetalleReservacion(detalle);
        }
    }
    public ArrayList<DetalleReservacion> cargarDetalleReservacion(){
        return detalledao.cargarDetalleReservaciones();
    }
    public DetalleReservacion getDetalleReservacion(int id) {
        if (id <= 0) {
            throw new MiError("Favor seleccionar un cliente");
        }
        return detalledao.seleccionarPorId(id);
    }
}