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
    private int id;
    private String codigo;
    private String descripcion;
    private int precio;
    private boolean activo;
    public TipoHabitacion() {
    }
    public TipoHabitacion(int id, String codigo, String descripcion, int precio, boolean activo) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.activo = activo;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    /**
     * Método toString de la clase TipoHabitacion
     * @return String codigo, int precio
     */
    @Override
    public String toString() {
        return "Código: " + codigo + " ₡ " + precio;
    }
}