/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.bo;
import java.util.ArrayList;
import proyectoiiprograhotelutn.dao.HabitacionDAO;
import proyectoiiprograhotelutn.entities.Habitacion;
import proyectoiiprograhotelutn.entities.MiError;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 24/11/2017
 **/
public class HabitacionBO {
    HabitacionDAO habidao;
    public HabitacionBO() {
        habidao = new HabitacionDAO();
    }
    public boolean registrarHabitacion(Habitacion habi) {
        if (habi.getCodigo().isEmpty()) {
            throw new MiError("Se requiere que ingrese el código de la habitación.");
        }
        if (String.valueOf(habi.getIdTipoHabitacion().getId()).isEmpty()){
            throw new MiError("Se requiere que ingrese el tipo de la habitación.");
        }
        if (habi.getImagen() == null) {
            throw new MiError("Favor seleccionar una imagen");
        }
        if (habi.getDescripcion().isEmpty()) {
            throw new MiError("Se Requiere que ingrese la descripcion del tipo de la habitación.");
        }
        if (String.valueOf(habi.getCantPersonas()).isEmpty()){
            throw new MiError("Se requiere que ingrese la cantidad de cupos de la habitación.");
        }
        if (habi.getId() == 0) {
            return habidao.insertarHabitacion(habi);
        } else {
            return habidao.modificarHabitacion(habi);
        }
    }
    public boolean elmininarHabitaciones(Habitacion habi){
        return habidao.eliminarHabitacion(habi);
    }
    public ArrayList<Habitacion> cargaHabitacionesDisponibles() {
        return habidao.cargarHabitaciones(true);
    }
    public ArrayList<Habitacion> cargarHabitaciones() {
        return habidao.cargarHabitaciones(false);
    }
    public Habitacion getHabitacion(int id) {
        if (id <= 0) {
            throw new MiError("Favor seleccionar una habitación");
        }
        return habidao.seleccionarPorId(id);
    }
}
