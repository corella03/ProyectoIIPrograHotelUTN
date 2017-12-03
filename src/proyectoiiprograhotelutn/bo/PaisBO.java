/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.bo;
import java.util.ArrayList;
import proyectoiiprograhotelutn.dao.PaisDAO;
import proyectoiiprograhotelutn.entities.MiError;
import proyectoiiprograhotelutn.entities.Pais;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 24/11/2017
 **/
public class PaisBO {
    PaisDAO paisdao;
    public PaisBO() {
        paisdao = new PaisDAO();
    }
    public boolean registrarPais(Pais pais) {
        if (pais.getNombre().isEmpty()) {
            throw new MiError("Se Requiere que ingrese el nombre del país.");
        }
        if(pais.getId() == 0) {
            return paisdao.insertarPais(pais);
        } else {
            return paisdao.modificarPais(pais);
        }
    }
    public ArrayList<Pais> cargarPaises() {
        return paisdao.cargarPaises();
    }
    public Pais getPais(int id) {
        if (id <= 0) {
            throw new MiError("Favor seleccionar un Pais");
        }
        return paisdao.seleccionarPorId(id);
    }
}