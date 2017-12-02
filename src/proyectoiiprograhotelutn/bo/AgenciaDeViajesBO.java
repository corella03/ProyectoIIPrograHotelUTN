/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.bo;
import java.util.ArrayList;
import proyectoiiprograhotelutn.dao.AgenciaDeViajesDAO;
import proyectoiiprograhotelutn.entities.AgenciaDeViajes;
import proyectoiiprograhotelutn.entities.MiError;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 24/11/2017
 **/
public class AgenciaDeViajesBO {
    AgenciaDeViajesDAO adao;
    public AgenciaDeViajesBO() {
        adao = new AgenciaDeViajesDAO();
    }
    public boolean registrarAgencia(AgenciaDeViajes agencia) {
        if (agencia.getCodigo().isEmpty()) {
            throw new MiError("Se Requiere que ingrese el codigo de la agencia.");
        }
        if (agencia.getNombre().isEmpty()) {
            throw new MiError("Se Requiere que ingrese el nombre de la agencia.");
        }
        if (String.valueOf(agencia.getTelefono()).isEmpty()) {
            throw new MiError("Se Requiere que ingrese el teléfono de la agencia.");
        }
        if (String.valueOf(agencia.getComision()).isEmpty()) {
            throw new MiError("Se Requiere que ingrese el porcentaje de comisión.");
        }
        if(agencia.getId() == 0){
            return adao.insertarAgencia(agencia);
        } else {
            return adao.modificarAgencia(agencia);
        }
    }
    public ArrayList<AgenciaDeViajes> cargarAgenciasActivas(){
        return adao.cargarAgencias(true);
    }
    public ArrayList<AgenciaDeViajes> cargarAgencias(){
        return adao.cargarAgencias(false);
    }
    public AgenciaDeViajes getAgencia(int id) {
        if (id <= 0) {
            throw new MiError("Favor seleccionar una Agencia de viajes.");
        }
        return adao.seleccionarPorId(id);
    }
    public boolean elmininarAgencia(AgenciaDeViajes agencia){
        return adao.eliminarAgencia(agencia);
    }
}