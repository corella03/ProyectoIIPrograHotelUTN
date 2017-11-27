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
import proyectoiiprograhotelutn.entities.Provincia;

/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 26/11/2017
 **/
public class ProvinciaDAO {
    public boolean insertarProvincia(Provincia provincia) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "insert into provincia(nombre, id_pais)"
                    + "values (?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, provincia.getNombre());
            stmt.setInt(2, provincia.getIdPais());
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo registrar la provincia, favor intente nuevamente.");
        }
    }
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
    private Provincia cargarProvincia(ResultSet rs) throws SQLException {
        Provincia provincia = new Provincia();
        provincia.setId(rs.getInt("id"));
        provincia.setNombre(rs.getString("nombre"));
        provincia.setIdPais(rs.getInt("id_pais"));
        return provincia;
    }
    public boolean verificarExistenciaProvincia(String nombre) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "select nombre from provincia where nombre = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nombre.toLowerCase());
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar, favor intente nuevamente.");
        }
    }
}
