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
    public Cliente() {
    }
    public Cliente(String numeroTarjeta, int id, String nombre, String apellido, 
            String cedula, String direccion, Distrito idDistrito, boolean activo) {
        super(id, nombre, apellido, cedula, direccion, idDistrito, activo);
        this.numeroTarjeta = numeroTarjeta;
    }
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
}