/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.entities;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 24/11/2017
 **/
public class TipoHabitacion {
    private String id;
    private String descripcion;
    private int precio;

    public TipoHabitacion() {
    }
    public TipoHabitacion(String id, String descripcion, int precio) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    @Override
    public String toString() {
        return "Tipo Habitacion: " + "\nId: " + id + "\nDescripción: " + descripcion + "\nPrecio:" + precio;
    }
}