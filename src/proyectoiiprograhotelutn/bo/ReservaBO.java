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
    public ArrayList<Reserva> cargarReservaActivos(){
        return reservadao.cargarReservas(true);
    }
    public ArrayList<Reserva> cargarReserva(){
        return reservadao.cargarReservas(false);
    }
    public Reserva getReserva(int id) {
        if (id <= 0) {
            throw new MiError("Favor seleccionar un usuario");
        }
        return reservadao.seleccionarPorId(id);
    }
    public boolean elmininarReserva(Reserva usuario){
        return reservadao.eliminarReserva(usuario);
    }
}