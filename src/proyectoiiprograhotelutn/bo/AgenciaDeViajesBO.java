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
    /**
     * Método para verificar datos de las agencias y enviarlo al registro de agenciasDAO.
     * @param agencia agenciaDeViajes que se va a verificar.
     * @return true si los datos estan correctos.
     */
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
    /**
     * Método para cargar las agencias de viajes que esten activas que vienen de la parte de DAO.
     * @return AgenciaDeViajes: la lista de las agencias de viajes activas.
     */
    public ArrayList<AgenciaDeViajes> cargarAgenciasActivas(){
        return adao.cargarAgencias(true);
    }
    /**
     * Método para cargar las agencias de viajes que vienen de la parte de DAO.
     * @return AgenciaDeViajes: la lista de las agencias de viajes.
     */
    public ArrayList<AgenciaDeViajes> cargarAgencias(){
        return adao.cargarAgencias(false);
    }
    /**
     * Recibe id de la interfaz para buscar las agencias de viajes con dicho id.
     * @param id int id de la agencia de viajes a buscar
     * @return AgenciaDeViajes encontrada.
     */
    public AgenciaDeViajes getAgencia(int id) {
        if (id <= 0) {
            throw new MiError("Favor seleccionar una Agencia de viajes.");
        }
        return adao.seleccionarPorId(id);
    }
    /**
     * Método para "eliminar" (desactiva) las agencias de viajes que estan en la parte de DAO.
     * @param agencia agencia de viajes que se desea elimininar.
     * @return AgenciaDeViajes desactivada.
     */
    public boolean elmininarAgencia(AgenciaDeViajes agencia){
        return adao.eliminarAgencia(agencia);
    }
}