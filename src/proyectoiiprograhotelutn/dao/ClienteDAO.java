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
import proyectoiiprograhotelutn.entities.Cliente;
import proyectoiiprograhotelutn.entities.MiError;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 24/11/2017
 **/
public class ClienteDAO {
    /**
     * Método para registar un Cliente en la BD.
     * @param cliente Cliente que se va a registar.
     * @return true si se conecto con la BD y se Registro, throw si hubo algún tipo de Error.
     */
    public boolean insertarCliente(Cliente cliente) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "insert into cliente(nombre, apellido, cedula, direccion, numero_tarjeta,telefono)"
                    + "values (?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getCedula());
            stmt.setString(4, cliente.getDireccion());
            stmt.setString(5, cliente.getNumeroTarjeta());
            stmt.setInt(6, cliente.getTelefono());
            return stmt.executeUpdate() > 0;
        }
        catch(SQLException e) {
            throw  new MiError("La cédula del usuario ya fue registrada.");
        } 
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo registrar el Cliente, favor intente nuevamente.");
        }
    }
    /**
     * Método que se encarga de cargar los clientes registrados en la BD segun esten activas o no.
     * @param activo boolean activo que decide cuales clientes retornar.
     * @return ArrayList Con los cliente registardos.
     */
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
    /**
     * Método para cargar los datos de un cliente en la entidad Cliente.
     * @param rs ResultSet una sentencia que trae una consulta para BD.
     * @return Cliente: datos del cliente seleccionado.
     * @throws SQLException Controla los errores.
     */
    private Cliente cargarCliente(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setId(rs.getInt("id"));
        cliente.setNombre(rs.getString("nombre"));
        cliente.setApellido(rs.getString("apellido"));
        cliente.setCedula(rs.getString("cedula"));
        cliente.setDireccion(rs.getString("direccion"));
        cliente.setNumeroTarjeta(rs.getString("numero_tarjeta"));
        cliente.setActivo(rs.getBoolean("activo"));
        cliente.setTelefono(rs.getInt("telefono"));
        return cliente;
    }
    /**
     * Método que selecciona un cliente por medio de un id.
     * @param id que recibe un int con el id del cliente.
     * @return Cliente: el cliente correspondiente al id.
     */
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
    /**
     * Método que selecciona un cliente para modificar sus datos.
     * @param cliente Cliente: el cliente que se desea modificar.
     * @return true si se pudo modificar.
     */
    public boolean modificarCliente(Cliente cliente) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "update cliente set nombre =?, apellido=?, cedula=?, direccion=?, "
                    + "numero_tarjeta=?, activo=?, telefono=?"
                    + " where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getCedula());
            stmt.setString(4, cliente.getDireccion());
            stmt.setString(5, cliente.getNumeroTarjeta());
            stmt.setBoolean(6, cliente.isActivo());
            stmt.setInt(7, cliente.getTelefono());
            stmt.setInt(8, cliente.getId());
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo modificar el Cliente, favor intente nuevamente");
        }
    }
    /**
     * Método que selecciona un cliente para eliminarlo (desactivarla).
     * @param cliente Cliente: el cliente que se desea eliminar.
     * @return true si se pudo eliminar.
     */
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
    /**
     * Método que selecciona un cliente por medio de la cedula.
     * @param cedula que recibe un String con la cedula del cliente.
     * @return Cliente: el cliente correspondiente a la cedula.
     */
    public Cliente seleccionarPorCedula(String cedula) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "select * from cliente where cedula = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cedula);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return cargarCliente(rs);
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar el Cliente, favor intente nuevamente");
        }
        return null;
    }
}