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
public class Usuario  extends Persona{
    private int telefono;
    private Puesto idPuesto;
    private String contrasena;
    public Usuario() {
    }
    public Usuario(int telefono, Puesto idPuesto, String contrasena, int id, String nombre,
            String apellido, String cedula, String direccion, Distrito idDistrito, boolean activo) {
        super(id, nombre, apellido, cedula, direccion, idDistrito, activo);
        this.telefono = telefono;
        this.idPuesto = idPuesto;
        this.contrasena = contrasena;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public Puesto getIdPuesto() {
        return idPuesto;
    }
    public void setIdPuesto(Puesto idPuesto) {
        this.idPuesto = idPuesto;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}