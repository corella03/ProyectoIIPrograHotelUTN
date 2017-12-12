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
            String sql = "insert into cliente(id_usuario, id_cliente, id_habitacion,"
                    + " id_agencia_de_viajes, fecha_reservacion, fecha_entrada, fecha_salida, desayuno,"
                    + "cant_personas, telefono)"
                    + "values (?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, detalle.getIdUsuario().getId());
            stmt.setInt(2, detalle.getIdCliente().getId());
            stmt.setInt(3, detalle.getIdHabitacion().getId());
            stmt.setInt(4, detalle.getIdAgencia().getId());
            return stmt.executeUpdate() > 0;
        }
//        catch(SQLException e) {
//            throw  new MiError("La cédula del usuario ya fue registrada.");
//        } 
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo registrar el Cliente, favor intente nuevamente.");
        }
    }
    public ArrayList<Cliente> cargarClientes(boolean activo) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try (Connection con = Conexion.getConexion()) {
            String sql = activo ? "select * from cliente where activo = true"
                    : "select * from cliente";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                clientes.add(cargarCliente(rs));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());// TODO: Eliminar esta  línea
            throw new MiError("Problemas al cargar los clientes, favor intente nuevamente.");
        }
        return clientes;
    }
    private Cliente cargarCliente(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setId(rs.getInt("id"));
        cliente.setNombre(rs.getString("nombre"));
        cliente.setApellido(rs.getString("apellido"));
        cliente.setCedula(rs.getString("cedula"));
        cliente.setDireccion(rs.getString("direccion"));
        cliente.setNumeroTarjeta(rs.getString("numero_tarjeta"));
        cliente.setActivo(rs.getBoolean("activo"));
        return cliente;
    }
    public Cliente seleccionarPorId(int id) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "select * from cliente where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return cargarCliente(rs);
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar el Cliente, favor intente nuevamente");
        }
        return null;
    }
    public boolean modificarCliente(Cliente cliente) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "update cliente set nombre =?, apellido=?, cedula=?, direccion=?, "
                    + "numero_tarjeta=?, activo=?"
                    + " where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getCedula());
            stmt.setString(4, cliente.getDireccion());
            stmt.setString(5, cliente.getNumeroTarjeta());
            stmt.setBoolean(6, cliente.isActivo());
            stmt.setInt(7, cliente.getId());
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo modificar el Cliente, favor intente nuevamente");
        }
    }
    public boolean eliminarCliente(Cliente cliente) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "update cliente set activo = false where id =?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, cliente.getId());
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo Eliminar el Cliente, favor intente nuevamente");
        }
    }
}