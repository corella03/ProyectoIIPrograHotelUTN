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
    private Pais pais;
    public Provincia() {
    }
    public Provincia(Pais pais, int id, String nombre) {
        super(id, nombre);
        this.pais = pais;
    }
    public Pais getPais() {
        return pais;
    }
    public void setPais(Pais pais) {
        this.pais = pais;
    }
    @Override
    public String toString() {
        return getNombre();
    }
}