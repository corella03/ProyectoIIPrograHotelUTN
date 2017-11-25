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
public class AgenciaDeViajes {
    private String id;
    private String nombre;
    private int comision;
    public AgenciaDeViajes() {
    }
    public AgenciaDeViajes(String id, String nombre, int comision) {
        this.id = id;
        this.nombre = nombre;
        this.comision = comision;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getComision() {
        return comision;
    }
    public void setComision(int comision) {
        this.comision = comision;
    }
    @Override
    public String toString() {
        return "AgenciaDeViajes: " + "\nId: " + id + "\nNombre: " + nombre + "\nComisión: " + comision;
    }
}