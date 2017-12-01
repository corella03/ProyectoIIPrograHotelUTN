/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.bo;
import java.util.ArrayList;
import proyectoiiprograhotelutn.dao.TipoHabitacionDAO;
import proyectoiiprograhotelutn.entities.MiError;
import proyectoiiprograhotelutn.entities.TipoHabitacion;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 24/11/2017
 **/
public class TipoHabitacionBO {
    TipoHabitacionDAO tipodao;
    public TipoHabitacionBO() {
        tipodao = new TipoHabitacionDAO();
    }
    public boolean registrarTipoHabitacion(TipoHabitacion tipo) {
        if (tipo.getCodigo().isEmpty()) {
            throw new MiError("Se requiere que ingrese el código del tipo de la habitación.");
        }
        if (String.valueOf(tipo.getPrecio()).isEmpty()){
            throw new MiError("Se requiere que ingrese el monto de la habitación.");
        }
        if (tipo.getDescripcion().isEmpty()) {
            throw new MiError("Se Requiere que ingrese la descripcion del tipo de la habitación.");
        }
        if (tipo.getId() == 0) {
            return tipodao.insertarTipoHabitacion(tipo);
        } else {
            return tipodao.modificarTipoHabitacion(tipo);
        }
    }
    public boolean elmininarTiposHabitacion(TipoHabitacion tipo){
        return tipodao.eliminarTipoHabitacion(tipo);
    }
    public ArrayList<TipoHabitacion> cargarTiposDeHabitacionesActivas() {
        return tipodao.cargarTiposDeHabitaciones(true);
    }
    public ArrayList<TipoHabitacion> cargarTiposDeHabitaciones() {
        return tipodao.cargarTiposDeHabitaciones(false);
    }
    public TipoHabitacion getTipoHabitacion(int id) {
        if (id <= 0) {
            throw new MiError("Favor seleccionar un tipo de habitación");
        }
        return tipodao.seleccionarPorId(id);
    }
}
