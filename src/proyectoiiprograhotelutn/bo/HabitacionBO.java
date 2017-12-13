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
    /**
     * Método para verificar datos de la habitacion y enviarlo al registro de habitacionDAO.
     * @param habi
     * @return
     */
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
    /**
     * Método para "eliminar" (desactiva) las habitaciones que estan en la parte de DAO.
     * @param habi Habitacion se desea elimininar.
     * @return Habitacion desactivado.
     */
    public boolean elmininarHabitaciones(Habitacion habi){
        return habidao.eliminarHabitacion(habi);
    }
    /**
     * Método para cargar las habitaciones que esten disponibles que vienen de la parte de DAO.
     * @return Habitacion: la lista de las habitaciones disponibles.
     */
    public ArrayList<Habitacion> cargaHabitacionesDisponibles() {
        return habidao.cargarHabitaciones(true);
    }
    /**
     * Método para cargar las habitaciones que vienen de la parte de DAO.
     * @return Habitacion: la lista de las habitaciones.
     */
    public ArrayList<Habitacion> cargarHabitaciones() {
        return habidao.cargarHabitaciones(false);
    }
    /**
     * Recibe id de la interfaz para buscar una habitacion con dicho id.
     * @param id id int de la habitacion a buscar.
     * @return Habitacion encontrado.
     */
    public Habitacion getHabitacion(int id) {
        if (id <= 0) {
            throw new MiError("Favor seleccionar una habitación");
        }
        return habidao.seleccionarPorId(id);
    }
    /**
     * Recibe cupos de la interfaz para buscar las habitaciones con dicho cupo.
     * @param cupo cupo int de la habitacion a buscar.
     * @return  Habitacion encontrada.
     */
    public Habitacion getCupo(int cupo) {
        return habidao.seleccionarCampos(cupo);
    }
}