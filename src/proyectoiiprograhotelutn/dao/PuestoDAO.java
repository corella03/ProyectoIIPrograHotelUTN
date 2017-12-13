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
import proyectoiiprograhotelutn.entities.Puesto;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 24/11/2017
 **/
public class PuestoDAO {
    /**
     * Método para registar un Puesto en la BD.
     * @param puesto Puesto que se va a registar.
     * @return true si se conecto con la BD y se Registro, throw si hubo algún tipo de Error.
     */
    public boolean insertarPuesto(Puesto puesto) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "insert into puesto(nombre, descripcion)"
                    + "values (?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, puesto.getNombre());
            stmt.setString(2, puesto.getDescripcion());
            return stmt.executeUpdate() > 0;
        }catch(SQLException e) {
            throw  new MiError("El nombre del puesto ya fue registrada.");
        } 
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo registrar el puesto, favor intente nuevamente.");
        }
    }
    /**
     * Método que se encarga de cargar los puestos registrados en la BD segun esten activas o no.
     * @param activo boolean activo que decide cuales clientes retornar.
     * @return ArrayList Con los puestos registardos.
     */
    public ArrayList<Puesto> cargarPuestos(boolean activo) {
        ArrayList<Puesto> puestos = new ArrayList<>();
        try (Connection con = Conexion.getConexion()) {
            String sql = activo ? "select * from puesto where activo = true"
                    : "select * from puesto";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                puestos.add(cargarPuesto(rs));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());// TODO: Eliminar esta  línea
            throw new MiError("Problemas al cargar los Pustos, favor intente nuevamente.");
        }
        return puestos;
    }
    /**
     * Método para cargar los datos de un puesto en la entidad Puesto.
     * @param rs ResultSet una sentencia que trae una consulta para BD.
     * @return Puesto: datos del puesto seleccionado.
     * @throws SQLException Controla los errores.
     */
    private Puesto cargarPuesto(ResultSet rs) throws SQLException {
        Puesto puestos = new Puesto();
        puestos.setId(rs.getInt("id"));
        puestos.setNombre(rs.getString("nombre"));
        puestos.setDescripcion(rs.getString("descripcion"));
        puestos.setActivo(rs.getBoolean("activo"));
        return puestos;
    }
    /**
     * Método que selecciona un puesto por medio de un id.
     * @param id que recibe un int con el id del puesto.
     * @return Puesto: el cliente correspondiente al id.
     */
    public Puesto seleccionarPorId(int id) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "select * from puesto where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return cargarPuesto(rs);
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar el puesto, favor intente nuevamente");
        }
        return null;
    }
    /**
     * Método que selecciona un usuario para modificar sus datos.
     * @param puesto Puesto: el usuario que se desea modificar.
     * @return true si se pudo modificar.
     */
    public boolean modificarPuesto(Puesto puesto) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "update puesto set nombre=?, descripcion=?, activo=?"
                    + " where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, puesto.getNombre());
            stmt.setString(2, puesto.getDescripcion());
            stmt.setBoolean(3, puesto.isActivo());
            stmt.setInt(4, puesto.getId());
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo modificar el Puesto, favor intente nuevamente");
        }
    }
    /**
     * Método que selecciona un puesto para eliminarlo (desactivarla).
     * @param puesto Puesto: el cliente que se desea eliminar.
     * @return true si se pudo eliminar.
     */
    public boolean eliminarPuesto(Puesto puesto) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "update puesto set activo = false where id =?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, puesto.getId());
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo Eliminar el Puesto, favor intente nuevamente");
        }
    }
}