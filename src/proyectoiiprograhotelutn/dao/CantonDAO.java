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
import proyectoiiprograhotelutn.entities.Canton;
import proyectoiiprograhotelutn.entities.MiError;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 26/11/2017
 **/
public class CantonDAO {
    public boolean insertarCanton(Canton canton) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "insert into canton(nombre, id_provincia)"
                    + "values (?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, canton.getNombre());
            stmt.setInt(2, canton.getProvincia().getId());
            return stmt.executeUpdate() > 0;
        }catch(SQLException e) {
            throw  new MiError("El nombre del cantón ya fue registrada.");
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo registrar el cantón, favor intente nuevamente.");
        }
    }
    public ArrayList<Canton> cargarCantones() {
        ArrayList<Canton> cantones = new ArrayList<>();
        try (Connection con = Conexion.getConexion()) {
            String sql = "select * from canton";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cantones.add(cargarCanton(rs));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());// TODO: Eliminar esta  línea
            throw new MiError("Problemas al cargar los cantónes, favor intente nuevamente.");
        }
        return cantones;
    }
    private Canton cargarCanton(ResultSet rs) throws SQLException {
        Canton canton = new Canton();
        canton.setId(rs.getInt("id"));
        canton.setNombre(rs.getString("nombre"));
        ProvinciaDAO provinciadao = new ProvinciaDAO();
        canton.setProvincia(provinciadao.seleccionarPorId(rs.getInt("id_provincia")));
        return canton;
    }
    public Canton seleccionarPorId(int id) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "select * from canton where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return cargarCanton(rs);
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar el cantón, favor intente nuevamente");
        }
        return null;
    }
    public ArrayList<Canton> cargarCantonDeProvincia(int id) {
        ArrayList<Canton> cantones = new ArrayList<>();
        try (Connection con = Conexion.getConexion()) {
            String sql = "select * from canton where id_provincia =?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cantones.add(cargarCanton(rs));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());// TODO: Eliminar esta  línea
            throw new MiError("Problemas al cargar los Cantónes, favor intente nuevamente.");
        }
        return cantones;
    }
    public boolean modificarCanton(Canton canton) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "update canton set nombre=?, id_provincia"
                    + " where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, canton.getNombre());
            stmt.setInt(2,canton.getProvincia().getId());//revisar
            stmt.setInt(3, canton.getId());
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo modificar el cantón, favor intente nuevamente");
        }
    }
}
