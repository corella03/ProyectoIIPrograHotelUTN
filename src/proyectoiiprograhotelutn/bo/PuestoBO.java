/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.bo;
import java.util.ArrayList;
import proyectoiiprograhotelutn.dao.PuestoDAO;
import proyectoiiprograhotelutn.entities.MiError;
import proyectoiiprograhotelutn.entities.Puesto;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 24/11/2017
 **/
public class PuestoBO {
    PuestoDAO puestodao;
    public PuestoBO() {
        puestodao = new PuestoDAO();
    }
    /**
     * Método para verificar datos del puesto y enviarlo al registro de puestosDAO.
     * @param puesto Puesto que se va a verificar.
     * @return true si los datos estan correctos.
     */
    public boolean registrarPuesto(Puesto puesto) {
        if(puesto.getNombre().isEmpty()) {
            throw new MiError("Se Requiere que ingrese el nombre del puesto.");
        }
        if(puesto.getDescripcion().isEmpty()) {
            throw new MiError("Se Requiere que ingrese la descripcion del puesto.");
        }
        if(puesto.getId() == 0) {
            return puestodao.insertarPuesto(puesto);
        } else {
            return puestodao.modificarPuesto(puesto);
        }
    }
    /**
     * Método para cargar los puestos que esten activos que vienen de la parte de DAO.
     * @return Puesto: la lista de los puestos activos.
     */
    public ArrayList<Puesto> cargarPuestosActivos(){
        return puestodao.cargarPuestos(true);
    }
    /**
     * Método para cargar los puestos que vienen de la parte de DAO.
     * @return Puesto: la lista de los puestos.
     */
    public ArrayList<Puesto> cargarPuestos(){
        return puestodao.cargarPuestos(false);
    }
    /**
     * Recibe id de la interfaz para buscar el puesto con dicho id.
     * @param id int id del Puesto a buscar.
     * @return Puesto encontrado.
     */
    public Puesto getPuesto(int id) {
        if (id <= 0) {
            throw new MiError("Favor seleccionar un Puesto");
        }
        return puestodao.seleccionarPorId(id);
    }
    /**
     * Método para "eliminar" (desactiva) los puestos que estan en la parte de DAO.
     * @param puesto Puesto se desea elimininar.
     * @return Puesto desactivado.
     */
    public boolean elmininarPuesto(Puesto puesto){
        return puestodao.eliminarPuesto(puesto);
    }
}