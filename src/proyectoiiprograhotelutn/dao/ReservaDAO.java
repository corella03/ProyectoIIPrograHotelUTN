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
import proyectoiiprograhotelutn.entities.Usuario;

/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 24/11/2017
 **/
public class ReservaDAO {
    public boolean insertarReserva(Reserva usuario) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "insert into reservacion(id_detalle_reservacion)"
                    + "values (?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, usuario.getIdDetalleReservacion().getId());
            return stmt.executeUpdate() > 0;
        }
//        catch(SQLException e) {
//            throw  new MiError("La cédula del usuario ya fue registrada.");
//        } 
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo registrar la Reserva, favor intente nuevamente.");
        }
    }
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
    private Reserva cargarReserva(ResultSet rs) throws SQLException {
        Reserva reserva = new Reserva();
        reserva.setId(rs.getInt("id"));
        DetalleReservacionDAO detalle = new DetalleReservacionDAO();
        reserva.setIdDetalleReservacion(detalle.seleccionarPorId(rs.getInt("id_detalle_reservacion")));
        reserva.setActivo(rs.getBoolean("activo"));
        return reserva;
    }
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