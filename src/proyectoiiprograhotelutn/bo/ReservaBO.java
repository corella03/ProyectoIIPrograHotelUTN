/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.bo;
import java.util.ArrayList;
import proyectoiiprograhotelutn.dao.ReservaDAO;
import proyectoiiprograhotelutn.entities.MiError;
import proyectoiiprograhotelutn.entities.Reserva;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 24/11/2017
 **/
public class ReservaBO {
    ReservaDAO reservadao;
    public ReservaBO() {
        reservadao = new ReservaDAO();
    }
    /**
     * Método para verificar datos de la reserva y enviarlo al registro de reservaDAO.
     * @param reserva Reserva que se va a verificar.
     * @return true si los datos estan correctos.
     */
    public boolean registrarReserva(Reserva reserva) {
        if(String.valueOf(reserva.getIdDetalleReservacion().getId()).isEmpty()) {
            throw new MiError("Se Requiere que ingrese el id del detalle de la reserva.");
        }
        if(reserva.getId() == 0) {
            return reservadao.insertarReserva(reserva);
        } else {
            return reservadao.modificarReserva(reserva);
        }
    }
    /**
     * Método para cargar las reservas que esten activas que vienen de la parte de DAO.
     * @return Reserva: la lista de las reservas activas.
     */
    public ArrayList<Reserva> cargarReservaActivos(){
        return reservadao.cargarReservas(true);
    }
    /**
     * Método para cargar las reservas que vienen de la parte de DAO.
     * @return Reserva: la lista de las reservas.
     */
    public ArrayList<Reserva> cargarReserva(){
        return reservadao.cargarReservas(false);
    }
    /**
     * Recibe id de la interfaz para buscar el reserva con dicho id.
     * @param id int id de la reserva a buscar.
     * @return Reserva encontrado.
     */
    public Reserva getReserva(int id) {
        if (id <= 0) {
            throw new MiError("Favor seleccionar un usuario");
        }
        return reservadao.seleccionarPorId(id);
    }
    /**
     * Método para "eliminar" (desactiva) las reservas que estan en la parte de DAO.
     * @param reserva Reserva se desea elimininar.
     * @return Reserva desactivado.
     */
    public boolean elmininarReserva(Reserva reserva){
        return reservadao.eliminarReserva(reserva);
    }
}