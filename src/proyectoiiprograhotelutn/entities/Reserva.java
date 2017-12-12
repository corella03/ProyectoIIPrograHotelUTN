/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.entities;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 10/12/2017
 **/
public class Reserva {
    private int id;
    private DetalleReservacion idDetalleReservacion;
    private boolean activo;
    public Reserva() {
    }
    public Reserva(int id, DetalleReservacion idDetalleReservacion, boolean activo) {
        this.id = id;
        this.idDetalleReservacion = idDetalleReservacion;
        this.activo = activo;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public DetalleReservacion getIdDetalleReservacion() {
        return idDetalleReservacion;
    }
    public void setIdDetalleReservacion(DetalleReservacion idDetalleReservacion) {
        this.idDetalleReservacion = idDetalleReservacion;
    }
    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}