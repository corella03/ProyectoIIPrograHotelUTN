/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.bo;

import java.util.ArrayList;
import java.util.LinkedList;
import proyectoiiprograhotelutn.dao.ProvinciaDAO;
import proyectoiiprograhotelutn.entities.MiError;
import proyectoiiprograhotelutn.entities.Provincia;

/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 26/11/2017
 **/
public class ProvinciaBO {
    ProvinciaDAO provinciadao;
    public ProvinciaBO() {
        provinciadao = new ProvinciaDAO();
    }
    public boolean registrarProvincia(Provincia provincia) {
        if (provincia.getNombre().isEmpty()) {
            throw new MiError("Se Requiere que ingrese el nombre de la provincia.");
        }
        if (String.valueOf(provincia.getPais().getId()).isEmpty()) {
            throw new MiError("Se Requiere que ingrese el país que pertenece la provincia.");
        }
        if(provincia.getId() == 0) {
            return provinciadao.insertarProvincia(provincia);
        } else {
            return provinciadao.modificarProvincia(provincia);
        }
    }
    public ArrayList<Provincia> cargarProvincias() {
        return provinciadao.cargarProvincias();
    }
    public Provincia getPais(int id) {
        if (id <= 0) {
            throw new MiError("Favor seleccionar una Provincia");
        }
        return provinciadao.seleccionarPorId(id);
    }
}
