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
    /**
     * Método para verificar datos de los cantones y enviarlo al registro de cantonesDAO.
     * @param canton Canton que se va a verificar.
     * @return true si los datos estan correctos.
     */
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
    /**
     * Método para cargar los cantones que vienen de la parte de DAO.
     * @return Canton: la lista de los cantones.
     */
    public ArrayList<Canton> cargarCantones() {
        return cantondao.cargarCantones();
    }
    /**
     * Método para cargar los cantones que cada provincia, vienen de la parte de DAO.
     * @param id int del id de la provincia a la que pertenece el canton.
     * @return Canton: lista de cantones de dicha provincia.
     */
    public ArrayList<Canton> cargarCantonesDeProvincia(int id) {
        return cantondao.cargarCantonDeProvincia(id);
    }
    /**
     * Recibe id de la interfaz para buscar el canton con dicho id.
     * @param id int id del Canton a buscar.
     * @return Canton encontrado.
     */
    public Canton getCanton(int id) {
        if (id <= 0) {
            throw new MiError("Favor seleccionar un Cantón");
        }
        return cantondao.seleccionarPorId(id);
    }
}