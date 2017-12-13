/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import proyectoiiprograhotelutn.entities.MiError;
import proyectoiiprograhotelutn.entities.Reserva;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 24/11/2017
 **/
public class ReservaDAO {
    /**
     * Método para registar una Reserva en la BD.
     * @param usuario REserva que se va a registar.
     * @return true si se conecto con la BD y se Registro, throw si hubo algún tipo de Error.
     */
    public boolean insertarReserva(Reserva usuario) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "insert into reservacion(id_detalle_reservacion)"
                    + "values (?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, usuario.getIdDetalleReservacion().getId());
            return stmt.executeUpdate() > 0;
        }
        catch(SQLException e) {
            throw  new MiError("La cédula del usuario ya fue registrada.");
        } 
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo registrar la Reserva, favor intente nuevamente.");
        }
    }
    /**
     * Método que se encarga de cargar las reservas registradas en la BD segun esten activas o no.
     * @param activo boolean activo que decide cuales reservas retornar.
     * @return ArrayList Con las reservas registardas.
     */
    public ArrayList<Reserva> cargarReservas(boolean activo) {
        ArrayList<Reserva> usuarios = new ArrayList<>();
        try (Connection con = Conexion.getConexion()) {
            String sql = activo ? "select * from reservacion where activo = true"
                    : "select * from reservacion";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                usuarios.add(cargarReserva(rs));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());// TODO: Eliminar esta  línea
            throw new MiError("Problemas al cargar las Reserva, favor intente nuevamente.");
        }
        return usuarios;
    }
    /**
     * Método para cargar los datos de una reserva en la entidad Reserva.
     * @param rs ResultSet una sentencia que trae una consulta para BD.
     * @return Cliente: datos del reserva seleccionado.
     * @throws SQLException Controla los errores.
     */
    private Reserva cargarReserva(ResultSet rs) throws SQLException {
        Reserva reserva = new Reserva();
        reserva.setId(rs.getInt("id"));
        DetalleReservacionDAO detalle = new DetalleReservacionDAO();
        reserva.setIdDetalleReservacion(detalle.seleccionarPorId(rs.getInt("id_detalle_reservacion")));
        reserva.setActivo(rs.getBoolean("activo"));
        return reserva;
    }
    /**
     * Método que selecciona una resrva por medio de un id.
     * @param id que recibe un int con el id de la reserva.
     * @return Reserva: el cliente correspondiente al id.
     */
    public Reserva seleccionarPorId(int id) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "select * from reservacion where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return cargarReserva(rs);
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar la Reserva, favor intente nuevamente");
        }
        return null;
    }
    /**
     * Método que selecciona una reserva para modificar sus datos.
     * @param reserva  Reserva: el cliente que se desea modificar.
     * @return true si se pudo modificar.
     */
    public boolean modificarReserva(Reserva reserva) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "update reservacion set id_detalle_reservacion =?, activo=?"
                    + " where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, reserva.getIdDetalleReservacion().getId());
            stmt.setBoolean(2, reserva.isActivo());
            stmt.setInt(3, reserva.getId());
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo modificar la Reserva, favor intente nuevamente");
        }
    }
    /**
     * Método que selecciona una resrva para eliminarla (desactivarla).
     * @param reserva Reserva: la reserva que se desea eliminar.
     * @return true si se pudo eliminar.
     */
    public boolean eliminarReserva(Reserva reserva) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "update reservacion set activo = false where id =?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, reserva.getId());
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo Eliminar la Reserva, favor intente nuevamente");
        }
    }
}