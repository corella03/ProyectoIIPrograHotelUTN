/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.bo;

import proyectoiiprograhotelutn.dao.TipoHabitacionDAO;
import proyectoiiprograhotelutn.entities.MiError;
import proyectoiiprograhotelutn.entities.TipoHabitacion;

/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 24/11/2017
 **/
public class TipoHabitacionBO {
    public boolean registrarTipoHabitacion(TipoHabitacion tipo) {
        if (tipo.getId().isEmpty()) {
            throw new MiError("Se Requiere que ingrese el id del tipo de la habitación.");
        }
        if (String.valueOf(tipo.getPrecio()).isEmpty()){
            throw new MiError("Se Requiere que ingrese el monto de la habitación.");
        }
        if (tipo.getDescripcion().isEmpty()) {
            throw new MiError("Se Requiere que ingrese la descripcion del tipo de la habitación.");
        }
        TipoHabitacionDAO tipodao = new TipoHabitacionDAO();
        if(tipodao.verificarExistenciaTipoHabitacion(tipo.getId())){
            throw new MiError("Ya existe el tipo de habitación ingresada.");
        }
        return tipodao.insertarTipoHabitacion(tipo);
    }
}
