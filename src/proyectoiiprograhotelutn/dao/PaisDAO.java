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
import proyectoiiprograhotelutn.entities.Pais;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 24/11/2017
 **/
public class PaisDAO {
    /**
     * Método para registar un pais en la BD.
     * @param pais Pais que se va a registar.
     * @return true si se conecto con la BD y se Registro, throw si hubo algún tipo de Error.
     */
    public boolean insertarPais(Pais pais) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "insert into pais(nombre)"
                    + "values (?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, pais.getNombre());
            return stmt.executeUpdate() > 0;
        }catch(SQLException e) {
            throw  new MiError("El nombre del puesto ya fue registrada.");
        }  
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo registrar el país, favor intente nuevamente.");
        }
    }
    /**
     * Método que se encarga de cargar los paises registrados en la BD.
     * @return ArrayList: Con los paises registardos.
     */
    public ArrayList<Pais> cargarPaises() {
        ArrayList<Pais> paises = new ArrayList<>();
        try (Connection con = Conexion.getConexion()) {
            String sql = "select * from pais";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                paises.add(cargarPais(rs));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());// TODO: Eliminar esta  línea
            throw new MiError("Problemas al cargar los Paises, favor intente nuevamente.");
        }
        return paises;
    }
    /**
     * Método para cargar los datos de un pais en la entidad Pais.
     * @param rs ResultSet una sentencia que trae una consulta para BD.
     * @return Pais: datos del pais seleccionado.
     * @throws SQLException Controla los errores.
     */ 
    private Pais cargarPais(ResultSet rs) throws SQLException {
        Pais pais = new Pais();
        pais.setId(rs.getInt("id"));
        pais.setNombre(rs.getString("nombre"));
        return pais;
    }
    /**
     * Método que selecciona un pais por medio de un id.
     * @param id que recibe un int con el id del pais a buscar.
     * @return Pais: el pais correspondiente al id.
     */
    public Pais seleccionarPorId(int id) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "select * from pais where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return cargarPais(rs);
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar el pais, favor intente nuevamente");
        }
        return null;
    }
    /**
     * Método que selecciona un pais para modificar sus datos.
     * @param pais Pais: el pais que se desea modificar.
     * @return true si se pudo modificar.
     */
    public boolean modificarPais(Pais pais) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "update pais set nombre=?"
                    + " where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, pais.getNombre());
            stmt.setInt(2, pais.getId());
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo modificar el Pais, favor intente nuevamente");
        }
    }
}