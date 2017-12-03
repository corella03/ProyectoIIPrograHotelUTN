/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.bo;

import java.util.ArrayList;
import proyectoiiprograhotelutn.dao.CantonDAO;
import proyectoiiprograhotelutn.entities.Canton;
import proyectoiiprograhotelutn.entities.MiError;

/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 26/11/2017
 **/
public class CantonBO {
    CantonDAO cantondao;
    public CantonBO() {
        cantondao = new CantonDAO();
    }
    public boolean registrarCanton(Canton canton) {
        if (canton.getNombre().isEmpty()) {
            throw new MiError("Se Requiere que ingrese el nombre del Cantón.");
        }
        if (String.valueOf(canton.getProvincia().getId()).isEmpty()) {
            throw new MiError("Se Requiere que ingrese la provincia a la que pertenece el cantón.");
        }
        if(canton.getId() == 0) {
            return cantondao.insertarCanton(canton);
        } else {
            return cantondao.modificarCanton(canton);
        }
    }
    public ArrayList<Canton> cargarCantones() {
        return cantondao.cargarCantones();
    }
    public Canton getCanton(int id) {
        if (id <= 0) {
            throw new MiError("Favor seleccionar un Cantón");
        }
        return cantondao.seleccionarPorId(id);
    }
}
