/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.bo;

import java.util.ArrayList;
import proyectoiiprograhotelutn.dao.DistritoDAO;
import proyectoiiprograhotelutn.entities.Distrito;
import proyectoiiprograhotelutn.entities.MiError;

/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 26/11/2017
 **/
public class DistritoBO {
    DistritoDAO distritodao;
    public DistritoBO() {
        distritodao = new DistritoDAO();
    }
    public boolean registrarDistrito(Distrito distrito) {
        if (distrito.getNombre().isEmpty()) {
            throw new MiError("Se Requiere que ingrese el nombre del Cantón.");
        }
        if (String.valueOf(distrito.getCanton().getId()).isEmpty()) {
            throw new MiError("Se Requiere que ingrese la provincia a la que pertenece el cantón.");
        }
        if(distrito.getId() == 0) {
            return distritodao.insertarDistrito(distrito);
        } else {
            return distritodao.modificarDistrito(distrito);
        }
    }
    public ArrayList<Distrito> cargarDistrito() {
        return distritodao.cargarDistritos();
    }
    public ArrayList<Distrito> cargarDistritosDeCantones(int id) {
        return distritodao.cargarDistritoDeCanton(id);
    }
    public Distrito getDistito(int id) {
        if (id <= 0) {
            throw new MiError("Favor seleccionar un Distrito");
        }
        return distritodao.seleccionarPorId(id);
    }
}
