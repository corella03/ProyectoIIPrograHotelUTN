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
    /**
     * Método para verificar datos del distrito y enviarlo al registro de distritoDAO.
     * @param distrito Distrito que se va a verificar.
     * @return true si los datos estan correctos.
     */
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
    /**
     *  Método para cargar los distritos que vienen de la parte de DAO.
     * @return Distrito: la lista de los distritos.
     */
    public ArrayList<Distrito> cargarDistrito() {
        return distritodao.cargarDistritos();
    }
    /**
     * Método para cargar los distritos que cada canton, vienen de la parte de DAO.
     * @param id int del id de la canton a la que pertenece el distrito.
     * @return Distrito: lista de distritos de dicha canton.
     */
    public ArrayList<Distrito> cargarDistritosDeCantones(int id) {
        return distritodao.cargarDistritoDeCanton(id);
    }
    /**
     * Recibe id de la interfaz para buscar el distrito con dicho id.
     * @param id int id del Distrito a buscar.
     * @return Distrito encontrado.
     */
    public Distrito getDistito(int id) {
        if (id <= 0) {
            throw new MiError("Favor seleccionar un Distrito");
        }
        return distritodao.seleccionarPorId(id);
    }
}