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
import proyectoiiprograhotelutn.entities.DetalleReservacion;
import proyectoiiprograhotelutn.entities.MiError;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 24/11/2017
 **/
public class DetalleReservacionDAO {
    public boolean insertarDetalle(DetalleReservacion detalle) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "insert into detalle_reservacion(id_usuario, id_cliente, id_habitacion,"
                    + " id_agencia_de_viajes, fecha_reservacion, fecha_entrada, fecha_salida, desayuno,"
                    + "cant_personas)"
                    + "values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, detalle.getIdUsuario().getId());
            stmt.setInt(2, detalle.getIdCliente().getId());
            stmt.setInt(3, detalle.getIdHabitacion().getId());
            stmt.setInt(4, detalle.getIdAgencia().getId());
            java.sql.Date fechaReservacion = new java.sql.Date(detalle.getFechaReservacion().getTime());
            stmt.setDate(5, fechaReservacion);
            java.sql.Date fechaEntrada = new java.sql.Date(detalle.getFechaEntrada().getTime());
            stmt.setDate(6, fechaEntrada);
            java.sql.Date fechaSalida = new java.sql.Date(detalle.getFechaSalida().getTime());
            stmt.setDate(7, fechaSalida);
            stmt.setBoolean(8, detalle.isDesayuno());
            stmt.setInt(9, detalle.getCantPersonas());
            return stmt.executeUpdate() > 0;
        }
//        catch(SQLException e) {
//            throw  new MiError("La cédula del usuario ya fue registrada.");
//        } 
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo registrar los detalles de reservación, favor intente nuevamente.");
        }
    }
    public ArrayList<DetalleReservacion> cargarDetalleReservaciones() {
        ArrayList<DetalleReservacion> reservaciones = new ArrayList<>();
        try (Connection con = Conexion.getConexion()) {
            String sql = "select * from detalle_reservacion";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                reservaciones.add(cargarDetalleReservacion(rs));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());// TODO: Eliminar esta  línea
            throw new MiError("Problemas al cargar los detalles de reservación, favor intente nuevamente.");
        }
        return reservaciones;
    }
    private DetalleReservacion cargarDetalleReservacion(ResultSet rs) throws SQLException {
        DetalleReservacion dellate = new DetalleReservacion();
        dellate.setId(rs.getInt("id"));
        UsuarioDAO usu = new UsuarioDAO();
        dellate.setIdUsuario(usu.seleccionarPorId(rs.getInt("id_usuario")));
        ClienteDAO cli = new ClienteDAO();
        dellate.setIdCliente(cli.seleccionarPorId(rs.getInt("id_cliente")));
        HabitacionDAO habi = new HabitacionDAO();
        dellate.setIdHabitacion(habi.seleccionarPorId(rs.getInt("id_habitacion")));
        AgenciaDeViajesDAO agencia = new AgenciaDeViajesDAO();
        dellate.setIdAgencia(agencia.seleccionarPorId(rs.getInt("id_agencia_de_viajes")));
        dellate.setFechaReservacion(rs.getDate("fecha_reservacion"));
        dellate.setFechaEntrada(rs.getDate("fecha_entrada"));
        dellate.setFechaSalida(rs.getDate("fecha_salida"));
        dellate.setDesayuno(rs.getBoolean("desayuno"));
        dellate.setCantPersonas(rs.getInt("cant_personas"));
        return dellate;
    }
    public DetalleReservacion seleccionarPorId(int id) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "select * from detalle_reservacion where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return cargarDetalleReservacion(rs);
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar los detalles de reservación, favor intente nuevamente");
        }
        return null;
    }
    public boolean modificarDetalleReservacion(DetalleReservacion detalle) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "update detalle_reservacion set id_usuario =?, id_cliente=?, id_habitacion=?,"
                    + " id_agencia_de_viajes=?, fecha_reservacion=?, fecha_entrada=?, fecha_salida=?,"
                    + "desayuno =?, cant_personas=?"
                    + " where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, detalle.getIdUsuario().getId());
            stmt.setInt(2, detalle.getIdCliente().getId());
            stmt.setInt(3, detalle.getIdHabitacion().getId());
            stmt.setInt(4, detalle.getIdAgencia().getId());
            java.sql.Date fechaReservacion = new java.sql.Date(detalle.getFechaReservacion().getTime());
            stmt.setDate(5, fechaReservacion);
            java.sql.Date fechaEntrada = new java.sql.Date(detalle.getFechaEntrada().getTime());
            stmt.setDate(6, fechaEntrada);
            java.sql.Date fechaSalida = new java.sql.Date(detalle.getFechaSalida().getTime());
            stmt.setDate(7, fechaSalida);
            stmt.setBoolean(8, detalle.isDesayuno());
            stmt.setInt(9, detalle.getCantPersonas());
            stmt.setInt(10, detalle.getId());
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo modificar los detalles de reservación, favor intente nuevamente");
        }
    }
}