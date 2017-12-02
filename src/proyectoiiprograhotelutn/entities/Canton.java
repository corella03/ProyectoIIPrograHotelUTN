/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.entities;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 01/11/2017
 **/
public class Canton extends Lugar{
    private Provincia provincia;
    public Canton() {
    }
    public Canton(Provincia provincia, int id, String nombre) {
        super(id, nombre);
        this.provincia = provincia;
    }
    public Provincia getProvincia() {
        return provincia;
    }
    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
    @Override
    public String toString() {
        return "Canton: " + getNombre();
    } 
}