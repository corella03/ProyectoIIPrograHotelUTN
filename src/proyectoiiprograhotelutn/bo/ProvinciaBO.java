/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.bo;
import java.util.ArrayList;
import proyectoiiprograhotelutn.dao.ProvinciaDAO;
import proyectoiiprograhotelutn.entities.MiError;
import proyectoiiprograhotelutn.entities.Provincia;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 26/11/2017
 **/
public class ProvinciaBO {
    ProvinciaDAO provinciadao;
    public ProvinciaBO() {
        provinciadao = new ProvinciaDAO();
    }
    /**
     * Método para verificar datos de las provincias y enviarlo al registro de provinciasDAO.
     * @param provincia Provincia que se va a verificar.
     * @return true si los datos estan correctos.
     */
    public boolean registrarProvincia(Provincia provincia) {
        if (provincia.getNombre().isEmpty()) {
            throw new MiError("Se Requiere que ingrese el nombre de la provincia.");
        }
        if (String.valueOf(provincia.getPais().getId()).isEmpty()) {
            throw new MiError("Se Requiere que ingrese el país que pertenece la provincia.");
        }
        if(provincia.getId() == 0) {
            return provinciadao.insertarProvincia(provincia);
        } else {
            return provinciadao.modificarProvincia(provincia);
        }
    }
    /**
     * Método para cargar los provincias que vienen de la parte de DAO
     * @return Provincia: la lista de los provincias.
     */
    public ArrayList<Provincia> cargarProvincias() {
        return provinciadao.cargarProvincias();
    }
    /**
     * Método para cargar las provincias de cada pais, vienen de la parte de DAO.
     * @param id int del id de la pais a la que pertenece la provincia.
     * @return Provincia: lista de provincias de dicha pais.
     */
    public ArrayList<Provincia> cargarProvinciasDePais(int id) {
        return provinciadao.cargarProvinciaDelPais(id);
    }
    /**
     * Recibe id de la interfaz para buscar la provincia con dicho id.
     * @param id int id de la Provincia a buscar.
     * @return Provincia encontrada.
     */
    public Provincia getProvincia(int id) {
        if (id <= 0) {
            throw new MiError("Favor seleccionar una Provincia");
        }
        return provinciadao.seleccionarPorId(id);
    }
}