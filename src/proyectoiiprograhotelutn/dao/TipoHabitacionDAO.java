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
import proyectoiiprograhotelutn.entities.TipoHabitacion;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 24/11/2017
 **/
public class TipoHabitacionDAO {
    public boolean insertarTipoHabitacion(TipoHabitacion tipo) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "insert into tipo_habitacion(codigo, descripcion, precio)"
                    + "values (?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, tipo.getCodigo());
            stmt.setString(2, tipo.getDescripcion());
            stmt.setInt(3, tipo.getPrecio());
            return stmt.executeUpdate() > 0;
        } 
        catch(SQLException e) {
            throw  new MiError("El código de la habitacion ya fue registrada.");
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo registrar el tipo de habitación, favor intente nuevamente.");
        }
    }
    public ArrayList<TipoHabitacion> cargarTiposDeHabitaciones(boolean activo) {
        ArrayList<TipoHabitacion> tipos = new ArrayList<>();
        try (Connection con = Conexion.getConexion()) {
            String sql = activo ? "select * from tipo_habitacion where activo = true"
                    : "select * from tipo_habitacion ";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tipos.add(cargarTipoDeHabitacion(rs));
            }
        }catch (Exception ex) {
            System.out.println(ex.getMessage());// TODO: Eliminar esta  línea
            throw new MiError("Problemas al cargar los tipos de habitación, favor intente nuevamente.");
        }
        return tipos;
    }
    private TipoHabitacion cargarTipoDeHabitacion(ResultSet rs) throws SQLException {
        TipoHabitacion tipo = new TipoHabitacion();
        tipo.setId(rs.getInt("id"));
        tipo.setCodigo(rs.getString("codigo"));
        tipo.setDescripcion(rs.getString("descripcion"));
        tipo.setPrecio(rs.getInt("precio"));
        tipo.setActivo(rs.getBoolean("activo"));
        return tipo;
    }
    public TipoHabitacion seleccionarPorId(int id) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "select * from tipo_habitacion where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return cargarTipoDeHabitacion(rs);
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar el tipo de habitación, favor intente nuevamente");
        }
        return null;
    }
    public boolean modificarTipoHabitacion(TipoHabitacion tipo) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "update tipo_habitacion set codigo=?, descripcion=?, precio=?, activo=?"
                    + " where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, tipo.getCodigo());
            stmt.setString(2, tipo.getDescripcion());
            stmt.setInt(3, tipo.getPrecio());
            stmt.setBoolean(4, tipo.isActivo());
            stmt.setInt(5, tipo.getId());
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo modificar el tipo de habitación, favor intente nuevamente");
        }
    }
    public boolean eliminarTipoHabitacion(TipoHabitacion tipo) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "update tipo_habitacion set activo = false where id =?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, tipo.getId());
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo Eliminar el tipo de habitación, favor intente nuevamente");
        }
    }
}
