/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.entities;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 04/11/2017
 **/
public class Cliente extends Persona{
    private String numeroTarjeta;
    private int telefono;
    public Cliente() {
    }
    public Cliente(String numeroTarjeta, int telefono, int id, String nombre, String apellido, 
            String cedula, String direccion, Distrito idDistrito, boolean activo) {
        super(id, nombre, apellido, cedula, direccion, idDistrito, activo);
        this.numeroTarjeta = numeroTarjeta;
        this.telefono = telefono;
    }
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}