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
    /**
     * Método para registar un DetalleReservacion en la BD.
     * @param detalle DetalleReservacion que se va a registar.
     * @return true si se conecto con la BD y se Registro, throw si hubo algún tipo de Error.
     */
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
            stmt.setString(6, detalle.getFechaEntrada());
            stmt.setString(7, detalle.getFechaSalida());
            stmt.setBoolean(8, detalle.isDesayuno());
            stmt.setInt(9, detalle.getCantPersonas());
            return stmt.executeUpdate() > 0;
        }
        catch(SQLException e) {
            throw  new MiError("La cédula del usuario ya fue registrada.");
        } 
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo registrar los detalles de reservación, favor intente nuevamente.");
        }
    }
    /**
     * Método que se encarga de cargar los detalles de reservacion en la BD.
     * @return ArrayList Con los detalles de reservacion registardas.
     */
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
    /**
     * Método para cargar los datos de el detalle de reservacion en la entidad Cliente.
     * @param rs ResultSet una sentencia que trae una consulta para BD.
     * @return DetalleReservacion: datos del cliente seleccionada.
     * @throws SQLException Controla los errores.
     */
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
        dellate.setFechaEntrada(rs.getString("fecha_entrada"));
        dellate.setFechaSalida(rs.getString("fecha_salida"));
        dellate.setDesayuno(rs.getBoolean("desayuno"));
        dellate.setCantPersonas(rs.getInt("cant_personas"));
        return dellate;
    }
    /**
     * Método que selecciona un dellate reservacion por medio de un id.
     * @param id que recibe un int con el id del dellate reservacion.
     * @return DetalleReservacion: el dellate reservacion correspondiente al id.
     */
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
    /**
     * Método que selecciona un dellate reservacion para modificar sus datos.
     * @param detalle DetalleReservacion: el dellate reservacion que se desea modificar
     * @return true si se pudo modificar.
     */
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
            stmt.setString(6, detalle.getFechaEntrada());
            stmt.setString(7, detalle.getFechaSalida());
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