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
    public boolean registrarTipoHabitacion(TipoHabitacion tipo) {
        TipoHabitacionDAO tipodao = new TipoHabitacionDAO();
        if (tipo.getCodigo().isEmpty()) {
            throw new MiError("Se requiere que ingrese el código del tipo de la habitación.");
        }
        if (String.valueOf(tipo.getPrecio()).isEmpty()){
            throw new MiError("Se requiere que ingrese el monto de la habitación.");
        }
        if (tipo.getDescripcion().isEmpty()) {
            throw new MiError("Se Requiere que ingrese la descripcion del tipo de la habitación.");
        }
        return tipodao.insertarTipoHabitacion(tipo);
    }
//    public ArrayList<TipoHabitacion> cargarTiposDeHabitaciones() {
//        TipoHabitacionDAO tiposdao = new TipoHabitacionDAO();
//        return tiposdao.cargarTiposDeHabitaciones();
//    }
}
