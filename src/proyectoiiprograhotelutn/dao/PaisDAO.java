/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import proyectoiiprograhotelutn.entities.MiError;
import proyectoiiprograhotelutn.entities.Pais;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 24/11/2017
 **/
public class PaisDAO {
    public boolean insertarPais(Pais pais) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "insert into pais(nombre)"
                    + "values (?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, pais.getNombre());
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo registrar el país, favor intente nuevamente.");
        }
    }
    public boolean verificarExistenciaPais(String nombre) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "select nombre from pais where nombre = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nombre.toLowerCase());
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar, favor intente nuevamente.");
        }
    }
}
