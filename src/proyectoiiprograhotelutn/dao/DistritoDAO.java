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
    /**
     * Método para registar un Distrito en la BD.
     * @param distrito Distrito que se va a registar.
     * @return true si se conecto con la BD y se Registro, throw si hubo algún tipo de Error.
     */
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
    /**
     * Método que se encarga de cargar los distritos registrados en la BD.
     * @return ArrayList: Con los distritos registardos.
     */
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
    /**
     * Método para cargar los datos de un distrito en la entidad Canton.
     * @param rs ResultSet una sentencia que trae una consulta para BD.
     * @return Distrito: datos del distrito seleccionado.
     * @throws SQLException Controla los errores.
     */
    private Distrito cargarDistrito(ResultSet rs) throws SQLException {
        Distrito distrito = new Distrito();
        distrito.setId(rs.getInt("id"));
        distrito.setNombre(rs.getString("nombre"));
        CantonDAO cantondao = new CantonDAO();
        distrito.setCanton(cantondao.seleccionarPorId(rs.getInt("id_canton")));
        return distrito;
    }
    /**
     * Método que selecciona un distrito por medio de un id.
     * @param id que recibe un int con el id del distrito a buscar.
     * @return Distrito: el distrito correspondiente al id.
     */
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
    /**
     * Método para cargar los distritos los cuales pertenecen a un canton por medio del id.
     * @param id int id de la canton al que pertenece el distrito.
     * @return ArrayList con los distritos del canton.
     */
    public ArrayList<Distrito> cargarDistritoDeCanton(int id) {
        ArrayList<Distrito> distrito = new ArrayList<>();
        try (Connection con = Conexion.getConexion()) {
            String sql = "select * from distrito where id_canton =?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                distrito.add(cargarDistrito(rs));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());// TODO: Eliminar esta  línea
            throw new MiError("Problemas al cargar los Distritos, favor intente nuevamente.");
        }
        return distrito;
    }
    /**
     * Método que selecciona un distrito para modificar sus datos.
     * @param distrito Distrito: el distrito que se desea modificar.
     * @return true si se pudo modificar.
     */
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