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
public class Distrito extends Lugar{
    private Canton canton;
    public Distrito() {
    }
    public Distrito(Canton canton, int id, String nombre) {
        super(id, nombre);
        this.canton = canton;
    }
    public Canton getCanton() {
        return canton;
    }
    public void setCanton(Canton canton) {
        this.canton = canton;
    }
    @Override
    public String toString() {
        return getNombre();
    }
}