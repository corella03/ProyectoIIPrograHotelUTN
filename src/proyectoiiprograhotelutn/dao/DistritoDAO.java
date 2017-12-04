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
import proyectoiiprograhotelutn.entities.Distrito;
import proyectoiiprograhotelutn.entities.MiError;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 26/11/2017
 **/
public class DistritoDAO {
    public boolean insertarDistrito(Distrito distrito) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "insert into distrito(nombre, id_canton)"
                    + "values (?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, distrito.getNombre());
            stmt.setInt(2, distrito.getCanton().getId());
            return stmt.executeUpdate() > 0;
        }catch(SQLException e) {
            throw  new MiError("El nombre del Distrito ya fue registrado.");
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo registrar el distrito, favor intente nuevamente.");
        }
    }
    public ArrayList<Distrito> cargarDistritos() {
        ArrayList<Distrito> distritos = new ArrayList<>();
        try (Connection con = Conexion.getConexion()) {
            String sql = "select * from distrito";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                distritos.add(cargarDistrito(rs));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());// TODO: Eliminar esta  línea
            throw new MiError("Problemas al cargar los Distritos, favor intente nuevamente.");
        }
        return distritos;
    }
    private Distrito cargarDistrito(ResultSet rs) throws SQLException {
        Distrito distrito = new Distrito();
        distrito.setId(rs.getInt("id"));
        distrito.setNombre(rs.getString("nombre"));
        CantonDAO cantondao = new CantonDAO();
        distrito.setCanton(cantondao.seleccionarPorId(rs.getInt("id_canton")));
        return distrito;
    }
    public Distrito seleccionarPorId(int id) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "select * from distrito where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return cargarDistrito(rs);
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar el distrito, favor intente nuevamente");
        }
        return null;
    }
    public boolean modificarDistrito(Distrito distrito) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "update distrito set nombre=?, id_canton"
                    + " where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, distrito.getNombre());
            stmt.setInt(2,distrito.getCanton().getId());//revisar
            stmt.setInt(3, distrito.getId());
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo modificar el distrito, favor intente nuevamente");
        }
    }
}
