/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.entities;
import java.awt.Image;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 09/12/2017
 **/
public class Habitacion {
    private int id;
    private String codigo;
    private TipoHabitacion idTipoHabitacion;
    private Image imagen;
    private String descripcion;
    private boolean estado;
    private int cantPersonas;
    public Habitacion() {
    }

    public Habitacion(int id, String codigo, TipoHabitacion idTipoHabitacion, 
            Image imagen, String descripcion, boolean estado, int cantPersonas) {
        this.id = id;
        this.codigo = codigo;
        this.idTipoHabitacion = idTipoHabitacion;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.estado = estado;
        this.cantPersonas = cantPersonas;
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
    public TipoHabitacion getIdTipoHabitacion() {
        return idTipoHabitacion;
    }
    public void setIdTipoHabitacion(TipoHabitacion idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }
    public Image getImagen() {
        return imagen;
    }
    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public int getCantPersonas() {
        return cantPersonas;
    }
    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }
    @Override
    public String toString() {
        return "Habitacion: " + codigo;
    }
}