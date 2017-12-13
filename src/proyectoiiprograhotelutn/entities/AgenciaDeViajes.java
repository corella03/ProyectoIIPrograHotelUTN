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
    private int id;
    private String codigo;
    private String nombre;
    private int telefono;
    private int comision;
    private boolean activo;
    public AgenciaDeViajes() {
    }
    public AgenciaDeViajes(int id, String codigo, String nombre, int telefono, int comision, boolean activo) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.comision = comision;
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
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public int getComision() {
        return comision;
    }
    public void setComision(int comision) {
        this.comision = comision;
    }
    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    /**
     * Método toString de la clase Agencia de viajes
     * @return String nombre
     */
    @Override
    public String toString() {
        return nombre;
    }
}