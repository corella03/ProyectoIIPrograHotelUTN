/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.entities;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 26/11/2017
 **/
public class Provincia extends Lugar{
    private int idPais;
    public Provincia() {
    }
    public Provincia(int idPais, int id, String nombre) {
        super(id, nombre);
        this.idPais = idPais;
    }
    public int getIdPais() {
        return idPais;
    }
    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }
    @Override
    public String toString() {
        return "Provincia: " + "\nId: " + getId() + "\nNombre: " + getNombre() + "\nId País: " + idPais;
    }
}