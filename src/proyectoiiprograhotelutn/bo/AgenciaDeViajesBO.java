/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.bo;

import java.util.ArrayList;
import proyectoiiprograhotelutn.dao.AgenciaDeViajesDAO;
import proyectoiiprograhotelutn.dao.TipoHabitacionDAO;
import proyectoiiprograhotelutn.entities.AgenciaDeViajes;
import proyectoiiprograhotelutn.entities.MiError;

/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 24/11/2017
 **/
public class AgenciaDeViajesBO {
    public boolean registrarAgencia(AgenciaDeViajes agencia) {
        if (agencia.getId().isEmpty()) {
            throw new MiError("Se Requiere que ingrese el Id de la agencia.");
        }
        if (agencia.getNombre().isEmpty()) {
            throw new MiError("Se Requiere que ingrese el nombre de la agencia.");
        }
        if (String.valueOf(agencia.getComision()).isEmpty()) {
            throw new MiError("Se Requiere que ingrese el porcentaje de comisión.");
        }
        AgenciaDeViajesDAO adao = new AgenciaDeViajesDAO();
        if(adao.verificarExistenciaAgencia(agencia.getId())){
            throw new MiError("la agencia ya ha sido registrada.");
        }
        return adao.insertarAgencia(agencia);
    }
    public ArrayList<AgenciaDeViajes> cargarAgenciasDeViajes() {
        AgenciaDeViajesDAO agenciadao = new AgenciaDeViajesDAO();
        return agenciadao.cargarAgenciasDeViajes();
    }
}