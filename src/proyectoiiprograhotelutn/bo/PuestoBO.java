/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.bo;

import proyectoiiprograhotelutn.dao.PuestoDAO;
import proyectoiiprograhotelutn.entities.MiError;
import proyectoiiprograhotelutn.entities.Puesto;

/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 24/11/2017
 **/
public class PuestoBO {
     public boolean registrar(Puesto puesto) {
        if (puesto.getNombre().isEmpty()) {
            throw new MiError("Se Requiere que ingrese el nombre del puesto.");
        }
        if (puesto.getDescripcion().isEmpty()) {
            throw new MiError("Se Requiere que ingrese la descripcion del puesto.");
        }
        PuestoDAO udao = new PuestoDAO();
        if(udao.verificarExistenciaPuesto(puesto.getNombre())){
            throw new MiError("Ya existe el puesto ingresado.");
        }
        return udao.insertar(puesto);
    }
}