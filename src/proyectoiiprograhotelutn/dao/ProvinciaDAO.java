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
import proyectoiiprograhotelutn.entities.Provincia;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 26/11/2017
 **/
public class ProvinciaDAO {
    /**
     * Método para registar una Provincia en la BD.
     * @param provincia Provincia que se va a registar.
     * @return true si se conecto con la BD y se Registro, throw si hubo algún tipo de Error.
     */
    public boolean insertarProvincia(Provincia provincia) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "insert into provincia(nombre, id_pais)"
                    + "values (?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, provincia.getNombre());
            stmt.setInt(2, provincia.getPais().getId());
            return stmt.executeUpdate() > 0;
        }catch(SQLException e) {
            throw  new MiError("El nombre de la provincia ya fue registrada.");
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo registrar la provincia, favor intente nuevamente.");
        }
    }
    /**
     * Método que se encarga de cargar las provincias registradas en la BD.
     * @return ArrayList: Con las provincias registardas.
     */
    public ArrayList<Provincia> cargarProvincias() {
        ArrayList<Provincia> provincias = new ArrayList<>();
        try (Connection con = Conexion.getConexion()) {
            String sql = "select * from provincia";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                provincias.add(cargarProvincia(rs));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());// TODO: Eliminar esta  línea
            throw new MiError("Problemas al cargar las Provincias, favor intente nuevamente.");
        }
        return provincias;
    }
    /**
     * Método para cargar los datos de una provincia en la entidad Provinicia.
     * @param rs ResultSet una sentencia que trae una consulta para BD.
     * @return Provincia: datos de la provincia seleccionada.
     * @throws SQLException Controla los errores.
     */
    private Provincia cargarProvincia(ResultSet rs) throws SQLException {
        Provincia provincia = new Provincia();
        provincia.setId(rs.getInt("id"));
        provincia.setNombre(rs.getString("nombre"));
        PaisDAO paisdao = new PaisDAO();
        provincia.setPais(paisdao.seleccionarPorId(rs.getInt("id_pais")));
        return provincia;
    }
    /**
     * Método que selecciona una provincia por medio de un id.
     * @param id que recibe un int con el id de la provincia a buscar.
     * @return Provincia: la provincia correspondiente al id.
     */
    public Provincia seleccionarPorId(int id) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "select * from provincia where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return cargarProvincia(rs);
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar la provincia, favor intente nuevamente");
        }
        return null;
    }
    /**
     * Método para cargar las provinicas las cuales pertenecen a un pais por medio del id.
     * @param id int id de la pais al que pertenece la provincia.
     * @return ArrayList con las provincias del pais.
     */
    public ArrayList<Provincia> cargarProvinciaDelPais(int id) {
        ArrayList<Provincia> provincias = new ArrayList<>();
        try (Connection con = Conexion.getConexion()) {
            String sql = "select * from provincia where id_pais =?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                provincias.add(cargarProvincia(rs));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());// TODO: Eliminar esta  línea
            throw new MiError("Problemas al cargar las Provincias, favor intente nuevamente.");
        }
        return provincias;
    }
    /**
     * Método que selecciona una provincia para modificar sus datos.
     * @param provincia Provincia: la provincia que se desea modificar.
     * @return true si se pudo modificar.
     */
    public boolean modificarProvincia(Provincia provincia) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "update provincia set nombre=?, id_pais"
                    + " where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, provincia.getNombre());
            stmt.setInt(2,provincia.getPais().getId());//revisar
            stmt.setInt(3, provincia.getId());
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo modificar la provincia , favor intente nuevamente");
        }
    }
}
