/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.bo;
import java.util.ArrayList;
import proyectoiiprograhotelutn.dao.PaisDAO;
import proyectoiiprograhotelutn.entities.MiError;
import proyectoiiprograhotelutn.entities.Pais;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 24/11/2017
 **/
public class PaisBO {
    PaisDAO paisdao;
    public PaisBO() {
        paisdao = new PaisDAO();
    }
    /**
     * Método para verificar datos de los paises y enviarlo al registro de paisesDAO.
     * @param pais Pais que se va a verificar.
     * @return true si los datos estan correctos.
     */
    public boolean registrarPais(Pais pais) {
        if (pais.getNombre().isEmpty()) {
            throw new MiError("Se Requiere que ingrese el nombre del país.");
        }
        if(pais.getId() == 0) {
            return paisdao.insertarPais(pais);
        } else {
            return paisdao.modificarPais(pais);
        }
    }
    /**
     * Método para cargar los paises que vienen de la parte de DAO.
     * @return Pais: la lista de los cantones.
     */
    public ArrayList<Pais> cargarPaises() {
        return paisdao.cargarPaises();
    }
    /**
     * Recibe id de la interfaz para buscar el pais con dicho id.
     * @param id int id del Pais a buscar.
     * @return Pais encontrado
     */
    public Pais getPais(int id) {
        if (id <= 0) {
            throw new MiError("Favor seleccionar un Pais");
        }
        return paisdao.seleccionarPorId(id);
    }
}