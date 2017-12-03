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
public class Pais extends Lugar{
    public Pais() {
    }
    public Pais(int id, String nombre) {
        super(id, nombre);
    }
    @Override
    public String toString() {
        return getNombre();
    }
}