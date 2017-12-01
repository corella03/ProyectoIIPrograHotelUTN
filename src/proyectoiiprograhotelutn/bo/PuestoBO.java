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
    public boolean registrarPuesto(Puesto puesto) {
        if (puesto.getNombre().isEmpty()) {
            throw new MiError("Se Requiere que ingrese el nombre del puesto.");
        }
        if (puesto.getDescripcion().isEmpty()) {
            throw new MiError("Se Requiere que ingrese la descripcion del puesto.");
        }
        if (puesto.getId() == 0) {
            return puestodao.insertarPuesto(puesto);
        } else {
            return puestodao.modificarPuesto(puesto);
        }
    }
    public ArrayList<Puesto> cargarPuestosActivos(){
        return puestodao.cargarPuestos(true);
    }
    public ArrayList<Puesto> cargarPuestos(){
        return puestodao.cargarPuestos(false);
    }
    public Puesto getPuesto(int id) {
        if (id <= 0) {
            throw new MiError("Favor seleccionar un Puesto");
        }
        return puestodao.seleccionarPorId(id);
    }
    public boolean elmininarPuesto(Puesto puesto){
        return puestodao.eliminarPuesto(puesto);
    }
}