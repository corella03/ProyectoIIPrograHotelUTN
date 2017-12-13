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
    /**
     * Método para verificar datos del tipo de habitacion  y enviarlo al registro de tipoDeReseracionDAO.
     * @param tipo TipoHabitacion que se va a verificar.
     * @return true si los datos estan correctos.
     */
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
    /**
     * Método para "eliminar" (desactiva) los tipos de habitaciones que estan en la parte de DAO.
     * @param tipo TipoHabitacion se desea elimininar.
     * @return TipoHabitacion desactivado.
     */
    public boolean elmininarTiposHabitacion(TipoHabitacion tipo){
        return tipodao.eliminarTipoHabitacion(tipo);
    }
    /**
     * Método para cargar los tipos de habitaciones que esten activas que vienen de la parte de DAO.
     * @return TipoHabitacion: la lista de los tipos de habitaciones activas.
     */
    public ArrayList<TipoHabitacion> cargarTiposDeHabitacionesActivas() {
        return tipodao.cargarTiposDeHabitaciones(true);
    }
    /**
     * Método para cargar los tipos de habitaciones que vienen de la parte de DAO.
     * @return TipoHabitacion: la lista de los tipos de habitaciones.
     */
    public ArrayList<TipoHabitacion> cargarTiposDeHabitaciones() {
        return tipodao.cargarTiposDeHabitaciones(false);
    }
    /**
     * Recibe id de la interfaz para buscar el tipo de habitacion con dicho id.
     * @param id int id del TipoHabitacion a buscar.
     * @return TipoHabitacion encontrado.
     */
    public TipoHabitacion getTipoHabitacion(int id) {
        if (id <= 0) {
            throw new MiError("Favor seleccionar un tipo de habitación");
        }
        return tipodao.seleccionarPorId(id);
    }
}