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
    /**
     * Método para verificar datos de detalle de reservacion y enviarlo al registro de detalleReservaDAO.
     * @param detalle DetalleReservacion que se va a verificar.
     * @return true si los datos estan correctos.
     */
    public boolean registrarDetalleReservacion(DetalleReservacion detalle) {
        if (String.valueOf(detalle.getIdUsuario().getId()).isEmpty()) {
            throw new MiError("Se Requiere que ingrese el id del Usuario.");
        }
        if (String.valueOf(detalle.getIdHabitacion().getId()).isEmpty()) {
            throw new MiError("Se Requiere que ingrese el id de la habitación.");
        }
        
        if(detalle.getFechaEntrada().isEmpty()) {
            throw new MiError("Se Requiere que ingrese la fecha de entrada.");
        }
        if(detalle.getFechaSalida().isEmpty()){
            throw new MiError("Se Requiere que ingrese la fecha de salida.");
        }
        if(detalle.getId() == 0) {
            return detalledao.insertarDetalle(detalle);
        } else {
            return detalledao.modificarDetalleReservacion(detalle);
        }
    }
    /**
     * Método para cargar los detalle de reservacion que vienen de la parte de DAO.
     * @return DetalleReservacio: la lista de los detalles de reservacion.
     */
    public ArrayList<DetalleReservacion> cargarDetalleReservacion(){
        return detalledao.cargarDetalleReservaciones();
    }
    /**
     * Recibe id de la interfaz para buscar el DetalleReservacion con dicho id.
     * @param id int id del DetalleReservacion a buscar.
     * @return DetalleReservacion encontrado.
     */
    public DetalleReservacion getDetalleReservacion(int id) {
        if (id <= 0) {
            throw new MiError("Favor seleccionar un cliente");
        }
        return detalledao.seleccionarPorId(id);
    }
}