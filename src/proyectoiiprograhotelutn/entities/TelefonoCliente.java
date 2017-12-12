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
public class TelefonoCliente {
    private int id;
    private int telefono;
    private Cliente idCliente;
    private boolean activo;
    public TelefonoCliente() {
    }
    public TelefonoCliente(int id, int telefono, Cliente idCliente, boolean activo) {
        this.id = id;
        this.telefono = telefono;
        this.idCliente = idCliente;
        this.activo = activo;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public Cliente getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }
    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}