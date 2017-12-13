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
import proyectoiiprograhotelutn.entities.AgenciaDeViajes;
import proyectoiiprograhotelutn.entities.MiError;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 24/11/2017
 **/
public class AgenciaDeViajesDAO {
    /**
     * Método para registar una AgenciaDeViajes en la BD.
     * @param agencia AgenciaDeViajes que se va a registar.
     * @return true si se conecto con la BD y se Registro, throw si hubo algún tipo de Error.
     */
    public boolean insertarAgencia(AgenciaDeViajes agencia) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "insert into agencia_de_viajes(codigo, nombre, telefono, comision)"
                    + "values (?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, agencia.getCodigo());
            stmt.setString(2, agencia.getNombre());
            stmt.setInt(3, agencia.getTelefono());
            stmt.setInt(4, agencia.getComision());
            return stmt.executeUpdate() > 0;
        }catch(SQLException e) {
            throw  new MiError("El codigo de la agencia ya fue registrada.");
        } 
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo registrar la agencia, favor intente nuevamente.");
        }
    }
    /**
     * Método que se encarga de cargar las agencias de viajes registrados en la BD segun esten activas o no.
     * @param activo boolean activo que decide cuales agencias retornar.
     * @return ArrayList: Con las agencias de viajes registardas.
     */
    public ArrayList<AgenciaDeViajes> cargarAgencias(boolean activo) {
        ArrayList<AgenciaDeViajes> agencia = new ArrayList<>();
        try (Connection con = Conexion.getConexion()) {
            String sql = activo ? "select * from agencia_de_viajes where activo = true"
                    : "select * from agencia_de_viajes";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                agencia.add(cargarAgencia(rs));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());// TODO: Eliminar esta  línea
            throw new MiError("Problemas al cargar las agencias de viajes, favor intente nuevamente.");
        }
        return agencia;
    }
    /**
     * Método para cargar los datos de una agencia en la entidad AgenciaDeViajes.
     * @param rs ResultSet una sentencia que trae una consulta para BD.
     * @return AgenciaDeViajes: datos de la agencia de viajes seleccionada.
     * @throws SQLException Controla los errores.
     */
    private AgenciaDeViajes cargarAgencia(ResultSet rs) throws SQLException {
        AgenciaDeViajes agencia = new AgenciaDeViajes();
        agencia.setId(rs.getInt("id"));
        agencia.setCodigo(rs.getString("codigo"));
        agencia.setNombre(rs.getString("nombre"));
        agencia.setTelefono(rs.getInt("telefono"));
        agencia.setComision(rs.getInt("comision"));
        agencia.setActivo(rs.getBoolean("activo"));
        return agencia;    
    }
    /**
     * Método que selecciona una agencia por medio de un id.
     * @param id que recibe un int con el id de la agencia a buscar.
     * @return AgenciaDeViajes: la agencia correspondiente al id.
     */
    public AgenciaDeViajes seleccionarPorId(int id) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "select * from agencia_de_viajes where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return cargarAgencia(rs);
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar la Agencia, favor intente nuevamente");
        }
        return null;
    }
    /**
     * Método que selecciona una agencia para modificar sus datos.
     * @param agencia AgenciaDeViajes: la  agencia que se desea modificar.
     * @return true si se pudo modificar.
     */
    public boolean modificarAgencia(AgenciaDeViajes agencia) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "update agencia_de_viajes set codigo=?, nombre=?, telefono=?, comision=?, activo=?"
                    + " where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, agencia.getCodigo());
            stmt.setString(2, agencia.getNombre());
            stmt.setInt(3, agencia.getTelefono());
            stmt.setInt(4, agencia.getComision());
            stmt.setBoolean(5, agencia.isActivo());
            stmt.setInt(6, agencia.getId());
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo modificar la agencia, favor intente nuevamente.");
        }
    }
    /**
     * Método que selecciona una agencia para eliminarla (desactivarla).
     * @param agencia AgenciaDeViajes: la  agencia que se desea eliminar.
     * @return true si se pudo eliminar.
     */
    public boolean eliminarAgencia(AgenciaDeViajes agencia) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "update agencia_de_viajes set activo = false where id =?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, agencia.getId());
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo Eliminar la Agencia, favor intente nuevamente");
        }
    }
}